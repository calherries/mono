(ns core)

(defn stream [src]
  1)

(defn done [stream]
  1)

(defn value [stream v]
  1)

(defn subscribe [stream subscriber]
  1)

(defmulti just :type)
(defmulti done :type)
(defmulti error :type)

(defmethod just :trace
  [subscriber x]
  (prn x))

(defmethod done :trace
  [subscriber]
  (prn "done"))

(defmethod error :trace
  [subscriber e]
  (prn "error" e))

(comment
  (error {:type :trace} "hey")
  )

(comment
  (def a (stream (fn (s)
                   (doto s
                     (just 1)
                     (just 2)
                     (done)))))
  (subscribe a (trace)))