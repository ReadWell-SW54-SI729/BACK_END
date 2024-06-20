package com.BookFlow.CatalogueService.domain.model.aggregates;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Entity
@Getter
public class Genre {
    @Id
    @NotNull
    @GeneratedValue
    private Long genreId;

    @NotBlank(message = "Genre name is mandatory")
    @Column
    private String name;

    public Genre(Long genreId,String name) {
        this.genreId = genreId;
        this.name = name;
    }

    public Genre() {
    }

    public Long getGenreId(){
        return genreId;
    }
    public String getName(){
        return name;
    }

}
