(ns nenewss.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[nenewss started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[nenewss has shut down successfully]=-"))
   :middleware identity})
