(ns word-count.boot
  (:gen-class)
  (:require [clojure.java.io :as io]
            [word-count.wordcount :refer :all]
            [word-count.histogram :refer :all]))

(defn read-file [file]
  (slurp (io/file file)))


(defn -main
  "I don't do a whole lot ... yet."
  [& [file-name]]
  (let [words (gather-words (read-file file-name))]
    (histogram! words)))