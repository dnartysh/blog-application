package org.blogio.java.api.response;

import lombok.Getter;
import lombok.Setter;
import org.blogio.java.model.Post;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
@Getter
@Setter
public class PostResponse {
    private int count;
    private List<Post> posts;

    public PostResponse(int count, List<Post> posts) {
        this.count = count;
        this.posts = posts;
    }

    public PostResponse() {
        this.count = 0;
        this.posts = new ArrayList<>();
    }

    public void addPost(Post post) {
//        PostTest postTest = new PostTest("rr");
//        posts.add(postTest);



        if (!posts.contains(post)) posts.add(post);
    }
}

class PostTest {
    private String test;

    public PostTest(String test) {
        this.test = test;
    }

    public PostTest() {

    }
}
