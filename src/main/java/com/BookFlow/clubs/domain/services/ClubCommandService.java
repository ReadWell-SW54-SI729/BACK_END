package com.BookFlow.clubs.domain.services;

import com.BookFlow.clubs.domain.model.aggregates.Club;
import com.BookFlow.clubs.domain.model.commands.CreateClubCommand;

import java.util.Optional;

public interface ClubCommandService {
    Optional<Club> handle(CreateClubCommand command);
}
