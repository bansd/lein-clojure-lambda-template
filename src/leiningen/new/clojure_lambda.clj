(ns leiningen.new.clojure-lambda
  (:require [leiningen.new.templates :refer [multi-segment sanitize-ns renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "clojure-lambda"))

(defn clojure-lambda
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :namespace (multi-segment (sanitize-ns name))
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' clojure-lambda project.")
    (->files data
             ["README.md" (render "README.md" data)]
             [".gitignore" (render "gitignore" data)]
             ["test/{{sanitized}}/core_test.clj" (render "test.clj" data)]
             ["project.clj" (render "project.clj" data)]
             ["src/{{sanitized}}/core.clj" (render "core.clj" data)])))
