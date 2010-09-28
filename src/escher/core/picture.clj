(ns escher.core.picture
  (:use :reload-all
	[escher.core.segment]
	[escher.core.rectangle]
	[escher.core.vect])
  (:import java.awt.geom.Line2D java.awt.Color))

(defn drawline [p1 p2 g]
  (println (:x p1) (:y p1) (:x p2) (:y p2))
  (.drawLine g (:x p1) (:y p1) (:x p2) (:y p2))
  )

(defn make-picture [seglist]
  (fn [rect]
    (doseq [s seglist]
      (drawline
        ((coord-map rect) (:seg-start s))
        ((coord-map rect) (:seg-end s))
        (:graphics rect)
        )
      )
    )
  )

(defn beside [pic1 pic2 a]
  (fn [rect]
    (pic1 (make-rect
      (:origin rect)
      (scale a (:horiz rect))
      (:vert rect)))

    (pic2 (make-rect
      (+vect (:origin rect) (scale a (:horiz rect)))
      (scale (- 1 a) (:horiz rect))
      (:vert rect)))
    )
  )