package com.BookFlow.CatalogueService.domain.model.queries;

import com.BookFlow.CatalogueService.domain.model.valueobjects.BookName;

public record GetBookByNameQuery (BookName bookTitle){
}
