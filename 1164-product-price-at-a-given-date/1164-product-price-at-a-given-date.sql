# Write your MySQL query statement below

With 
cte as
(
select * 
from products 
where change_date <= '2019-08-16' 
),
 cte2 as  #cte2 uske liye bnaya h jo element cte mein nhi h taaki unko bina compare kare 1 likh sakein ; 
 (
select p.product_id , 10 as price
from products p
where NOT EXISTS ( select cte.product_id from cte where p.product_id = cte.product_id) ) 

select  c.product_id , c.new_price as price
from cte c
where change_date = (select max(change_date) from cte where cte.product_id = c.product_id ) 
union
select *
from cte2 ; 
 


