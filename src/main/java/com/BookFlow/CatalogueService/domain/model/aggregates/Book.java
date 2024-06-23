package com.BookFlow.CatalogueService.domain.model.aggregates;

import com.BookFlow.CatalogueService.domain.model.commands.CreateBookCommand;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Entity

public class Book  {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column
    private String bookTitle;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre bookGenreId;

    @Getter
    @NotBlank(message = "Book image is mandatory")
    @Column
    private String bookImage;

    @NotBlank (message = "Book description is mandatory")
    @Column
    private String bookDescription;

    @NotBlank(message = "Book author is mandatory")
    @Column
    private String bookAuthor;

    @Column
    private String bookAuthorImage;

    @Column
    private String bookPublisher;

    @NotNull
    @Column
    private String bookRank;

    public Book(String bookTitle, Long bookGenreId, String bookImage, String bookDescription, String bookAuthor, String bookAuthorImage, String bookPublisher, String bookRank) {
        this.bookTitle = bookTitle;
        this.bookGenreId = new Genre(bookGenreId,"");
        this.bookImage = bookImage;
        this.bookDescription = bookDescription;
        this.bookAuthor = bookAuthor;
        this.bookAuthorImage = bookAuthorImage;
        this.bookPublisher = bookPublisher;
        this.bookRank = bookRank;
    }
    public Book(Long bookId,String bookTitle, Long bookGenreId, String bookImage, String bookDescription, String bookAuthor, String bookAuthorImage, String bookPublisher, String bookRank) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookGenreId = new Genre(bookGenreId,"");
        this.bookImage = bookImage;
        this.bookDescription = bookDescription;
        this.bookAuthor = bookAuthor;
        this.bookAuthorImage = bookAuthorImage;
        this.bookPublisher = bookPublisher;
        this.bookRank = bookRank;
    }
    public Book(CreateBookCommand command, Genre genre){
       bookTitle = command.bookTitle();
       bookGenreId = genre;
       bookImage = command.bookImage();
       bookDescription = command.bookDescription();
       bookAuthor = command.bookAuthor();
       bookAuthorImage = command.bookAuthorImage();
       bookPublisher = command.bookPublisher();
       bookRank = command.bookRank();
    }
    public Book() {
        this.bookImage = "";
        this.bookDescription = "";
        this.bookAuthor = "";
        this.bookAuthorImage = "";
        this.bookPublisher = "";
        this.bookRank = "";
    }

    public Genre getGenre(){
        return bookGenreId;
    }
    public String getBookName(){
        return bookTitle;
    }

    public Long getBookId() {
        return bookId;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getBookAuthorImage() {
        return bookAuthorImage;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public String getBookRank() {
        return bookRank;
    }
}
