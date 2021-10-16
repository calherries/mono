(ns frontendpractice.pages.home
  (:require [frontendpractice.util :as util]
            [garden.core :refer [css]]
            [stylefy.core :as stylefy :refer [use-style]]))

(defn home []
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
     "real websites"]]])
