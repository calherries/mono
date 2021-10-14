(ns ableton.core
  (:require [ring.adapter.jetty :as ring-jetty]))

;; Globals
(defonce server (atom nil))

(defn handler [req]
  {:status 200
   :body "hello, world"})

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
