(ns core-async-repro.repro
  "Repro for a core.async bug involving a `<!` in a finally clause."
  (require [clojure.core.async :as a :refer [go <!]]))

;; you'd expect those 2 functions to return the same thing

(defn without-<!
  []
  (go
    (try :a
      (finally :b))
    ))

(defn with-<!
  []
  (go
    (try :a
      (finally (<! (go :b))))
    ))

;; they don't, try it in the REPL:

(comment
  (a/<!! (without-<!))
  => :a

  (a/<!! (with-<!))
  => :b
  )

(defn reproduced?
  "Returns whether the bug was reproduced in a channel."
  []
  (go
    (not= (<! (with-<!)) (<! (without-<!)))))
