-- mysql db 생성
drop database booktving;
CREATE DATABASE booktving DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

select * from member;

select * from book;

-- 테스트용 데이터
insert into book values (200, '2022-08-17', 1, "이지연", "책이다", "책이다", "문학", "문학책", "111111111111A", "출판사", '2023-08-17', '2023-08-17');

select * from best_seller;
select * from new_book_tving;
select * from book;
select * from book_img;

use booktving;
