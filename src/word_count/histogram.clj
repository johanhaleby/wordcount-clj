(ns word-count.histogram)

(defn- sort-by-values-desc [m]
  (into (sorted-map-by (fn [key1 key2]
                         (compare [(get m key1) key1]
                                  [(get m key2) key2])))
        m))

(defn histogram! [words]
  (let [sorted-words (sort-by-values-desc words)]
    (doseq [[word count] sorted-words]
      (let [sharps (reduce str (take count (repeat "#")))]
        (printf "%-12.10s %s\n" word sharps)))))


