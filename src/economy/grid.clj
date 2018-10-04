(ns economy.grid)

(defn create-grid
  [width height val]
  (vec (repeat height (vec (repeat width val)))))

(defn set-value
  [grid x y val]
  (try
    (assoc grid y (assoc (grid y) x val))
    (catch Exception e nil)))