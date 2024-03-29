(defproject ring-clavatar-spike "0.1.0-SNAPSHOT"
  :description "Ring Clavatar Spike"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.5"]
                 [hiccup "1.0.3"]
                 [clavatar "0.2.1"]]
  :plugins [[lein-ring "0.8.2"]]
  :ring {:handler gravatar.handler/app}
  :profiles {:dev {:dependencies [[ring-mock "0.1.3"]
                                  [midje "1.5.1"]]
                   :plugins [[lein-midje "2.0.1"]]}})
