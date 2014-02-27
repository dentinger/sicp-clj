(ns sicp-clj.chpt1.solution)



(defn good-enough? [guess x] 	
	(<  ( Math/abs (- guess x)) 0.000001) )
	 


;;; Exercise 1.7
(defn sqrt2 [val]
  (defn good-enough? [old-guess new-guess] 	
	(<  (/ ( Math/abs (- old-guess new-guess)) old-guess) 0.0001) )
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


