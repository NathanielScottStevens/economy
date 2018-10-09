(ns economy.grid-test
  (:require [clojure.test :refer :all]
            [economy.grid :refer :all]))

(def default-grid [["@" "."] ["." "."]])

(deftest create-grid-returns-correct-value
  (is (= (create-grid 3 3 ".")
          [["." "." "."]
           ["." "." "."]
           ["." "." "."]])))

(deftest set-value-works
  (is (= (set-grid-value default-grid 1 1 "@")
         [["@" "."]["." "@"]])))

(deftest set-value-returns-nil-when-x-is-out-of-bounds
  (is (= (set-grid-value default-grid 100 0 "@")
         nil)))

(deftest set-value-returns-nil-when-y-is-out-of-bounds
  (is (= (set-grid-value default-grid 0 100 "@")
         nil)))

(deftest get-value-works
  (is (= (get-grid-value default-grid 0 0)
         "@")))

(deftest get-value-returns-nil-when-x-is-out-of-bounds
  (is (= (get-grid-value default-grid 100 0)
         nil)))

(deftest get-value-returns-nil-when-y-is-out-of-bounds
  (is (= (get-grid-value default-grid 0 100)
         nil)))

(deftest convert-grid-to-string-does-so
  (is (= (convert-grid-to-string default-grid)
         "@ .\n. .\n")))

(deftest position-in-bounds-returns-true-when-in-lower-bounds
  (is (= (position-in-bounds? [0, 0] default-grid) true)))

(deftest position-in-bounds-returns-true-when-in-upper-bounds
  (is (= (position-in-bounds? [1, 1] default-grid) true)))

(deftest position-in-bounds-returns-false-when-below-lower-bounds
  (is (= (position-in-bounds? [-1, -1] default-grid) false)))

(deftest position-in-bounds-returns-false-when-above-upper-bounds
  (is (= (position-in-bounds? [5, 5] default-grid) false)))

