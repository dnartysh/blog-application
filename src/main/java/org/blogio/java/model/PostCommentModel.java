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

    @Column(name = "parent_id")
    private int parentId;

    @NotNull
    @Column(name = "post_id")
    private int postId;

    @NotNull
    @Column(name = "user_id")
    private int userId;

    @NotNull
    private Date time;

    @NotNull
    private String text;
}
