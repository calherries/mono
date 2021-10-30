(ns datalevin-practice.sql-exercises
  (:require [datalevin.core :as d]))

;; Following exercises form https://www.w3resource.com/sql-exercises/sql-retrieve-from-table.php

;; create connection
(def conn (d/get-conn "/tmp/datalevin/sqlexercisesdb"))

(def data
  [{:salesman-id 5001 :name "James Hoog" :city "New York"  :commission 0.15}
   {:salesman-id 5002 :name "Nail Knite" :city "Paris"     :commission 0.13}
   {:salesman-id 5005 :name "Pit Alex"   :city "London"    :commission 0.11}
   {:salesman-id 5006 :name "Mc Lyon"    :city "Paris"     :commission 0.14}
   {:salesman-id 5007 :name "Paul Adam"  :city "Rome"      :commission 0.13}
   {:salesman-id 5003 :name "Lauson Hen" :city "San Jose"  :commission 0.12}])

;; Add the data
(d/transact! conn data)

;; Warm-up
(d/q '[:find ?salesman-id ?name ?city
       :keys salesman-id name city
       :where
       [_ :name ?name]
       [_ :city ?city]
       [_ :salesman-id ?salesman-id]]
  (d/db conn)) ; db is a reference to a database

;; 1. Write a SQL statement to display all the information of all salesmen

(d/q '[:find (pull ?e [*])
       :where
       [?e _ _]]
  (d/db conn))
;; => ([{:city "Paris",
;;       :commission 0.14,
;;       :db/id 4,
;;       :name "Mc Lyon",
;;       :salesman-id 5006}]
;;     [{:city "San Jose",
;;       :commission 0.12,
;;       :db/id 6,
;;       :name "Lauson Hen",
;;       :salesman-id 5003}]
;;     [{:city "London",
;;       :commission 0.11,
;;       :db/id 3,
;;       :name "Pit Alex",
;;       :salesman-id 5005}]
;;     [{:city "Rome",
;;       :commission 0.13,
;;       :db/id 5,
;;       :name "Paul Adam",
;;       :salesman-id 5007}]
;;     [{:city "Paris",
;;       :commission 0.13,
;;       :db/id 2,
;;       :name "Nail Knite",
;;       :salesman-id 5002}]
;;     [{:city "New York",
;;       :commission 0.15,
;;       :db/id 1,
;;       :name "James Hoog",
;;       :salesman-id 5001}])

;; 2. Write a SQL statement to display a string "This is SQL Exercise, Practice and Solution".

; Not practical in datalog
