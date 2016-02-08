; http://www.codewars.com/kata/5629db57620258aa9d000014
(ns codewars.mix
  (:require [clojure.set :refer [union]]
            [clojure.string :refer [join]]))

(defn freq-map [s]
  (->> s
       (filter #(Character/isLowerCase %))
       (frequencies)
       (filter (fn [[_ v]] (> v 1)))
       (into {})))

(defn maximums [s1-freq s2-freq]
  (let [fmt (fn [winner letter freq]
              (str winner ":" (join (repeat freq letter))))]
    (for [letter (union (set (keys s1-freq)) (set (keys s2-freq)))]
      (let [s1-letter (get s1-freq letter 0)
            s2-letter (get s2-freq letter 0)]
        (cond
          (> s1-letter s2-letter)
            (fmt "1" letter s1-letter)
          (> s2-letter s1-letter)
            (fmt "2" letter s2-letter)
          :else
            (fmt "=" letter s1-letter))))))

(defn mix [s1 s2]
  (->> (maximums (freq-map s1) (freq-map s2))
       (sort-by (juxt (comp - count) identity))
       (join "/")))
