# obsidian_utils

Obsidianで使えるユーティリティーツール。


## Usage

```clojure
;; 変換元のサンプルリスト
(def convert-list ["map-indexed"
                   "drop"
                   "partition-by"
                   "partirion"
                   "flatten"
                   "re-find"
                   "spit"])

;; リストをObsidianリンクのチェックリストに変換する。
;; 使用例(クリップボードにコピーされる)
(obsidian-checklist->clip convert-list)
;; - [] [[map-indexed]]
;; - [] [[drop]]
;; - [] [[partition-by]]
;; - [] [[partirion]]
;; - [] [[flatten]]
;; - [] [[re-find]]
;; - [] [[spit]]

;; リストをObsidianリンクのチェックリストに変換する(ラベル付き)。
;; 使用例(クリップボードにコピーされるラベル付き)
(obsidian-checklist->clip-labeled convert-list "(Clojure)")
;;  - [ ] [[map-indexed(Clojure)]]
;;  - [ ] [[drop(Clojure)]]
;;  - [ ] [[partition-by(Clojure)]]
;;  - [ ] [[partirion(Clojure)]]
;;  - [ ] [[flatten(Clojure)]]
;;  - [ ] [[re-find(Clojure)]]
;;  - [ ] [[spit(Clojure)]]
```

## License

Copyright © 2024 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.

