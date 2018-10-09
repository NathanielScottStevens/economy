(ns economy.agent)

(defn move-right
  [agent grid]
  ;; (let [max-length (- (count (grid 0)) 1)]
   (let [max-length (-> (grid 0) count dec)]
    (let [x ((agent :pos) 0)]
      (if (< x max-length)
        (update agent :pos #(update-in % [0] inc))
        agent))))

(defn count-good
  [good char]
  ((frequencies good) char))
