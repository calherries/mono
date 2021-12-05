(ns day-1
  (:require [clojure.string :as str]))

(def input
  (->> (slurp "day_1.txt")
       (str/split-lines)
       (map read-string)))

(->> input
     (partition 2 1)
     (map #(apply < %))
     (filter true?)
     (count))
