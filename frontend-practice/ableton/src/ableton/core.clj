(ns ableton.core
  (:require
   [ableton.layout :as layout]
   [hiccup2.core :as hiccup]
   [ring.adapter.jetty :as ring-jetty]
   [ruuter.core :as ruuter]
   [stylefy.core :as stylefy]))

;; Globals
(defonce server (atom nil))

(def routes
  [{:path     "/"
    :method   :get
    :headers  {"Content-Type" "text/html"}
    :response (fn [req]
                {:status 200
                 :body   (str
                          (stylefy/query-with-styles
                           (fn []
                             (hiccup/html (layout/page)))))})}])

(defn handler [req]
  (ruuter/route routes req))

(defn start-server []
  (reset! server (ring-jetty/run-jetty #'handler {:join? false :port 8001})))

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
