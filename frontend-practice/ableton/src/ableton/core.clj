(ns ableton.core
  (:require [ruuter.core :as ruuter]
            [ring.adapter.jetty :as ring-jetty]))

;; Globals
(defonce server (atom nil))

(def routes
  [{:path     "/"
    :method   :get
    :headers  {"Content-Type" "text/html"}
    :response {:status 200
               :body   "<html><body>Hi there!</body></html>"}}])

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
