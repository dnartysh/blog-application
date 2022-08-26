package org.blogio.java.api.response.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.blogio.java.model.User;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseModel {
    private int id;
    private long timestamp;
    private User user;
    private String title;
    private String announce;
    private long likeCount;
    private long dislikeCount;
    private long commentCount;
    private long viewCount;
}
