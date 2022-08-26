package org.blogio.java.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "posts")
public class Post {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @JoinColumn(name = "is_active")
    private boolean isActive;

    @NotNull
    @JoinColumn(name = "moderation_status")
    @Enumerated(EnumType.STRING)
    private PostStatus moderationStatus;

    @JoinColumn(name = "moderator_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private User moderator;

    @NotNull
    @JoinColumn(name = "user_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    @NotNull
    private Date time;

    @NotNull
    private String title;

    @NotNull
    private String text;

    @NotNull
    @JoinColumn(name = "view_count")
    private int viewCount;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<PostVote> postVotes;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<PostComment> postComments;
}