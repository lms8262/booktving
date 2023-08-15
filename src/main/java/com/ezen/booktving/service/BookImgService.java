package com.ezen.booktving.service;

import org.apache.groovy.parser.antlr4.util.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ezen.booktving.entity.BookImg;
import com.ezen.booktving.repository.BookImgRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class BookImgService {
	
	private String bookImgLocation = "c:/booktving/book";
	private final BookImgRepository bookImgRepository;
	private final FileService fileService;
	
	
	public void saveBookImg(BookImg bookImg, MultipartFile bookimgFile) throws Exception {
		String oriImgName = bookimgFile.getOriginalFilename(); //파일이름 -> 이미지1.jpg
		String imgName = "";
		String imgUrl = "";
		
		//1.파일을 bookImgLocation에 저장
		if(!StringUtils.isEmpty(oriImgName)) {
			//oriImgName이 빈문자열이 아니라면 이미지 파일 업로드
			imgName = fileService.uploadFile(bookImgLocation, oriImgName, bookimgFile.getBytes());
			imgUrl = "/images/book/" + imgName;
		}
		
		//2.book_img 테이블에 저장
		bookImg.updateBookImg(oriImgName, imgName, imgUrl);
		bookImgRepository.save(bookImg);
	}
	
	
	public void updateBookImg(Long bookImgId, MultipartFile bookImgFile) throws Exception {
		if(!bookImgFile.isEmpty()) { //첨부한 파일이 있으면
			
			//해당 이미지 가져오고
			BookImg savedBookImg = bookImgRepository.findById(bookImgId)
										.orElseThrow(EntityNotFoundException::new);
			
			//기존이미지 파일 C:/booktving/book 폴더에서 삭제
			if(!StringUtils.isEmpty(savedBookImg.getImgName())) {
				fileService.deleteFiles(bookImgLocation + "/" + savedBookImg.getImgName());
			}
			
			//수정된 이미지 파일 업로드 C:/booktving/book에 업로드
			String oriImgName = bookImgFile.getOriginalFilename();
			String imgName = fileService.uploadFile(bookImgLocation, oriImgName, bookImgFile.getBytes());
			String imgUrl = "/images/book" + imgName;
			
			//update 쿼리문 실행
			/*한번 insert를 진행하면 엔티티가 영속성 컨텍스트에 저장이 되므로 
			//그 이후에는 변경감지 기능이 동작하기 때문에 개발자는 update 쿼리문을 쓰지않고 
			엔티티만 변경해주면 된다.
			*/
			
			savedBookImg.updateBookImg(oriImgName, imgName, imgUrl);

		}
	}
}
