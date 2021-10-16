(ns frontendpractice.components
  (:require [frontendpractice.util :as util]
            [garden.core :refer [css]]
            [stylefy.core :as stylefy :refer [use-style]]))

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
            ::stylefy/manual [(util/descendants-garden
                               {:color       "#333"
                                :font-weight 600})]})
     [:a {:href ""}
      "Projects"]
     [:a {:href ""}
      "FAQ"]
     [:a {:href ""}
      "HOME"]]]])