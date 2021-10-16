(ns frontendpractice.core
  (:require
   [frontendpractice.layout :as layout]
   [frontendpractice.pages.home :as home]
   [frontendpractice.pages.ableton :as ableton]
   [hiccup2.core :as hiccup]
   [ring.adapter.jetty :as ring-jetty]
   [ruuter.core :as ruuter]
   [stylefy.core :as stylefy]
   ))

;; Globals
(defonce server (atom nil))

(defn request->page-response [page]
  (fn [req]
    {:status 200
     :body   (stylefy/query-with-styles
              (fn []
                (hiccup/html (layout/page page))))}))

(def routes
  [{:path     "/ableton"
    :method   :get
    :headers  {"Content-Type" "text/html"}
    :response (request->page-response ableton/ableton)}
   {:path     "/"
    :method   :get
    :headers  {"Content-Type" "text/html"}
    :response (request->page-response home/home)}])

(defn handler [req]
  (ruuter/route routes req))

(defn start-server []
  (reset! server (ring-jetty/run-jetty #'handler {:join? false :port 8000})))

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
