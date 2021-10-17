(ns frontendpractice.util
  (:require [garden.core :as garden]))

(defn descendants-garden [style-map]
  [:& :descendants :*
   style-map])

(defn css
  "Converts a standalone style map to css with `garden`.
  See [[html]]."
  [style]
  (let [s (garden/css {:pretty-print? false} [:foo style])]
    (subs s 4 (- (count s) 1))))