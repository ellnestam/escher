(ns escher.core.vect)

(defstruct vect :x :y)

(defn make-vect [x y]
  (struct vect x y)
  )

(defn +vect [v1 v2]
  (make-vect
    (+ (:x v1) (:x v2))
    (+ (:y v1) (:y v2))
    )
  )

(defn scale [s vect]
  (make-vect
    (* s (:x vect))
    (* s (:y vect))
    )
  )