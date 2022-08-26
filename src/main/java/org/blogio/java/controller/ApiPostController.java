package org.blogio.java.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.blogio.java.api.response.PostResponse;
import org.blogio.java.view.UserView;
import org.blogio.java.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post")
public class ApiPostController {
    private final PostService postService;

    public ApiPostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping()
    @JsonView(UserView.Post.class)
    public PostResponse test(@RequestParam(defaultValue = "0") int offset,
                             @RequestParam(defaultValue = "10") int limit,
                             @RequestParam(defaultValue = "recent") String mode) {
        return postService.getPosts(offset, limit, mode);
    }
}
