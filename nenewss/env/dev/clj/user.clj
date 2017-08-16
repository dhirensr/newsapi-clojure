(ns user
  (:require [mount.core :as mount]
            [nenewss.figwheel :refer [start-fw stop-fw cljs]]
            nenewss.core))

(defn start []
  (mount/start-without #'nenewss.core/repl-server))

(defn stop []
  (mount/stop-except #'nenewss.core/repl-server))

(defn restart []
  (stop)
  (start))


