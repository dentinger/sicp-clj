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

(deftest test-factorial-l-6
(testing "the liner recursion impl of factorial computes 6! correctly"
(is (= 720 (factorial-l 6)))))

(deftest test-factorial-l-1
(testing "the liner recursion impl of factorial computes 1! correctly"
(is (= 1 (factorial-l 1)))))
(deftest test-factorial-l-2
(testing "the liner recursion impl of factorial computes 1! correctly"
(is (= 2 (factorial-l 2)))))

(deftest test-factorial-t-6
(testing "the tail recursion impl of factorial computes 6! correctly"
(is (= 720 (factorial-t 6)))))
(deftest test-factorial-t-1
(testing "the tail recursion impl of factorial computes 6! correctly"
(is (= 1 (factorial-t 1)))))

(deftest test-factorial-t-6
(testing "the tail recursion impl of factorial computes 6! correctly"
(is (= 720 (factorial-t 6)))))

(deftest test-my-two-factorials-are-the-same
(testing "that the two impls of factorial produce the same results"
 (is (= (factorial-l 1) (factorial-t 1)))
 (is (= (factorial-l 2) (factorial-t 2)))
 (is (= (factorial-l 3) (factorial-t 3)))
 (is (= (factorial-l 4) (factorial-t 4)))
 ))
 (deftest test-ackermann
(testing "that the ackermann function is running correctly"
(is (= 1024 (ackermann 1 10)))
(is (= 65536 (ackermann 2 4)))
(is (= 4 (ackermann 2 2)))
(is (= 16 (ackermann 2 3)))
))

(deftest test-fn-ackermann1-10 
	(defn dbl [x] (+ x x))
	(let [ nums (range 20)]
	(testing "that the f(n) = (A 0 n) is equal to 2* n "
	(is (= (map dbl nums) (map a-fn nums)))
	)))

(deftest test-gn-ackermann1-10 
	(testing "that the g(n) = (A 1 n) is equal to 2^n where n > 0"
(defn raise [x] (int (Math/pow 2 x)))
(let [ nums (range 1 10)]
(is (= (map raise nums) (map a-gn nums)))
)))

(deftest test-fib1-generalFibAssertions
	(testing  "that the impl of fib using linear recursion is working"
	(is (= 0 (fib1 0)))
	(is (= 1 (fib1 1)))
	(is (= 1 (fib1 2)))
	(is (= 2 (fib1 3)))
	(is (= 3 (fib1 4)))
	(is (= 5 (fib1 5)))
	(is (= 8 (fib1 6)))
	(is (= 13 (fib1 7)))
	(is (= 21 (fib1 8)))
	))
;;
(deftest test-fib2-generalFibAssertions
	(testing  "that the impl of fib using tail recursion is working"
	(is (= 0 (fib2 0)))
	(is (= 1 (fib2 1)))
	(is (= 1 (fib2 2)))
	(is (= 2 (fib2 3)))
	(is (= 3 (fib2 4)))
	(is (= 5 (fib2 5)))
	(is (= 8 (fib2 6)))
	(is (= 13 (fib2 7)))
	(is (= 21 (fib2 8)))
	))
;;testing exercise 1.11
(deftest test-linear-recur1_11-base-condition
	(testing "that the linear recur version of 1.11 works properly for the base condition of n < 3"
	(is (= 1 (f1_11lr 1)))
	(is (= 2 (f1_11lr 2)))
	(is (= 0 (f1_11lr 0)))
	))
(deftest test-linear-recur1_11-second-condition
	(testing "that the linear recur version of 1.11 works properly for the base condition of n > 3"
	(is (= 4 (f1_11lr 3)))
	(is (= 11 (f1_11lr 4)))
		
))
(deftest test-tail-recur1_11-base-condition
	(testing "that the linear recur version of 1.11 works properly for the base condition of n < 3"
	(is (= 1 (f1_11itr 1)))
	(is (= 2 (f1_11itr 2)))
	(is (= 0 (f1_11itr 0)))
	))
(deftest test-tail-recur1_11-second-condition
	(testing "that the linear recur version of 1.11 works properly for the base condition of n > 3"
	(is (= 4 (f1_11itr 3)))
	(is (= 11 (f1_11itr 4)))	
))
(deftest test-tail-recur1_11-two_versions_equality
	(defn eqlChk [x] (is (= (f1_11itr x) (f1_11lr x))))
	(testing "that the linear recur version of 1.11 works properly "
	(is (= (map f1_11itr (range 0 25))  (map f1_11lr (range 0 25))))
	
))