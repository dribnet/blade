(defproject net.drib/blade "0.2.0-SNAPSHOT"
  :description "blade: leaflet from clojurescript"
  :url "https://github.com/dribnet/blade"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [net.drib/mrhyde "0.5.2"]  ]
  :min-lein-version "2.0.0"
  :source-paths ["src/cljs"]

  :plugins [[lein-cljsbuild "0.3.2"]]

  :cljsbuild {:builds [{:source-paths ["src/cljs"]
                        :jar true}

                       ; tests
                       {:source-paths ["src/cljs" "test/cljs"]
                        :compiler  {:optimizations :whitespace
                                    :pretty-print true
                                    :print-input-delimiter true
                                    :output-to "public/out/test_whitespace.js"}}
                       {:source-paths ["src/cljs" "test/cljs"]
                        :compiler  {:optimizations :simple
                                    :pretty-print true
                                    :print-input-delimiter true
                                    :output-to "public/out/test_simple.js"}}
                       {:source-paths ["src/cljs" "test/cljs"]
                        :compiler  {:optimizations :advanced
                                    :externs ["public/d3/d3-externs.js"]
                                    :pretty-print true
                                    :print-input-delimiter true
                                    :output-to "public/out/test_advanced.js"}}

                      ; blade "internal" examples
                       {:source-paths ["examples/tutorial1"]
                        :compiler  {:optimizations :simple
                                    :pretty-print false
                                    :output-to "public/out/tutorial1.js"}}
                      ]})
