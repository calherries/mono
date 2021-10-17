(ns core)

(def canvas (first (.getElementsByClassName js/document "sheet_canvas")))

(def ctx (.getContext canvas "2d"))

(set! (.-fillStyle ctx) "rgb(200, 0, 0)")
(.fillRect ctx 10 10 50 50)

(set! (.-fillStyle ctx) "rgb(0, 0, 200, 0.5)")
(.fillRect ctx 50 30 50 50)


(set! (.-fillStyle ctx) "rgb(0, 0, 0, 0.9)")

;; ctx.beginPath ();
;; ctx.moveTo (75, 50);
;; ctx.lineTo (100, 75);
;; ctx.lineTo (100, 25);
;; ctx.fill ();
(doto ctx
  (.beginPath)
  (.moveTo 75 50)
  (.lineTo 100 75)
  (.lineTo 100 25)
  (.fill))

(defn init []
  (js/console.log "init"))
