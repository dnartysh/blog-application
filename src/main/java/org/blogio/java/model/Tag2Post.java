package org.blogio.java.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Table(name = "tag2post")
public class Tag2Post {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @JoinColumn(name = "post_id")
    @OneToOne(cascade = CascadeType.ALL)
    private Post post;

    @NotNull
    @JoinColumn(name = "tag_id")
    @OneToOne(cascade = CascadeType.ALL)
    private Tag tag;
}
