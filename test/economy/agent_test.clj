(ns economy.agent-test
  (:require [clojure.test :refer :all])
  (:require [economy.agent :refer :all])
  (:require [economy.grid :refer :all]))

(def default-grid (create-grid 5 5 "."))

(deftest move-right-adds-one-to-x
  (is (= (move-right {:pos [1, 3]} default-grid) {:pos [2, 3]} )))

(deftest move-right-does-not-move-if-on-edge
  (is (= (move-right {:pos [4, 3]} default-grid) {:pos [4, 3]} )))

(deftest move-updates-x
  (is (= (move {:pos [3, 3]} [1 0] default-grid) {:pos [4, 3]} )))

(deftest move-updates-y
  (is (= (move {:pos [3, 3]} [0 -1] default-grid) {:pos [3, 2]} )))

(deftest count-good-returns-sum-of-character
  (is (= (count-good [\a \b \a \c] \a) 2)))
