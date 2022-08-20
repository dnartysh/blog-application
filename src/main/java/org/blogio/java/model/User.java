package org.blogio.java.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private boolean isModerator;

    @NotNull
    @JoinColumn(name = "reg_time")
    @JsonIgnore
    private Date regTime;

    @NotNull
    private String name;

    @NotNull
    @JsonIgnore
    private String email;

    @NotNull
    @JsonIgnore
    private String password;

    @JsonIgnore
    private String code;

    @JsonIgnore
    private String photo;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Post> posts;

    @OneToMany(mappedBy = "moderator", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Post> moderatedPosts;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PostVote> postVotes;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PostComment> postComments;
}
