(ns codewars.nthseries)

(defn series-sum [n]
  (let [nth-term (fn f [i] (lazy-seq (cons (/ (+ (* 3 i) 1)) (f (inc i)))))]
    (format "%.2f" (reduce + 0.0 (take n (nth-term 0))))))
