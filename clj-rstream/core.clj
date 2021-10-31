(ns core)

(defprotocol ISubscriber
  (just [this x])
  (done [this])
  (error [this e]))

(defprotocol ISubscribable
  (subscribe [this subscriber])
  (unsubscribe-self [this])
  (unsubscribe-child [this subscriber]))

(defrecord Trace []
  ISubscriber
  (just [trace x] (prn x))
  (done [trace] (prn "done"))
  (error [trace e] (prn "error" e)))

(comment
  (doto (->Trace)
    (just "p")
    (done)
    (error "p"))
  )

(comment
  (def a (stream (fn (s)
                   (doto s
                     (just 1)
                     (just 2)
                     (done)))))
  (subscribe a (trace)))