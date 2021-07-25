package org.blogio.java.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "post_votes")
public class PostVotesModel {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @JoinColumn(name = "user_id")
    @OneToOne(cascade = CascadeType.ALL)
    private UserModel userId;

    @NotNull
    @JoinColumn(name = "post_id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private PostModel postId;

    @NotNull
    private Date time;

    @NotNull
    private boolean value;
}
