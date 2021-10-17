(ns hot-dog-machine
  (:require [clojure.core.async
             :as a
             :refer [>! <! >!! <!! go chan buffer close! thread
                     alts! alts!! timeout]]))

(defn hot-dog-machine []
  (let [in  (chan)
        out (chan)]
    (go (<! in)
        (>! out "hot dog"))
    [in out]))

(let [[in out] (hot-dog-machine)]
  (>!! in "anything lint")
  (<!! out))

(defn hot-dog-machine [hot-dog-count]
  (let [in  (chan)
        out (chan)]
    (go (loop [hdc hot-dog-count]
          (if (zero? hdc)
            (do (close! in)
                (close! out))
            (let [input (<! in)]
              (if (= 3 input)
                (do (>! out "hot dog")
                    (recur (dec hdc)))
                (do (>! out "wilted lettuce")
                    (recur hdc)))))))
    [in out]))

(let [[in out] (hot-dog-machine 3)]
  (>!! in 3)
  (<!! out))