(ns escher.core.artwork
  (:use
   :reload-all
   [escher.core.rectangle]
   [escher.core.vect]
   [escher.core.picture]
   [escher.core.segment]
   ))


(def origin (make-vect 0 0))
(def x-axis (make-vect 200 0))
(def y-axis (make-vect 0 200))

(defn myart []

  (def s1 (make-segment 0 0.5 0.5 0))
  (def s2 (make-segment 0.5 0 1 0.5))
  (def s3 (make-segment 1 0.5 0.5 1))
  (def s4 (make-segment 0.5 1 0 0.5))

  (def pic (make-picture [s1 s2 s3 s4]))

  (def bigger (beside pic (beside pic pic 0.75) 0.25))

  (above bigger bigger 0.5)
  )


(defn make-art [g]
      (def rect (make-rect origin x-axis y-axis g))
      ((myart) rect)
  )