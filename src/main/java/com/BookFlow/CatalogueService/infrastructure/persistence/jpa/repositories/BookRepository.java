package com.BookFlow.CatalogueService.infrastructure.persistence.jpa.repositories;

import com.BookFlow.CatalogueService.domain.model.aggregates.Book;
import com.BookFlow.CatalogueService.domain.model.valueobjects.BookName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
    Optional<Book> findByBookTitle(BookName bookTitle);
}
