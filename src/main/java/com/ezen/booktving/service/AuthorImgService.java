package com.ezen.booktving.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import com.ezen.booktving.entity.AuthorBookImg;
import com.ezen.booktving.entity.AuthorImg;
import com.ezen.booktving.repository.AuthorBookImgRepository;
import com.ezen.booktving.repository.AuthorImgRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthorImgService {
	
	//@Value("${authorImgLocation}")
	private String authorImgLocation = "c:/booktving/author";
	private final AuthorImgRepository authorImgRepository;
	private final AuthorBookImgRepository authorBookImgRepository;
	private final FileService fileService;
	
	public void saveAuthorImg(AuthorImg authorImg, MultipartFile authorImgFile) throws Exception{
		String oriImgName = authorImgFile.getOriginalFilename();
		String imgName = "";
		String imgUrl = "";
		
		if(!StringUtils.isEmpty(oriImgName)) {
			imgName = fileService.uploadFile(authorImgLocation, oriImgName, authorImgFile.getBytes());
			imgUrl = "/image/author/" + imgName;
		}
		
		authorImg.updateAuthorImg(oriImgName, imgName, imgUrl);
		authorImgRepository.save(authorImg);
	}
	
	public void updateAuthorImg(Long authorImgId, MultipartFile authorImgFile) throws Exception {
		
		if(!authorImgFile.isEmpty()) {
			AuthorImg savedAuthorImg = authorImgRepository.findById(authorImgId)
											.orElseThrow(EntityNotFoundException::new);
			
			if(!StringUtils.isEmpty(savedAuthorImg.getImgName())) {
				fileService.deleteFiles(authorImgLocation + "/" + savedAuthorImg.getImgName());
			}
			
			String oriImgName = authorImgFile.getOriginalFilename();
			String imgName = fileService.uploadFile(authorImgLocation, oriImgName, authorImgFile.getBytes());
			String imgUrl = "/image/author/" + imgName;
			
			savedAuthorImg.updateAuthorImg(oriImgName, imgName, imgUrl);
			
		}
	}
	
	public void saveAuthorBookImg(AuthorBookImg authorBookImg, MultipartFile authorBookImgFile) throws Exception{
		String oriImgName = authorBookImgFile.getOriginalFilename();
		String imgName = "";
		String imgUrl = "";
		
		if(!StringUtils.isEmpty(oriImgName)) {
			imgName = fileService.uploadFile(authorImgLocation, oriImgName, authorBookImgFile.getBytes());
			imgUrl = "/image/author/" + imgName;
		}
		
		authorBookImg.updateAuthorImg(oriImgName, imgName, imgUrl);
		authorBookImgRepository.save(authorBookImg);
	}
	
	public void updateAuthorBookImg(Long authorBookImgId, MultipartFile authorBookImgFile) throws Exception {
		
		if(!authorBookImgFile.isEmpty()) {
			AuthorImg savedAuthorBookImg = authorImgRepository.findById(authorBookImgId)
											.orElseThrow(EntityNotFoundException::new);
			
			if(!StringUtils.isEmpty(savedAuthorBookImg.getImgName())) {
				fileService.deleteFiles(authorImgLocation + "/" + savedAuthorBookImg.getImgName());
			}
			
			String oriImgName = authorBookImgFile.getOriginalFilename();
			String imgName = fileService.uploadFile(authorImgLocation, oriImgName, authorBookImgFile.getBytes());
			String imgUrl = "/image/author/" + imgName;
			
			savedAuthorBookImg.updateAuthorImg(oriImgName, imgName, imgUrl);
			
		}
	}

}
