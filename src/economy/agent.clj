(ns economy.agent)

(defn move-right [agent grid]
   (let [max-length (-> (grid 0) count dec)]
    (let [x ((agent :pos) 0)]
      (if (< x max-length)
        (update agent :pos #(update-in % [0] inc))
        agent))))

(defn move [agent direction grid]
  (update agent :pos #(vec (map + % direction))))

(defn count-good [good char]
  ((frequencies good) char))
