package com.ezen.booktving.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.java.Log;

@Service
@Log
public class FileService {
	//파일 업로드 
	public String uploadFile(String uploadPath, String originalFileName, byte[] fileData) throws Exception{
		UUID uuid = UUID.randomUUID(); //종복되지 않는 파일명을 만든다.
		
		//이미지1.jpg -> 이미지의 확장자 명을 구한다.
		String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
		
		//파일이름 생성 EASD.jpg
		String savedFileName = uuid.toString() + extension; //파일이름 생성
		
		//C:/booktving/book/name.jpg
		String fileUploadFullUrl = uploadPath + "/" + savedFileName;
		
		//파일 업로드
		FileOutputStream fos = new FileOutputStream(fileUploadFullUrl);
		fos.write(fileData);
		fos.close();
		
		return savedFileName;
	}
	
	//파일 삭제
	public void deleteFiles(String filePath) throws Exception {
		
		//C:/booktving/book/name.jpg
		File deleteFile = new File(filePath) ; //파일이 저장된 경로를 이용해서 파일객체 생성
		
		//파일 삭제
		if(deleteFile.exists()) {  //해당 경로에 파일이 있다면
			deleteFile.delete(); //파일삭제
			log.info("파일을 삭제하였습니다."); //로그기록을 저장한다.
		} else {
			log.info("파일이 존재하지 않습니다.");
		}
	}
	
	//작가등록 파일업로드
	@Value("${file:///C:/booktving/}")
	private String uploadPath;
	
	public String authorUploadFile(MultipartFile file, String subDirectory) throws IOException {
		UUID uuid = UUID.randomUUID();		
		
		String originalFileName = StringUtils.cleanPath(file.getOriginalFilename());
		
		String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
	    String savedFileName = uuid.toString() + extension;
	    Path uploadDirectory = Path.of(uploadPath, subDirectory);
		
        try {
            Path targetLocation = uploadDirectory.resolve(savedFileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return savedFileName;
        } catch (IOException e) {
            throw new IOException("Failed to store file " + uploadDirectory, e);
        }
    }
	
	
	
}