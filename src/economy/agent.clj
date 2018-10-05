(ns economy.agent)

(defn move-right
  [agent grid-width]
  (if (< (agent :x) (- grid-width 1))
    (update agent :x inc)
    agent))
