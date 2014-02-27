(defproject sicp-clj "0.1.0-SNAPSHOT"
  :description "Answers to SICP"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]]
  :main ^:skip-aot sicp-clj.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
