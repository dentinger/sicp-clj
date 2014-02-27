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