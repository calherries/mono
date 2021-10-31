(ns core)

(defn stream [src]
  1)

(defn done [stream]
  1)

(defn  [stream v]
  1)

(defn subscribe [stream subscriber]
  1)

(defprotocol ISubscribable
  (just [subscriber x])
  (done [subscriber])
  (error [subscriber e]))

(defrecord Trace []
  ISubscribable
  (just [subscriber x] (prn x))
  (done [subscriber] (prn "done"))
  (error [subscriber e] (prn "error" e)))

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