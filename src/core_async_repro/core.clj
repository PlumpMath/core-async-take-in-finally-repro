(ns core-async-repro.core
  "Repro for a core.async bug involving a `<!` in a finally clause."
  (require [clojure.core.async :as a]
           [core-async-repro.repro :refer [reproduced?]]))

(defn -main [& args]
  (println
    (if (a/<!! (reproduced?))
      "Reproduced the issue."
      "Did not reproduce the issue.")))
