package org.blogio.java.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "post_comments")
public class PostCommentModel {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @JoinColumn(name = "parent_id")
    private int parentId;

    @NotNull
    @JoinColumn(name = "post_id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private PostModel postId;

    @NotNull
    @JoinColumn(name = "user_id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserModel userId;

    @NotNull
    private Date time;

    @NotNull
    private String text;
}