(ns gravatar.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [hiccup.core :refer [html]]
            [ring.util.response :as response]
            [clavatar.core :as clavatar]))

(defn gravatar [{:keys [email https] :as params}]
  (apply clavatar/gravatar email (-> params (assoc :https (= "true" https)) vec flatten)))

(defroutes app-routes
  (GET "/" []
    (response/redirect "/gravatar?email=tommi@iki.fi&size=200&https=false&default=mm"))
  (GET "/gravatar" {:keys [params]}
    (html [:html
           [:body
            [:pre (:doc (meta #'clavatar/gravatar))]
            [:img {:src (gravatar params)}]]]))
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
