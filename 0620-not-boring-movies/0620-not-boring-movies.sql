# Write your MySQL query statement below

select *                  # kyonki saare column chahiye
from cinema 
where description != 'boring' and id % 2 =  1
order by rating desc ; 