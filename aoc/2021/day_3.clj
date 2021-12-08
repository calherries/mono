(ns day-3
  (:require [clojure.string :as str]))

(def input (->> (slurp "day_3.txt")
                (str/split-lines)
                (map vec)))

;; Part 1
(->> input
    (apply map vector)
    (map (fn [col]
           (->> (frequencies col)
                (sort-by second)
                (map first))))
    (apply map vector)
    (map (comp #(Integer/parseInt % 2) str/join))
    (apply *))

;; Part 2
(let [rating (fn [type]
               (let [select (fn [{zero \0
                                  one  \1}]
                              (case (compare zero one)
                                -1 (case type
                                     :oxygen \1
                                     :co2    \0)
                                0  (case type
                                     :oxygen \1
                                     :co2    \0)
                                1  (case type
                                     :oxygen \0
                                     :co2    \1)))]
                 (loop [remaining input
                        index     0]
                   (if (= (count remaining) 1)
                     (first remaining)
                     (let [to-keep   (->> remaining
                                          (apply map vector)
                                          (#(nth % index))
                                          (frequencies)
                                          (select))
                           remaining (->> remaining
                                          (filter #(= (nth % index) to-keep)))]
                       (recur remaining (inc index)))))))]
  (->> [(rating :co2)
        (rating :oxygen)]
       (map (comp #(Integer/parseInt % 2) str/join))
       (apply *)))
