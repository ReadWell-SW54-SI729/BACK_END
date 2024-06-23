package com.BookFlow.clubs.domain.model.aggregates;

import com.BookFlow.clubs.domain.model.commands.CreateCommentCommand;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Entity
@Getter
public class Comment {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @NotBlank(message = "Comment content is mandatory")
    @Column
    private String name;

    public Comment(Long commentId, String content) {
        this.commentId = commentId;
        this.name = content;
    }
    public Comment(CreateCommentCommand command) {
        this.name = command.content();
    }
    public Comment() {
    }

    public Long getCommentId(){
        return commentId;
    }
    public String getCommentContent(){
        return name;
    }

}
