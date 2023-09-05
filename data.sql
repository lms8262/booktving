insert into member(user_id, password, member_name, email, tel, birth, address, address_no, address_detail, role, reg_time, update_time)
values("aaaa1111", "$2a$12$OGtStbqrjZSsjgL.GzX12uKKBruj5wq0ZRr0lTO8I/MXnRUKyQdua", "김철수", "aaaa1111@naver.com", "010-1234-5678", "1994-03-03", "인천 남동구 인주대로 593", "21558", "(구월동) 엔타스빌딩 12층", "ADMIN", now(), now());
insert into member(user_id, password, member_name, email, tel, birth, address, address_no, address_detail, role, reg_time, update_time)
values("aaaa2222", "$2a$12$WQUMQEiZ9EuVbSWZeq8lFOKH2Amr0uNlzD64lu3DO3JrSMTGwYs6.", "김영희", "aaaa2222@naver.com", "010-2345-6789", "1996-05-05", "인천 남동구 인주대로 593", "21558", "(구월동) 엔타스빌딩 12층", "USER", now(), now());

insert into author(author_introduction, author_name_eg, author_name_ko, title, reg_time, created_by) 
values("2009년 한국일보 신춘문예를 통해 작품활동을 시작했다. 소설집 『센티멘털도 하루 이틀』 『너무 한낮의 연애』 『오직 한 사람의 차지』 『우리는 페퍼로니에서 왔어』, 장편소설 『경애의 마음』 『복자에게』, 중편소설 『나의 사랑, 매기』, 연작소설 『크리스마스 타일』, 짧은 소설 『나는 그것에 대해 아주 오랫동안 생각해』, 산문집 『사랑 밖의 모든 말들』 등이 있다. 신동엽문학상, 젊은작가상 대상, 현대문학상, 우현예술상, 김승옥문학상 대상, 오늘의 젊은 예술가상 등을 수상했다.",
"Kim Keum-hee", "김금희", "따뜻한 시선으로<br>보통의 마음을 그리는 작가", "2023-08-29", "cbh4547");
-- authoir_id = 2
insert into author(author_introduction, author_name_eg, author_name_ko, title, reg_time, created_by) 
values("전북 정읍에서 태어나 서울예술대학 문예창작과를 졸업했다. 1985년 『문예중앙』 신인문학상에 중편 「겨울 우화」가 당선되어 작품활동을 시작한 이래 소설집 『겨울 우화』 『풍금이 있던 자리』 『오래전 집을 떠날 때』 『딸기밭』 『종소리』 『모르는 여인들』, 장편소설 『깊은 슬픔』 『외딴방』 『기차는 7시에 떠나네』 『바이올렛』 『리진』 『엄마를 부탁해』 『어디선가 나를 찾는 전화벨이 울리고』 『아버지에게 갔었어』, 짧은 소설집 『J이야기』 『달에게 들려주고 싶은 이야기』, 산문집 『아름다운 그늘』 『자거라, 네 슬픔아』 『요가 다녀왔습니다』와 한일 양국을 오간 왕복 서간집 『산이 있는 집 우물이 있는 집』 등을 펴냈다. 『엄마를 부탁해』가 미국을 비롯해 41개국에 번역 출판된 것을 시작으로 다수의 작품들이 영미권을 중심으로 유럽과 아시아 등에 출판되었다. 국내에서 오늘의 젊은 예술가상, 한국일보문학상, 현대문학상, 만해문학상, 동인문학상, 이상문학상, 오영수문학상, 호암상 등을 받았으며, 『외딴방』이 프랑스의 비평가와 문학기자가 선정하는 ‘리나페르쉬 상’을, 『엄마를 부탁해』가 한국문학 최초로 ‘맨 아시아 문학상’을 수상했다.",
"Shin Kyung-sook", "신경숙", "언젠가 작가가 된다면<br>엄마에게 바치는 아름다운 글을 써야겠다", "2023-08-29", "cbh4547");
-- authoir_id = 3
insert into author(author_introduction, author_name_eg, author_name_ko, title, reg_time, created_by) 
values("1964년 도쿄에서 태어난 에쿠니 가오리는 청아한 문체와 세련된 감성 화법으로 사랑받는 작가이다. 1989년 『409 래드클리프』로 페미나상을 수상했고, 동화부터 소설, 에세이까지 폭넓은 집필 활동을 해 나가면서 참신한 감각과 세련미를 겸비한 독자적인 작품 세계를 구축하고 있다. 『반짝반짝 빛나는』으로 무라사키시키부 문학상(1992), 『나의 작은 새』로 로보노이시 문학상(1999), 『울 준비는 되어 있다』로 나오키상(2003), 『잡동사니』로 시마세 연애문학상(2007), 『한낮인데 어두운 방』으로 중앙공론문예상(2010)을 받았다. 일본 문학 최고의 감성 작가로 불리는 그녀는 『냉정과 열정 사이 Rosso』, 『도쿄 타워』, 『언젠가 기억에서 사라진다 해도』, 『좌안 1·2』, 『달콤한 작은 거짓말』, 『소란한 보통날』, 『부드러운 양상추』, 『수박 향기』, 『하느님의 보트』, 『우는 어른』, 『울지 않는 아이』, 『등 뒤의 기억』, 『포옹 혹은 라이스에는 소금을』, 『즐겁게 살자, 고민하지 말고』, 『벌거숭이들』, 『저물 듯 저물지 않는』, 『개와 하모니카』, 『별사탕 내리는 밤』 등으로 한국의 많은 독자들을 사로잡고 있다.",
"Ekuni Kaori", "에쿠니 가오리", "청아한 문체로<br>전 세계 독자를 사로잡은", "2023-08-29", "cbh4547");
-- authoir_id = 4
insert into author(author_introduction, author_name_eg, author_name_ko, title, reg_time, created_by) 
values("정식 이름은 Agatha Mary Clarissa Miller Christie Mallowan이다. 1890년 9월 15일 영국의 데번에서 부유한 미국인인 아버지 프레드릭 밀러와 영국 귀족이었던 어머니 클라라 보머 사이에서 태어났다. '메리 웨스트매컷(Mary Westmacott)'이란 필명으로 연애소설을 집필하기도 하였으나 80여편의 추리소설의 '아가사 크리스티'란 필명으로 대중에게 널리 알려졌다. 그녀는 어머니로부터 집에서 교육받았고, 16살에 파리로 건너가 성악과 피아노를 공부하다가 1914년 크리스티 대령과 결혼했다. 그녀의 소설에 시안화물, 라이신, 탈륨 등의 독약이 자주 등장하는데 이는 제1차 세계대전 동안 병원의 약국에서 일했던 경험 때문이다. 전쟁중인 1916년 첫 작품 <스타일즈 저택의 수수께끼>를 썼다. 1976년 86세의 나이로 사망할 때까지 90여 권의 책을 펴냈다. 그녀가 창조해 낸 '에르퀼 푸아로', '제인 마플'은 대중적인 사랑을 받았으며, 그녀는 추리소설 장르에서 주목받는 작가로서 추리소설의 여왕이라 불린다. 그녀의 작품은 영어권에서 10억부 이상 팔렸으며 103개의 언어로 번역된 다른 언어판 역시 10억부 이상 판매되어 기네스 세계 기록에 등재되었다. 이와 같은 기록은 세익스피어와 견줄만 한 것이다. 또한 그녀의 희곡 <쥐덫>은 1955년 런던에서 초연된 이래 2007년 현재까지 공연 중이다.",
"Agatha Christie", "애거서 크리스티", "미스터리 역사를 다시 쓴<br>추리소설의 여왕", "2023-08-29", "cbh4547");
-- authoir_id = 5
insert into author(author_introduction, author_name_eg, author_name_ko, title, reg_time, created_by) 
values("1974년 프랑스 앙티브에서 태어나 니스대학에서 경제학을 공부했고, 몽펠리에대학원 경제학과에서 석사 과정을 이수한 후 국제고등학교 교사로 재직하며 집필 활동을 시작했다. 현실에서는 도저히 있을 법하지 않은 이야기에 꿈과 리듬을 불어넣는 작가로 유명하다. 첫 소설 《스키다마링크》에 이어 2004년 두 번째 소설 《그 후에》를 출간하며 프랑스 문단에 일대 센세이션을 불러일으켰고, 《그 후에》부터 《안젤리크》까지 19권의 소설 모두가 프랑스 베스트셀러 1위를 기록했다. 매년 《르 피가로》지와 <프랑스서점연합회>에서 조사하는 베스트셀러 작가 순위에서도 8년 연속 1위에 올랐다. 세 번째 소설 《구해줘》는 아마존 프랑스 85주 연속 베스트셀러 1위를 기록했고, 국내에서도 무려 200주 이상 베스트셀러에 등재되었다. 현재 전 세계 45개국 독자들이 그의 소설에 공감과 지지를 보내고 있다. 《종이 여자》는 한 편의 매직 쇼 혹은 한 편의 미스터리 판타지 영화를 보듯 예측불허의 긴장 속으로 독자들을 끌어들인다. 한시도 눈 돌릴 틈을 주지 않는 흥미진진한 전개, 독자들의 의표를 찌르는 결말이 돋보이는 소설이다. 그의 소설 《안젤리크》, 《센 강의 이름 모를 여인》, 《인생은 소설이다》, 《작가들의 비밀스러운 삶》, 《아가씨와 밤》, 《파리의 아파트》, 《브루클린의 소녀》, 《지금 이 순간》, 《센트럴파크》, 《내일》, 《7년 후》, 《천사의 부름》, 《종이 여자》, 《그 후에》, 《당신 없는 나는?》, 《사랑을 찾아 돌아오다》, 《사랑하기 때문에》, 《당신 거기 있어줄래요?》, 《구해줘》.",
"Guillaume Musso", "기욤 뮈소", "치밀한 이야기 전개와 잘 짜인 결말로<br>매 작품 놀라움을 선사하는 작가", "2023-08-29", "cbh4547");
-- authoir_id = 6
insert into author(author_introduction, author_name_eg, author_name_ko, title, reg_time, created_by) 
values("독일 남부 뷔르템베르크의 칼프에서 태어났다. 아버지 요하네스는 목사였고, 어머니 역시 독실한 신학자 가문 출신이라 기독교적 분위기 속에서 어린 시절을 보냈다. 1890년 라틴어 학교에 입학했고, 이듬해 마울브론 신학교에 들어갔다. 하지만 신학교의 속박된 생활을 못 견디고 뛰쳐나와 한때 자살을 시도했다. 시인이 되기를 꿈꾼 뒤 시계 공장에서 시계 톱니바퀴를 닦으며 문학수업을 시작했다. 1895년 낭만주의 문학에 심취해 첫 시집 《낭만적인 노래》를 출간했다. 1904년 첫 장편소설 《페터 카멘친트》를 출간하여 문학적 지위를 얻었다. 그해에 피아니스트 마리아 베르누이와 결혼했으며, 스위스로 이주해 시작에 몰두했다. 그 후 인도 여행으로 동양에 대한 관심이 깊어졌으며, 아내의 정신병, 헤세 자신의 신병 등 가정적 위기를 겪었고, 제2차 세계대전 중 나치스의 광적인 폭정에 저항하는 등 파란 많은 세월을 겪었다. 주요 작품으로 《수레바퀴 밑에서》, 《게르트루트》, 《크눌프》, 《데미안》, 《싯다르타》, 《나르치스와 골트문트》, 《유리알 유희》(1946년 노벨문학상 수상작) 등이 있다.",
"Hermann Hesse", "헤르만 헤세", "자연과 평화를 그려내는 화가이자<br>끊엄없이 인간의 내면을 탐구하는 소설가", "2023-08-29", "cbh4547");
-- authoir_id = 7
insert into author(author_introduction, author_name_eg, author_name_ko, title, reg_time, created_by) 
values("오사카 부립대학 전기 공학과를 졸업한 후 엔지니어로 일하면서 틈틈이 소설을 쓰기 시작해 마침내 전업 작가의 길로 들어섰다. 1985년 『방과후』로 에도가와 란포상을 수상하며 이름을 알리기 시작해 1999년 『비밀』로 일본 추리 작가 협회상을, 2006년에는 탐정 갈릴레오 시리즈 제3탄 『용의자 X의 헌신』으로 제134회 나오키상과 본격 미스터리 대상을 수상했다. 2012년 『나미야 잡화점의 기적』으로 중앙공론 문예상을, 2013년 『몽환화』로 시바타 렌자부로상을 수상했으며, 2014년에는 『기도의 막이 내릴 때』로 요시카와 에이지 문학상을 수상했다. 그 밖의 작품으로 『가면 산장 살인 사건』『백야행』『인어가 잠든 집』『분신』『환야』『살인의 문』『기린의 날개』『한여름의 방정식』『신참자』『탐정 갈릴레오』『예지몽』『다잉 아이』『뻐꾸기 알은 누구의 것인가』『학생가의 살인』『오사카 소년 탐정단』『방황하는 칼날』『천공의 벌』『붉은 손가락』 등이 있다.",
"Higashino-keigo", "히가시노 게이고", "일본 추리소설의 아이콘이자<br>희대의 이야기꾼", "2023-08-29", "cbh4547");
-- authoir_id = 8
insert into author(author_introduction, author_name_eg, author_name_ko, title, reg_time, created_by) 
values("여덟 살 때부터 단편소설을 쓰기 시작한 타고난 글쟁이다. 1961년 프랑스 툴루즈에서 태어나 법학을 전공하고 고등 언론 학교에서 저널리즘을 공부했다. 저널리스트로 활동하면서 과학 잡지에 개미에 관한 글을 발표해 오다가 1991년 『개미』를 출간해 전 세계 독자를 단숨에 사로잡으며 <프랑스의 천재 작가>로 부상했다. 이후 영계 탐사단을 소재로 한 『타나토노트』, 세계를 빚어내는 신들의 이야기 『신』, 제2의 지구를 찾아 떠난 인류의 모험 『파피용』, 고양이의 눈으로 세상을 본 『고양이』, 독창적인 아이디어가 빛나는 단편집 『나무』 등 수많은 베스트셀러를 써냈다. 그의 작품은 35개 언어로 번역되었으며, 전 세계에서 3천만 부 이상 판매되었다.",
"Bernard Werber", "베르나르 베르베르", "독자를 사로잡는<br>기상천외한 상상력의 대가", "2023-08-29", "cbh4547");
-- authoir_id = 9
insert into author(author_introduction, author_name_eg, author_name_ko, title, reg_time, created_by) 
values("시인. 경희대학교 국문과를 졸업하고 한국일보 신춘문예에 시가 당선되어 문단에 나왔다. 〈시운동〉 동인으로 활동하다가 한동안 시 창작을 접고 인도, 네팔, 티베트 등지를 여행하기 시작했다. 이 시기부터 오쇼, 지두 크리슈나무르티, 바바 하리 다스, 달라이 라마, 틱낫한, 무닌드라 등 영적 스승들의 책을 번역 소개하는 한편 서울과 인도를 오가며 생활해 왔다. 1991년 첫 시집 『그대가 곁에 있어도 나는 그대가 그립다』를, 1996년 두 번째 시집 『외눈박이 물고기의 사랑』을 발표했다. 세상을 신비주의적 차원에서 바라보면서 인생의 불가사의함을 섬세한 언어로 그려 내어 모두가 공감하는 보편적 정서에 도달했다는 평가를 받았다. 2012년에 출간한 제3시집 『나의 상처는 돌 너의 상처는 꽃』은 독특한 시적 감성과 상상력으로 삶에 대한 투명한 관조를 보여 주었다.",
"Ryu shi-va", "류시화", "영혼을 돌보는 명상가이자<br>길 위에서 인생을 이야기하는 시인", "2023-08-29", "cbh4547");
-- authoir_id = 10
insert into author(author_introduction, author_name_eg, author_name_ko, title, reg_time, created_by) 
values("1945년 충남 서천에서 태어났다. 공주사범학교를 졸업하고 43년간 초등학교 교사로 재직했으며, 2007년 공주 장기초등학교 교장으로 퇴임했다. 1971년 서울신문 신춘문예에 시가 당선되어 작품활동을 시작했다. 첫 시집 『대숲 아래서』를 출간한 후 『풀꽃』 『너와 함께라면 인생도 여행이다』 『꽃을 보듯 너를 본다』 『너무 잘하려고 애쓰지 마라』 등 여러 권의 시집을 펴냈고, 산문집 그림시집 동화집 등 150여 권을 출간했다. 학교에서 만난 아이들에 대한 마음을 담은 시 「풀꽃」을 발표해 ‘풀꽃 시인’이라는 애칭과 함께 국민적인 사랑을 받았다. 소월시문학상, 흙의문학상, 충청남도문화상 등을 수상했다. 2014년부터는 공주에서 ‘나태주풀꽃문학관’을 설립 · 운영하며 풀꽃문학상을 제정 · 시상하고 있다.",
"Na Tae-ju", "나태주", "자세히 보아야 이쁘다<br>오래 보아야 사랑스럽다<br>너도 그렇다", "2023-08-29", "cbh4547");
-- authoir_id = 11
insert into author(author_introduction, author_name_eg, author_name_ko, title, reg_time, created_by) 
values("“죽을 때까지 현역 작가로 남는다면 행복할 것”<BR>\n박완서는 모진 삶이 안겨준 상흔을 글로 풀어내고자 작가의 길을 시작했지만, 그것에 머무르지 않았다. 누구나 한번쯤 겪어봤을 내면의 은밀한 갈등을 짚어내고, 중산층의 허위의식, 여성 평등 등의 사회 문제를 특유의 신랄함으로 드러냈다. 그럼에도 결국 그의 글이 가리키는 방향은 희망과 사랑이었다. 그의 글은 삶을 정면으로 직시하여 아픔과 모순들을 외면하지 않으면서도, 기어코 따뜻한 인간성을 지켜내고야 만다. 오직 진실로 켜켜이 쌓아 올린 그의 작품 세계는, 치열하게 인간적이었던, 그래서 그리운 박완서의 삶을 대변하고 있다.",
"Park Wan-suh", "박완서", "소박하고, 진실하고, 단순해서<br>아름다운 것들을 사랑한 작가", "2023-08-29", "cbh4547");
-- authoir_id = 12
insert into author(author_introduction, author_name_eg, author_name_ko, title, reg_time, created_by) 
values("1964년 제주도에서 태어났다. 1996년 한겨레신문의 시사만화가로 데뷔했으며, 만평 〈한겨레 그림판〉을 통해 따뜻하면서도 날카로운 시사 풍자를 보여줬다. 이듬해부터 연재한 〈박시백의 그림 세상〉은 평범한 사람들의 소소한 일상을 그려내 많은 독자의 공감과 지지를 얻었다. 2000년 《조선왕조실록》의 매력에 빠져들면서 이를 만화로 만드는 구상을 하고, 2001년에 그 구상을 실행에 옮기기 위해 신문사를 그만두었다. 2003년 《박시백의 조선왕조실록》 첫 권이 출간되었고, 그해 대한민국 만화대상 장관상을 수상했다. 이후 10년간 조선시대 사관의 심정으로 500년 역사를 20권의 책에 담아내 2013년 완간했다. 13년간의 대장정을 마친 그해 부천만화 대상을 수상했다. 2020년 일제강점사를 다룬 《35년》(전 7권)을 내놓았다. 현재는 한반도 역사상 가장 역동적인 나라 고려의 500년 역사를 탁월한 서사와 독보적인 작화로 생동감 있게 되살려내는 데 전념하고 있다.",
"Park Si-baek", "박시백", "시대의 요구에<br>헌신한 자를 기억하는 것은<br>우리의 의무", "2023-08-29", "cbh4547");
-- authoir_id = 13
insert into author(author_introduction, author_name_eg, author_name_ko, title, reg_time, created_by) 
values("1973년 서울에서 태어났어요. 회사원을 거쳐 커피를 만드는 바리스타로 오랫동안 일하면서 글을 썼고, 현재는 전업 작가로 활동하고 있습니다. 요즘 가장 재미있는 일은 학교나 도서관 강연에서 어린 친구들을 만나는 겁니다. 《기억, 직지》로 2013년 제1회 직지소설문학상 최우수상, 《조선변호사 왕실소송사건》으로 2016년 부산국제영화제 NEW 크리에이터상을 받았으며, 2019년 ‘원주 한 도시 한 책’에 《미스 손탁》이 선정되었습니다. 2020년에는 한국추리문학상 대상을 받았습니다. 《무너진 아파트의 아이들》, 《불 꺼진 아파트의 아이들》 등 환경과 재난을 다룬 동화와 《귀신 초등학교》, 《어린 만세꾼》 등의 어린이책, 역사추리소설 《온달장군 살인사건》, 《적패》, 《개봉동 명탐정》, 《유품정리사》 등을 썼습니다.",
"Joeng Myung-seop", "정명섭", "다양한 장르를 섭렵한 출판계의 다이소", "2023-08-29", "cbh4547");
-- authoir_id = 14
insert into author(author_introduction, author_name_eg, author_name_ko, title, reg_time, created_by) 
values("프린스턴 대학교에서 ‘기업가정신’을 강의하며 성공적인 작가와 투자자의 길을 걸어온 팀 페리스는 글로벌 CEO, 석학, 언론들에게서 ‘우리 시대 가장 혁신적인 아이콘’으로 평가받는다. 그는 페이스북, 알리바바, 우버 등 세계 최고 혁신기업의 초기 투자자이자 컨설턴트로서 엄청난 수익을 올렸고 그가 쓴 네 권의 책은 모두 아마존과 <뉴욕 타임스> 베스트셀러에 올랐다. <패스트 컴퍼니><포브스><포춘>이 선정한 ‘우리 시대 최고의 젊은 혁신가들’ 중 한 명인 그는 3년 연속 애플 팟캐스트 방송 청취율 1위를 기록한 <팀 페리스 쇼>를 진행하면서 ‘라디오 분야의 오프라 윈프리’라는 격찬을 받기도 했다. 세계 최고의 성공을 거둔 200명의 인물이 출연해 자신들만의 성공 비결을 솔직하고 낱낱하게 공개함으로써 청취자들의 폭발적인 인기를 불러 모은 이 방송은 팟캐스트 비즈니스 분야 최초로 1억 회 다운로드 돌파라는 기록을 남겼다. 그리고 이 방송이 현재 전 세계 베스트셀러 차트에 올라 젊은 독자들의 지지를 얻고 있는 이 책 《타이탄의 도구들》의 밑바탕이 되어주었다. 이 책에는 평범한 사람들이 최고의 목표와 성과를 달성할 수 있는 강력하고 검증된 방법들이 총 망라되어 있다. 따라서 이 책의 마지막 장까지 뜨거운 열정으로 따라온 독자들은 거인들의 어깨 위에 서서 자신의 일과 삶을 최고의 수준으로 혁신할 수 있는 모든 것을 얻게 될 것이다.",
"Timothy Ferris", "팀페리스", "美 포브스 선정<br>우리 시대 최고의 젊은 혁신가", "2023-08-29", "cbh4547");
-- authoir_id = 15
insert into author(author_introduction, author_name_eg, author_name_ko, title, reg_time, created_by) 
values("소설가. 장편소설로 『작별인사』 『살인자의 기억법』 『검은 꽃』 『아랑은 왜』 『나는 나를 파괴할 권리가 있다』 『너의 목소리가 들려』 『퀴즈쇼』, 소설집으로 『오직 두 사람』 『무슨 일이 일어났는지는 아무도』 『오빠가 돌아왔다』 『엘리베이터에 낀 그 남자는 어떻게 되었나』 『호출』이 있다. 여행에 관한 산문 『여행의 이유』와 『오래 준비해온 대답』을 냈고 산문집으로 『보다』 『말하다』 『읽다』의 합본인 『다다다』 등이 있다. F. 스콧 피츠제럴드의 『위대한 개츠비』를 번역하기도 했다. 서울에서 아내와 함께 살며 여행, 요리, 그림 그리기와 정원 일을 좋아한다. 2018년 오영수문학상, 2015년 김유정문학상, 2012년 이상문학상, 2007년 만해문학상, 2004년 동인문학상, 2004년 이산문학상, 2004년 황순원문학상, 1999년 현대문학상, 1996년 문학동네 작가상을 수상했다.",
"Kim Young-ha", "김영하", "도회적이고 직관적인 문체<br>예측하기 힘든 전개", "2023-08-29", "cbh4547");
-- authoir_id = 16
insert into author(author_introduction, author_name_eg, author_name_ko, title, reg_time, created_by) 
values("30년간 기업과 방송 등 강의 무대에서 활약해온 대한민국 최고의 자기계발 강사, 160만 구독자를 보유한 유튜브 채널 MKTV 크리에이터이자 18만 회원의 온라인 지식 커뮤니티 MKYU 대표. 사람들은 늘 궁금해한다. 자기 철학을 바탕으로 일을 추진해나가는 몰입력, 평생 공부를 멈추지 않는 꾸준함, 위기 때마다 해법을 찾아내는 긍정력, 사회에 발휘하는 선한 영향력까지 도전과 성장을 끊임없이 이어나가는 그의 성공 비결은 무엇일까. 그런데 사람들이 잘 모르는 것이 있다. 40대 중반까지 그도 무명 강사에 불과했다는 사실을. 자신의 이름을 내건 방송 프로그램 <김미경 쇼>도, 《꿈이 있는 아내는 늙지 않는다》 《언니의 독설》 등의 대표작도 모두 40대 후반에야 이룬 일이다. 마흔 즈음의 그는 초라한 인생 성적표와 불안한 미래 앞에서 하루하루 흔들렸다. 그런 그이기에 요즘 30~40대가 겪고 있는 우울과 불안에 누구보다 공감하며 뜨거운 위로를 보낸다. 마흔이 되면 좀 더 여유롭고 단단한 어른이 될 거라 믿었지만 여전히 하루하루 초조하고 불안하다면, 정상이다. 왜냐하면 마흔이란 결과가 아닌 ‘과정’이며, 안정보다는 ‘도전과 성장’이 어울리는 나이니까. 이 책은 그가 온몸으로 겪으며 한발 앞서 깨달은 40대에 관한 통찰이자 100세 시대에 새로 쓰는 인생 해석집이다. 그는 인생에서 가장 빛나는 시절을 살고 있는 마흔들이 계속해서 꿈꾸고 도전하기를 간절히 바란다. 마흔이 해야 할 일은 인생 정산이 아니라 오늘 하루를 진정한 황금기를 만드는 것이기에.",
"Kim Mi-kyung", "김미경", "언니들의 언니<br>촌철살인, 뼈 때지는 조언", "2023-08-29", "cbh4547");
-- authoir_id = 17
insert into author(author_introduction, author_name_eg, author_name_ko, title, reg_time, created_by) 
values("1993년부터 글을 쓰기 시작했다. 자기계발·인문학·교육 등 다양한 분야에서 서른 권 넘는 책을 출간했고, 총 500만 부 이상의 판매를 기록했다. 대표작으로는 《꿈꾸는 다락방》 《리딩으로 리드하라》 《에이트》 《에이트 : 씽크》 등이 있다. 주요 저서들은 미국·일본·중국·대만·베트남·인도네시아 등에서 번역 출간되었다.",
"Lee Ji-sung", "이지성", "생생하게 꿈꾸면 이루어진다<br>꿈꾸는 다락방", "2023-08-29", "cbh4547");
-- authoir_id = 18
insert into author(author_introduction, author_name_eg, author_name_ko, title, reg_time, created_by) 
values("KAIST에서 물리학으로 학사, 석사, 박사 학위를 받았습니다. 예일대학교 의과대학 정신과 박사후 연구원, 고려대학교 물리학과 연구교수, 컬럼비아대학교 의과대학 정신과 조교수를 거쳐, KAIST 뇌인지과학과 교수와 융합인재학부 학부장을 맡고 있습니다. 주된 연구 주제는 의사 결정의 신경 과학, 뇌-로봇 인터페이스, 정신 질환의 대뇌 모델링, 대뇌 기반 인공 지능이며, 다보스 포럼 ‘2009 차세대 글로벌 리더’, ‘대한민국 근정포장’을 수상했습니다. 저서로 《정재승의 과학 콘서트》(2001), 《열두 발자국》(2018) 등이 있습니다.",
"Jeong Jae-seung", "정재승", "글쓰는 과학자<br>우리 사회에서 보기 힘든<br>'통섭형 인간'", "2023-08-29", "cbh4547");
-- authoir_id = 19
insert into author(author_introduction, author_name_eg, author_name_ko, title, reg_time, created_by) 
values("평생 자연을 관찰해 온 생태학자이자 동물행동학자. 서울대학교에서 동물학을 전공하고 미국 펜실베이니아주립대학교에서 생태학 석사학위를, 하버드대학교에서 생물학 박사학위를 받았다. 10여 년간 중남미 열대를 누비며 동물의 생태를 탐구한 뒤, 한국으로 돌아와 자연과학과 인문학의 경계를 넘나들며 생명에 대한 지식과 사랑을 널리 나누고 실천해 왔다. 서울대학교 생명과학부 교수, 환경운동연합 공동대표, 한국생태학회장, 국립생태원 초대원장 등을 지냈다. 현재 이화여자대학교 에코과학부 석좌교수로 재직 중이며 생명다양성재단의 이사장을 맡고 있다. 《개미제국의 발견》, 《생명이 있는 것은 다 아름답다》, 《다윈 지능》, 《열대예찬》, 《최재천의 인간과 동물》, 《과학자의 서재》, 《생태적 전환, 슬기로운 지구 생활을 위하여》 등을 썼다. 2019년 총괄편집장으로서 세계 동물행동학자 500여 명을 이끌고 《동물행동학 백과사전》을 편찬했다. 2020년 유튜브 채널 〈최재천의 아마존〉을 개설해 자연과 인간 생태계에 대한 폭넓은 이야기를 전하고 있다.",
"Choe Jae-cheon", "최재천", "알면 사랑한다<br>생명은 정녕 그 모습이 어떻든<br>아름다울 수 밖에 없다", "2023-08-29", "cbh4547");
-- authoir_id = 20
insert into author(author_introduction, author_name_eg, author_name_ko, title, reg_time, created_by) 
values("2013년 『작가세계』 신인상을 수상하며 작품활동을 시작했다. 소설집 『쇼코의 미소』 『내게 무해한 사람』, 장편소설 『밝은 밤』, 짧은 소설 『애쓰지 않아도』가 있다. 허균문학작가상, 김준성문학상, 구상문학상 젊은작가상, 이해조소설문학상, 한국일보문학상, 대산문학상, 제5회, 제8회, 제11회 젊은작가상을 수상했다.",
"Choi Eun-yeong", "최은영", "여성의 글쓰기<br>위로와 치유가 되다", "2023-08-29", "cbh4547");

-- 작가 이미지 정보 등록
-- authoir_id = 1
insert into author_img(img_name, img_url, ori_img_name, author_id) 
values("3497c441-abd2-47dd-b9e4-73a5771591c8.jpeg", "/image/author/3497c441-abd2-47dd-b9e4-73a5771591c8.jpeg", "01_Kim_Keum-hee.jpeg", "1");
-- authoir_id = 2
insert into author_img(img_name, img_url, ori_img_name, author_id) 
values("275af915-717b-44aa-9536-53e4059723fb.jpg", "/image/author/275af915-717b-44aa-9536-53e4059723fb.jpg", "02_Shin_Kyung-sook.jpg", "2");
-- authoir_id = 3
insert into author_img(img_name, img_url, ori_img_name, author_id) 
values("7cdb4bb1-452b-430b-95ab-509d2082cac5.jpg", "/image/author/7cdb4bb1-452b-430b-95ab-509d2082cac5.jpg", "03_Ekuni_Kaori.jpg", "3");
-- authoir_id = 4
insert into author_img(img_name, img_url, ori_img_name, author_id) 
values("3e6f6112-6af0-419d-bafb-66ad46bb734a.jpg", "/image/author/3e6f6112-6af0-419d-bafb-66ad46bb734a.jpg", "04_Agatha_Christie.jpg", "4");
-- authoir_id = 5
insert into author_img(img_name, img_url, ori_img_name, author_id) 
values("4fb3b121-73a5-491a-9014-0bac560a2ca6.jpg", "/image/author/4fb3b121-73a5-491a-9014-0bac560a2ca6.jpg", "05_Guillaume_Musso.jpg", "5");
-- authoir_id = 6
insert into author_img(img_name, img_url, ori_img_name, author_id) 
values("ecb5e554-3925-4811-ac19-99d9d6f912b4.jpg", "/image/author/ecb5e554-3925-4811-ac19-99d9d6f912b4.jpg", "06_Hermann_Hesse.jpg", "6");
-- authoir_id = 7
insert into author_img(img_name, img_url, ori_img_name, author_id) 
values("e4c4a018-121e-4936-8217-548c8ee07ce8.jpg", "/image/author/e4c4a018-121e-4936-8217-548c8ee07ce8.jpg", "07_Higashino-keigo.jpg", "7");
-- authoir_id = 8
insert into author_img(img_name, img_url, ori_img_name, author_id) 
values("8a1d088a-fa14-4043-b535-ff33ca1e4898.jpg", "/image/author/8a1d088a-fa14-4043-b535-ff33ca1e4898.jpg", "08_Bernard_Werber.jpg", "8");
-- authoir_id = 9
insert into author_img(img_name, img_url, ori_img_name, author_id) 
values("ad2f95d7-67bc-4522-a30c-17e56b68d4c3.jpg", "/image/author/ad2f95d7-67bc-4522-a30c-17e56b68d4c3.jpg", "09_Ryu_shi-va.jpg", "9");
-- authoir_id = 10
insert into author_img(img_name, img_url, ori_img_name, author_id) 
values("40ad5d21-a212-41ed-9138-2585be84cd5c.jpg", "/image/author/40ad5d21-a212-41ed-9138-2585be84cd5c.jpg", "10_Na_Tae-ju.jpg", "10");
-- authoir_id = 11
insert into author_img(img_name, img_url, ori_img_name, author_id) 
values("29571713-ee04-4dfe-926d-0e29e2c4fbbf.jpg", "/image/author/29571713-ee04-4dfe-926d-0e29e2c4fbbf.jpg", "11_Park_Wan-suh.jpg", "11");
-- authoir_id = 12
insert into author_img(img_name, img_url, ori_img_name, author_id) 
values("6a4614e6-660a-4709-ba59-0a5e8c2165e9.jpg", "/image/author/6a4614e6-660a-4709-ba59-0a5e8c2165e9.jpg", "12_Park_Si-baek.jpg", "12");
-- authoir_id = 13
insert into author_img(img_name, img_url, ori_img_name, author_id) 
values("035a0f69-3063-4374-b919-c5caedf7f42e.jpg", "/image/author/035a0f69-3063-4374-b919-c5caedf7f42e.jpg", "13_Joeng_Myung-seop.jpg", "13");
-- authoir_id = 14
insert into author_img(img_name, img_url, ori_img_name, author_id) 
values("7839d1bf-0d44-4202-a59c-df3b3ea3be0a.jpg", "/image/author/7839d1bf-0d44-4202-a59c-df3b3ea3be0a.jpg", "14_Timothy_Ferris.jpg", "14");
-- authoir_id = 15
insert into author_img(img_name, img_url, ori_img_name, author_id) 
values("6e17e093-f952-41d3-a74e-6003579961f1.jpg", "/image/author/6e17e093-f952-41d3-a74e-6003579961f1.jpg", "15_Kim_Young-ha.jpg", "15");
-- authoir_id = 16
insert into author_img(img_name, img_url, ori_img_name, author_id) 
values("10a7479a-482c-4927-a062-4817619fed4e.jpg", "/image/author/10a7479a-482c-4927-a062-4817619fed4e.jpg", "16_Kim_Mi-kyung.jpg", "16");
-- authoir_id = 17
insert into author_img(img_name, img_url, ori_img_name, author_id) 
values("ddb9236a-864e-4234-b13b-8f31fa631a24.jpg", "/image/author/ddb9236a-864e-4234-b13b-8f31fa631a24.jpg", "17_Lee_Ji-sung.jpg", "17");
-- authoir_id = 18
insert into author_img(img_name, img_url, ori_img_name, author_id) 
values("ce908281-58c9-497d-bd49-ae43a58f3d6d.jpg", "/image/author/ce908281-58c9-497d-bd49-ae43a58f3d6d.jpg", "18_Jeong_Jae-seung.jpg", "18");
-- authoir_id = 19
insert into author_img(img_name, img_url, ori_img_name, author_id) 
values("2bc8c2ed-39b3-4c26-9ec9-1ca838d5bb6e.jpg", "/image/author/2bc8c2ed-39b3-4c26-9ec9-1ca838d5bb6e.jpg", "19_Choe_Jae-cheon.jpg", "19");
-- authoir_id = 20
insert into author_img(img_name, img_url, ori_img_name, author_id) 
values("7123ca06-81f6-4309-9bb7-846737de2447.jpg", "/image/author/7123ca06-81f6-4309-9bb7-846737de2447.jpg", "20_Choi_Eun-yeong.jpg", "20");

-- 작가 도서 정보 등록
-- author_book = 1
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("미숙하고 풋풋한 시절의 위태로운 마음을 총 아홉 편의 소설에 나눠 담았다.", "너무 한낮의 연애", "미숙했던 사랑 돌아보기", "1");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("한 사람의 인생을 꺾이고 무너지게 만드는 '실패'에 대해 썼다.", "복자에게", "서러웠던 실패 마주보기", "1");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("삶을 살아내기 위해 묻어두어야만 했던 지난 시절의 상처를 그 어느 때보다 골똘하게 바다본다.", "오직 한 사람의 차지", "묻어뒀던 상처 꺼내보기", "1");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("유년 시절부터 지금에 이르기까지, 사랑과 사랑 밖을 아우르는 거의 모든 말을 담았다.", "사랑 밖의 모든 말들", "지나왔던 시절 사랑하기", "1");
-- author_book = 2
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("늘 곂에서 보살펴주고 무한한 사랑은<br>주기만하던, 그래서 당연한 존재,<br>실종된 어머니의 흔적을 추적하는 과정", "엄마를 부탁해", "무심코 무시했던 엄마의 인생", "2");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("가장 깊이 정말하고 고민하고<br>상처받았기에 오히려 더욱<br>아름답게 빛나는 시간.", "어디선가 나를 찾는 전화벨이 울리고", "사랑과 젊음의 의미 탐색", "2");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("환하게 웃다 코끝이 찡해지는<br>스물여섯 개의 보석 같은 이야기.<br>달이 듣고 함빡 웃을 수 있는 이야기.", "달에게 들려주고 싶은 이야기", "명랑하고 상큼한 유머", "2");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("열여섯에서 스물까지 문학의 꿈을 키웠던 소녀,<br>신경숙의 사랑과 아픔을 생생하게 담은<br>자전소설.", "외딴방", "잔잔한 아픔이 앞서는 소녀시절", "2");
-- author_book = 3
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("8년을 함께한 남자가<br>만난 지 4일 된 여자 때문에 나를 떠난다.<br>아이유가 추천한 한 여자의<br>아주 느린 실연 이야기.", "낙하하는 저녁", "이별까지도 사랑인가요?", "3");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("안타까운 오해로 헤어져 각자의 삶을 살던<br>아오리와 쥰세이. 그 둘은 연인일 때 했던<br>마지막 약속을 지키기 위해 피렌체로 향한다.", "냉정과 열정 사이 Rosso", "헤어진 연인을 아직 사랑하나요?", "3");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("스무 상 남자에게 찾아온 40대 연상의 연인<br>그 둘은 나이 차를 극복할 수 있을까?<br>김희애.유야인 주연 드라마<밀회>의 원작소설.", "도쿄타워", "사랑에 있어 나이가 중요하나요?", "3");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("30여 년간 꾸준히 작품 활동을 이어온<br>에쿠니 가오리가 자신의 '읽고 쓰는' 삶에 대해 말한다.", "한 동안 머물다<br>밖으로 나가고 싶다", "독서를 사랑하나요?", "3");
-- author_book = 4
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("1억 부 이상 팔린 애거서 크리스티 최고의 소설<br>외딴섬 저택에 초대받은 10명의 손님이 차례대로<br>죽음을 맞이한다.", "그리고 아무도 없었다", "방문자 모두 사망한 저택, 범인은 누구?", "4");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("애거서 크리스티가 창조한 최고의 명탐정<br>푸아로를 대표하는 작품. 오리엔트 특급 열차가 폭설 속에<br>고립되고, 한 남자가 열두 번이나 칼에 찔린<br>실체로 발견된다.", "오리엔트 특급 살인", "고립된 열차 안 살인, 범인은 누구?", "4");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("고급 유람선 위 울린 한발의 총성.<br>눈부신 미모에 막대한 재산을 가진 상속녀<br>리넷 리지웨이를 죽인 이는 누구일까?", "나일 강의 죽음", "유람선 살인 사건, 범인은 누구?", "4");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("마을 신문에 살인을 예고하는 기사가 실린다.<br>호기심 가득한 마을 사람들은 살인 '게임'을 기대했지만,<br>게인이 아닌 '실제' 살인이 벌어지고 마는데.", "살인을 예고합니다", "신문 광고로 예고한 살인, 범인은 누구?", "4");
-- author_book = 5
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("살인을 저지르고 25년 뒤,<br>시체를 숨겨놓은 체육관이 허물릴 위기해 처했다.<br>과연 살인범들의 선택은?", "아가씨와 밤", "매혹적인 스릴러를 읽고 싶다면?", "5");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("줄리에트가 탄 프랑스행 비행기가<br>대서양 상공에서 폭발한다. 우연히 그녀와 만나<br>사랑에 빠졌던 샘은 큰 충격에 빠진다.", "구해줘", "속도감 있는 미스터리를 읽고 싶다면?", "5");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("아들이 죽어 큰 충격에 빠진 네이선<br>그에게 죽음을 예견할 수 있는 사람이 찾아온다.<br>네이선은 다음 차례가 자신임을 직감한다.", "그 후에", "초현실적인 상황의 작품을 읽고 싶다면?", "5");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("실수로 공항에서 휴대폰이 뒤바뀐 남녀<br>염탐하지 말아야 할 정보들을 계속해서 보게되고,<br>결국 충격적인 사실을 알게 된다.", "천사의 부름", "스릴러와 로맨스의 조합을 찾는다면?", "5");
-- author_book = 6
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("100년 넘게 사랑받은 고전.<br>외로운 소년 '싱클레어'가 인생의 중요한 순간다마<br>만난 데미안이란 존재로 인해 성장하는 이야기.", "데미안", "진정한 자아를 찾기 위한 길을 제시하다", "6");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("세월의 갈림길에서 새로운 성찰이 필요할 때,<br>헤세가 제안하는 단단한 조언. 풍부한 인생 경험담을<br>바탕으로 만나는 일상의 소중함.", "어쩌면 괜찮은 나이", "나이듦의 과정 속 빛나는 지혜를 포착하다", "6");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("어릴 적 첫사랑부터 원숙한 사랑까지,<br>세상에 존재하는 사랑의 모든 것.<br>헤세가 담아낸 뜨거운 열정의 이야기.", "헤세, 사랑이 지나간 순간들", "다채로운 사랑의 경험을 떠올리다", "6");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("어두운 삶 속에서 사색을 거듭한 헤세.<br>고통스러운 순간마다 문학으로 극복하기 위해<br>써 내려간 치유의 글.", "밤의 사색", "위안과 안식이 필요한 이들에게 말하다", "6");
-- author_book = 7
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("탄탄한 복선과 트릭을 담아낸 학원 미스터리,<br>히가시노식 추리소설의 시작점인 데뷔작.", "방과 후", "히가시노의 초기작이 궁금하다면?", "7");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("살해당한 아버지의 장례식에서 만나는<br>살해 용의자들의 미묘한 심리 추리소설.", "블랙 쇼맨과<br>이름 없는 마을의 살인", "히가시노의 최신작을 먼저 보고 싶다면?", "7");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("소원을 들어주는 녹나무를 찾아오는<br>사람들의 애절한 사연을 담은 소설.", "녹나무의 파수꾼", "무섭지 않은 미스터리를 즐기고 싶다면?", "7");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("화살로 살해된 유명 대기업 사장 살인 사건,<br>두 남자의 치열한 숙명을 그린 미스터리 대작.", "숙명", "히가시노식 정통 추리소설을 보고 싶다면?", "7");
-- author_book = 8
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("개미를 통해 본 인간 사회의 민낯<br>인간 세계와 개미 새계가 공존하는 과정을 그리다.", "개미", "개미 세계를 탐구하고 싶다면?", "8");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("초고령 사회, 기계화된 세계 등,<br>현대사회의 13가지 문제를<br>미래 사회를 통해 보여주다.", "나무", "사회 문제를 새롭게 해석해보고 싶다면?", "8");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("나비를 닮은 거대 우주 범선을 타고 떠난<br>인류의 지구 탈출기를 기록하다.", "파피용", "우주 이민의 꿈, 인류의 미래를 알고 싶다면?", "8");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("자신도 모르는 사이 살해당한 추리 소설가,<br>이승과 저승을 오가며 범인을 찾아나서다.", "죽음", "죽음을 대하는 새로운 시선을 느끼고 싶다면?", "8");
-- author_book = 9
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("시대를 넘나드는 여러 시인들의 시 77편.<br>한 편의 좋은 시가 보태지면 세상은<br>더 이상 전과 같지 않다.", "사랑하라 한번도 상처받지 않은 것처럼", "치유와 깨달음", "9");
insert into author_book(book_introdution, book_name, book_sub_title, author_id)
values("수수한 말로 삶레 색채를 불어넣는 감각있는 시.<br>문학상 수상작가의 시부터 페이스북 시인의 시까지<br>시들이 말을 걸어왔다.", "마음챙김의 시", "애매모호함 없이, 더없이 명료하게", "9");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("지금과는 다른 새로운 삶을 원하는 사람,<br>새로운 존재를 영위하고 싶은 모든 사람들에게<br>자신의 삶의 방식에 대해 전해주는 시집", "지금 알고 있는 걸 그때도 알았더라면", "냉정한 관찰법, 웃음과 감동", "9");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("긴 겨울을 버티고 겨우 봄꽃을 만난<br>자기 자신에게 내미는 손. '홀로 봄앓이하는 겨울' 지나<br>다시 봉오리를 여는 하나의 우주, 한 그루의 꽃나무들", "꽃샘바란에 흔들린다면 너는 꽃", "손을 내밀어 보라 다친 새를 초대하듯이", "9");
-- author_book = 10
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("현재를 살아가면서 불확실한 미래로 막막하고,<br>불안정하며 우울한 이들에게 현상 너머 진짜를 보는바짝이는 별이 되라고<br>시인 특유의 따뜻하고 진솔한 시어로 위로를 전한다.", "별빛 너머의 별", "흔들리며 방황하는 이들에게", "10");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("기존 일력의 글과 그림들을 늘 소장하고 싶다는<br>독자들의 목소리에 따라 기존 일력의 날짜는 빼고,<br>시인이 직접 그린 그림들과 글들은 그대로 담았다.", "나태주, 시간의 쉼표", ", 하나 , 둘 , 셋 , 넷", "10");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("나태주 시인이 자신의 삶을 회고하며 오랫동안 차근히<br>집필해온 산문집으로, 일상에서 만난 놀라운 생명력과<br>회복력에 대한 그의 섬세한 마음이 담겨 있다.", "봄이다, 살아보자", "그래 살아보는 거다", "10");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("황량한 사막에서도 사랑스러운 존재들이 공존하듯이<br>삶에서도 놓치지 말아야할 마음들이 있음을,<br>시인은 다정히 일러준다.", "네가 없으면 인생도 사막이다", "다정한 연서로 읽히는 서시", "10");
-- author_book = 11
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("1970년부터 2010년까지 박완서 작가가 집필한 660여 편의<br>에세이 중 고르고 골라 대표할 만한 35편의 글을 한 권에 담았다.", "모래알만 한 진실이라도", "박완서 작가 10주기 에세이", "11");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("도시민과 농촌민간의 갈등, 빈부의 격차를 통해<br>인간의 삶에서 진정한 행복과 참된 아름다움이 무엇인지 묻고 있다.", "자전거 도둑", "어두운 시절에 마음을 달래고자", "11");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("새로운 삶에 대한 흥분, 불확실한 미래에 대한<br>두려움이 공종하는 시기를 통과하고 있는 이들을 위해 쓰여인 산문들이다.", "생애 최고의 날은 아직 살지 않은 날들", "어떻게 살아갈 것인가?", "11");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("'자유와 평화'를 누릴 수 있음과 '살아 있는 것들만이 낼 수 있는 기척'을<br> 감지할 수 있음에 감사하는 작가의 마음을 느낄 수 있다.<br>죽음과 가까워진 생에 대한 노작가만의 성찰도 담겨 있다.", "못 가본 길이 더 아름답다", "기쁨과 경탄, 감사와 애정", "11");
-- author_book = 12
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("조선사 입문의 대표 도서로 자리 잡은 《박시백의 조선왕조실록》<br>조선사가 지식인 문화에 머물고 대중들에게는 아직 생소했던 시절,<br>조선사로 사는 길못을 시원하게 열어준 책", "박시백의 조선왕조실록(전20권)", "성실한 고증과 탄탄한 구성, 조선왕조 500년", "12");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("고려시대가 한눈에 이해되는 탄탄한 구성!<br>물 흐르듯 읽히는 이야기. 1000년 전 고려의<br>역사적 인물들을 눈 앞에 생생히 되살린 또렷한 작화다.", "박시백의 고려사", "제대로 알지 못했던 고려왕조 500년", "12");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("국내외 답사를 포함한 준비 과정을 포함하면 5년 만의 결실이다.<br>우리 선조들의 힘으로 일궈낸 자랑스러움을 간직한 역사<br>그들의 투쟁 정신이 기억될 수 있었으면 좋겠다는 작가의 마음이 담겨 있다.", "35년(전 7권)", "75주년에 아로새기는 우리의 역사", "12");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("친일파의 탄생부터 이들이 어떻게 세를 불리고 어떻게 부를 쌓아왔는지<br>또 해방 이후 어떻게 그 죗값을 피해갔는지를 상세하게 추적한다.", "친일파 열전", "고리타분하지만 '친일 청산'", "12");
-- author_book = 13
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("육모 방망이를 든 포도청 군관 육중창과<br>이종의 콤비의 해결 못할 사건은 없다.<br>실존 인물을 바탕으로 한 역사 추리물", "조선의 형사들", "역사 추리물이 보고 싶다면?", "13");
insert into author_book(book_introdution, book_name, book_sub_title, author_id)
values("바이러스가 퍼지고 사람들이 변했다. 좀비를 피해<br>우주로 도피했다가 102년 만에 지구로 귀환한<br>인류에게 벌어진 일을 다룬 SF 좀비물.", "그들이 세상을 지배할 때", "좀비물이 보고 싶다면?", "13");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("단 한 발의 탄환이나 한 자루의 칼이 역사의<br>흐름을 바꾼다. 한국사에서 벌어진 열한 가지의<br>암살 사건을 소개하는 역사 인문서.", "암살로 있는 한국사", "역사 인문서를 보고 싶다면?", "13");
insert into author_book(book_introdution, book_name, book_sub_title, author_id)
values("조선 시대부터 일제강점기, 근현대까지<br>600여 년의 역사를 품은 서울 곳곳을<br>이야기와 그림으로 풀어낸 기행문.", "오래된 서울을 그리다", "역사 기행문을 보고 싶다면?", "13");
-- author_book = 14
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("<뉴욕 타임스> 베스트셀러 1위. 세계 최정상에<br>오른 200여명이 직접 밝힌 '독창적인 성공 비결'을<br>61가지로 나눠 완벽히 정리했다.", "타이탄의 도구들", "새해를 '빛나게' 해줄 성공 비결", "14");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("<아마존>베스트셀러 1위. 일주일에 4시간만<br>일하고 한 달에 4천만 원 넘게 버는 방법을<br>4단계 전략을 알려준다.", "나는 4시간만 일한다", "새해를 '놀랍게' 해줄 업무 비결", "14");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("<뉴욕 타임스> 베스트셀러 1위. 세계에서 가장<br>지혜로운 사람들이 알려주는 '원하는 삶을 얻는<br>방법'을 51가지로 정리해 풀어냈다.", "지금 하지 않으면<br>언제 하겠는가", "새해를 '즐겁게' 해줄 인생 비결", "14");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("우리 시대 가장 성공한 사람들의 2,30대 시절은<br>어땠을까? 세계적인 석학들을 만나 얻은 깨달음을<br>젊은 독자에게 전한다.", "마흔이 되기 전에", "새해를 '행복하게' 해줄 성장 비결", "14");
-- author_book = 15
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("그리 멀지 않은 미래를 배경으로 별안간 삶이<br>송두리째 뒤흔들린 한 소년의 여정을 좇는다.", "작별 인사", "정말 미래는 알 수 없는 거네요", "15");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("삶이 부과하는 문제가 까다로울수록 여행을 더 갈망해온<br>작가에게 여행은 어떤 의미인지, 왜 여행하는지, 오랜 시간 여행하면서<br>경험하고 생각해온 이야기들을 확인할 수 있다.", "여행의 이유", "사유의 여해으 문학적 사유의 성찬", "15");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("알츠하이머에 걸린 은퇴한 연쇄살인법이 점점<br>사라져가는 기억과 사투를 벌이며 딸을 구하기 위한<br>마지막 살인을 계획한다.", "살인자의 기억법", "삶과 죽음, 시간과 악에 대한 통찰", "15");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("묘하게도 편편이 무언가를 '상실'한 사람들, 그리고<br>'상실 이후의 삶'을 사는 이들의 이야기들이다.", "오직 두 사람", "그 이후의 삶, 김영하 스타일", "15");
-- author_book = 16
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("12년 전 <언니의 독설>에서 서른의 불안과 두려운을<br>다독였던 김미경이 다시 마흔에게 말한다.<br>마흔은 잘못이 없다고, 당신의 마흔은 매일 나아지는 중이라고,<br>100세 시대에 마흔은 아직 인생의 전반기라고,", "김미경의 마흔 수업", "마흔은 결과가 아닌 과정이다", "16");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("코로나로 언택트 시대로의 변화를 절감했던 그녀는<br>이제 한발 앞서 '온택트' 시대를 열고 있다. 이 책은<br>그 절박하고 간절했던 고민의 결과다.", "김미경의 리부트", "다시 시작하는 사람들을 위하여", "16");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("스타 강사 김미경의 관심사는 코로나 이전과 이후로 나뉜다.<br>그동안 사람들의 용기를 북돋우고 그들이 성인이 되면서<br>이제는 다른 차원의 동기 부여에 나선 것이다.", "세븐 테크", "미래로 가는 길, 아는 만큼 보인다", "16");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("'꿈은 성공이 아니라 성찰의 언어이고,<br>성취가 아니라 성장의 언어다'<br>꿈을 만들고, 키우고, 가지고 노는 그 법칙.", "김미경의 드림 온", "드림워커로 살아라", "16");
-- author_book = 17
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("방대한 자료를 바탕으로 보통 사람들이 생활에서<br>실행할 수 있도록 쉽게 정리하였다. 그것이 바로<br>R=VD, '생생하게(vivid) 꿈을 꾸면(dream) 이루어진다(realization)'.", "꿈꾸는 다락방", "생생하게 꿈꾸면 이루어진다", "17");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("이지성 작가는 '북한의 쉰들러'라 불리는 수퍼맨 목사의 든든한 후원자였다.<br>이들을 구출하고 있는 자신의 모습이 낯설게 다가온, 그 질문에 대한 답을 담았다.", "이지성의 1만 킬로미터", "그들은 왜 목숨을 건 여정을 떠나는가?", "17");
insert into author_book(book_introdution, book_name, book_sub_title, author_id)
values("가정에서 아이에게 인문고전 독서교육을 시킬 때 주의할 점,<br>초보자를 위한 세심한 조언, 단계별 추천도서 목록까지, 바로 인문고전 독서를<br>시작할 수 있도록 돕는 실용적인 정보들도 담았다.", "리딩으로 리드하라", "미래를 바꾸는 힘을 제시하는 책", "17");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("미래 사회는 인공지능에게 지시를 내리는 계급과<br>인공지능의 지시를 받는 계급으로 나뉜다고 한다.<br>인공지능이 인간을 넘어서는 시대, 어떻게 살아남을 것인가", "에이트", "실리콘밸리의 천재들", "17");
-- author_book = 18
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("해결하는 뇌의 작동방식을 알려주는 동시에,<br>이를 바탕으로 더 나은 삶을 추구하고 아직 오지 않은 세상을<br>탐구하는 인간 그리고 뇌의 여정을 보여준다.", "열두 발자국", "당신의 열세 번째 발걸음을 기대합니다", "18");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("물리학이라는 렌즈로 포착한 인간과 사회에 관한<br>새로운 발견들을 흥미롭게 들려준다.", "정재승의 과학 콘서트", "복잡한 세상 명쾌한 과학", "18");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("익숙한 듯 낯선, 인간이라는 세계로의 항해<br>스트레스, 선택, 공감 등 인간에 대해<br>뇌과학과 심리학의 관점으로 파헤져 본다.", "정재승의 인간 탐구 보고서", "어린이를 위한 뇌과학", "18");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("과학 선생님이 가장 많이 추천하는 교양과학<br>영화를 통해 과학을 배우고, 과학을 통해<br>영화를 즐기는 새로운 시도.", "물리학자는 영화에서 과학을 본다", "정재승의 시네마 사이언스", "18");
-- author_book = 19
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("최재천 교수와 저널리스트 안희경이 공부를 주제로<br>나눈 대화 갈무리, 최재천의 말들은 어딘가 계속 예상한 지점으로부터<br>벗어나는 구석이 이다. 그는 괴짜구나!", "최재천의 공부", "어떻게 배우며 살 것인가", "19");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("새로운 세계를 알게 된다는 것은<br>또 다른 세상이 열리는 것과 같다.<br>관심만 갖는다면 우리는 새로운 세상을 만날 수도 있다.", "생명이 있는 것은 다 아름답다", "최재천의 동문과 인간 이야기", "19");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("'드디어 다윈' 시리즈로, 팬데믹과 공진화, 마음의 진화,<br>음악의 진화, 그리고 호모 심비우스에 관한 글을 추가했다.", "다윈 지능", "최재천의 진화학 에세이", "19");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("코로나19 사태로 인해 인류가 예전과 전혀 다른<br>삶을 살게 될 것은 자명해 보인다.<br>우리의 삶은 어떻게 변할 것인가?", "코로나 사피엔스", "신인류의 미래를 말한다", "19");
-- author_book = 20
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("작가가 처음 작품활동을 시작했을 때<br>품은 마음이 지금의 관점에서 어떻게 이어지는지 보여준다.", "아주 희미한 빛으로도", "그렇게 사랑하고 싶었던 사람들에게", "20");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("오랫동안 마음속에 품어왔던 '증조모-할머니-엄마-나'로 이어지는 4대의 삶을 비추며<br>자연스럽게 백년의 시간을 관통한다.", "밝은 밤", "얼마나 서럽구 외로웠냐고 묻는 편지처럼", "20");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("서로 다른 국적과 언어를 가진 두 인물이 만나<br>성장의 문턱을 통과해가는 과정을 그려냈다.", "쇼코의 미소", "낯섦과 전위에 대한 요구", "20");
insert into author_book(book_introdution, book_name, book_sub_title, author_id) 
values("특정한 시기에 여러 번 듣게 된 노래에는 강력한 인력이 있어<br>그 노래를 다시 듣는 것 만으로도 당시의 기억이 떠오른다.", "내게 무해한 사람", "한 시기에 우리를 지배했던 그런..", "20");

-- 작가 도서 이미지 정보 등록
-- author_book_img = 1
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("30660154-0447-49a2-a4f8-c9918a5e3387.jpeg", "/image/author/30660154-0447-49a2-a4f8-c9918a5e3387.jpeg", "01_Kim_Keum-hee-book1.jpeg", "1");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("ff65155e-f5ce-40fd-bc72-6b4db2255dca.jpg", "/image/author/ff65155e-f5ce-40fd-bc72-6b4db2255dca.jpg", "01_Kim_Keum-hee-book2.jpg", "2");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("e1b10ebc-790d-4882-91ee-6fe6af38eb40.jpeg", "/image/author/e1b10ebc-790d-4882-91ee-6fe6af38eb40.jpeg", "01_Kim_Keum-hee-book3.jpeg", "3");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("55cab2a7-a57e-45b5-9a8a-38663671f851.jpeg", "/image/author/55cab2a7-a57e-45b5-9a8a-38663671f851.jpeg", "01_Kim_Keum-hee-book4.jpeg", "4");
-- author_book_img = 2
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("d9fbd005-efa3-4210-a6b8-217953d695c6.jpg", "/image/author/d9fbd005-efa3-4210-a6b8-217953d695c6.jpg", "02_Shin_Kyung-sook-book1.jpg", "5");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("5c02158f-2e3e-4c1d-b8ad-190bd9bf25c1.jpg", "/image/author/5c02158f-2e3e-4c1d-b8ad-190bd9bf25c1.jpg", "02_Shin_Kyung-sook-book2.jpg", "6");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("d43b34c4-a40d-4063-ad7b-e7b0a4dedaf9.jpeg", "/image/author/d43b34c4-a40d-4063-ad7b-e7b0a4dedaf9.jpeg", "02_Shin_Kyung-sook-book3.jpeg", "7");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("7b050113-526e-413b-b4b2-604378e4590f.jpg", "/image/author/7b050113-526e-413b-b4b2-604378e4590f.jpg", "02_Shin_Kyung-sook-book4.jpg", "8");
-- author_book_img = 3
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("a3f2e11f-cc26-483a-a21f-3401556e980c.jpeg", "/image/author/a3f2e11f-cc26-483a-a21f-3401556e980c.jpeg", "03_Ekuni_Kaori-book1.jpeg", "9");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("025ecd08-dbac-4003-8c75-60dc5989e9d7.jpg", "/image/author/025ecd08-dbac-4003-8c75-60dc5989e9d7.jpg", "03_Ekuni_Kaori-book2.jpg", "10");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("0e9921f7-a38c-42ce-a361-40cbfffd467d.jpeg", "/image/author/0e9921f7-a38c-42ce-a361-40cbfffd467d.jpeg", "03_Ekuni_Kaori-book3.jpeg", "11");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("4d647a9a-0dcf-4892-b2a6-da1779a9e851.jpeg", "/image/author/4d647a9a-0dcf-4892-b2a6-da1779a9e851.jpeg", "03_Ekuni_Kaori-book4.jpeg", "12");
-- author_book_img = 4
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("441193d7-cfc8-4367-9648-d795a685280c.jpg", "/image/author/441193d7-cfc8-4367-9648-d795a685280c.jpg", "04_Agatha_Christie-book1.jpg", "13");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("fe984675-25f6-4041-8a69-d7a1e00ef635.jpeg", "/image/author/fe984675-25f6-4041-8a69-d7a1e00ef635.jpeg", "04_Agatha_Christie-book2.jpeg", "14");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("b86f4ab1-b3a8-4bcc-9439-02410f906496.jpg", "/image/author/b86f4ab1-b3a8-4bcc-9439-02410f906496.jpg", "04_Agatha_Christie-book3.jpg", "15");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("062abbf1-1895-4a6c-89a0-c2562c9b8f6d.jpeg", "/image/author/062abbf1-1895-4a6c-89a0-c2562c9b8f6d.jpeg", "04_Agatha_Christie-book4.jpeg", "16");
-- author_book_img = 5
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("0cd20a5d-dba2-45cc-a250-3d353282afa0.jpeg", "/image/author/0cd20a5d-dba2-45cc-a250-3d353282afa0.jpeg", "05_Guillaume_Musso-book1.jpeg", "17");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("795f448a-a157-41a0-bec5-e96112bdb9d7.jpg", "/image/author/795f448a-a157-41a0-bec5-e96112bdb9d7.jpg", "05_Guillaume_Musso-book2.jpg", "18");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("eb18a9e2-3246-4f99-80c0-3e7ea9d79666.jpg", "/image/author/eb18a9e2-3246-4f99-80c0-3e7ea9d79666.jpg", "05_Guillaume_Musso-book3.jpg", "19");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("82c1e1fb-0a30-4a83-93db-ca8101330ade.jpg", "/image/author/82c1e1fb-0a30-4a83-93db-ca8101330ade.jpg", "05_Guillaume_Musso-book4.jpg", "20");
-- author_book_img = 6
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("e0ca1988-cc46-4fd5-978a-5224b78abfb4.jpeg", "/image/author/e0ca1988-cc46-4fd5-978a-5224b78abfb4.jpeg", "06_Hermann_Hesse-book1.jpeg", "21");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("9a4de354-53a2-426c-925d-e74fc7c7d74e.jpeg", "/image/author/9a4de354-53a2-426c-925d-e74fc7c7d74e.jpeg", "06_Hermann_Hesse-book2.jpeg", "22");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("5a398faf-0b4b-4447-ab25-298d00d99247.jpg", "/image/author/5a398faf-0b4b-4447-ab25-298d00d99247.jpg", "06_Hermann_Hesse-book3.jpg", "23");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("6f182dc8-0435-4c17-8356-56b45c746982.jpg", "/image/author/6f182dc8-0435-4c17-8356-56b45c746982.jpg", "06_Hermann_Hesse-book4.jpg", "24");
-- author_book_img = 7
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("5c2da657-1674-4bd2-8ec1-2aabd7b0c19c.jpg", "/image/author/5c2da657-1674-4bd2-8ec1-2aabd7b0c19c.jpg", "07_Higashino-keigo-book1.jpg", "25");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("930e06e8-79bd-4973-8a38-5d68a17612cf.jpeg", "/image/author/930e06e8-79bd-4973-8a38-5d68a17612cf.jpeg", "07_Higashino-keigo-book2.jpeg", "26");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("499d4f53-b929-4607-8f30-92556539bb8e.jpg", "/image/author/499d4f53-b929-4607-8f30-92556539bb8e.jpg", "07_Higashino-keigo-book3.jpg", "27");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("d4ffb8b5-6546-451d-ae18-45540d88e1fb.jpeg", "/image/author/d4ffb8b5-6546-451d-ae18-45540d88e1fb.jpeg", "07_Higashino-keigo-book4.jpeg", "28");
-- author_book_img = 8
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("03fea807-1a2b-4906-9dac-14d2b2993b2f.jpeg", "/image/author/03fea807-1a2b-4906-9dac-14d2b2993b2f.jpeg", "08_Bernard_Werber-book1.jpeg", "29");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("47e984f8-2063-452d-bd3b-42365813a54c.jpg", "/image/author/47e984f8-2063-452d-bd3b-42365813a54c.jpg", "08_Bernard_Werber-book2.jpg", "30");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("fcae7b80-32a7-4733-a6e2-13279f87725a.jpeg", "/image/author/fcae7b80-32a7-4733-a6e2-13279f87725a.jpeg", "08_Bernard_Werber-book3.jpeg", "31");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("da1e3064-4230-4918-abe6-202ee9a2240c.jpeg", "/image/author/da1e3064-4230-4918-abe6-202ee9a2240c.jpeg", "08_Bernard_Werber-book4.jpeg", "32");
-- author_book_img = 9
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("787f025a-0030-4c2a-9ce4-171ae3397f36.jpg", "/image/author/787f025a-0030-4c2a-9ce4-171ae3397f36.jpg", "09_Ryu_shi-va-book1.jpg", "33");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("96392728-97a8-40b8-91ba-5760c4b7b46f.jpeg", "/image/author/96392728-97a8-40b8-91ba-5760c4b7b46f.jpeg", "09_Ryu_shi-va-book2.jpeg", "34");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("d3183ae9-aca1-47d7-92f2-4813b44a26ec.jpg", "/image/author/d3183ae9-aca1-47d7-92f2-4813b44a26ec.jpg", "09_Ryu_shi-va-book3.jpg", "35");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("bcb741ee-64d5-4704-ac11-0153c0e00ea4.jpeg", "/image/author/bcb741ee-64d5-4704-ac11-0153c0e00ea4.jpeg", "09_Ryu_shi-va-book4.jpeg", "36");
-- author_book_img = 10
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("9e283c81-c792-4fca-afb5-06be37761bdc.jpeg", "/image/author/9e283c81-c792-4fca-afb5-06be37761bdc.jpeg", "10_Na_Tae-ju-book1.jpeg", "37");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("635c37cf-b9c5-49f1-9041-5147a0da09e9.jpeg", "/image/author/635c37cf-b9c5-49f1-9041-5147a0da09e9.jpeg", "10_Na_Tae-ju-book2.jpeg", "38");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("8565965a-ea86-4ed0-b577-465e167013c4.jpeg", "/image/author/8565965a-ea86-4ed0-b577-465e167013c4.jpeg", "10_Na_Tae-ju-book3.jpeg", "39");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("932fff62-8be5-42a1-9683-8656c9160469.jpeg", "/image/author/932fff62-8be5-42a1-9683-8656c9160469.jpeg", "10_Na_Tae-ju-book4.jpeg", "40");
-- author_book_img = 11
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("03bc92e2-3b66-4daa-840d-dd9f6ec1efc8.jpg", "/image/author/03bc92e2-3b66-4daa-840d-dd9f6ec1efc8.jpg", "11_Park_Wan-suh-book1.jpg", "41");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("36256ffc-ba84-4e44-8592-d1bffebadf1d.jpeg", "/image/author/36256ffc-ba84-4e44-8592-d1bffebadf1d.jpeg", "11_Park_Wan-suh-book2.jpeg", "42");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("4b1a43ab-588a-42e2-92df-2ac851af0b9c.jpg", "/image/author/4b1a43ab-588a-42e2-92df-2ac851af0b9c.jpg", "11_Park_Wan-suh-book3.jpg", "43");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("d168920e-9d87-4278-bfa1-c8efed9116c7.jpg", "/image/author/d168920e-9d87-4278-bfa1-c8efed9116c7.jpg", "11_Park_Wan-suh-book4.jpg", "44");
-- author_book_img = 12
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("6a985977-2b77-4029-a1f5-889e2ffaa001.jpg", "/image/author/6a985977-2b77-4029-a1f5-889e2ffaa001.jpg", "12_Park_Si-baek-book1.jpg", "45");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id)
values("fa6bf63f-3e6c-4ee8-9120-f221b55d5834.jpg", "/image/author/fa6bf63f-3e6c-4ee8-9120-f221b55d5834.jpg", "12_Park_Si-baek-book2.jpg", "46");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("7aeb7b57-dace-4362-9900-dc6d23c36910.jpg", "/image/author/7aeb7b57-dace-4362-9900-dc6d23c36910.jpg", "12_Park_Si-baek-book3.jpg", "47");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id)
values("90e2e356-f9dc-45c8-acc6-b16a67f03336.jpeg", "/image/author/90e2e356-f9dc-45c8-acc6-b16a67f03336.jpeg", "12_Park_Si-baek-book4.jpeg", "48");
-- author_book_img = 13
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("3e987e84-9195-456d-974e-473901804b46.jpeg", "/image/author/3e987e84-9195-456d-974e-473901804b46.jpeg", "13_Joeng_Myung-seop-book1.jpeg", "49");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("9c1fb035-63c8-474f-9567-8c2cebb74ca3.jpg", "/image/author/9c1fb035-63c8-474f-9567-8c2cebb74ca3.jpg", "13_Joeng_Myung-seop-book2.jpg", "50");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("9d2eef30-b0fe-47ae-8472-4eb383d8ff8b.jpg", "/image/author/9d2eef30-b0fe-47ae-8472-4eb383d8ff8b.jpg", "13_Joeng_Myung-seop-book3.jpg", "51");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("dfe85b7e-333f-4c3e-82ec-3fd91ba4764c.jpeg", "/image/author/dfe85b7e-333f-4c3e-82ec-3fd91ba4764c.jpeg", "13_Joeng_Myung-seop-book4.jpeg", "52");
-- author_book_img = 14
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("ed20a7f4-6201-44c2-9ebf-97c4a9265f03.jpg", "/image/author/ed20a7f4-6201-44c2-9ebf-97c4a9265f03.jpg", "14_Timothy_Ferris-book1.jpg", "53");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("bd3288ee-7c45-480f-b3c1-06eb9db64abf.jpeg", "/image/author/bd3288ee-7c45-480f-b3c1-06eb9db64abf.jpeg", "14_Timothy_Ferris-book2.jpeg", "54");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("f243db16-fb7c-424a-92e1-125194ab7a55.jpeg", "/image/author/f243db16-fb7c-424a-92e1-125194ab7a55.jpeg", "14_Timothy_Ferris-book3.jpeg", "55");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("d2840d3d-de5a-450b-97d6-4019663b2fe8.jpeg", "/image/author/d2840d3d-de5a-450b-97d6-4019663b2fe8.jpeg", "14_Timothy_Ferris-book4.jpeg", "56");
-- author_book_img = 15
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("7bc74c7c-4761-488a-85f0-655fe8a2ec23.jpeg", "/image/author/7bc74c7c-4761-488a-85f0-655fe8a2ec23.jpeg", "15_Kim_Young-ha-book1.jpeg", "57");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("efbe7721-fb4e-4f9f-ab95-7c9cb1e759ac.jpeg", "/image/author/efbe7721-fb4e-4f9f-ab95-7c9cb1e759ac.jpeg", "15_Kim_Young-ha-book2.jpeg", "58");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("e0f8def5-920b-4d5e-b9aa-b236a44d351a.jpeg", "/image/author/e0f8def5-920b-4d5e-b9aa-b236a44d351a.jpeg", "15_Kim_Young-ha-book3.jpeg", "59");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("81847571-aefe-4434-aabf-8d7699042173.jpeg", "/image/author/81847571-aefe-4434-aabf-8d7699042173.jpeg", "15_Kim_Young-ha-book4.jpeg", "60");
-- author_book_img = 16
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("57297522-a093-46cb-ab2a-f4cdb5580d0c.jpeg", "/image/author/57297522-a093-46cb-ab2a-f4cdb5580d0c.jpeg", "16_Kim_Mi-kyung-book1.jpeg", "61");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("f78f0868-d1c4-4b4e-ac21-f0f5a378a603.jpeg", "/image/author/f78f0868-d1c4-4b4e-ac21-f0f5a378a603.jpeg", "16_Kim_Mi-kyung-book2.jpeg", "62");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("c2ddcf60-9203-45cb-bdec-9b2ee9ea2758.jpg", "/image/author/c2ddcf60-9203-45cb-bdec-9b2ee9ea2758.jpg", "16_Kim_Mi-kyung-book3.jpg", "63");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("bf4cd0e6-5b12-470b-bccf-e4e129860af5.jpg", "/image/author/bf4cd0e6-5b12-470b-bccf-e4e129860af5.jpg", "16_Kim_Mi-kyung-book4.jpg", "64");
-- author_book_img = 17
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("e82f84dd-cbfa-48e6-abcd-0ddf6f1a8a81.jpg", "/image/author/e82f84dd-cbfa-48e6-abcd-0ddf6f1a8a81.jpg", "17_Lee_Ji-sung-book1.jpg", "65");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("d3556e74-c98f-4732-ab29-92be5eca9b08.jpeg", "/image/author/d3556e74-c98f-4732-ab29-92be5eca9b08.jpeg", "17_Lee_Ji-sung-book2.jpeg", "66");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("459ebe31-b909-4e47-ad27-cd3221d99474.jpg", "/image/author/459ebe31-b909-4e47-ad27-cd3221d99474.jpg", "17_Lee_Ji-sung-book3.jpg", "67");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("c3ef123e-881c-422b-b2f8-cfd8f96eff14.jpeg", "/image/author/c3ef123e-881c-422b-b2f8-cfd8f96eff14.jpeg", "17_Lee_Ji-sung-book4.jpeg", "68");
-- author_book_img = 18
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("aef6f176-cb03-4df2-8c3b-f82cc33e5308.jpeg", "/image/author/aef6f176-cb03-4df2-8c3b-f82cc33e5308.jpeg", "18_Jeong_Jae-seung-book1.jpeg", "69");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("423614f3-55d2-4859-af0d-b5f61b5d6200.jpg", "/image/author/423614f3-55d2-4859-af0d-b5f61b5d6200.jpg", "18_Jeong_Jae-seung-book2.jpg", "70");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("6a643858-37f0-4c03-ae5a-f6ca955a7673.jpg", "/image/author/6a643858-37f0-4c03-ae5a-f6ca955a7673.jpg", "18_Jeong_Jae-seung-book3.jpg", "71");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("9d8ee7b4-74d3-4a56-b808-d3246c5743a8.jpg", "/image/author/9d8ee7b4-74d3-4a56-b808-d3246c5743a8.jpg", "18_Jeong_Jae-seung-book4.jpg", "72");
-- author_book_img = 19
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("b01c55ee-6e39-4523-a921-877a4f86a448.jpeg", "/image/author/b01c55ee-6e39-4523-a921-877a4f86a448.jpeg", "19_Choe_Jae-cheon-book1.jpeg", "73");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("7820aa29-e0d0-4b3c-b0da-babc8bfdeaa0.jpeg", "/image/author/7820aa29-e0d0-4b3c-b0da-babc8bfdeaa0.jpeg", "19_Choe_Jae-cheon-book2.jpeg", "74");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("e1837514-f103-4053-95ee-96b47a59f41a.jpg", "/image/author/e1837514-f103-4053-95ee-96b47a59f41a.jpg", "19_Choe_Jae-cheon-book3.jpg", "75");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("b44cd201-9795-47bd-9a3b-53337528f778.jpg", "/image/author/b44cd201-9795-47bd-9a3b-53337528f778.jpg", "19_Choe_Jae-cheon-book4.jpg", "76");
-- author_book_img = 20
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("f4526df6-9edf-4397-ad4e-44602938628f.jpeg", "/image/author/f4526df6-9edf-4397-ad4e-44602938628f.jpeg", "20_Choi_Eun-yeong-book1.jpeg", "77");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id)
values("c56fa5eb-d7ee-46be-b5e6-08cf9a4b6ae3.jpg", "/image/author/c56fa5eb-d7ee-46be-b5e6-08cf9a4b6ae3.jpg", "20_Choi_Eun-yeong-book2.jpg", "78");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id) 
values("94953d30-7bce-480d-94c9-25c7b553cb67.jpeg", "/image/author/94953d30-7bce-480d-94c9-25c7b553cb67.jpeg", "20_Choi_Eun-yeong-book3.jpeg", "79");
insert into author_book_img(img_name, img_url, ori_img_name, author_book_id)
values("f8542611-08ce-4546-9e23-7b5b8d29c28e.jpeg", "/image/author/f8542611-08ce-4546-9e23-7b5b8d29c28e.jpeg", "20_Choi_Eun-yeong-book4.jpeg", "80");

-- 작가 관련 임시데이터(테스트용)  끝


-- 메인페이지 북티빙top10 관련 임시데이터(테스트용)

-- book 데이터 삽입
insert into book(book_id, reg_time, update_time, author, book_introduction, book_name, category, contents, isbn, page, publication_date, publisher, author_info, item_id)
values(11, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "김금희", "'너무 한낮의 연애'로 2016년 제7회 젊은작가상 대상을 수상하며 한국문학 장을 뜨겁게 달구고 있는 소설가 김금희의 두번째 소설집. 첫 소설집 <센티멘털도 하루 이틀>로 제33회 신동엽문학상을 수상하며 작가로서의 가능성을 보여준 김금희는, 이제 명실상부 '지금 가장 주목받는 젊은 작가'가 되었다. 이번에 선보이는 소설집에는 2014년부터 2015년까지 발표된 9편의 작품이 수록된바, 이 점에서 문학에 대한 작가의 열정과 소설쓰기의 왕성함에 더불어, 한국문단이 김금희에게 걸고 있는 기대감도 한껏 느낄 수 있다. <너무 한낮의 연애>는 그 기대를 향한, 김금희의 수줍지만 당당한 응답이다. 문학평론가 정홍수는 '너무 한낮의 연애'에 대한 젊은작가상 심사평에서, 당시 이슈가 되었던 '중력파'의 검출 이야기로 서두를 시작한다. 그를 놀라게 한 것은 그 중력파가 십삼억 광년 전에 생성되어 지금의 우리 눈에 띄었다는 사실이라고. 나아가 정홍수는 '우리 나날의 일상 역시 관계의 충돌이나 비껴감(그리고 기타 등등) 속에서 미세하게 시공간을 진동하고 왜곡하는 모종의 파波를 생성하리라는 것은 충분히 짐작 가능한 일'이라고 말한다. 그리고 그 파장의 '미세한 누적이 임계치를 넘길 때 우리의 몸을 기울이고, 삶의 좌표를 슬그머니 옮겨놓는다'고. 십육 년 전 종로의 맥도날드에서 '양희'와 마주앉아 있었던 '필용'의 추억이 의식 밑에 잠겨 있다가, 무언가를 계기로 도달되어 그를 눈물 흘리게 했던 것처럼 말이다.",
"너무 한낮의 연애", "국내도서 > 소설/시/희곡 > 한국소설 > 2000년대 이후 한국소설", "너무 한낮의 연애 _007<br>조중균의 세계 _043<br>세실리아 _073<br>반월 _103<br>고기 _129<br>개를 기다리는 일 _153<br>우리가 어느 별에서 _179<br>보통의 시절 _205<br>고양이는 어떻게 단련되는가 _231<br><br>해설 | 강지희(문학평론가)<br>잔존의 파토스 _261<br><br>작가의 말 _285",
"9788954640756", 288, "2016-05-31", "문학동네", "2009년 한국일보 신춘문예를 통해 작품활동을 시작했다. 소설집 『센티멘털도 하루 이틀』 『너무 한낮의 연애』 『오직 한 사람의 차지』 『우리는 페퍼로니에서 왔어』, 장편소설 『경애의 마음』 『복자에게』, 중편소설 『나의 사랑, 매기』, 연작소설 『크리스마스 타일』, 짧은 소설 『나는 그것에 대해 아주 오랫동안 생각해』, 산문집 『사랑 밖의 모든 말들』 등이 있다. 신동엽문학상, 젊은작가상 대상, 현대문학상, 우현예술상, 김승옥문학상 대상, 오늘의 젊은 예술가상 등을 수상했다.", "74920933");
insert into book(book_id, reg_time, update_time, author, book_introduction, book_name, category, contents, isbn, page, publication_date, publisher, author_info, item_id)
values(12, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "기욤 뮈소", "한국에서 15번째로 출간하는 기욤 뮈소의 장편소설이다. 2018년 작 <아가씨와 밤>은 프랑스에서 초판 55만 부가 판매되었고, 전 세계 30여 개국에 판권이 팔렸고, FR2 방송에서는 전격적으로 드라마 제작을 결정했다. 소설의 주요 배경은 기욤 뮈소가 나고 자란 프랑스 남부 코트다쥐르의 앙티브이다. 소설은 크게 두 갈래로 나누어진다. '코트다쥐르, 1992년 겨울'과 '코트다쥐르, 2017년 봄'이다. 무려 25년의 시차를 두고 이야기가 전개되지만 등장인물은 바뀌지 않고 그대로이다. 1992년 코트다쥐르의 생텍쥐페리고교 졸업생들인 토마, 막심, 파니, 스테판과 그해 겨울 실종된 그들의 동급생 빙카의 이야기가 25년이라는 시간의 장벽을 허물고 되살아난다. 과거가 더 이상 희미한 그림자로 남아 있기를 거부할 경우 기억의 저편으로 밀쳐둘 수는 없다. 소설은 1992년 겨울과 2017년 봄을 교차하며 전개된다. 1992년에 생텍쥐페리고교에 다닌 남학생이라면 누구나 빙카 로크웰을 좋아했다. 빨강머리, 반짝이는 눈, 흘러내린 머리카락을 귀 뒤로 쓸어 넘기는 우아한 제스처, 특유의 신비한 미소와 시크한 표정은 어느 누구도 흉내 낼 수 없는 빙카만의 매력이었다. 1992년, 대다수 학생들이 고향으로 떠난 크리스마스 휴가 기간에 생텍쥐페리고교에서 살인을 저지르고, 체육관 신설공사 현장에 사체를 유기하고, 치밀한 은폐를 시도해 완전범죄를 획책한 사람들이 바로 이 소설의 주요 등장인물들인 토마, 파니, 막심, 막심의 부친 프란시스, 토마의 모친 안나벨이다. 매우 단순한 사건인 듯 보이지만 비밀을 파헤쳐갈수록 놀라운 사실들이 새록새록 드러난다.",
"아가씨와 밤", "국내도서 > 소설/시/희곡 > 프랑스소설", "밀수업자들의 오솔길<br>어제와 오늘<br>언제나 청춘<br>1. 체리코크<br>2. 다시 만난 친구들<br>3. 우리가 저지른 일<br>4. 불행의 문<br>5. 빙카 로크웰의 마지막 며칠<br>6. 눈으로 덮인 학교<br>다른 아이들과 다른 아이<br>7. 앙티브의 거리에서<br>8. 그랑 블루의 여름<br>9. 장미의 삶<br>10. 사랑의 빛<br>다른 아이들과 다른 아이<br>11. 그녀의 미소 뒤에서<br>12. 빨간머리 소녀<br>소녀와 죽음<br>13. 카타스트로프 광장<br>파니<br>14. 라붐<br>15. 학교에서 가장 예쁜 아이<br>안나벨<br>16. 밤은 항상 너를 기다린다<br>17. 천사의 정원<br>리샤르<br>18. 아가씨와 밤<br>뒷이야기 - 밤이 지나간 후<br>선한 사람들을 겨냥하는 저주<br>장크리스토프<br>산부인과<br>위험으로부터 한 발짝 앞서가기<br>소설가의 특권<br>작가의 말 - 실재하는 것과 지어낸 것<br>옮긴이의 말",
"9788984373617", 403, "2018-11-26", "밝은세상", "1974년 프랑스 앙티브에서 태어나 니스대학에서 경제학을 공부했고, 몽펠리에대학원 경제학과에서 석사 과정을 이수한 후 국제고등학교 교사로 재직하며 집필 활동을 시작했다. 현실에서는 도저히 있을 법하지 않은 이야기에 꿈과 리듬을 불어넣는 작가로 유명하다. 첫 소설 《스키다마링크》에 이어 2004년 두 번째 소설 《그 후에》를 출간하며 프랑스 문단에 일대 센세이션을 불러일으켰고, 《그 후에》부터 《안젤리크》까지 19권의 소설 모두가 프랑스 베스트셀러 1위를 기록했다. 매년 《르 피가로》지와 <프랑스서점연합회>에서 조사하는 베스트셀러 작가 순위에서도 8년 연속 1위에 올랐다. 세 번째 소설 《구해줘》는 아마존 프랑스 85주 연속 베스트셀러 1위를 기록했고, 국내에서도 무려 200주 이상 베스트셀러에 등재되었다. 현재 전 세계 45개국 독자들이 그의 소설에 공감과 지지를 보내고 있다. 《종이 여자》는 한 편의 매직 쇼 혹은 한 편의 미스터리 판타지 영화를 보듯 예측불허의 긴장 속으로 독자들을 끌어들인다. 한시도 눈 돌릴 틈을 주지 않는 흥미진진한 전개, 독자들의 의표를 찌르는 결말이 돋보이는 소설이다. 그의 소설 《안젤리크》, 《센 강의 이름 모를 여인》, 《인생은 소설이다》, 《작가들의 비밀스러운 삶》, 《아가씨와 밤》, 《파리의 아파트》, 《브루클린의 소녀》, 《지금 이 순간》, 《센트럴파크》, 《내일》, 《7년 후》, 《천사의 부름》, 《종이 여자》, 《그 후에》, 《당신 없는 나는?》, 《사랑을 찾아 돌아오다》, 《사랑하기 때문에》, 《당신 거기 있어줄래요?》, 《구해줘》. ", "173993981");
insert into book(book_id, reg_time, update_time, author, book_introduction, book_name, category, contents, isbn, page, publication_date, publisher, author_info, item_id)
values(13, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "에쿠니 가오리", "에쿠니 가오리의 <낙하하는 저녁>이 14년 만에 개정되어 재출간됐다. 일본에서는 1996년에 출간됐으니 만 21년, 딱 성년이 된 소설이다. 이 오래도록 사랑받은 소설을 새롭게 선보이기 위해 소담출판사와 번역가 김난주가 책 전체를 공들여 손봤다. 번역가 김난주는 개정판 작업을 위해 원문 전체를 다시 살피고 번역 문장을 시대 흐름에 맞게 다듬었다. 그는 '이 책의 초판을 번역할 당시보다 나이가 좀 더 든 지금, 리카와 다케오와 하나코 이야기가 참 다르게 와닿았다'면서 '다시 읽으니 새삼 정말 좋은 작품'이라고 거듭 말했다. 소담출판사 편집부 또한 '독자들에게 꼭 다시 읽기를 추천하고 싶다'면서 '리카에게도, 다케오에게도, 하나코에게도 시간의 흔적이 묻어나 마치 다른 소설을 읽는 듯 놀랍도록 새로운 인상이다'라고 소개했다. 초판 표지는 온기가 느껴지는 노을빛이었던 데 반해, 이번 개정판 표지는 보다 더 차분하고 냉철한 듯한 새벽빛이다. 초판 '작가의 말'에서 에쿠니 가오리가 '냉철하고 명석하고 차분하고 밝고, 그러면서도 절망하고 있는…… <낙하하는 저녁>은 그런 작품일 수 있으면 좋겠다는 생각으로 썼다'고 말한 바를 이미지화한 표지이다. 사랑을 온전히 떠나보내는 데 15개월이나 걸린 한 여자의 아주 느린 실연 이야기는 '그대들 일은 그대들이 알아서 할 일'이라는 소설 속 대사처럼, 읽는 독자마다 저마다의 그릇에 다르게 담긴다.",
"낙하하는 저녁", "국내도서 > 소설/시/희곡 > 일본소설 > 1950년대 이후 일본소설", "낙하하는 저녁<br>작가 후기<br>작품 해설<br>옮긴이의 말<br>개정판 옮긴이의 말",
"9791160270259", 248, "2017-10-30", "태일소담출판사", "1964년 도쿄에서 태어난 에쿠니 가오리는 청아한 문체와 세련된 감성 화법으로 사랑받는 작가이다. 1989년 『409 래드클리프』로 페미나상을 수상했고, 동화부터 소설, 에세이까지 폭넓은 집필 활동을 해 나가면서 참신한 감각과 세련미를 겸비한 독자적인 작품 세계를 구축하고 있다. 『반짝반짝 빛나는』으로 무라사키시키부 문학상(1992), 『나의 작은 새』로 로보노이시 문학상(1999), 『울 준비는 되어 있다』로 나오키상(2003), 『잡동사니』로 시마세 연애문학상(2007), 『한낮인데 어두운 방』으로 중앙공론문예상(2010)을 받았다. 일본 문학 최고의 감성 작가로 불리는 그녀는 『냉정과 열정 사이 Rosso』, 『도쿄 타워』, 『언젠가 기억에서 사라진다 해도』, 『좌안 1·2』, 『달콤한 작은 거짓말』, 『소란한 보통날』, 『부드러운 양상추』, 『수박 향기』, 『하느님의 보트』, 『우는 어른』, 『울지 않는 아이』, 『등 뒤의 기억』, 『포옹 혹은 라이스에는 소금을』, 『즐겁게 살자, 고민하지 말고』, 『벌거숭이들』, 『저물 듯 저물지 않는』, 『개와 하모니카』, 『별사탕 내리는 밤』 등으로 한국의 많은 독자들을 사로잡고 있다.", "120326689");
insert into book(book_id, reg_time, update_time, author, book_introduction, book_name, category, contents, isbn, page, publication_date, publisher, author_info, item_id)
values(14, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "최은영", "‘함께 성장해나가는 우리 세대의 소설가’를 갖는 드문 경험을 선사하며 동료 작가와 평론가, 독자 모두에게 특별한 이름으로 자리매김한 최은영의 세번째 소설집 『아주 희미한 빛으로도』가 출간되었다. 2023년 데뷔 10년을 맞이하는 최은영은 그간 만남과 헤어짐을 거듭하는 인물의 내밀하고 미세한 감정을 투명하게 비추며 우리의 사적인 관계 맺기가 어떻게 사회적인 맥락을 얻는지를 고찰하고(『쇼코의 미소』, 2016), 지난 시절을 끈질기게 떠올리는 인물을 통해 기억을 마주하는 일이 어떻게 재생과 회복의 과정이 될 수 있는지를 살피며(『내게 무해한 사람』, 2018), 4대에 걸친 인물들의 삶의 궤적을 따라감으로써 과거에서 현재를 향해 쓰이는 종적인 연대기(年代記)가 어떻게 인물들을 수평적 관계에 위치시키며 횡적인 연대기(連帶記)로 나아가는지를 그려왔다(『밝은 밤』, 2021). 이전 작품들에 담긴 문제의식을 한층 더 깊고 날카로운 시선으로 이어나가는 이번 소설집은 작가가 처음 작품활동을 시작했을 때 품은 마음이 지금의 관점에서 어떻게 이어지는지 보여줌으로써 “깊어지는 것과 넓어지는 것이 문학에서는 서로 다른 말이 아니라는 것”(한국일보문학상 심사평)을 감동적으로 증명해낸다.",
"아주 희미한 빛으로도", "국내도서 > 소설/시/희곡 > 한국소설 > 2000년대 이후 한국소설", "아주 희미한 빛으로도 / 007<br>몫 / 047<br>일 년 / 085<br>답신 / 125<br>파종 / 181<br>이모에게 / 213<br>사라지는, 사라지지 않는 / 267<br><br>해설│양경언(문학평론가)<br>더 가보고 싶어 / 321<br><br>작가의 말 / 347",
"9788954695053", 352, "2023-08-07", "문학동네", "2013년 『작가세계』 신인상을 수상하며 작품활동을 시작했다. 소설집 『쇼코의 미소』 『내게 무해한 사람』, 장편소설 『밝은 밤』, 짧은 소설 『애쓰지 않아도』가 있다. 허균문학작가상, 김준성문학상, 구상문학상 젊은작가상, 이해조소설문학상, 한국일보문학상, 대산문학상, 제5회, 제8회, 제11회 젊은작가상을 수상했다.", "321294005");
insert into book(book_id, reg_time, update_time, author, book_introduction, book_name, category, contents, isbn, page, publication_date, publisher, author_info, item_id)
values(15, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "최은영", "공감을 불러일으키는 이야기와 서정적이며 사려 깊은 문장, 그리고 그 안에 자리한 뜨거운 문제의식으로 등단 이후 줄곧 폭넓은 독자의 지지와 문학적 조명을 두루 받고 있는 작가 최은영의 첫 장편소설. 작가가 2020년 봄부터 2020년 겨울까지 꼬박 일 년 동안 계간 『문학동네』에 연재한 작품을 공들여 다듬은 끝에 선보이는 첫 장편소설로, 「쇼코의 미소」 「한지와 영주」 「모래로 지은 집」 등 긴 호흡으로 이야기를 이끌어가는 중편소설에서 특히 강점을 보여온 작가의 특장이 한껏 발휘된 작품이다. 『밝은 밤』은 작가가 오랫동안 마음속에 품어왔던 ‘증조모-할머니-엄마-나’로 이어지는 4대의 삶을 비추며 자연스럽게 백 년의 시간을 관통한다. 증조모에게서 시작되어 ‘나’에게로 이어지는 이야기와 ‘나’에게서 출발해 증조모로 향하며 쓰이는 이야기가 서로를 넘나들며 서서히 그 간격을 메워갈 때, 우리는 사람들의 입을 통해 이야기가 전해진다는 건 서로를 살리고 살아내는 숨이 연쇄되는 과정이기도 하다는 것을, 그리고 그것이 이야기 자체가 가진 본연의 힘이기도 하다는 것을 느끼게 될 것이다.",
"밝은 밤", "국내도서 > 소설/시/희곡 > 한국소설 > 2000년대 이후 한국소설", "1부 _007<br>2부 _083<br>3부 _153<br>4부 _237<br>5부 _295<br><br>작가의 말 _339",
"9788954681179", 344, "2021-07-27", "문학동네", "2013년 『작가세계』 신인상을 수상하며 작품활동을 시작했다. 소설집 『쇼코의 미소』 『내게 무해한 사람』, 장편소설 『밝은 밤』, 짧은 소설 『애쓰지 않아도』가 있다. 허균문학작가상, 김준성문학상, 구상문학상 젊은작가상, 이해조소설문학상, 한국일보문학상, 대산문학상, 제5회, 제8회, 제11회 젊은작가상을 수상했다.", "275419192");
insert into book(book_id, reg_time, update_time, author, book_introduction, book_name, category, contents, isbn, page, publication_date, publisher, author_info, item_id)
values(16, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "김금희", "젊은작가상, 신동엽문학상, 현대문학상 수상작가 김금희의 세번째 소설집. 전작 <너무 한낮의 연애>에서 일순 생활을 장악해버린 불가해한 감정을 섬세하게 묘사하며 그 감정의 기원을 탐사했던 김금희의 단편은 이제 평온했던 내면을 거세게 뒤흔들곤 하는 과거의 순간들을 세밀하게 그려낸다. 작가는 우리가 삶을 살아내기 위해 묻어두어야만 했던 지난 시절의 상처를 그 어느 때보다 골똘하게 바라본다. 그렇게 때때로 모질고 비겁해야 했던 우리의 흉한 일면, 삶의 부산물처럼 딸려오는 모욕감과 죄책감이 시간의 더께 밑에서 하나둘 발굴된다. 그러나 이러한 사랑스럽지 않은 모습들마저도 인간을 향한 김금희의 애정 어린 문장을 통과하면 좋거나 나쁘다고 평가될 수 없는, 살아가려는 의지의 표현이 된다. 김금희는 과거의 상처를 미화하는 대신 그 벌어진 틈새를 똑바로 들여다보며, 특유의 다정한 시선으로 우리가 살아온 모든 시간에 담긴 의미를 찾아낸다. 잊고 싶었던 과거와 마주하는 것을 두려워하지 말라고, 우리가 그려온 궤적에는 그렇게 그려져야 할 이유가 있었다고, 그래야 살아낼 수 있었다고 작가는 말한다. 비록 잃는 것에 점점 익숙해져가는 삶을 살고 있지만, 매 순간 느껴지는 이 충만한 감정만큼은 오롯이 우리의 차지가 아니겠냐고.", 
"오직 한 사람의 차지", "국내도서 > 소설/시/희곡 > 한국소설 > 2000년대 이후 한국소설", "체스의 모든 것 _007<br>사장은 모자를 쓰고 온다 _039<br>오직 한 사람의 차지 _061<br>레이디 _095<br>문상 _131<br>새 보러 간다 _161<br>모리와 무라 _193<br>누구 친구의 류 _223<br>쇼퍼, 미스터리, 픽션 _251<br><br>해설｜백지연(문학평론가)<br>생의 아이러니를 응시하는 심퍼사이저 _275<br><br>작가의 말 _292",
"9788954657273", 296, "2019-08-30", "문학동네", "2009년 한국일보 신춘문예를 통해 작품활동을 시작했다. 소설집 『센티멘털도 하루 이틀』 『너무 한낮의 연애』 『오직 한 사람의 차지』 『우리는 페퍼로니에서 왔어』, 장편소설 『경애의 마음』 『복자에게』, 중편소설 『나의 사랑, 매기』, 연작소설 『크리스마스 타일』, 짧은 소설 『나는 그것에 대해 아주 오랫동안 생각해』, 산문집 『사랑 밖의 모든 말들』 등이 있다. 신동엽문학상, 젊은작가상 대상, 현대문학상, 우현예술상, 김승옥문학상 대상, 오늘의 젊은 예술가상 등을 수상했다.", "204000338");
insert into book(book_id, reg_time, update_time, author, book_introduction, book_name, category, contents, isbn, page, publication_date, publisher, author_info, item_id)
values(17, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "김영하", "<나는 나를 파괴할 권리가 있다> 제1회 문학동네 신인작가상 수상작. 삶과 화해하지 못하는 인물들의 자살을 도와주는 자살안내인이 화자로 등장한다. 화자의 고객으로 '유디트'를 닮은 세연은 형제인 C·K와 기묘한 삼각관계를 이룬다. 정주하지 못하고 부박하는 삶을 사는 세 주인공을 중심으로 황폐한 삶의 단면을 보여준다. 2003년 정보석, 추상미 주연의 영화로도 제작되었다. <살인자의 기억법> 수식어가 필요 없는 작가, 다른 누구도 아닌 바로 그 김영하다. 2013년 올해로 데뷔한 지 19년. 하지만 그는 독보적인 스타일로 여전히 가장 젊은 작가다. 그의 소설은 잔잔한 일상에 '파격'과 '도발'을 불어넣어 우리를 흔들어 깨운다. 그가 일깨운 우리의 일상은, 매순간이 비극인 동시에 또한 희극이다. 슬픔과 고독, 아이러니와 패러독스의 인물들을 마주할 때마다 내 곁을 스쳐지나간 사람들의 얼굴이 하나하나 떠오른다. 김영하는 어느새 우리 삶에 깊숙이 침투해 있다. 데뷔작 <나는 나를 파괴할 권리가 있다>에서 김영하는 우리에게 자살안내인을 소개했다. 판타지이고 허구인 줄만 알았던 그의 역할이 오래지 않아 현실이 되는 기이한 현상을 목도한 우리는 이제 다시 그 강렬했던 경험을 만나게 된다. '고아 트릴로지'의 마지막 작품 <너의 목소리가 들려> 이후 일 년 반 만에 신작 장편소설 <살인자의 기억법>을 들고 김영하가 돌아왔다. <살인자의 기억법>에서는 알츠하이머에 걸린 은퇴한 연쇄살인범이 점점 사라져가는 기억과 사투를 벌이며 딸을 구하기 위한 마지막 살인을 계획한다. 아무렇지 않게 툭툭 던지는 잠언들, 돌발적인 유머와 위트, 마지막 결말의 반전까지, 정교하고 치밀하게 설계된 이번 소설에서 김영하는 삶과 죽음, 시간과 악에 대한 깊은 통찰을 풀어놓는다.",
"살인자의 기억법", "국내도서 > 소설/시/희곡 > 한국소설 > 2000년대 이후 한국소설", "살인자의 기억법<br>나는 나를 파괴할 권리가 있다",
"6000652181", 156, "2013-07-24", "문학동네", "소설가. 장편소설로 『작별인사』 『살인자의 기억법』 『검은 꽃』 『아랑은 왜』 『나는 나를 파괴할 권리가 있다』 『너의 목소리가 들려』 『퀴즈쇼』, 소설집으로 『오직 두 사람』 『무슨 일이 일어났는지는 아무도』 『오빠가 돌아왔다』 『엘리베이터에 낀 그 남자는 어떻게 되었나』 『호출』이 있다. 여행에 관한 산문 『여행의 이유』와 『오래 준비해온 대답』을 냈고 산문집으로 『보다』 『말하다』 『읽다』의 합본인 『다다다』 등이 있다. F. 스콧 피츠제럴드의 『위대한 개츠비』를 번역하기도 했다. 서울에서 아내와 함께 살며 여행, 요리, 그림 그리기와 정원 일을 좋아한다. 2018년 오영수문학상, 2015년 김유정문학상, 2012년 이상문학상, 2007년 만해문학상, 2004년 동인문학상, 2004년 이산문학상, 2004년 황순원문학상, 1999년 현대문학상, 1996년 문학동네 작가상을 수상했다.", "28596530");

-- book_img 데이터 삽입
insert into book_img(book_img_id, reg_time, update_time, img_name, img_url, ori_img_name, rep_yn, book_id)
values(11, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "30660154-0447-49a2-a4f8-c9918a5e3387.jpeg", "/image/author/30660154-0447-49a2-a4f8-c9918a5e3387.jpeg", "01_Kim_Keum-hee-book1.jpeg", "Y", 11);
insert into book_img(book_img_id, reg_time, update_time, img_name, img_url, ori_img_name, rep_yn, book_id)
values(12, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "0cd20a5d-dba2-45cc-a250-3d353282afa0.jpeg", "/image/author/0cd20a5d-dba2-45cc-a250-3d353282afa0.jpeg", "05_Guillaume_Musso-book1.jpeg", "Y", 12);
insert into book_img(book_img_id, reg_time, update_time, img_name, img_url, ori_img_name, rep_yn, book_id)
values(13, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "a3f2e11f-cc26-483a-a21f-3401556e980c.jpeg", "/image/author/a3f2e11f-cc26-483a-a21f-3401556e980c.jpeg", "03_Ekuni_Kaori-book1.jpeg", "Y", 13);
insert into book_img(book_img_id, reg_time, update_time, img_name, img_url, ori_img_name, rep_yn, book_id)
values(14, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "f4526df6-9edf-4397-ad4e-44602938628f.jpeg", "/image/author/f4526df6-9edf-4397-ad4e-44602938628f.jpeg", "20_Choi_Eun-yeong-book1.jpeg", "Y", 14);
insert into book_img(book_img_id, reg_time, update_time, img_name, img_url, ori_img_name, rep_yn, book_id)
values(15, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "c56fa5eb-d7ee-46be-b5e6-08cf9a4b6ae3.jpg", "/image/author/c56fa5eb-d7ee-46be-b5e6-08cf9a4b6ae3.jpg", "20_Choi_Eun-yeong-book2.jpg", "Y", 15);
insert into book_img(book_img_id, reg_time, update_time, img_name, img_url, ori_img_name, rep_yn, book_id)
values(16, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "e1b10ebc-790d-4882-91ee-6fe6af38eb40.jpeg", "/image/author/e1b10ebc-790d-4882-91ee-6fe6af38eb40.jpeg", "01_Kim_Keum-hee-book3.jpeg", "Y", 16);
insert into book_img(book_img_id, reg_time, update_time, img_name, img_url, ori_img_name, rep_yn, book_id)
values(17, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "e0f8def5-920b-4d5e-b9aa-b236a44d351a.jpeg", "/image/author/e0f8def5-920b-4d5e-b9aa-b236a44d351a.jpeg", "15_Kim_Young-ha-book3.jpeg", "Y", 17);

-- rent_book 데이터 삽입
-- book_id => 1 (3개)
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(1, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "N", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 11, 1 );

-- book_id => 2(1개)
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(2, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "N", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 12, 1 );

-- book_id => 3 (2개)
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(3, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "N", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 13, 1 );

-- book_id => 4(5개)
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(4, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "N", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 14, 1 );

-- book_id => 5(6개)
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(5, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "N", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 15, 1 );

-- book_id => 6(10개)
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(6, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "N", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 16, 1 );

-- book_id => 7(9개)
insert into rent_book(rent_book_id, reg_time, update_time, complete_yn, rent_date, review, sentence, book_id, member_id) 
values(7, "2023-08-15 06:31:03.354606", "2023-08-15 06:31:03.354606", "N", "2023-08-21 06:31:03.354606", 
"알라딘 신간 코너에서 마음에 끌려 구입했어요.", "안녕", 17, 1 );
-- 메인페이지 북티빙top10 관련 임시데이터(테스트용) 끝


-- 공지사항 정보 임시데이터(테스트용) 

-- 공지사항
insert into notice(notice_id, notice_group, title, content, created_by) 
values(1, "NOTICE", "베타 서비스 오픈 축하해 주세요.", "안녕하세요.<br>
'EZEN북티빙시대'입니다.<br><br>

'100만개의 책방, 1만개의 도서관'<br>
모두 함께 만드는 콘텐츠 플랫폼 '밀리의 서재'<br><br>

당신의 서재를 만들어 보세요.<br>
   - 책장을 만들고, 책에 대한 생﻿각을 만들어서 사람들과 공유하세요.<br><br>

당신의 서재를 구독 도서관으로 운영해 보세요.<br>
   - 함께 책을 읽고 생각을 공유하는 구독 도서관.<br>
   - 당신의 서재를 설정 전환만 하면 구독 도서관이 됩니다.<br>
   - 경제/경영 전문 도서관, 소설의 세계가 열리는 도서관, 노무현 대통령의 도서관, 회사에서 독서 경영을 하는 도서관 ...<br>
   - 다양한 구독 도서관들이 순차적으로 오픈됩니다.<br><br>

당신의 서재를 책방으로 운영해 보세요.<br>
   - 사람들이 당신의 서재에서 종이 책, 이북을 구매할 수 있어요.<br>
   - 책이 판매되면 소정의 수수료를 서재주인에게 드립니다. <br><br>

출판사, 저자, 파워 블로거, 셀럽, 기부 기관, 회사 ... <br>
친구의 서재에서 책을 발견하고, 구매하고, 같이 읽고,<br><br>

다양한 2차 저작물을 함께 만드는 'EZEN북티빙시대'<br>
9월 6일부터 오픈 베타 진행중입니다.<br>
구독 서재는 10월부터, 책방 기능은 11월부터 제공될 예정입니다.<br><br>

작가 활동, 도서 공급, 도서관 서재 개설 등에 대한 문의<br>
EZEN북티빙시대 bbo1234@gmail.com<br><br>감사합니다. <br>", "cbh4547");

insert into notice(notice_id, notice_group, title, content, created_by) 
values(2, "NOTICE", "뷰어 업데이트 소식 및 공모전 안내", "EZEN북티빙시대 회원 여러분 안녕하세요.<br>
 앱 업데이트와 공모전 소식을 안내드립니다.<br><br>

1. 앱 업데이트 <br>
EZEN북티빙시대가 지난 주말 안드로이드와 iOS 뷰어 업데이트를 완료했습니다. <br>
다양한 배경/폰트/여백 설정과 깔끔한 UI로 전자책을 편하게 즐기실 수 있을거에요.  <br><br>

2. 도서 업데이트 <br>
새로운 뷰어, 새로운 마음으로 10월 업데이트된 프리미엄 도서들도 읽어보시길 바랍니다. <br>
문재인 대통령의 저서부터 베스트셀러에 올랐던 소설과 에세이들이 여러 권 보이는데요. <br>
연휴기간 동안 가족들과 읽어보시면 어떨까요? (혼자 읽어도 좋고요...) <br><br>

3. 웹 애니메이션 공모전 개최 <br>
SBA 서울애니메이션센터, 네이버 그라폴리오, 그리고 EZEN북티빙시대가 함께 공모전을 진행합니다. <br>
총 1.2 억원의 지원금과 연재와 전자책 출간 기회까지 드리는 크리에이터 원스톱 지원서비스인데요. <br>
흔치 않은 기회인만큼 주변에 창작자, 예비창작자에게 많이 알려주세요. <br><br>

책이 필요한 순간, 언제 어디에서나 EZEN북티빙시대와 함께 하시면 좋겠네요! <br>
모두 풍성한 한가위 맞으시길 바랍니다.<br>", "cbh4547");

insert into notice(notice_id, notice_group, title, content, created_by) 
values(3, "NOTICE", "아이폰 iOS 10, 11에서 모두 이용 가능합니다.", "아이폰 iOS 10에서도 이용하실 수 있도록 앱 업데이트를 10/12 완료하였습니다. <br>
10월 12일부터는 iOS 10과 11에서 모두 이용 가능합니다.<br><br>

기다려 주셔서 감사합니다.<br>

===================================================

안녕하세요. EZEN북티빙시대입니다. <br><br>

아이폰과 아이패드를 통해 밀리 앱을 이용 중이신 회원님들께 안내드립니다.  <br><br>
 
애플 iOS 11 버전 업데이트에 대응하기 위해 EZEN북티빙시대 iOS 앱 업데이트를 진행했습니다.<br><br>

업데이트 이후 기존 iOS 10 버전과 밀리 신규 앱 충돌 현상이 확인되었습니다.  <br>
이에 따라 아이폰/패드 이용 회원께서는 다음과 같이 조치 후 사용해 주시기 바랍니다.  <br>

아이폰 사용자께서는 EZEN북티빙시대 앱 이용이 안 되실 경우 iOS 버전을 확인하고, 업데이트를 진행해 주시기 바랍니다. <br><br>

버전 확인과 업데이트는 아이폰 내 '설정 > 일반 > 소프트웨어 업데이트' 메뉴에서 확인하실 수 있습니다. <br><br>

* 'iOS 11.0.2 최신 소프트웨어입니다.'라는 메시지가 나와야 합니다. <br><br>

iOS 10 버전에도 대응하기 위해 금주 업데이트를 진행할 예정이오나, 가급적 최신 iOS 11로 업데이트 후 이용 부탁드립니다.  <br><br>

이용에 불편을 드려 죄송합니다.<br><br>

상기 내용에 궁금하신 점은 고객센터 일대일 문의 게시판 또는 070-1234-1234로 문의 부탁드립니다.<br><br>

감사합니다.<br> ", "cbh4547");

insert into notice(notice_id, notice_group, title, content, created_by) 
values(4, "NOTICE", "23년 9월 놓치면 후회할 업데이트 소식", "1. 콘텐츠 업데이트 <br><br>

(1) 기욤 뮈소도 EZEN북티빙 식구였어  <br>
- 한국인이 가장 사랑하는 프랑스 작가<br>
기욤 뮈소의 대표작을 펼쳐보세요.  <br><br>
 

(2) 더글라스 케네디도 EZEN북티빙 식구였어<br>
 - 『빅 피처』로 유명한 더글라스 케네디의 대표 작품 4권이 서비스 중입니다.<br>
스릴러 입덕 문이 열렸습니다.<br><br>
 

(3) 9월 대규모 도서 업데이트<br>
- 9월 오픈을 맞아 파트너 출판사분들께서 핫한 도서들을 보내주셨어요.<br>
넥서스BOOKS의 『ENJOY 여행』 시리즈,<br>
『이동우의10분 독서』, 『장병규의 스타트업한국』<br>
『사주풀이』, 『물리학은 처음인데요』포함<br>
수 백여권이 새로 서비스 됩니다. <br><br>

프리미엄 NEW 서재에서 도서들을 만나보세요!  <br><br>
 

(4) 애니메이션으로 보는 책<br>
- 원작의 매력을 더 UP! 시켜줄 애니메이션 연재가 시작되었습니다.<br>
원작도 읽고, 애니메이션도 보고.<br>
오직 EZEN북티빙에서만 가능합니다 ????<br><br>
 

2. 앱/웹 업데이트 <br><br>

 (1) 책읽기가 쉬워졌습니다.<br>
 - 기존에는 프리미엄 도서를 등록하는 버튼과  책읽기 버튼이 분리되어 있었는데요.<br>
 하나의 버튼으로 통합하여 좀 더 빠르고 쉽게 책을 읽으실 수 있도록 했습니다.<br><br>
 

(2) 독서 노트 기능을 개선했습니다.<br>
 - 인용문, 메모, 북마크를 서버에 기록해서,  반납한 도서를 다시 다운로드했을 때  <br>
​예전에 저장해 놓은 기록을 볼 수 있게 되었습니다. <br><br>


(3) 피드 화면을 변경했습니다.<br>
 - 기존 플립 방식이 불편하다는 고객 의견을  반영하여 상하 스크롤 방식으로 변경했습니다.<br><br>
 

이 밖에도  EZEN북티빙 회원님들의 의견을 듣고 크고 작은 개선을 진행하였습니다. <br><br>
 
곧 ​이벤트도 진행될 예정이오니, 매일 출석! 잊지 마세요^^<br>", "cbh4547");

insert into notice(notice_id, notice_group, title, content, created_by) 
values(5, "NOTICE", "EZEN북티빙시대 이용 약관 개정 안내", "안녕하세요. EZEN북티빙시대 입니다.<br><br>

2023년 9월 20일부터 EZEN북티빙시대 이용 약관이 변경됩니다.  <br><br>

변경된 용어 및 중복된 표기를 수정, 삭제하였으며<br>
현재 배포된 서비스 환경에 맞춰 전반적인 이용 약관을 변경하였습니다.<br><br>

구체적인 변경 내용은 아래 개정안 전문을 통해 확인 가능합니다. <br><br>

▶ 개정 대상 : 이용 약관<br><br>

▶ 적용 일정 : 2018년 7월 3일<br><br>

▶ 주요 변경 내용 : <br><br>

▪ 약관 명칭을 ‘서비스 약관’에서 ‘이용약관’으로 변경<br>
▪ 불필요하거나 중복된 조항은 병합하거나 축소<br>
▪ 유료서비스를 3가지로 분리하고 관련 내용 수정<br>
▪ 해지 정책과 관련해서 1)자동결제 해지와 2)유료서비스 이용 해지로 구분하여 수정<br>
▪ 밀/마일리지 내용 수정<br>
▪ 기타 전반적인 문구, 표현 수정 <br>
(구체적인 변경 내용은 하단에 첨부한 개정 약관 전문을 통해 확인 가능합니다)<br><br>

▶ 개정 후 약관 : 이용약관 메뉴에서 확인<br><br>

※ 변경된 약관 사항에 동의하지 않을 경우, 서비스 이용을 중단하고 이용 계약을 해지할 수 있습니다.<br>
이러한 명시적인 거부에 의사 표시를 하지 아니할 경우 약관 변경에 동의한 것으로 간주됩니다.<br>", "cbh4547");


insert into notice(notice_id, notice_group, title, content, created_by) 
values(6, "GUIDE", "EZEN북티빙시대 시즌 2.0 업데이트 완료", "안녕하세요, EZEN북티빙시대 입니다.<br>
시즌 2.0 업데이트가 완료 되었습니다. <br><br>

아직도 부족한 점이 많지만<br>
점점 발전해나가는 EZEN북티빙시대가 되겠습니다.<br><br>
 
감사합니다.<br>", "cbh4547");

insert into notice(notice_id, notice_group, title, content, created_by) 
values(7, "GUIDE", "서비스 정상화 안내", "9월 8일 오전 7시 52분부터 8시 57분까지 약 1시간 동안 서비스 접속 장애가 있었습니다. <br><br>

네이버 클라우드 플랫폼의 네트워크 문제로 현재는 정상화된 상태입니다.<br>
서비스 접속 장애로 불편함을 겪은 사용자 여러분께 진심으로 사과드립니다. <br><br>

이번 일을 계기로 서비스에 문제가 발생할 때 바로 안내해 드릴 수 있는 시스템을 구축하고 다운로드 받은 책을 문제없이 읽을 수 있도록 개선할 예정입니다.<br><br>

추가로, 서비스 안정화를 위해 서버 점검 및 증설도 준비하고 있습니다. <br><br>

다시 한번 이용에 불편을 드려 죄송합니다. <br><br>

불편하셨겠지만 너그러운 마음으로 이해 부탁드립니다.<br>", "cbh4547");

insert into notice(notice_id, notice_group, title, content, created_by) 
values(8, "GUIDE", "서버 점검 안내", "안녕하세요. EZEN북티빙시대입니다.<br><br>
 

더욱 안정적인 서비스 운영을 위하여 아래와 같이 정기 점검을 시행합니다.<br>
점검 기간에는 서비스가 간헐적으로 중지될 수 있습니다.<br>
조금 불편하시더라도 너그러운 마음으로 양해와 이해 부탁드립니다.<br>
* 서버 점검 중에도 앱에 다운로드 받은 책은 정상적으로 읽을 수 있습니다.  <br><br>

- 작업 내용 : 서버 점검 및 증설<br>
- 점검 시간 : 10월 23일(화)에서 10월 24일(수)로 넘어가는 자정부터 새벽 6시까지<br>
열심히 점검하고 좀 더 안정적인 서비스로 찾아뵙겠습니다.<br><br>

고맙습니다.<br>", "cbh4547");

insert into notice(notice_id, notice_group, title, content, created_by) 
values(9, "NOTICE", "개인정보처리방침 일부 변경 안내", '안녕하세요. EZEN북티빙시대입니다.<br>
개인정보처리방침을 일부 변경하게 되어 사전 안내 드립니다.<br><br>

[변경사유]<br>
법정대리인 권리/의무 행사방법 추가<br>
개인정보보호 책임자 변경<br><br>

[변경내용]<br><br>

7조 변경 사항 <br><br>

현재) 7. 정보주체의 권리•의무 및 그 행사방법<br>
- 홈페이지를 통한 열람, 수정 및 회원 탈퇴 방법<br>
이용자는 언제든지 "관리 > 내정보관리 > 개인정보수정"에서 자신의 개인정보를 조회하거나 수정할 수 있습니다.<br>
이용자는 언제든지 "관리 > 내정보관리 > 회원탈퇴" 등을 통해 개인정보의 수집 및 이용 동의를 철회할 수 있습니다.<br>
이용자가 개인정보의 오류에 대한 정정을 요청한 경우, 정정을 완료하기 전까지 해당 개인정보를 이용 또는 제공하지 않습니다. <br>
또한 잘못된 개인정보를 제3자에게 이미 제공한 경우에는 정정 처리결과를 제3자에게 지체 없이 통지하여 정정이 이루어지도록 하겠습니다.<br><br>

- 전화, 전자우편을 통한 열람, 수정 및 회원 탈퇴 방법<br>
회원이 홈페이지를 통해 개인정보에 대한 정보를 열람, 수정 및 탈퇴를 요청할 수 없는 경우 개인정보보호 책임자 또는 고객센터로 전화, 전자우편으로 연락하시면 지체 없이 조치하겠습니다.<br>
고객센터 : 070-1234-1234<br>
전자우편 : bbo1234@gmail.com<br><br>

변경) 7. 이용자 및 법정대리인의 권리와 그 행사방법<br>
① 정보주체는 회사에 대해 언제든지 다음 각호의 개인정보 보호 관련 권리를 행사할 수 있습니다.<br>
- 개인정보 열람 요구<br>
- 오류 등이 있을 경우 정정 요구<br>
- 삭제 요구<br>
- 처리정지 요구<br><br>

② 제1항에 따른 권리 행사는 회사에 대해 전화, 전자우편 등을 통하여 하실 수 있으며 회사는 이에 대해 지체 없이 조치하겠습니다.<br>
- 홈페이지를 통한 열람, 수정 및 회원 탈퇴 방법<br>
이용자는 언제든지 "관리 > 내정보관리 > 개인정보수정"에서 자신의 개인정보를 조회하거나 수정할 수 있습니다.<br>
이용자는 언제든지 "관리 > 내정보관리 > 회원탈퇴" 등을 통해 개인정보의 수집 및 이용 동의를 철회할 수 있습니다.<br>
- 전화, 전자우편을 통한 열람, 수정 및 회원 탈퇴 방법<br>
고객센터 : 070-1234-1234<br>
전자우편 : bbo1234@gmail.com<br><br>

③ 정보주체가 개인정보의 오류 등에 대한 정정 또는 삭제를 요구한 경우에 회사는 정정 또는 삭제를 완료할 때까지 당해 개인정보를 이용하거나 제공하지 않습니다.<br>
④ 제1항에 따른 권리 행사는 정보주체의 법정대리인이나 위임을 받은 자 등 대리인을 통하여 하실 수 있습니다.<br>
이 경우 개인정보 보호법 시행규칙 별지 제 11호 서식에 따른 위임장을 제출하셔야 합니다.<br>
⑤ 정보주체는 개인정보보호법 등 관계법령을 위반하여 회사가 처리하고 있는 정보주체 본인이나 타인의 개인정보 및 사생활을 침해하여서는 아니 됩니다.<br><br>

10조 변경사항<br><br>

현재) 개인정보보호 책임자 변경<br>
이 름 : 제갈종원<br>
직 위 : 팀장<br>
메 일 : bbo1234@gmail.com<br><br>

변경) 이 름 : 김주영<br>
직 위 : 팀장<br>
메 일 : bbo1234@gmail.com<br><br>

위 내용은 2023년 10월 2일부터 시행됩니다.<br>
변경되는 내용에 동의하지 않으시는 경우 ‘회원탈퇴’를 통해 거부 의사를 표시할 수 있습니다.<br>
관련하여 궁금하신 부분은 1:1문의하기로 접수 부탁드립니다.<br><br>

앞으로도 더 나은 서비스 제공을 위해 최선을 다하겠습니다.<br>
감사합니다.<br><br>


EZEN북티빙시대 드림<br>", "cbh4547");

insert into notice(notice_id, notice_group, title, content, created_by) 
values(10, "NOTICE", "챌린지 삭제 기능 추가", "안녕하세요. EZEN북티빙시대입니다. <br>
나의챌린지 삭제 기능이 추가되어 안내드립니다! <br><br>

1) 종료 / 중단된 목표 삭제기능 추가 <br>
나의챌린지 현황 > 종료/중단된 목표 리스트의 ‘목표 삭제하기’ 버튼을 확인해 주세요.<br><br>

2) 독서/활동/포스트 내역 삭제기능 추가 <br>
나의챌린지 내역 > 목록 더보기 > 삭제 버튼을 확인해 주세요. <br><br>

편리한 EZEN북티빙시대가 되기 위해 노력하겠습니다.<br>
감사합니다.<br>", "cbh4547");

insert into notice(notice_id, notice_group, title, content, created_by) 
values(11, "NOTICE", "뷰어 일부 기능 수정 안내", "안녕하세요.<br>
EZEN북티빙시대입니다.<br><br>

10월 5일, 오늘 앱 뷰어 업데이트가 완료되었습니다.<br>
아래와 같은 오류가 개선되었으니 앱 업데이트를 진행해주시기 바랍니다.<br><br>

1.특정 도서에서 앱이 크래시되는 현상을 개선하였습니다.<br>
2.스크롤모드나, 일반 드래그 시 하이라이트가 자동으로 저장되는 문제를 개선하였습니다.<br>
3.시선 추적 이용 시, 아이패드 가로모드에서 앱이 크래시되는 현상을 개선하였습니다.<br><br>

*iOS 애니메이션 진입 오류도 개선하였습니다.<br><br>

현재 업데이트 이후, 일부 회원님께 도서의 보기 설정 (폰트 크기, 줄간격, 테마 색상 등) 이 초기화되는 오류가 발생하였습니다.<br>
관련 오류는 1월 8일(금) 이전에 개선될 예정이며 최대한 빠르게 수정 하겠습니다.<br>
서비스 이용에 불편을 끼쳐 죄송합니다.<br><br>

추가로 오늘 내서재와 내가 만든 오디오북이 함께 업데이트 됩니다.<br>
각각 공지를 통해 자세히 안내드릴 예정이니 잠시만 기다려 주세요!<br><br>

감사합니다.<br>', "cbh4547");

-- 이용권 추가
insert into commutation_ticket(price, use_period, commutation_name) values(9900, 1, '북티빙 1개월 이용권');
insert into commutation_ticket(price, use_period, commutation_name) values(27000, 3, '북티빙 3개월 이용권');
insert into commutation_ticket(price, use_period, commutation_name) values(52000, 6, '북티빙 6개월 이용권');
insert into commutation_ticket(price, use_period, commutation_name) values(99000, 12, '북티빙 1년 이용권');

-- 추천 키워드 추가
insert into recommend_keyword(recommend_keyword_type, recommend_keyword_name, reg_time, update_time) values('Title', '세이노의 가르침', now(), now());
insert into recommend_keyword(recommend_keyword_type, recommend_keyword_name, reg_time, update_time) values('Title', '너의 이름은', now(), now());
insert into recommend_keyword(recommend_keyword_type, recommend_keyword_name, reg_time, update_time) values('Author', '히가시노 게이고', now(), now());
insert into recommend_keyword(recommend_keyword_type, recommend_keyword_name, reg_time, update_time) values('Title', '최애의 아이', now(), now());
insert into recommend_keyword(recommend_keyword_type, recommend_keyword_name, reg_time, update_time) values('Title', '1%를 읽는 힘', now(), now());
insert into recommend_keyword(recommend_keyword_type, recommend_keyword_name, reg_time, update_time) values('Title', '일론 머스크', now(), now());
insert into recommend_keyword(recommend_keyword_type, recommend_keyword_name, reg_time, update_time) values('Author', '베르나르 베르베르', now(), now());
insert into recommend_keyword(recommend_keyword_type, recommend_keyword_name, reg_time, update_time) values('Author', '기욤 뮈소', now(), now());
insert into recommend_keyword(recommend_keyword_type, recommend_keyword_name, reg_time, update_time) values('Author', '헤르만 헤세', now(), now());
insert into recommend_keyword(recommend_keyword_type, recommend_keyword_name, reg_time, update_time) values('Author', '김영하', now(), now());
insert into recommend_keyword(recommend_keyword_type, recommend_keyword_name, reg_time, update_time) values('Author', '신경숙', now(), now());
insert into recommend_keyword(recommend_keyword_type, recommend_keyword_name, reg_time, update_time) values('Title', '아주 희미한 빛으로도', now(), now());
insert into recommend_keyword(recommend_keyword_type, recommend_keyword_name, reg_time, update_time) values('Author', '무라카미 하루키', now(), now());
insert into recommend_keyword(recommend_keyword_type, recommend_keyword_name, reg_time, update_time) values('Title', '오펜하이머', now(), now());
insert into recommend_keyword(recommend_keyword_type, recommend_keyword_name, reg_time, update_time) values('Title', '한국사', now(), now());

commit;
