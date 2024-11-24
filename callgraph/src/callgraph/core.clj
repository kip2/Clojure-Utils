(ns callgraph.core
  (:gen-class)
  (:require [clojure.string :as str]
            [clj-clip.core :as clip]))

(defn generate-mermaid-string [caller callee]
  (-> (str (:fc caller) "[" (:ns caller) "/" (:fc caller) "]")
      (str " " "-->" " ")
      (str (:fc callee)  "[" (:ns callee) "/" (:fc callee) "]")))

(defn generate-mermaid-strings [data]
  (->> data
       (map (fn [[caller callee]] (generate-mermaid-string caller callee)))
       (str/join "\n")))

(def data [[{:fc "run" :ns "core"} {:fc "cursor-up" :ns "tool"}]
           [{:fc "run1" :ns "core"} {:fc "cursor-up1" :ns "tool"}]
           [{:fc "run2" :ns "core"} {:fc "cursor-up2" :ns "tool"}]
           [{:fc "run3" :ns "core"} {:fc "cursor-up3" :ns "tool"}]
           [{:fc "run4" :ns "core"} {:fc "cursor-up4" :ns "tool"}]])

(defn copy-mermaid-to-clipboard [data]
  (clip/write-clip (generate-mermaid-strings data)))

(copy-mermaid-to-clipboard data)

