; http://www.codewars.com/kata/559aa1295f5c38fd7b0000ac
(ns codewars.routes)

(defn routes [n]
  (if (< n 1)
    0
    (/ (apply *' (map #(+ n % 1) (range n)))
       (apply *' (range n 0 -1)))))
