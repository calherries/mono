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
          {:text-decoration :none
           :font-family     "futura-pt"
           :font-size       "20px"}
          {:href ""})
      "Menu"]]]])

(defn ableton []
  [:body (use-style
          {:font-family "Helvetica Neue"})
   (header)
   [:div (use-style
          {:height     0
           :border-top "2px solid #eee"})]
   [:main
    [:div (use-style
           {:display        :flex
            :flex-direction :row
            :align-items   :center
            :gap            "10px"
            :padding        "30 20 30 20"})
     [:a (use-style
          {:text-align  :center
           :font-size   "10px"})
      "About"]
     [:a (use-style
          {:text-align  :center
           :font-size   "10px"})
      "Jobs"]]
    [:div (use-style
           {:padding "20px"
            :display :flex
            :flex-direction :column
            :gap "20px"})
     [:header (use-style
               {:display         :flex
                :background-color :grey
                :flex-direction  :row
                :justify-content :center})
      [:h1 (use-style
            {:font-family "futura-pt"
             :font-size   "60px"})
       "Ableton"]]
     [:div (use-style
            {:display :flex
             :flex-direction :column
             :gap "10px"})
      [:p (use-style
           {:font-size "20px"
            :line-height 1.5})
       "We make " [:a {:href ""} "Live"] ", " [:a {:href ""} "Push"] " and " [:a {:href ""} "Link"] " — unique software and hardware for music creation and performance. With these products, our community of users creates amazing things."]
      [:p (use-style
           {:font-size "14px"
            :line-height 1.5})
       "Ableton was founded in 1999 and released the first version of Live in 2001. Our products are used by a community of dedicated musicians, sound designers, and artists from across the world."]]]]])
