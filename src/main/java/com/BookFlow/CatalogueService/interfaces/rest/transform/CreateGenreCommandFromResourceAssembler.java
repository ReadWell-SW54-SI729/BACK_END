package com.BookFlow.CatalogueService.rest.transform;

import com.BookFlow.CatalogueService.domain.model.commands.CreateGenreCommand;
import com.BookFlow.CatalogueService.rest.resources.CreateGenreResource;

public class CreateGenreCommandFromResourceAssembler {
    public static CreateGenreCommand toCommandFromResource(CreateGenreResource resource) {
        return new CreateGenreCommand(
                resource.name()
        );
    }
}
