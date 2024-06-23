package com.BookFlow.clubs.rest.transform;

import com.BookFlow.clubs.domain.model.aggregates.Comment;
import com.BookFlow.clubs.rest.resources.CommentResource;

public class CommentResourceFromEntityAssembler {
    public static CommentResource toResourceFromEntity(Comment comment) {
        return new CommentResource(comment.getCommentId(), comment.getCommentContent());
    }
}
