(ns {{namespace}}
  (:gen-class
   :methods [^:static [handler [java.util.Map] String]]))


(defprotocol ConvertibleToClojure
  (->cljmap [o]))

(extend-protocol ConvertibleToClojure
  java.util.Map
  (->cljmap [o] (let [entries (.entrySet o)]
                (reduce (fn [m [^String k v]]
                          (assoc m (keyword k) (->cljmap v)))
                        {} entries)))

  java.util.List
  (->cljmap [o] (vec (map ->cljmap o)))

  java.lang.Object
  (->cljmap [o] o)

  nil
  (->cljmap [_] nil))

(defn -handler [s]
  (println (->cljmap s))
  (println "Hello World!"))
