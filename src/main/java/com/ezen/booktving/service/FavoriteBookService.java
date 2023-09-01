package com.ezen.booktving.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.booktving.constant.YesNoStatus;
import com.ezen.booktving.dto.FavoriteBookDto;
import com.ezen.booktving.dto.FavoriteBookDtoList;
import com.ezen.booktving.entity.Book;
import com.ezen.booktving.entity.FavoriteBook;
import com.ezen.booktving.entity.Member;
import com.ezen.booktving.repository.BookImgRepository;
import com.ezen.booktving.repository.BookRepository;
import com.ezen.booktving.repository.FavoriteBookRepository;
import com.ezen.booktving.repository.MemberRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class FavoriteBookService {
	private final FavoriteBookRepository favoriteBookRepository;
	private final BookRepository bookRepository;
	private final MemberRepository memberRepository;
	private final BookImgRepository bookImgRepository;

	
	//찜하기
	public Long like(String userId, String isbn) {
		Member member = memberRepository.findByUserId(userId);
		Book book = bookRepository.findByIsbn(isbn);
		
		FavoriteBook existingFavorite = favoriteBookRepository.findByMemberAndBook(member, book);
	    if (existingFavorite != null) {
	        // 해당 책은 이미 사용자의 찜목록에 있습니다.
	        return -1L;
	    }
		
		FavoriteBook favoriteBook = FavoriteBook.createFavoriteBook(member, book);
		
		favoriteBookRepository.save(favoriteBook);
		
		return favoriteBook.getId();
	}
	
	@Transactional
	public Page<FavoriteBook> getFavoriteList(String userId, Pageable pageable) {
		Member member = memberRepository.findByUserId(userId);
		
		return favoriteBookRepository.findByMember(member, pageable);
	}
	

    public List<FavoriteBookDto> getFavoriteBooksByMember(String userId) {
    	Member member = memberRepository.findByUserId(userId);
    	List<FavoriteBook> favoriteBooks = favoriteBookRepository.findByMember(member);
    	List<FavoriteBookDto> favoriteBookDtos = favoriteBooks.stream().map(FavoriteBookDto::of)
				.collect(Collectors.toList());
        return favoriteBookDtos;
    }

    
    @Transactional(readOnly = true)
	   public Book getBookById(Long favoriteBookId) {
    	FavoriteBook favoriteBook = favoriteBookRepository.findById(favoriteBookId)
    			.orElseThrow(() -> new NoSuchElementException("FavoriteBook not found with id: " + favoriteBookId));
    	return favoriteBook.getBook();
    }
    
   
    public void removeFavoriteBook(Long likeId) {
    	FavoriteBook favoriteBook = favoriteBookRepository.findById(likeId)
    						.orElseThrow(EntityNotFoundException::new);
    	
    	favoriteBookRepository.deleteById(likeId);
    }
    
   //로그인한 사용자의 찜도서 정보 가져오기
   	public List<FavoriteBook> getFavoriteListAll(String userId){
  		List<FavoriteBook> favoriteBookList = bookRepository.findByMember(userId);
  		return favoriteBookList;
  	}
    
  	//찜도서 정보가져오기(나의서재)
   	public Page<FavoriteBookDtoList> getFavoriteBookList(String userId, Pageable pageable){
   		
   		List<FavoriteBook> favoriteBooks = bookRepository.findFavoritebook(userId, pageable);
   		
   		Long totalCount = bookRepository.countFavoriteBook(userId);
   				
   		
   		List<FavoriteBookDtoList> favoriteBookDtoList = new ArrayList<>();

   		for(FavoriteBook favoriteBook : favoriteBooks) {
   			FavoriteBookDtoList favoriteBookDto = new FavoriteBookDtoList(favoriteBook, bookImgRepository.findByBookIdAndRepYn(favoriteBook.getBook().getId(), YesNoStatus.Y));
   			
   			favoriteBookDtoList.add(favoriteBookDto);
   		}
   		
   		return new PageImpl<>(favoriteBookDtoList, pageable, totalCount);
   	}
   
}
