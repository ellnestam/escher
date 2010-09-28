(ns escher.core.rectangle
  (:use :reload-all [escher.core.vect]))

(defstruct rectangle :origin :horiz :vert :graphics)

(defn make-rect [origin horiz vert graphics]
  (struct rectangle origin horiz vert graphics))

(defstruct point :xcor :ycor)

(defn coord-map [rectangle]
  (fn [point]
    (+vect
      (+vect
       (scale (:xcor point) (:horiz rectangle))
       (scale (:ycor point) (:vert rectangle)))
      (:origin rectangle))
    )
  )
