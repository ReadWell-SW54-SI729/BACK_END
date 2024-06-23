package com.BookFlow.clubs.domain.services;

import com.BookFlow.clubs.domain.model.aggregates.Comment;
import com.BookFlow.clubs.domain.model.queries.GetAllCommentsQuery;
import com.BookFlow.clubs.domain.model.queries.GetCommentByIdQuery;
import com.BookFlow.clubs.domain.model.queries.GetCommentByNameQuery;

import java.util.List;
import java.util.Optional;

public interface CommentQueryService {
    Optional<Comment> handle(GetCommentByIdQuery query);
    Optional<Comment> handle(GetCommentByNameQuery query);
    List<Comment> handle(GetAllCommentsQuery query);
}
