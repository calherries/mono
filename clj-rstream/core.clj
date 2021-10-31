(ns core)

(defprotocol ISubscriber
  (just [this x])
  (done [this])
  (error [this e]))

(defprotocol ISubscribable
  (subscribe [this subscriber])
  (unsubscribe-self [this])
  (unsubscribe-child [this subscriber]))

(defprotocol ISubscription
  (state [this])
  (parent [this]))

(defrecord Trace []
  ISubscriber
  (just [trace x] (prn x))
  (done [trace] (prn "done"))
  (error [trace e] (prn "error" e)))

; WIP
(defrecord Stream [src state parent subs]
  ISubscribable
  (subscribe [stream subscriber] 1)
  (unsubscribe-self [stream] 1)
  (unsubscribe-child [stream subscriber] 1)
  ISubscriber
  (just [stream x] (prn x))
  (done [stream] (prn "done"))
  (error [stream e] (prn "error" e))
  ISubscription
  (state [stream] (:state stream))
  (parent [stream] (:parent stream)))

(defn make-stream [src]
  (->Stream src :idle nil []))

(comment

  (let [stream (make-stream (fn [s] "hey"))]
    (state stream))

  (let [src (fn [s]
              (doto s
                (just "p")
                (error "p")
                (done)))]))

(comment
  (def a (stream (fn [s]
                   (doto s
                     (just 1)
                     (just 2)
                     (done)))))
  (subscribe a (trace)))