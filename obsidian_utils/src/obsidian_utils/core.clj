(ns obsidian-utils.core
  (:require [clj-clip.core :as clip]))

;; サンプルリスト
(def convert-list ["map-indexed"
                   "drop"
                   "partition-by"
                   "partirion"
                   "flatten"
                   "re-find"
                   "spit"])

(defn list->obsidian-link-checklist
  ([lst]
   (list->obsidian-link-checklist lst nil))
  ([lst label]
   (let [convert-checklist (fn [element] (str " - [ ] [[" element label "]]\n"))]
     (apply str (map convert-checklist lst)))))


(defn obsidian-checklist->file [lst output-name]
  (->> (list->obsidian-link-checklist lst)
       (spit output-name)))

(defn obsidian-checklist->clip [lst]
  (->> (list->obsidian-link-checklist lst)
       (clip/write-clip)))

(defn obsidian-checklist->clip-labeled [lst label]
  (-> lst
      (list->obsidian-link-checklist label)
      (clip/write-clip)))
(obsidian-checklist->clip convert-list)

;; 使用例
(obsidian-checklist->clip-labeled convert-list "(Clojure)")


