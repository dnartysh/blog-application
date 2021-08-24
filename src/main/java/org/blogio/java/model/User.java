package org.blogio.java.model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import org.blogio.java.view.UserView;

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
    @JsonView(UserView.Normal.class)
    private String name;

    @NotNull
    @JsonView(UserView.Normal.class)
    private String email;

    @NotNull
    @JsonView(UserView.Normal.class)
    private String password;

    private String code;

    private String photo;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonView(UserView.Normal.class)
    private List<Post> posts;

    @OneToMany(mappedBy = "moderator", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonView(UserView.Normal.class)
    private List<Post> moderatedPosts;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonView(UserView.Normal.class)
    private List<PostVote> postVotes;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonView(UserView.Normal.class)
    private List<PostComment> postComments;
}
