-- SQL Basics: Simple EXISTS
-- https://www.codewars.com/kata/58113a64e10b53ec36000293/sql
SELECT * FROM departments WHERE EXISTS (SELECT department_id FROM sales WHERE departments.id = sales.department_id AND price > 98.00);
