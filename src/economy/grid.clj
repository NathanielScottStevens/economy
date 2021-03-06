(ns economy.grid
  (:require [clojure.string]))

(defn create-grid
  [width height val]
  (vec (repeat height (vec (repeat width val)))))

(defn set-grid-value
  [grid x y val]
  (try
    (assoc grid y (assoc (grid y) x val))
    (catch Exception e nil)))

(defn get-grid-value
  [grid x y]
  (try
    ((grid y) x)
    (catch Exception e nil)))

(defn convert-grid-to-string
  [grid]
  (letfn [(append [a b] (str a (clojure.string/join " " b) "\n"))]
    (reduce append "" grid)))

(defn position-in-bounds? [position grid]
  (let [bounds [(-> (grid 0) count dec)
                (-> grid count dec)]]
    (and (>= (position 0) 0)
         (<= (position 0) (bounds 0))
         (>= (position 1) 0)  
         (<= (position 1) (bounds 1)))))

