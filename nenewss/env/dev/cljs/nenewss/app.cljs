(ns ^:figwheel-no-load nenewss.app
  (:require [nenewss.core :as core]
            [devtools.core :as devtools]))

(enable-console-print!)

(devtools/install!)

(core/init!)
