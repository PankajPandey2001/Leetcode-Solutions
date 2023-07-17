# Write your MySQL query statement below

With 
cte as
(
  Select a.id , a.num as first , b.num as second 
  from logs a inner join logs b 
  where a.id = b.id-1  
),
cte2 as
(
  Select cte.id , cte.first , cte.second , b.num as third
  from cte inner join logs b 
  where cte.id = b.id-2  
)

# select Distinct (case WHEN cte2.first = cte2.second and cte2.second = cte2.third THEN cte2.first END ) as ConsecutiveNums
# from cte2 ; 

select Distinct cte2.first  as ConsecutiveNums
from cte2 
where cte2.first = cte2.second and cte2.second = cte2.third ; 



