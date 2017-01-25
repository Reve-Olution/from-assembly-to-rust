(ns program)

; Pure part
(defn process [nbelements]
  (reduce (fn [acc v] (+ acc 1)) 0 (range nbelements)))

; Impure part
(def f1 (future (process 10000000)))
(def f2 (future (process 10000000)))
(def f3 (future (process 10000000)))
(def f4 (future (process 10000000)))

(time
  (prn (+ @f1 @f2 @f3 @f4)))

(shutdown-agents)
