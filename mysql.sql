-- mysql db 생성
drop database booktving;
CREATE DATABASE booktving DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

use booktving;

select * from member;
select * from best_seller;
select * from new_book_tving;
select * from book;
select * from book_img;
select * from book_review;
select * from rent_book;
select * from author;
select * from author_img;
select * from author_book;
select * from author_book_img;
select * from search_keyword;
select * from recommend_keyword;
select * from payment;
select * from member_commutation;
select * from commutation_ticket;
select * from question;
select * from answer;