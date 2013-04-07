(defproject gravatar "0.1.0-SNAPSHOT"
  :description "Gravatar test"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.5"]
                 [hiccup "1.0.3"]
                 [midje "1.5.1"]
                 [clavatar "0.2.1"]]
  :plugins [[lein-ring "0.8.2"]]
  :ring {:handler gravatar.handler/app}
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.3"]]}})
