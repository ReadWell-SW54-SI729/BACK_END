package com.BookFlow.clubs.rest.transform;

import com.BookFlow.clubs.domain.model.commands.CreateClubCommand;
import com.BookFlow.clubs.rest.resources.CreateClubResource;

public class CreateClubCommandFromResourceAssembler {
    public static CreateClubCommand toCommandFromResource(CreateClubResource resource) {
        return new CreateClubCommand(
                resource.clubTitle(),
                resource.clubCommentId(),
                resource.clubImage(),
                resource.clubDescription(),
                resource.clubAuthor()
        );
    }
}
