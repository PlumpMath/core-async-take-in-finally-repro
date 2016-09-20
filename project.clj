(defproject core-async-repro "0.1.0-SNAPSHOT"
  :description "Reproduces a core.async bug involving a parking take (<!) in a finally clause."
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :main core-async-repro.core
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/core.async "0.2.391"]])
