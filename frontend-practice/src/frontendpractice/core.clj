(ns frontendpractice.core
  (:require
   [frontendpractice.layout :as layout]
   [frontendpractice.pages.home :as home]
   [frontendpractice.pages.ableton :as ableton]
   [hiccup2.core :as hiccup]
   [muuntaja.middleware]
   [ring.adapter.jetty :as ring-jetty]
   [ring.middleware.defaults :as ring-defaults]
   [ruuter.core :as ruuter]
   [stylefy.core :as stylefy]))

;; Globals
(defonce server (atom nil))

(defn path-bodies []
  [["/ableton" ableton/ableton]
   ["/" home/home]])

(defn routes []
  (for [[path body] (path-bodies)]
    {:path     path
     :method   :get
     :response (fn [req]
                 {:status  200
                  :headers {"Content-Type" "text/html"}
                  :body    (stylefy/query-with-styles
                            (fn []
                              (hiccup/html (layout/page body))))})}))

(defn handler [req]
  (ruuter/route (routes) req))

(defn start-server []
  (reset! server (ring-jetty/run-jetty
                  (-> #'handler
                      muuntaja.middleware/wrap-format
                      (ring-defaults/wrap-defaults ring-defaults/site-defaults))
                  {:join? false
                   :port  8000})))

(defn stop-server []
  (.stop @server)
  (reset! server nil))

(defn reset-server []
  (stop-server)
  (start-server))

;; Init
(start-server)
(stylefy/init)

(comment
  (reset-server)
  (keys (ns-publics 'ring.adapter.jetty))
  )
