# Write your MySQL query statement below\

With cte as
(select user_id , count(user_id) as confirmed
from confirmations 
group by user_id , action 
having action IN ('confirmed') ) ,

cte2 as
(
  select user_id , count(user_id) as total
  from confirmations 
  group by user_id 
) ,

cte3 as
(select cte2.user_id , cte2.total , cte.confirmed 
from cte2 left join cte
on cte.user_id = cte2.user_id ) , 

cte4 as
(select signups.user_id , case when cte3.total is not null then cte3.total else 0 end as total ,  case when cte3.confirmed is not null then cte3.confirmed else 0 end as confirmed 
from signups left join cte3
on signups.user_id = cte3.user_id ) 

select cte4.user_id ,case when total = 0 then 0 else round(confirmed/total , 2) end as confirmation_rate
from cte4 ; 

