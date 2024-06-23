package com.BookFlow.CatalogueService.infrastructure.persistence.jpa.repositories;

import com.BookFlow.CatalogueService.domain.model.aggregates.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
    boolean existsByBookTitle(String bookTitle);
    Optional<Book> findByBookTitle(String bookTitle);
}
