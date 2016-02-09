; http://www.codewars.com/kata/54d496788776e49e6b00052f
(ns codewars.sumbyfactors)

(defn prime-factors [n]
  (loop [factors '() x n]
    (if (= x 1)
      factors
      (let [factor (some #(when (= (rem x %) 0) %) (range 2 (inc x)))]
        (recur (conj factors factor) (quot x factor))))))

(defn sum-of-divided [xs]
  (->> xs
       (mapcat (fn [n] (map #(vector % n) (set (prime-factors (Math/abs n))))))
       (reduce (fn [memo [p n]] (update-in memo [p] (fnil #(+ n %) 0))) {})
       (seq)
       (sort)))
