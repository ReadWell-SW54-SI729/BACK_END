package com.BookFlow.clubs.domain.services;

import com.BookFlow.clubs.domain.model.aggregates.Club;
import com.BookFlow.clubs.domain.model.queries.GetAllClubsQuery;
import com.BookFlow.clubs.domain.model.queries.GetClubByIdQuery;
import com.BookFlow.clubs.domain.model.queries.GetClubByNameQuery;

import java.util.List;
import java.util.Optional;

public interface ClubQueryService {
    Optional<Club> handle(GetClubByIdQuery query);
    Optional<Club> handle(GetClubByNameQuery query);
    List<Club> handle(GetAllClubsQuery query);
}
