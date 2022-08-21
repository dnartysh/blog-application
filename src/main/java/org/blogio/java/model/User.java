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
    @JsonView({UserView.Public.class, UserView.Post.class})
    private int id;

    @NotNull
    @JoinColumn(name = "is_moderator")
    @JsonView(UserView.Internal.class)
    private boolean isModerator;

    @NotNull
    @JoinColumn(name = "reg_time")
    @JsonView(UserView.Internal.class)
    private Date regTime;

    @NotNull
    @JsonView({UserView.Public.class, UserView.Post.class})
    private String name;

    @NotNull
    @JsonView(UserView.Public.class)
    private String email;

    @NotNull
    @JsonView(UserView.Internal.class)
    private String password;

    @JsonView(UserView.Public.class)
    private String code;

    @JsonView(UserView.Public.class)
    private String photo;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonView(UserView.Internal.class)
    private List<Post> posts;

    @OneToMany(mappedBy = "moderator", cascade = CascadeType.ALL)
    @JsonView(UserView.Internal.class)
    private List<Post> moderatedPosts;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonView(UserView.Internal.class)
    private List<PostVote> postVotes;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonView(UserView.Internal.class)
    private List<PostComment> postComments;
}
