; http://www.codewars.com/kata/5672682212c8ecf83e000050
(ns codewars.dblinear)

(defn series
  ([] (series (sorted-set 1)))
  ([q] (lazy-seq
         (let [x     (first q)
               new-q (conj (disj q x) (+ (* 2 x) 1) (+ (* 3 x) 1))]
           (cons x (series new-q))))))

(def dblinear (partial nth (series)))
