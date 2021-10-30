(ns frontendpractice.pages.ableton
  (:require [frontendpractice.style :as style]
            [frontendpractice.util :as util]
            [garden.core :as garden]
            [stylefy.core :as stylefy :refer [use-style]]))

;; https://www.frontendpractice.com/project/ableton

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

(defn link-style
  ([]
    (use-style
      {:text-align "center"
       :font-size  "15px"}))
  ([options]
    (use-style
      {:text-align "center"
       :font-size  "15px"}
      options)))

(defn blue-link-style [options]
  (use-style
    {:text-align "center"
     :text-decoration "none"
     :color      "blue"}
    options))

(defn first-paragraph-style []
  (use-style
    {:font-size       "20px"
     :line-height     1.5}))

(defn second-paragraph-style []
  (use-style
    {:font-size   "14px"
     :line-height 2.0}))

(defn two-paragraph-style []
  (use-style
    {:display        :flex
     :flex-direction :column
     :gap            "10px"}))

(defn ableton []
  [:body (use-style
          {:font-family "futura-pt"})
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
     [:a (link-style)
      "About"]
     [:a (link-style)
      "Jobs"]]
    [:div (use-style
           {:padding        "0 40px"
            :display        "flex"
            :flex-direction :column
            :gap            "20px"})
     [:header (use-style
               {:display             :flex
                :background-color    :grey
                :background-size     :cover
                :height              "calc(100vh - 100px)"
                :background-position "50% 50%"
                :background-image    "url(\"https://ableton-production.imgix.net/about/header.jpg?auto=format&dpr=2&fit=crop&fm=jpg&h=646&ixjsv=1.1.3&q=50&w=349\")"
                :flex-direction      :row
                :justify-content     :center})
      [:h1 (use-style
            {:font-size   "70px"
             :font-weight "bold"
             :color       style/orange
             :position    "absolute"
             :top         "50%"})
       "Ableton"]]
     [:div (two-paragraph-style)
      [:p (first-paragraph-style)
       "We make " [:a (blue-link-style {:href ""}) "Live"] ", " [:a (blue-link-style {:href ""}) "Push"] " and "
       [:a (blue-link-style {:href ""}) "Link"] " — unique software and hardware for music creation and performance. "
       "With these products, our community of users creates amazing things."]
      [:p (second-paragraph-style)
       "Ableton was founded in 1999 and released the first version of Live in 2001. Our products are used by a community of dedicated musicians, sound designers, and artists from across the world."]]
     [:div (two-paragraph-style)
      [:p (first-paragraph-style)
       "We make " [:a (blue-link-style {:href ""}) "Live"] ", " [:a (blue-link-style {:href ""}) "Push"] " and "
       [:a (blue-link-style {:href ""}) "Link"] " — software and hardware for music creation and performance."
       "With these products, our community of users creates amazing things."]
      [:p (second-paragraph-style)
       "Ableton was founded in 1999 and released the first version of Live in 2001. Our products are used by a community of dedicated musicians, sound designers, and artists from across the world."]]]]])
