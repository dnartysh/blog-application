package org.blogio.java.api.response;

import lombok.Getter;
import lombok.Setter;
import org.blogio.java.api.response.model.PostSimple;
import org.blogio.java.model.Post;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
@Getter
@Setter
public class PostResponse {
    private int count;
    private List<PostSimple> posts;

    public PostResponse(int count, List<PostSimple> posts) {
        this.count = count;
        this.posts = posts;
    }

    public PostResponse() {
        this.count = 0;
        this.posts = new ArrayList<>();
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void addPost(PostSimple post) {
        if (!posts.contains(post)) posts.add(post);
    }
}