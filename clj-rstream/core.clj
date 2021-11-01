(ns core
  (:require [clojure.pprint])
  (:import [clojure.lang IDeref]))

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

(defn has-subscribable-state [sub]
  (contains? #{:idle :active} (.state sub)))

(defn ensure-state [sub]
  (when-not (contains? #{:idle :active} (.state sub))
    (throw (Error. (str "Illegal operation with state " (.state sub))))))

(defprotocol ISetX
  (set-x [this o]))

(defprotocol IGetX
  (get-x [this]))

(deftype Stream [src
                 ^:unsynchronized-mutable state
                 ^:unsynchronized-mutable parent
                 ^:unsynchronized-mutable subs
                 ^:unsynchronized-mutable last]
  ISubscribable
  (subscribe [stream subscriber]
    (ensure-state stream)
    (set! subs (conj subs subscriber))
    ;; (update stream :subs conj subscriber) ;; Note I'm not declaring a parent attribute yet
    )
  (unsubscribe-self [stream] 1)
  (unsubscribe-child [stream subscriber] 1)
  ISubscriber
  (just [stream x] (prn x))
  (done [stream] (prn "done"))
  (error [stream e] (prn "error" e))
  ISubscription
  (state [stream] state)
  (parent [stream] parent)
  IDeref
  (deref [stream]
    (when (not= last :SEMAPHORE)
      last))
  ISetX
  (set-x [this o]
    (set! state o))
  IGetX
  (get-x [stream]
    subs)
  )

(defmethod print-method Stream [v ^java.io.Writer w]
  (.write w "<<-XYZ->>"))

(defmethod print-method Stream [stream ^java.io.Writer writer]
  (doto writer
    (.write "#stream ")
    (.write (str (state stream)))
    (.write (str (parent stream)))
    (.write "...subs"))
  (doall (map (fn [el]
                (.write writer ".")
                (.write writer (str el)))
           (get-x stream))))


(defn make-stream [src]
  (->Stream src :idle nil '() :SEMAPHORE))

(comment
  (def states [:idle :active :done :unsubscribed :error]))

(comment
  (let [stream (make-stream (fn [s] "hey"))
        _ (subscribe stream 2)
        _ (set-x stream :active)]
    stream)

  (let [stream (make-stream (fn [s] "hey"))
        stream (assoc stream :state :done)]
    (ensure-state stream))

  (let [stream (make-stream (fn [s] "hey"))
        stream (assoc stream :state :done)]
    (ensure-state stream))

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