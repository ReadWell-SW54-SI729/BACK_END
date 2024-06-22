package com.BookFlow.CatalogueService.rest.transform;

import com.BookFlow.CatalogueService.domain.model.aggregates.Book;
import com.BookFlow.CatalogueService.rest.resources.BookResource;

public class BookResourceFromEntityAssembler {
    public static BookResource toResourceFromEntity (Book book) {
        return new BookResource(
                book.getBookId(),
                book.getBookName(),
                GenreResourceFromEntityAssembler.toResourceFromEntity(book.getGenre()),
                book.getBookImage(),
                book.getBookDescription(),
                book.getBookAuthor(),
                book.getBookAuthorImage(),
                book.getBookPublisher(),
                book.getBookRank()
        );
    }
}
