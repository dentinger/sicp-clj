(ns sicp-clj.core-test
  (:require [clojure.test :refer :all]
            [sicp-clj.core :refer :all]
			[sicp-clj.chpt1.solution :refer :all]))

(deftest test-good-enough-false
 (testing "the first impl of good enough will return false when not within bounds"
  (is (= false (good-enough? 1.0 4.0)))))

  (deftest test-good-enough-true
	  (testing "the first impl of good enough will return true when within the bounds"
	  (is (= true (good-enough? 4.00000000001 4.0)))))

	  (deftest test-sqrt2-sqrt-of-4
		  (testing "the sqrt2 function returns a sqrt that is good enough "
		  (is (good-enough? (sqrt2 4) 2.0))))
(deftest test-sqrt2-sqrt-of-9
(testing "the sqrt of 9 is 3 using the new sqrt2 function"
(is (good-enough? 3 (sqrt2 9)))))

(deftest test-sqrt2-self-check
(testing "the value of two calls to sqrt2 are the same value"
(is (= (sqrt2 144) (sqrt2 144)))))

(deftest test-euler-cube-root-with-8 
(testing "the value of the cube root of 8 is 2 using the euler-cube-root-method"
(is (good-enough? 2 (cube-root-euler 8)))))

(deftest test-cube-root-of1000
	(testing "the value of the cube root of 1000 is 10 using cube-root-euler"
(is (good-enough? 10.0 (cube-root-euler 1000)))))
