package com.ezen.booktving.entity;

import java.util.List;

import com.ezen.booktving.dto.BookImgDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "favorite_book")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteBook extends BaseTimeEntity {

	@Id
	@Column(name = "favorite_book_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id", nullable = false)
	private Member member;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_id", nullable = false)
	private Book book;
	
	@Transient // 이 필드는 데이터베이스에 매핑하지 않음
    private List<BookImgDto> bookImgDtoList;
	
	public static FavoriteBook createFavoriteBook(Member member, Book book) {
		FavoriteBook favoriteBook = new FavoriteBook();
		favoriteBook.setMember(member);
		favoriteBook.setBook(book);
		
		/*Book book = new Book();
        book.setId(id);
        favoriteBook.setBook(book);*/
		
		return favoriteBook;
		
	}

}
