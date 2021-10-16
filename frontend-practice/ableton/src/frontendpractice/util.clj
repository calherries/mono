(ns frontendpractice.util)

(defn descendants-garden [style-map]
  [:& :descendants :*
   style-map])