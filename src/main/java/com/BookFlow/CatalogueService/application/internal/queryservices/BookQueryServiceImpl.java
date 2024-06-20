package com.BookFlow.CatalogueService.application.internal.queryservices;

import com.BookFlow.CatalogueService.domain.model.aggregates.Book;
import com.BookFlow.CatalogueService.domain.model.queries.GetAllBooksQuery;
import com.BookFlow.CatalogueService.domain.model.queries.GetBookByIdQuery;
import com.BookFlow.CatalogueService.domain.model.queries.GetBookByNameQuery;
import com.BookFlow.CatalogueService.domain.model.valueobjects.BookName;
import com.BookFlow.CatalogueService.domain.services.BookQueryService;
import com.BookFlow.CatalogueService.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookQueryServiceImpl implements BookQueryService{
    private final BookRepository bookRepository;

    public BookQueryServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public Optional<Book> handle(GetBookByNameQuery query) {
        return bookRepository.findByBookTitle(query.bookTitle());
    }
    @Override
    public Optional<Book> handle(GetBookByIdQuery query) {
        return bookRepository.findById(query.id());
    }
    @Override
    public List<Book> handle(GetAllBooksQuery query) {
        return bookRepository.findAll();
    }
}
