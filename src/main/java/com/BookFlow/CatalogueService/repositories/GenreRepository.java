package com.BookFlow.CatalogueService.repositories;

import com.BookFlow.CatalogueService.domain.model.aggregates.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long>{
boolean existsByName(String name);
}
