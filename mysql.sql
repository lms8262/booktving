-- mysql db 생성
drop database booktving;
CREATE DATABASE booktving DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

select * from best_seller;
select * from new_book_tving;
select * from book;
select * from book_img;
select * from member;
select * from rent_book;

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

-- book 데이터 삽입
insert into book(book_id, reg_time, update_time, author, book_introduction, book_name, category, contents, isbn, page, publication_date, publisher)
values(1, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "최보현", "특유의 웃픈 인생철학으로 사람들의 공감을 불러일으킨 유튜버 〈리틀타네의 슬기로운 생활〉의 첫 책, 『이렇게 살면 큰일 나는 줄 알았지』가 출간되었다. 코로나19가 한창 기승을 부리던 2021년, 30대에 취업·연애·결혼을 모두 포기하고 그동안 모은 돈을 모두 쏟아 귀촌을 단행한 신출내기 귀촌인 리틀타네의 이야기는 순식간에 알고리즘을 탔고, 자신이 원하는 모습대로 살고 싶은 이들에게 큰 공감을 샀다.",
"나만 그랬던 게 아냐", "국내도서 > 에세이 > 한국에세이", 
"프롤로그 - 이 순간을 즐길 작은 여유 <br> Chapter 1. <br> 바다 건너의 일상 <br>• 이 화분은 당분간 팔지 않아요 <br>• 맛있는 빵집을 찾는 법<br>• 기분이 좋아<br>• 낡고 오래된 것들의 이야기<br>• 노란 벽돌집 옆 작은 동네 책방<br>• 아무도 우릴 발견 못 해!",
"9791155642207", 100, "2023-08-15", "문학동네");
insert into book(book_id, reg_time, update_time, author, book_introduction, book_name, category, contents, isbn, page, publication_date, publisher)
values(2, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "김은경", "국내 최고의 자본시장 분석가이자, 경제·주식 분야 파워 인플루언서로 타의 추종을 불허하는 독보적인 시각을 제시하는 메르의 모든 투자 노하우를 담은 책이다. 정보의 질도 중요하지만, 그 이상으로 중요한 것이 정보를 다른 시각으로 바라보고 정리할 수 있는 능력이다. 관점이 있는 투자는 결코 흔들리지 않는다. 요동치는 시장 속에서 선명한 투자 지표를 찾는 법, 자신만의 관점을 만드는 법, 경제 원리 속에 숨은 부와 투자의 비밀이 이 책에 담겨 있다.",
"1%를 읽는 힘", "국내도서 > 에세이 > 한국에세이", 
"프롤로그 - 이 순간을 즐길 작은 여유 <br> Chapter 1. <br> 바다 건너의 일상 <br>• 이 화분은 당분간 팔지 않아요 <br>• 맛있는 빵집을 찾는 법<br>• 기분이 좋아<br>• 낡고 오래된 것들의 이야기<br>• 노란 벽돌집 옆 작은 동네 책방<br>• 아무도 우릴 발견 못 해!",
"9791158512767", 100, "2023-08-15", "문학동네");
insert into book(book_id, reg_time, update_time, author, book_introduction, book_name, category, contents, isbn, page, publication_date, publisher)
values(3, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "박완서", "국내 최고의 자본시장 분석가이자, 경제·주식 분야 파워 인플루언서로 타의 추종을 불허하는 독보적인 시각을 제시하는 메르의 모든 투자 노하우를 담은 책이다. 정보의 질도 중요하지만, 그 이상으로 중요한 것이 정보를 다른 시각으로 바라보고 정리할 수 있는 능력이다. 관점이 있는 투자는 결코 흔들리지 않는다. 요동치는 시장 속에서 선명한 투자 지표를 찾는 법, 자신만의 관점을 만드는 법, 경제 원리 속에 숨은 부와 투자의 비밀이 이 책에 담겨 있다.",
"문과 남자의 과학 공부", "국내도서 > 에세이 > 한국에세이", 
"프롤로그 - 이 순간을 즐길 작은 여유 <br> Chapter 1. <br> 바다 건너의 일상 <br>• 이 화분은 당분간 팔지 않아요 <br>• 맛있는 빵집을 찾는 법<br>• 기분이 좋아<br>• 낡고 오래된 것들의 이야기<br>• 노란 벽돌집 옆 작은 동네 책방<br>• 아무도 우릴 발견 못 해!",
"9791192836188", 100, "2023-08-15", "문학동네");
insert into book(book_id, reg_time, update_time, author, book_introduction, book_name, category, contents, isbn, page, publication_date, publisher)
values(4, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "유재석", "국내 최고의 자본시장 분석가이자, 경제·주식 분야 파워 인플루언서로 타의 추종을 불허하는 독보적인 시각을 제시하는 메르의 모든 투자 노하우를 담은 책이다. 정보의 질도 중요하지만, 그 이상으로 중요한 것이 정보를 다른 시각으로 바라보고 정리할 수 있는 능력이다. 관점이 있는 투자는 결코 흔들리지 않는다. 요동치는 시장 속에서 선명한 투자 지표를 찾는 법, 자신만의 관점을 만드는 법, 경제 원리 속에 숨은 부와 투자의 비밀이 이 책에 담겨 있다.",
"세이노의 가르침", "국내도서 > 에세이 > 한국에세이", 
"프롤로그 - 이 순간을 즐길 작은 여유 <br> Chapter 1. <br> 바다 건너의 일상 <br>• 이 화분은 당분간 팔지 않아요 <br>• 맛있는 빵집을 찾는 법<br>• 기분이 좋아<br>• 낡고 오래된 것들의 이야기<br>• 노란 벽돌집 옆 작은 동네 책방<br>• 아무도 우릴 발견 못 해!",
"9791168473690", 100, "2023-08-15", "문학동네");
insert into book(book_id, reg_time, update_time, author, book_introduction, book_name, category, contents, isbn, page, publication_date, publisher)
values(5, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "최태성", "국내 최고의 자본시장 분석가이자, 경제·주식 분야 파워 인플루언서로 타의 추종을 불허하는 독보적인 시각을 제시하는 메르의 모든 투자 노하우를 담은 책이다. 정보의 질도 중요하지만, 그 이상으로 중요한 것이 정보를 다른 시각으로 바라보고 정리할 수 있는 능력이다. 관점이 있는 투자는 결코 흔들리지 않는다. 요동치는 시장 속에서 선명한 투자 지표를 찾는 법, 자신만의 관점을 만드는 법, 경제 원리 속에 숨은 부와 투자의 비밀이 이 책에 담겨 있다.",
"아주 희미한 빛으로도 ", "국내도서 > 에세이 > 한국에세이", 
"프롤로그 - 이 순간을 즐길 작은 여유 <br> Chapter 1. <br> 바다 건너의 일상 <br>• 이 화분은 당분간 팔지 않아요 <br>• 맛있는 빵집을 찾는 법<br>• 기분이 좋아<br>• 낡고 오래된 것들의 이야기<br>• 노란 벽돌집 옆 작은 동네 책방<br>• 아무도 우릴 발견 못 해!",
"9788954695053", 100, "2023-08-15", "문학동네");
insert into book(book_id, reg_time, update_time, author, book_introduction, book_name, category, contents, isbn, page, publication_date, publisher)
values(6, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "도라에몽", "국내 최고의 자본시장 분석가이자, 경제·주식 분야 파워 인플루언서로 타의 추종을 불허하는 독보적인 시각을 제시하는 메르의 모든 투자 노하우를 담은 책이다. 정보의 질도 중요하지만, 그 이상으로 중요한 것이 정보를 다른 시각으로 바라보고 정리할 수 있는 능력이다. 관점이 있는 투자는 결코 흔들리지 않는다. 요동치는 시장 속에서 선명한 투자 지표를 찾는 법, 자신만의 관점을 만드는 법, 경제 원리 속에 숨은 부와 투자의 비밀이 이 책에 담겨 있다.",
"도둑맞은 집중력", "국내도서 > 에세이 > 한국에세이", 
"프롤로그 - 이 순간을 즐길 작은 여유 <br> Chapter 1. <br> 바다 건너의 일상 <br>• 이 화분은 당분간 팔지 않아요 <br>• 맛있는 빵집을 찾는 법<br>• 기분이 좋아<br>• 낡고 오래된 것들의 이야기<br>• 노란 벽돌집 옆 작은 동네 책방<br>• 아무도 우릴 발견 못 해!",
"9791167740984", 100, "2023-08-15", "문학동네");
insert into book(book_id, reg_time, update_time, author, book_introduction, book_name, category, contents, isbn, page, publication_date, publisher)
values(7, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "김혜미", "국내 최고의 자본시장 분석가이자, 경제·주식 분야 파워 인플루언서로 타의 추종을 불허하는 독보적인 시각을 제시하는 메르의 모든 투자 노하우를 담은 책이다. 정보의 질도 중요하지만, 그 이상으로 중요한 것이 정보를 다른 시각으로 바라보고 정리할 수 있는 능력이다. 관점이 있는 투자는 결코 흔들리지 않는다. 요동치는 시장 속에서 선명한 투자 지표를 찾는 법, 자신만의 관점을 만드는 법, 경제 원리 속에 숨은 부와 투자의 비밀이 이 책에 담겨 있다.",
"역행자 확장판 ", "국내도서 > 에세이 > 한국에세이", 
"프롤로그 - 이 순간을 즐길 작은 여유 <br> Chapter 1. <br> 바다 건너의 일상 <br>• 이 화분은 당분간 팔지 않아요 <br>• 맛있는 빵집을 찾는 법<br>• 기분이 좋아<br>• 낡고 오래된 것들의 이야기<br>• 노란 벽돌집 옆 작은 동네 책방<br>• 아무도 우릴 발견 못 해!",
"9788901272580", 100, "2023-08-15", "문학동네");

-- book_img 데이터 삽입
insert into book_img(book_img_id, reg_time, update_time, img_name, img_url, ori_img_name, rep_yn, book_id)
values(1, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "image.aladin.co.kr/product/31892/3/cover/k342833636_1.jpg", "https://image.aladin.co.kr/product/31892/3/cover/k342833636_1.jpg",
"k342833636_1.jpg", "Y", 1);
insert into book_img(book_img_id, reg_time, update_time, img_name, img_url, ori_img_name, rep_yn, book_id)
values(2, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "image.aladin.co.kr/product/32292/63/cover/8936439286_1.jpg", "https://image.aladin.co.kr/product/32292/63/cover/8936439286_1.jpg",
"8936439286_1.jpg", "Y", 2);
insert into book_img(book_img_id, reg_time, update_time, img_name, img_url, ori_img_name, rep_yn, book_id)
values(3, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "image.aladin.co.kr/product/32289/45/cover/k852834850_1.jpg", "https://image.aladin.co.kr/product/31892/3/cover/k342833636_1.jpg",
"k342833636_1.jpg", "Y", 3);
insert into book_img(book_img_id, reg_time, update_time, img_name, img_url, ori_img_name, rep_yn, book_id)
values(4, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "image.aladin.co.kr/product/32289/24/cover/k512834850_1.jpg", "https://image.aladin.co.kr/product/32289/24/cover/k512834850_1.jpg",
"k512834850_1.jpg", "Y", 4);
insert into book_img(book_img_id, reg_time, update_time, img_name, img_url, ori_img_name, rep_yn, book_id)
values(5, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "image.aladin.co.kr/product/32289/19/cover/k412834850_1.jpg", "https://image.aladin.co.kr/product/32289/19/cover/k412834850_1.jpg",
"k412834850_1.jpg", "Y", 5);
insert into book_img(book_img_id, reg_time, update_time, img_name, img_url, ori_img_name, rep_yn, book_id)
values(6, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "image.aladin.co.kr/product/32288/87/cover/k692834859_1.jpg", "https://image.aladin.co.kr/product/32288/87/cover/k692834859_1.jpg",
"k692834859_1.jpg", "Y", 6);
insert into book_img(book_img_id, reg_time, update_time, img_name, img_url, ori_img_name, rep_yn, book_id)
values(7, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "image.aladin.co.kr/product/32288/62/cover/k352834859_1.jpg", "https://image.aladin.co.kr/product/32288/62/cover/k352834859_1.jpg",
"k352834859_1.jpg", "Y", 7);

-- rent_book 데이터 삽입
-- book_id => 1 (3개)
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(1, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "Y", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 1, 1 );
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(2, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "Y", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 1, 1 );
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(3, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "Y", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 1, 1 );

-- book_id => 2(1개)
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(4, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "Y", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 2, 1 );

-- book_id => 3 (2개)
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(5, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "Y", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 3, 1 );insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(16, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "Y", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 3, 1 );

-- book_id => 4(5개)
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(6, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "Y", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 4, 1 );
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(17, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "Y", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 4, 1 );
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(18, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "Y", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 4, 1 );
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(19, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "Y", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 4, 1 );
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(20, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "Y", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 4, 1 );

-- book_id => 5(6개)
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(7, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "Y", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 5, 1 );
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(15, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "Y", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 5, 1 );
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(21, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "Y", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 5, 1 );
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(22, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "Y", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 5, 1 );
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(23, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "Y", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 5, 1 );
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(24, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "Y", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 5, 1 );

-- book_id => 6(10개)
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(8, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "Y", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 6, 1 );
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(13, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "Y", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 6, 1 );
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(14, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "Y", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 6, 1 );
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(31, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "Y", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 6, 1 );
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(25, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "Y", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 6, 1 );
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(26, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "Y", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 6, 1 );
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(27, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "Y", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 6, 1 );
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(28, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "Y", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 6, 1 );
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(29, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "Y", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 6, 1 );
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(30, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "Y", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 6, 1 );

-- book_id => 7(9개)
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(9, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "Y", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 7, 1 );
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(10, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "Y", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 7, 1 );
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(11, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "Y", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 7, 1 );
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(12, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "Y", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 7, 1 );
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(32, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "Y", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 7, 1 );
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(33, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "Y", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 7, 1 );
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(34, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "Y", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 7, 1 );
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(35, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "Y", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 7, 1 );
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(36, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "Y", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 7, 1 );

-- 북티빙 Top10 Query문 -일간
select data.num num, book.book_id id, book.book_name BookName, book_img.img_url imgUrl, book_img.rep_yn repYn, book.publisher publisher, book.isbn isbn, book.author author
from book inner join book_img 
			on (book.book_id = book_img.book_id)
		  inner join (select @ROWNUM:=@ROWNUM+1 num, groupdata.* 
					  from(select rent_book.book_id, DATE(rent_book.rent_date) rent_date, count(*) cnt
						   from rent_book
						   where rent_date >= CURDATE() - INTERVAL 1 DAY
						   group by rent_book.book_id, DATE(rent_book.rent_date) order by cnt desc
                           ) groupdata, (SELECT @ROWNUM:=0) R limit 7
						) data
			  on (book.book_id = data.book_id)
		  	where book_img.rep_yn = 'Y'
			order by num;

-- 북티빙 Top10 Query문 -주간
select data.num num, book.book_id id, book.book_name BookName, book_img.img_url imgUrl, book_img.rep_yn repYn, book.publisher publisher, book.isbn isbn, book.author author
from book inner join book_img 
			on (book.book_id = book_img.book_id)
		  inner join (select @ROWNUM:=@ROWNUM+1 num, groupdata.* 
					  from(select rent_book.book_id, YEAR(rent_book.rent_date) rent_year, WEEK(rent_book.rent_date) rent_week, count(*) cnt
						   from rent_book
						   where rent_date >= CURDATE() - INTERVAL 1 WEEK
						   group by rent_book.book_id, YEAR(rent_book.rent_date), WEEK(rent_book.rent_date) order by cnt desc
                           ) groupdata, (SELECT @ROWNUM:=0) R limit 7
						) data
			  on (book.book_id = data.book_id)
		  	where book_img.rep_yn = 'Y'
			order by num;

-- 북티빙 Top10 Query문 -월간
select data.num num, book.book_id id, book.book_name BookName, book_img.img_url imgUrl, book_img.rep_yn repYn, book.publisher publisher, book.isbn isbn, book.author author
from book inner join book_img 
			on (book.book_id = book_img.book_id)
		  inner join (select @ROWNUM:=@ROWNUM+1 num, groupdata.* 
					  from(select rent_book.book_id, YEAR(rent_book.rent_date) rent_year, MONTH(rent_book.rent_date) rent_month, count(*) cnt
						   from rent_book
						   where rent_date >= CURDATE() - INTERVAL 1 YEAR
						   group by rent_book.book_id, YEAR(rent_book.rent_date), MONTH(rent_book.rent_date) order by cnt desc
                           ) groupdata, (SELECT @ROWNUM:=0) R limit 7
						) data
			  on (book.book_id = data.book_id)
		  	where book_img.rep_yn = 'Y'
			order by num;

            
-- 북티빙 Top10 Query문 -연간
select data.num num, book.book_id id, book.book_name BookName, book_img.img_url imgUrl, book_img.rep_yn repYn, book.publisher publisher, book.isbn isbn, book.author author
from book inner join book_img 
			on (book.book_id = book_img.book_id)
		  inner join (select @ROWNUM:=@ROWNUM+1 num, groupdata.* 
					  from(select rent_book.book_id, YEAR(rent_book.rent_date) rent_year, count(*) cnt
						   from rent_book
						   where rent_date >= CURDATE() - INTERVAL 1 YEAR
						   group by rent_book.book_id, YEAR(rent_book.rent_date) order by cnt desc
                           ) groupdata, (SELECT @ROWNUM:=0) R limit 7
						) data
			  on (book.book_id = data.book_id)
		  	where book_img.rep_yn = 'Y'
			order by num;

DELETE from new_book_tving WHERE new_book_tving_id > 50;
DELETE from new_book_tving WHERE new_book_tving_id = 5;

DELETE from best_seller WHERE best_seller_id = 1;

drop table new_book_tving;



use booktving;