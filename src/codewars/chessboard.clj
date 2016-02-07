; http://www.codewars.com/kata/55ab4f980f2d576c070000f4
(ns codewars.chessboard)

(defn game [n]
  (let [square (* n n)]
    (if (odd? square) [square 2] [(/ square 2)])))
