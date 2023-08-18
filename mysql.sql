-- mysql db 생성
drop database booktving;
CREATE DATABASE booktving DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

select * from best_seller;
select * from new_book_tving;


update new_book_tving set description = "보기 드문 해부학 드로잉 입문서"  where new_book_tving_id = 1;
update new_book_tving set description = "서로의 마음을 마주하고.."  where new_book_tving_id = 2;
update new_book_tving set description = "숨은 부와 투자의 비밀"  where new_book_tving_id = 3;
update new_book_tving set description = "건강하고 특별한 우리 아이 첫 밥상"  where new_book_tving_id = 4;
update new_book_tving set description = "보이지 않는 노동"  where new_book_tving_id = 5;
update new_book_tving set description = "막 오른 문명 대변혁"  where new_book_tving_id = 6;
update new_book_tving set description = "출간 15주년 기념 양장본"  where new_book_tving_id = 7;
update new_book_tving set description = "우연히 야생동물 자원봉사자가 된다"  where new_book_tving_id = 8;
update new_book_tving set description = "좋은 삶’을 원한다면 ?"  where new_book_tving_id = 9;
update new_book_tving set description = "나는 정상인가"  where new_book_tving_id = 10;

DELETE from new_book_tving WHERE new_book_tving_id > 50;
DELETE from new_book_tving WHERE new_book_tving_id = 5;

DELETE from best_seller WHERE best_seller_id = 1;

drop table new_book_tving;

use booktving;