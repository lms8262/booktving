-- mysql db 생성
drop database booktving;
CREATE DATABASE booktving DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
use booktving;

select * from member;

select * from book;
select * from book_img;
insert into book values (200, '2022-08-17', 1, "이지연", "책이다", "책이다", "문학", "문학책", "111111111111A", "출판사", '2023-08-17', '2023-08-17');

insert into book values (150, '2021-09-23', 2, "최은영", "츼은영 소설", "아주 희미한 빛으로도", "소설", "국내소설", "9788954695053", "문학동네", '2021-09-23', '2021-09-23');
insert into book_img values (2, 2, "이미지2", "https://image.aladin.co.kr/product/30929/51/cover/s302832892_1.jpg", "PHOTO.jpg", "Y", "2023-07-24 09:18:24.913742", "2023-07-24 09:18:24.913742");
insert into book_img values (1, 1, "이미지", "https://image.aladin.co.kr/product/30929/51/cover/s302832892_1.jpg", "PHOTO.jpg", "Y", "2023-07-24 09:18:24.913742", "2023-07-24 09:18:24.913742");

update book_img set img_url = "https://image.aladin.co.kr/product/32355/30/cover500/8954699073_1.jpg" where book_id = 2;

update book set contents = "아주 희미한 빛으로도 / 007
몫 / 047
일 년 / 085
답신 / 125
파종 / 181
이모에게 / 213
사라지는, 사라지지 않는 / 267
해설│양경언(문학평론가)
더 가보고 싶어 / 321
작가의 말 / 347"  where book_id = 1;
select * from book_review;
insert into book_review values (1, "감동적임", 1, 1);
update book set book_name = "세이노의 가르침" where book_id = 1;
set foreign_key_checks=0;
insert into book_review values (2, "명작입니다", 2, 2);

delete from book_review where book_review_id = 2;

insert into member values ('2000-08-22', 1, 'abc@naver.com', '지연', 'abc12345', "USER", '010-1111-1111', 1, '2023-08-22', '2023-08-22');

select * from favorite_book;
delete from favorite_book where favorite_book_id =13;

commit;
rollback;
insert into favorite_book values (1, 4, 3, "2023-08-22 05:56:12.655769", "2023-08-22 05:56:12.655769");
delete from favorite_book where favorite_book_id >= 3;
update member set role = 'USER' where member_id = 3;
update question set member_id = 3 where member_id = 1;

select * from question;

ALTER TABLE question
MODIFY member_id INT NOT NULL;

insert into question (member_id) values (1);

insert into question values (3, 1, "환불 문의합니다", "환불 관련", now(), now(), "ㅇㅇㅇ", "ㅇㅇㅇ", now(), "WAIT");
insert into question values (3, 2, "이용권", "관련", now(), now(), "ㅇㅇㅇㅇ", "ㅇㅇㅇㅇ", now(), "WAIT");
insert into question values (3, 4, "질문", "관련", now(), now(), "ㅇㅇㅇㅇㅇ", "ㅇㅇㅇㅇㅇ", now(), "WAIT");

delete from question where quesion_id =6;