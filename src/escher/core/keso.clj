(import 'javax.swing JFrame JPanel JButton)

(defn escher []
  (
        ; (clear gfx)
        ;(.setSize frame (java.awt.Dimension. 640 480))

       ;(def rect (make-rect origin x y gfx))
       ;(pic rect)


      (let [
        button (JButton. "Add 1")
        panel (JPanel.)
        frame (JFrame. "Counter App")]
    (.setOpaque panel true)
    (.add panel button)
    (.setContentPane frame panel)
    (.setSize frame 300 100)
    (.setVisible frame true))

  )
  )
