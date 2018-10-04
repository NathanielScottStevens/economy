(ns economy.core
  (:gen-class))

(use 'seesaw.core)

(def f (frame
         :title "Economy"
         :size [640 :by 480]))

(defn display [content]
  (config! f :content content)
  content)

(defn print-map []
  (display (text :font "MONOSPACED-PLAIN-12" :multi-line? true :text ". . .\n. @ .\n. . ."))
  (Thread/sleep 1000)
  (display (text :font "MONOSPACED-PLAIN-12" :multi-line? true :text ". . .\n. . @\n. . ."))
  (Thread/sleep 1000))

(defn -main
  [& args]
  (native!)
  (-> f show!)
  (while true
    (print-map)))

