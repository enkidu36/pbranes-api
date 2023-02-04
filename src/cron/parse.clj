(ns cron.parse
  (:import (com.cronutils.model.definition CronDefinitionBuilder)
           (com.cronutils.parser CronParser)
           (com.cronutils.model CronType)
           (com.cronutils.descriptor CronDescriptor)
           (java.util Locale))
  (:require [cronstar.parser :as p]))


(def expression "0 23 * ? * 1-5 *")


(defn cron->human-time [type locale expression]
  (let [cronDefinition (CronDefinitionBuilder/instanceDefinitionFor type)
        parser (CronParser. cronDefinition)
        descriptor (CronDescriptor/instance locale)]
    (.describe descriptor (.parse parser expression))))

(prn ( cron->human-time CronType/QUARTZ Locale/US expression))

(comment

  (p/parse [:minute :hour] "*/2 1-10/3"))