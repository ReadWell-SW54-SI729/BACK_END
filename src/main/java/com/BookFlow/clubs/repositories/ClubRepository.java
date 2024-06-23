package com.BookFlow.clubs.repositories;

import com.BookFlow.clubs.domain.model.aggregates.Club;
import com.BookFlow.clubs.domain.model.valueobjects.ClubName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {
    Optional<Club> findByClubTitle(ClubName clubTitle);
}
