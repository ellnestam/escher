(ns escher.core.launch
  (:use
   :reload-all
	[escher.core.vect]
	[escher.core.picture]
	[escher.core.rectangle]
	[escher.core.segment]))

(import '(javax.swing JFrame JPanel))

(def origin (make-vect 0 0))
(def x-axis (make-vect 0 10))
(def y-axis (make-vect 10 0))

(def s1 (make-segment 0 0 1 1))
(def s2 (make-segment 1 1 2 0))
(def s3 (make-segment 0 2 1 3))
(def s4 (make-segment 1 3 2 2))
(def pic (make-picture [s1 s2 s3 s4]))

(defn escher-panel []
  (proxy [JPanel] []
    (paintComponent [g]
      (proxy-super paintComponent g)
      (def rect (make-rect origin x-axis y-axis g))
      (pic rect)
     )
    )
  )

(defn escher-frame []
  (let [
       frame (JFrame. "Escher")
    ]
    (doto frame
      (.pack)
      (.setDefaultCloseOperation JFrame/DISPOSE_ON_CLOSE)
      (.setSize 640 480)
      (.add (escher-panel))
      (.setVisible true))
    )
  )

(defn run-escher []
  (escher-frame)
)

; (run-escher)
