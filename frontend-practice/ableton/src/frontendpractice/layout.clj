(ns frontendpractice.layout
  (:require [garden.core :refer [css]]
            [stylefy.core :as stylefy :refer [use-style]]))

(defn descendants-garden [style-map]
  [:& :descendants :*
   style-map])

(defn header []
  [:header
   [:div (use-style
          {:display         :flex
           :flex-direction  :row
           :padding         "20px"
           :align-items     :center
           :justify-content :space-between})
    [:h1 (use-style {:margin 0})
     [:a (use-style
          {:color           "#333"
           :font-family     "DM Serif Display"
           :font-weight     600
           :text-decoration :none
           :font-size       "30px"}
          {:href "https://www.frontendpractice.com/"})
      "Frontend Practice"]]
    [:div (use-style
           {:display        :flex
            :flex-direction :row
            :gap            "30px"
            ::stylefy/manual [(descendants-garden
                               {:color       "#333"
                                :font-weight 600})]})
     [:a {:href ""}
      "Projects"]
     [:a {:href ""}
      "FAQ"]
     [:a {:href ""}
      "HOME"]]]])

(defn main []
  [:main
   [:div (use-style
          {:display        :flex
           :flex-direction :column
           :align-items   :center
           :gap            "10px"
           :padding        "30 20 30 20"
           :background-color "#F9EBD7"})
    [:h1 (use-style
          {:margin      0
           :text-align  :center
           :line-height 1.1
           :font-size   "60px"
           :font-family "DM Serif Display"})
     "Become a better frontend developer"]
    [:h2 (use-style
          {:text-align  :center
           :font-weight :normal})
     "Take your skills to the next level by recreating "
     [:span (use-style
             {:font-weight :bold})
      "real websites"]]]])

(defn page []
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
    (header)
    (main)]])
