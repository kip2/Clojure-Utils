(ns markdown-utils.core
  (:require [clj-clip.core :as clip]))

;; サンプルリスト
(def convert-list ["map-indexed"
                   "drop"
                   "partition-by"
                   "partirion"
                   "flatten"
                   "re-find"
                   "spit"])

(defn convert-to-markdown-checklist
  ([lst]
   (convert-to-markdown-checklist lst nil))
  ([lst label]
   (let [convert-checklist (fn [element] (str " - [ ] [[" element label "]]\n"))]
     (apply str (map convert-checklist lst)))))


(defn convert-md-checklist-with-output-txt [lst output-name]
  (->> (convert-to-markdown-checklist lst)
       (spit output-name)))

(defn convert-md-checklist-and-copy-to-clipboard [lst]
  (->> (convert-to-markdown-checklist lst)
       (clip/write-clip)))

(defn convert-checklist-with-clojure-and-copy [lst]
  (-> lst
      (convert-to-markdown-checklist "(Clojure)")
      (clip/write-clip)))

;; 使用例
(convert-checklist-with-clojure-and-copy convert-list)

