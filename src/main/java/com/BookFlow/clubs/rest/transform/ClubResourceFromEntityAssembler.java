package com.BookFlow.clubs.rest.transform;

import com.BookFlow.clubs.domain.model.aggregates.Club;
import com.BookFlow.clubs.rest.resources.ClubResource;

public class ClubResourceFromEntityAssembler {
    public static ClubResource toResourceFromEntity(Club club) {
        return new ClubResource(
                club.getClubId(),
                club.getClubTitle(),
                CommentResourceFromEntityAssembler.toResourceFromEntity(club.getComment()),
                club.getClubImage(),
                club.getClubDescription(),
                club.getClubAuthor()
        );
    }
}
