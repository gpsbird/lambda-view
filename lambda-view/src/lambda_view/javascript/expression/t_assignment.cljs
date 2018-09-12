;; ESTree Spec
;; https://github.com/estree/estree

(ns lambda-view.javascript.expression.t-assignment
  (:use [lambda-view.javascript.render :only [render-node]]
        [lambda-view.javascript.common :only [smart-box
                                              operator
                                              white-space-optional]]
        [lambda-view.tag :only [id-of]]
        [lambda-view.javascript.expression.utils :only [render-node-by-priority]]))

;; AssignmentExpression
(defn render [node]
  (let [op (get node "operator")
        left (get node "left")
        right (get node "right")]
    [:div.assignment.expression
     (render-node-by-priority node left)
     (white-space-optional)
     (operator op)
     (white-space-optional)
     (render-node-by-priority node right)]))

(def demo ["a = 1"
           "c = d = 2"])
