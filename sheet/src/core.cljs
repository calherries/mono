(ns core
  (:require [helins.canvas :as c]))

(def canvas (first (js/document.getElementsByClassName "sheet_canvas")))

(def ctx (.getContext canvas "2d"))

(def img
  (js/Image.))

(set! (.-src img)
  "https://static01.nyt.com/images/2014/01/28/science/28SLOT_SPAN/28SLOT-articleLarge.jpg?quality=75&auto=webp&disable=upscale")

(defn draw-frame

  [ctx]

  (-> ctx
      (c/color-fill (c/grad-linear ctx 0 0 1000 400 [[0   "black"]
                                                               [0.5 "blue"]
                                                               [1   "black"]]))
      (c/rect-fill 0 0 1000 400)
      (c/smoothing? true)
      (c/paste img
        500
        0)
      (c/color-fill "white")
      (c/color-stroke "grey")
      (c/line-width 2)
      (c/font "bold 200px serif")
      (c/text-fill 50 100 "Hello")
      (c/shadow 10 10 10 "green")
      (c/text-stroke 100 200 "Hello")))

(doto ctx
  (set! .fill)
  (.rect 20 20 150 150))

(-> ctx
    (c/color-fill (c/grad-linear ctx 0 0 1000 400 [[0   "black"]
                                                   [0.5 "blue"]
                                                   [1   "black"]]))
    (c/rect-fill 0 0 1000 400))

(comment
  (draw-frame ctx)
  (do
    (def frame
      (c/on-frame (fn draw [_timestamp]
                    (try
                      (draw-frame ctx)
                      true
                      (catch :default e
                        (js/console.log "err" e)
                        false)))))
    (frame))
  (frame)
  )

(defn init []
  (js/console.log "init"))
