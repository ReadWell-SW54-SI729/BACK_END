package com.BookFlow.CatalogueService.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record BookName (String bookTitle){
    public BookName {
        if (bookTitle == null || bookTitle.isBlank()) {
            throw new IllegalArgumentException("Book name is mandatory");
        }
        if (bookTitle.length() > 60) {
            throw new IllegalArgumentException("Book name must not exceed 60 characters");
        }
    }
    public String bookTitle() {
        return bookTitle;
    }
}
