; http://www.codewars.com/kata/55e2adece53b4cdcb900006c
(ns codewars.tortoise)

(defn race [v1 v2 g]
  (if (< v1 v2)
    (let [secs (int (Math/floor (* (/ (- g) (- v1 v2)) 3600)))]
      [(quot secs 3600) (mod (quot secs 60) 60) (mod secs 60)])))
