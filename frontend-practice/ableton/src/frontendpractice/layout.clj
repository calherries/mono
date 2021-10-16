(ns frontendpractice.layout
  (:require [frontendpractice.components :as components]
            [garden.core :refer [css]]
            [stylefy.core :as stylefy :refer [use-style]]))

(defn page [container]
  [:html
   [:head
    [:link {:rel "stylesheet" :href "https://fonts.googleapis.com/css2?family=Archivo:ital,wght@0,400;0,700;1,400&family=DM+Serif+Display&display=swap"}]
    [:link {:rel "stylesheet" :href "https://fonts.googleapis.com/css?family=Open+Sans:200italic,300italic,400italic,500italic,600italic,700italic,800italic,900italic,200,300,400,500,600,700,800"}]
    [:style {:id "_stylefy-server-styles_"} "_stylefy-server-styles-content_"] ; Generated CSS will be inserted here
    [:style {:id "_stylefy-constant-styles_"}]
    [:style {:id "_stylefy-styles_"}]]
   [:body (use-style
           {:line-height 1.5
            :margin      0
            :font-family "Archivo,sans-serif"
            :color       "rgba(0,0,0,.8)"})
    (components/header)
    [:main (container)]]])
