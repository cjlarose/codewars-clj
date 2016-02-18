(ns codewars.weight-sort
  (require [clojure.string :refer [split join]]))

(defn order-weight [weight-str]
  (let [weight (fn [s] (apply + (map #(- (int %) 48) (seq s))))]
    (->> (split weight-str #" ")
         (sort-by (juxt weight identity))
         (join \space))))
