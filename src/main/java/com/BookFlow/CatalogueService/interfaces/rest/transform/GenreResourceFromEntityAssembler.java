package com.BookFlow.CatalogueService.rest.transform;

import com.BookFlow.CatalogueService.domain.model.aggregates.Genre;
import com.BookFlow.CatalogueService.rest.resources.GenreResource;

public class GenreResourceFromEntityAssembler {
    public static GenreResource toResourceFromEntity(Genre genre) {
        return new GenreResource(genre.getGenreId(), genre.getName());
    }
}
