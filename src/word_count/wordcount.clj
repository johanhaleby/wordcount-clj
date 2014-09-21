(ns word-count.wordcount)

(defn gather-words [string]
  (let [words (seq (.split string "\\W+"))
        non-empty-words (filter #(not (.isEmpty %)) words)
        lowercase-words (map #(.toLowerCase %) non-empty-words)
        gathered-words (frequencies lowercase-words)]
    gathered-words))