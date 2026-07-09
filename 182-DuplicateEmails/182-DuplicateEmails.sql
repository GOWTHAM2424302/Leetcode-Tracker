-- Last updated: 7/9/2026, 3:02:38 PM
# Write your MySQL query statement below
SELECT email AS Email
FROM Person
GROUP BY email
HAVING COUNT(*) > 1;