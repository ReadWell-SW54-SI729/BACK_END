package com.BookFlow.clubs.domain.services;

import com.BookFlow.clubs.domain.model.aggregates.Comment;
import com.BookFlow.clubs.domain.model.commands.CreateCommentCommand;

import java.util.Optional;

public interface CommentCommandService {
    Optional<Comment> handle(CreateCommentCommand command);
}