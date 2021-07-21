package org.blogio.java.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "posts")
public class PostModel {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Column(name = "is_active")
    private boolean isActive;

    @NotNull
    @Column(name = "moderation_status")
    @Enumerated(EnumType.STRING)
    private PostStatus moderationStatus;

    @Column(name = "moderator_id")
    private int moderatorId;

    @NotNull
    @Column(name = "user_id")
    private int userId;

    @NotNull
    private Date time;

    @NotNull
    private String title;

    @NotNull
    private String text;

    @NotNull
    @Column(name = "view_count")
    private int viewCount;
}
