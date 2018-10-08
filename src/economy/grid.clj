(ns economy.grid
  (:require [clojure.string :only (join)]))

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
  (reduce #(str %1 (join " " %2) "\n") "" grid))

