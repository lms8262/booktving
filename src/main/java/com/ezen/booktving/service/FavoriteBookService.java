package com.ezen.booktving.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.booktving.dto.FavoriteBookDto;
import com.ezen.booktving.entity.Book;
import com.ezen.booktving.entity.FavoriteBook;
import com.ezen.booktving.entity.Member;
import com.ezen.booktving.repository.BookRepository;
import com.ezen.booktving.repository.FavoriteBookRepository;
import com.ezen.booktving.repository.MemberRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FavoriteBookService {
	private final FavoriteBookRepository favoriteBookRepository;
	private final BookRepository bookRepository;
	private final MemberRepository memberRepository;

	//찜하기
	public Long like(FavoriteBookDto favoriteBookDto, String email) {
		
		Book book = bookRepository.findById(favoriteBookDto.getId())
									.orElseThrow(EntityNotFoundException::new);
		
		Member member = memberRepository.findByEmail(email);
		
		List<FavoriteBook> favoriteBookList = new ArrayList<>();
		FavoriteBook favoriteBook = FavoriteBook.createFavoriteBook(member, favoriteBookDto.getId());
		favoriteBookList.add(favoriteBook);
		
		favoriteBook.setBook(book);
		favoriteBookRepository.save(favoriteBook);
		
		return favoriteBook.getId();
	}
	
    @Autowired
    public FavoriteBookService(FavoriteBookRepository favoriteBookRepository, BookRepository bookRepository, MemberRepository memberRepository) {
        this.favoriteBookRepository = favoriteBookRepository;
        this.bookRepository = bookRepository;
		this.memberRepository = memberRepository;
    }

    public List<FavoriteBook> getFavoriteBooksByMember(Member member) {
        return favoriteBookRepository.findByMember(member);
    }

    /*@Transactional
    public Boolean addFavoriteBook(Member member, Book book) {
        FavoriteBook entity = favoriteBookRepository.findByMemberAndBook(member, book);

        if(entity == null){
            FavoriteBook favoriteBook = FavoriteBook.from(member,book);
            favoriteBookRepository.save(favoriteBook);
            return true;
        }
        else{
            return false;
        }

    }*/
    
    @Transactional(readOnly = true)
	   public Book getBookById(Long favoriteBookId) {
    	FavoriteBook favoriteBook = favoriteBookRepository.findById(favoriteBookId)
    			.orElseThrow(() -> new NoSuchElementException("FavoriteBook not found with id: " + favoriteBookId));
    	return favoriteBook.getBook();
    }
    
    public void removeFavoriteBook(Member member, Book book) {
        FavoriteBook favoriteBook = favoriteBookRepository.findByMemberAndBook(member, book);
        if (favoriteBook != null) {
            favoriteBookRepository.delete(favoriteBook);
        }
    }
    
   
}
