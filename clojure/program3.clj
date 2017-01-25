(ns program)

(def nb (atom 0))

; Pure part
(defn process [nbelements]
  (count (range 0 nbelements)))

;(time (reduce + 0 (map (fn [a] @a) (map (fn [_] (future (process 10000000))) (range 0 4)))))
;(time (reduce + 0 (pmap (fn [_] @(future (process 10000000))) (range 0 4))))
(time (->> (range 0 4)
  (map (fn [_] (future (process 10000000))))
  (map (fn [a] @a))
  (reduce + 0)
  (swap! nb +)
  (prn)))

(shutdown-agents)
