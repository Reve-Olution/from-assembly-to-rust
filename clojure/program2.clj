(ns program)

; Pure part
(defn process [nbelements]
  (reduce (fn [acc v] (+ acc 1)) 0 (range nbelements)))
  ;nbelements)

;(time (reduce + 0 (map (fn [a] @a) (map (fn [_] (future (process 10000000))) (range 0 4)))))
;(time (reduce + 0 (pmap (fn [_] @(future (process 10000000))) (range 0 4))))
(time (->> (range 0 4)
  (map (fn [_] (future (process 10000000))))
  (map (fn [a] @a))
  (reduce + 0)
  (prn)))

(shutdown-agents)
