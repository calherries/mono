(ns ableton.core
  (:require [ruuter.core :as ruuter]
            [hiccup2.core :as hiccup]
            [ring.adapter.jetty :as ring-jetty]))

;; Globals
(defonce server (atom nil))

(def body
  [:html
   [:body
    "Hello, there"]])

(def routes
  [{:path     "/"
    :method   :get
    :headers  {"Content-Type" "text/html"}
    :response {:status 200
               :body   (str (hiccup/html body))}}])

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

(comment
  (reset-server)
  (keys (ns-publics 'ring.adapter.jetty))
  )
