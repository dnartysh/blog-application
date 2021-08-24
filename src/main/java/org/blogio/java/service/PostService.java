package org.blogio.java.service;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.IterableUtils;
import org.blogio.java.api.response.PostResponse;
import org.blogio.java.model.Post;
import org.blogio.java.model.PostComment;
import org.blogio.java.model.PostVote;
import org.blogio.java.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Getter
@Setter
public class PostService {
    private final PostRepository postRepository;
    private final PostResponse postResponse;

    public PostService(PostRepository postRepository, PostResponse postResponse) {
        this.postRepository = postRepository;
        this.postResponse = postResponse;
    }

    public PostResponse getPosts(int offset, int limit, String mode) {
        Iterable<Post> posts = postRepository.findAll();
        int count = IterableUtils.size(posts);

//        postResponse.

        if (count > 0) postResponse.setCount(count);

        posts.forEach(postResponse::addPost);

        return postResponse;
    }

    private Long getPostVoteCount(List<PostVote> votes, boolean isLike) {
        return votes.stream().filter(p -> p.isValue() == isLike).count();
    }

    private int getCommentCount(List<PostComment> comments) {
        return comments.size();
    }
}
