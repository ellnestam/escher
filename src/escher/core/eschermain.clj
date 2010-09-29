(ns eschermain
  (:gen-class))

(use 'escher.core.launch)

(defn -main [& args]
  (run-escher))