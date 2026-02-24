# Write your MySQL query statement below
Select(
    select Distinct Salary  from Employee order by Salary DESC limit 1 offset 1) as SecondHighestSalary;