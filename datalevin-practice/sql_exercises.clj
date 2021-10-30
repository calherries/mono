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
       :where
       [_ :name ?name]
       [_ :city ?city]
       [_ :salesman-id ?salesman-id]]
  (d/db conn)) ; db is a reference to a database

;; 1. Write a SQL statement to display all the information of all salesmen
