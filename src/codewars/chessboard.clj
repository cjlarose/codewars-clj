; http://www.codewars.com/kata/55ab4f980f2d576c070000f4
(ns codewars.chessboard)

(defn game [n]
  (let [board (for [i (range n) j (range n)] (/ (+ j 1) (+ i j 2)))
        sum (reduce + 0 board)]
    (if (ratio? sum)
      [(numerator sum) (denominator sum)]
      [sum])))
