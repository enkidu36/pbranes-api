(ns cron.parse
  (:import (com.cronutils.model.definition CronDefinitionBuilder)
           (com.cronutils.parser CronParser)
           (com.cronutils.model CronType)
           (com.cronutils.descriptor CronDescriptor)
           (java.util Locale)))

(defn cron->human-time [cronType locale expression]
  (let [cronDefinition (CronDefinitionBuilder/instanceDefinitionFor cronType)
        parser (CronParser. cronDefinition)
        descriptor (CronDescriptor/instance locale)]
    (.describe descriptor (.parse parser expression))))

(comment
  (def expression "0 23 * ? * 1-5 *")
  (cron->human-time CronType/QUARTZ Locale/US expression))