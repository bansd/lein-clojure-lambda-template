# lein-clojure-lambda-template
A leiningen template for AWS Lambda in clojure

[![Clojars Project](https://clojars.org/clojure-lambda/lein-template/latest-version.svg)](https://clojars.org/bansd/clojure-lambda/lein-template)

# Requirments 
Requires Leiningen version 2.5.3+

# Usage
Run the following command to create Clojure template for Lambda function

```bash
lein new clojure-lambda <your-app-name>
lein new clojure-lambda hello-world
```

In AWS Lambda console, select `Java` runtime and add `hello_world.core::handler` as handler function.

Use below to convert LinkedHashedMap to convert to clojure map when input is passed as JSON.
```clojure
(->cljmap java-Map)
```

If String is passed as input event, use `String` instead of `java.util.Map`
```clojure
:methods [^:static [handler [String] String]]
```
