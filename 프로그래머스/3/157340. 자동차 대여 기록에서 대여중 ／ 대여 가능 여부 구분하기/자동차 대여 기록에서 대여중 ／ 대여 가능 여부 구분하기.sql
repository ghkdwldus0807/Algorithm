-- 코드를 입력하세요
SELECT CAR_ID, 
(case 
 when (case when max('2022-10-16' between START_DATE and END_DATE) then 1 else 0 end)
 then '대여중'
 else '대여 가능'
 end
 ) as AVAILABILITY

from CAR_RENTAL_COMPANY_RENTAL_HISTORY group by car_id order by car_id desc;
