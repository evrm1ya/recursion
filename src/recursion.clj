(ns recursion)

(defn product [coll]
  (if (empty? coll)
    1
    (* (first coll)
       (product (rest coll)))))

(defn singleton? [coll]
  (if (empty? coll) 
    false
    (empty? (rest coll))))

(defn my-last [coll]
    (cond
      (empty? coll) nil
      (singleton? coll) (first coll)
      :else (my-last (rest coll))))

(defn max-element [a-seq]
  (let [[alpha & remaining] a-seq]
    (cond
      (empty? a-seq) nil
      (singleton? a-seq) alpha
      :else (max alpha (max-element remaining)))))

(defn seq-max [seq-1 seq-2]
  (if (> (count seq-1) (count seq-2))
    seq-1
    seq-2))

(defn longest-sequence [a-seq]
  (let [[alpha & remaining] a-seq]
    (cond
      (empty? a-seq) nil
      (singleton? a-seq) alpha
      :else (seq-max alpha (longest-sequence remaining)))))

(defn my-filter [pred? a-seq]
  (cond
    (empty? a-seq) a-seq
    (pred? (first a-seq))
      (cons (first a-seq)
            (my-filter pred? (rest a-seq)))
    :else (my-filter pred? (rest a-seq))))

(defn sequence-contains? [elem a-seq]
  (let [[alpha & remaining] a-seq]
    (cond
      (empty? a-seq) false
      (and (singleton? a-seq) (not (= elem alpha))) false
      (= elem alpha) true
      :else (sequence-contains? elem remaining))))

(defn my-take-while [pred? a-seq]
  (if (or (empty? a-seq) ((complement pred?) (first a-seq)))
    '()
    (cons (first a-seq) (my-take-while pred? (rest a-seq)))))

(defn my-drop-while [pred? a-seq]
  (cond
    (empty? a-seq) '()
    (pred? (first a-seq)) (my-drop-while pred? (rest a-seq))
    :else a-seq))

(defn seq= [a-seq b-seq]
  (let [[alpha1 & remaining1] a-seq
        [alpha2 & remaining2] b-seq]
  (cond
    (and (empty? a-seq) (empty? b-seq)) true
    (not= (empty? remaining1) (empty? remaining2)) false
    (not= alpha1 alpha2) false
    :else (seq= remaining1 remaining2))))
    
(defn my-map [f seq-1 seq-2]
  (let [[alpha1 & remaining1] seq-1
        [alpha2 & remaining2] seq-2]
  (cond
    (or (empty? seq-1) (empty? seq-2)) '()
    (or (empty? remaining1) (empty? remaining2))
      (vector (f alpha1 alpha2))
    :else (cons (f alpha1 alpha2)
                (my-map f remaining1 remaining2)))))

;; to handle negative powers -> 1 / (power n (* -1 k))
(defn power [n k]
  (if (zero? k)
    1
    (* n (power n (dec k)))))

;; compute the nth fibonacci number
;; Fn defined as:
;; F0 = 0
;; F1 = 1
;; Fn = Fn-1 + Fn-2
(defn fib [n]
  (cond
    (= n 0) 0
    (= n 1) 1
    :else (+ (fib (- n 1)) (fib (- n 2)))))

(defn my-repeat [how-many-times what-to-repeat]
  (if (<= how-many-times 0)
    '()
    (cons what-to-repeat (my-repeat (dec how-many-times) what-to-repeat))))

(defn my-range [up-to]
  (if (<= up-to 0)
    '()
    (cons (dec up-to) (my-range (dec up-to)))))

;; original
;;(defn tails [a-seq]
;;  (if (empty? a-seq)
;;    [[]]
;;    (map vec (cons a-seq (tails (rest a-seq))))))

;; checked
(defn tails [a-seq]
  (if (empty? a-seq)
    '(())
    (cons a-seq (tails (rest a-seq)))))

(defn inits [a-seq]
  (map reverse (tails (reverse a-seq))))

(defn rotations [a-seq]
  [:-])

(defn my-frequencies-helper [freqs a-seq]
  [:-])

(defn my-frequencies [a-seq]
  [:-])

(defn un-frequencies [a-map]
  [:-])

(defn my-take [n coll]
  [:-])

(defn my-drop [n coll]
  [:-])

(defn halve [a-seq]
  [:-])

(defn seq-merge [a-seq b-seq]
  [:-])

(defn merge-sort [a-seq]
  [:-])

(defn split-into-monotonics [a-seq]
  [:-])

(defn permutations [a-set]
  [:-])

(defn powerset [a-set]
  [:-])

