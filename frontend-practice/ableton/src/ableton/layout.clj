(ns ableton.layout
  (:require [garden.core :refer [css]]
            [stylefy.core :refer [use-style]]))

(defn page []
  [:html
   [:head
    [:style {:id "_stylefy-server-styles_"} "_stylefy-server-styles-content_"] ; Generated CSS will be inserted here
    [:style {:id "_stylefy-constant-styles_"}]
    [:style {:id "_stylefy-styles_"}]
    [:style {:type "text/css" :id "ornament"} (o/defined-styles)]]
   [:body
    (use-style {:color :blue})
    "Hello, there"]])