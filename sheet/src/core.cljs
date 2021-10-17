(ns core)

(def canvas (first (.getElementsByClassName js/document "sheet_canvas")))

(def ctx (.getContext canvas "2d"))

(set! (.-fillStyle ctx) "rgb(200, 0, 0)")
(.fillRect ctx 10 10 50 50)

(set! (.-fillStyle ctx) "rgb(0, 0, 200, 0.5)")
(.fillRect ctx 50 30 50 50)


(set! (.-fillStyle ctx) "rgb(0, 0, 0, 0.9)")

(defn rounded-rect [ctx x y width height radius]
  (doto ctx
    (.beginPath)
    (.moveTo x (+ y radius))
    (.lineTo x (+ y (- height radius)))
    (.arcTo x (+ y height) (+ x radius) (+ y height) radius)
    (.lineTo (+ x (- width radius)) (+ y height))
    (.arcTo (+ x width) (+ y height) (+ x width) (+ y (- height radius)) radius)
    (.lineTo (+ x width) (+ y radius))
    (.arcTo (+ x width) y (+ x (- width radius)) y radius)
    (.lineTo (+ x radius) y)
    (.arcTo x y x (+ y radius) radius)
    (.stroke)))

(doto ctx
  (rounded-rect 12, 12, 150, 150, 15)
  (rounded-rect 19, 19, 150, 150, 15))

(doto ctx
  (.beginPath)
  (.arc 37 37 13 (/ js/Math.PI 7) (/ (- js/Math.PI) 7) false)
  (.lineTo 31 37)
  (.fill)
  )
;;   (rounded-rect 53, 53, 49, 33, 10)
;;   (rounded-rect 53, 119, 49, 16, 6)
;;   (rounded-rect 135, 53, 49, 33, 10)
;;   (rounded-rect 135, 119, 25, 49, 10))

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

(doto ctx
  (.beginPath)
  (.arc 75 75 50 0 (* (.-PI js/Math) 2) true)
  (.moveTo 110 75)
  (.arc 75 75 35 0 (.-PI js/Math) false)
  (.moveTo 65 65)
  (.arc 60 65 5 0 (* (.-PI js/Math) 2) true)
  (.moveTo 95 65)
  (.arc 90 65 5 0 (* (.-PI js/Math) 2) true)
  (.stroke))

(defn init []
  (js/console.log "init"))
