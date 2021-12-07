(ns day-2
  (:require [clojure.string :as str]))

(def input
  (->> (slurp "day_2.txt")
       (str/split-lines)
       (map (fn [line]
              (let [[x y] (str/split line #"\s")]
                [(keyword x) (read-string y)])))))

;; Part 1
(let [[x-pos y-pos] (reduce (fn [[x-pos y-pos] [command distance]]
                              (case command
                                :forward [(+ x-pos distance) y-pos]
                                :down    [x-pos (+ y-pos distance)]
                                :up      [x-pos (- y-pos distance)]))
                            [0 0]
                            input)]
  (* x-pos y-pos))

;; Part 2
(let [[x-pos y-pos aim] (reduce (fn [[x-pos y-pos aim] [command distance]]
                              (case command
                                :forward [(+ x-pos distance) (+ (* aim distance) y-pos) aim]
                                :down    [x-pos y-pos (+ aim distance)]
                                :up      [x-pos y-pos (- aim distance)]))
                            [0 0 0]
                            input)]
    (* x-pos y-pos))
