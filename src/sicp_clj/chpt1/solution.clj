(ns sicp-clj.chpt1.solution)



(defn good-enough? [guess x] 	
	(<  ( Math/abs (- guess x)) 0.000001) )
	
;;; Exercise 1.7
(defn sqrt2 [val]
  (defn good-enough? [old-guess new-guess] 	
	(<  (/ ( Math/abs (- old-guess new-guess)) old-guess) 0.000001) )
  (defn improve [guess] 
	(defn average [ a b] ( / (+ a b) 2))
	(average guess (/ val guess)))
  (defn  sqrt-iter [guess] 
    (let [newg (improve guess)]
 	(if (good-enough? guess newg) newg
		(sqrt-iter newg)
     )))	 
   (sqrt-iter 1.0)	
	)
	
(defn euler [ a b] 
	(defn sq [x] (* x x)) 
	( / (+ (/ a (sq b)) (* 2 b)) 3))
;;; Exercise 1.8
(defn cube-root-euler [val]
  (defn good-enough? [old-guess new-guess] 	
  	(<  (/ ( Math/abs (- old-guess new-guess)) old-guess) 0.0000001) )
  (defn sq [x] (* x x))
  (defn improve [guess] 
  	(defn euler [ a b] ( / (+ (/ a (sq b)) (* 2 b)) 3))
  	(euler val guess))
    (defn  cube-iter [guess] 
      (let [newg (improve guess)]
   	(if (good-enough? guess newg) newg
  		(cube-iter newg)
       )))	 
     (cube-iter 1.0)		
	)
;;;factorial impl #1
(defn factorial-l [n]
	(if (= n 1) 
		1
		(* n (factorial-l (- n 1)))))
(defn factorial-t [n]
	(defn fact-iter [product counter]
		(if (> counter n) 
			product
			(fact-iter (* product counter)
			           (+ counter 1))))
	(fact-iter 1 1))
;;; impl of Ackermann's function Excercise 1.10
(defn ackermann [ x y]
	(cond (= y 0) 0
		  (= x 0) (* 2 y)
		  (= y 1) 2
		   :else (ackermann (- x 1) (ackermann x (- y 1)))))
(defn a-fn [n]
	(ackermann 0 n))
	
(defn a-gn [n]
	(ackermann 1 n))

(defn a-hn [n]
(ackermann 2 n))	
;;;;  Tree Recusion Section 1.2.2
(defn fib1 [x] 
	(cond (= x 0) 0
		  (= x 1) 1
		  :else (+ (fib1 (- x 1)) (fib1 (- x 2)))))
(defn fib2 [x]
(defn fib-iter [a b count] 
	(if (= count 0) 
		b
		(fib-iter (+ a b) a (- count 1))))
		(fib-iter 1 0 x) )  
			
(defn count-change [amount]
	(defn first-denomination [kind-of-coins]
			(cond (= kind-of-coins 1) 1
				(= kind-of-coins 2) 5
				(= kind-of-coins 3) 10
		        (= kind-of-coins 4) 25
				(= kind-of-coins 5) 50			
				))
	(defn cc [amount kind-of-coins]
		(cond (= amount 0) 1
			(or (< amount 0) ( = kind-of-coins 0)) 0
				:else (+ (cc amount (- kind-of-coins 1)) 
					     (cc (- amount 
							    (first-denomination kind-of-coins) )
							  kind-of-coins))))
	
		(cc amount 5))
;;; Exercise 1.11 f(n) = { {n <3: n; n>= 3: (f(n-1) + 2f(n-2) + 3f(n-3))}}
(defn f1_11lr [n]
	(if (< n 3) n
		(+ (f1_11lr (- n 1)) 
		   (* 2 (f1_11lr (- n 2)))
		   (* 3 (f1_11lr (- n 3)))
		   ))
	)
;;; use a handfull of variables in an internal iter to turn tree recusrions in to tail recursion.  
;;; Will need a n, n1, n2, n3 and counter I think.	
(defn f1_11itr [n]
	(defn fn-iter [n n1 n2 n3 counter]
		;;;(println (str "n: " n " n1: " n1 " n2: " n2 " n3: " n3 " counter: " counter))	
		(cond (< counter 3 ) n
			:else 
				(fn-iter 
				(+ n (* 2 n1) (* 3 n2))
				 n n1 n2
				 (- counter 1) )
				 ))
		(if (< n 3) n 
			(fn-iter 2 1 0 0 n))
)

;;; exercise 1.12 implement a procedure that computes Pascal's triangle recurisvly
(defn pascal-triangle [level]
	(defn calc-col [row length position]
		(cond (= position 0) 1
			   (= position length ) 1
				:else (+ (nth row position) (nth row (- position 1))))
		)
  (defn calr [row] 
	  (let 
		  [[rowlen newrow] [(count row) [] ]] 
		(loop [rl rowlen n 0 nr newrow] 
    (if (> 0 rl) nr
        (recur (- rl 1) (+ n 1) (conj nr (calc-col row rowlen n))) 
				 ))
     ))  

  (defn pt-iter [triangle level counter]
	(cond 
   (= level counter) triangle 
   		:else (pt-iter
             (conj triangle (calr (last triangle)))
			level (+ counter 1))
		))
	(pt-iter [[1]] level 1)
 
)