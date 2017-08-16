(ns nenewss.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [nenewss.core-test]))

(doo-tests 'nenewss.core-test)

