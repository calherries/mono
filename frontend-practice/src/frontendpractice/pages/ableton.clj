(ns frontendpractice.pages.ableton
  (:require [frontendpractice.util :as util]
            [garden.core :refer [css]]
            [stylefy.core :as stylefy :refer [use-style]]))

(defn header []
  [:header
   [:div (use-style
          {:display         :flex
           :flex-direction  :row
           :padding         "20px"
           :align-items     :center})
    [:svg (use-style
           {:width "3.75em"
            :height "1.75em"}
           {:role "img"})
     [:path {:d "M0 0h3v21H0zM6 0h3v21H6zM12 0h3v21h-3zM18 0h3v21h-3zM24 18h21v3H24zM24 12h21v3H24zM24 6h21v3H24zM24 0h21v3H24z"}]]
    [:h1
     [:a (use-style
          {:color           "#333"
           :font-weight     600
           :text-decoration :none
           :font-size       "30px"}
          {:href ""})
      "Frontend Practice"]]]])

(defn ableton []
  [:body
   (header)
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
       "real websites"]]]]])
