(ns gravatar.test.handler
  (:use midje.sweet
        ring.mock.request
        gravatar.handler))

(facts
  (fact "main route"
    (let [response (app (request :get "/gravatar?email=tommi@iki.fi&size=200&https=false&default=mm"))]
      (:status response) => 200
      (:body response) => (contains "http://www.gravatar.com/avatar/5de1105d1b72989a597f3d5e144bcc2b.jpg?s=200&amp;r=pg&amp;d=mm&amp;")))

  (fact "not-found route"
    (let [response (app (request :get "/invalid"))]
      (:status response) => 404)))
