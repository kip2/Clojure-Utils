(ns markdown-utils.core
  (:require [clj-clip.core :as clip]))

(clip/write-clip "Hello from clj-clip!")
(println (clip/read-clip))

(defn convert-to-markdown-checklist [lst]
  (let [convert-checklist (fn [element] (str "- [ ] [[" element "(Clojure)]]\n"))]
    (apply str (map convert-checklist lst))))

(defn convert-md-checklist-with-output-txt [lst output-name]
  (->> (convert-to-markdown-checklist lst)
       (spit output-name)))

(defn convert-md-checklist-and-copy-to-clipboard [lst]
  (->> (convert-to-markdown-checklist lst)
       (clip/write-clip)))


(def convert-list ["map-indexed"
                   "drop"
                   "partition-by"
                   "partirion"
                   "flatten"
                   "re-find"
                   "spit"])

(convert-to-markdown-checklist convert-list)

(convert-md-checklist-with-output-txt convert-list "output2.txt")

(convert-md-checklist-and-copy-to-clipboard convert-list)


