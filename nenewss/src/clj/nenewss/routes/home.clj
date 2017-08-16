(ns nenewss.routes.home
  (:require [nenewss.layout :as layout]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]
            [clj-http.client :as client]
            [clojure.data.json :as json]))

(defn home-page []
  (layout/render "home.html"))

#_(defn fetch-news []
  (let [content (-> (str "https://newsapi.org/v1/articles?source=the-next-web&sortBy=latest&apiKey=b2735befc15f4264aa598dd50fecba3f")
                    client/get
                    :body
                    json/read-str)]
    content))


(defn pull-values [m val-map]
  (into {} (for [[k v] val-map]
             [k (get-in m (if (sequential? v) v [v]))])))

(defn all-task
  "displays all news"
  [m]
  (map
   #(select-keys % [:author :title :description])
   m))

(defn newss []
  (layout/render-json  (-> (str "https://newsapi.org/v1/articles?source=the-next-web&sortBy=latest&apiKey=")
                           client/get
                           :body
                           json/read-str
                           #_(pull-values {:author ["articles" 0 "author"]
                                           :title ["articles" 0 "title"]
                                           :description ["articles" 0 "description"]})
                           (clojure.walk/keywordize-keys)
                           (:articles)
                           (all-task))))


(defroutes home-routes
  (GET "/" []
       (home-page))
  (GET "/news" []
       (newss))
  (GET "/docs" []
       (-> (response/ok (-> "docs/docs.md" io/resource slurp))
           (response/header "Content-Type" "text/plain; charset=utf-8"))))


(client/get  "https://newsapi.org/v1/articles?source=the-next-web&sortBy=latest&apiKey=b2735befc15f4264aa598dd50fecba3f")
