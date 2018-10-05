(ns economy.agent-test
  (:require [clojure.test :refer :all])
  (:require [economy.agent :refer :all]))

(deftest move-right-adds-one-to-x
  (is (= (move-right {:x 1} 5) {:x 2} )))

(deftest move-right-does-not-move-if-on-edge
  (is (= (move-right {:x 4} 5) {:x 4} )))

