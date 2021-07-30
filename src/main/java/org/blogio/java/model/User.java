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
@Table(name = "users")
public class User {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @JoinColumn(name = "is_moderator")
    private boolean isModerator;

    @NotNull
    @JoinColumn(name = "reg_time")
    private Date regTime;

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String password;

    private String code;

    private String photo;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Post> posts;

    @OneToMany(mappedBy = "moderator", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Post> moderatedPosts;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private PostVote postVote;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PostComment> postComments;
}
