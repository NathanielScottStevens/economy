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
