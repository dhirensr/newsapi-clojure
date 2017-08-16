(ns nenewss.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [nenewss.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[nenewss started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[nenewss has shut down successfully]=-"))
   :middleware wrap-dev})
