package com.BookFlow.clubs.domain.model.commands;

public record CreateClubCommand(
        String clubTitle,
        Long clubCommentId,
        String clubImage,
        String clubDescription,
        String clubAuthor
) {}
