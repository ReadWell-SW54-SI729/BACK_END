package com.BookFlow.CatalogueService.domain.services;

import com.BookFlow.CatalogueService.domain.model.aggregates.Book;
import com.BookFlow.CatalogueService.domain.model.queries.GetAllBooksQuery;
import com.BookFlow.CatalogueService.domain.model.queries.GetBookByIdQuery;
import com.BookFlow.CatalogueService.domain.model.queries.GetBookByNameQuery;

import java.util.List;
import java.util.Optional;

public interface BookQueryService {
    Optional<Book> handle(GetBookByIdQuery query);
    Optional<Book> handle(GetBookByNameQuery query);
    List<Book> handle(GetAllBooksQuery query);
}
