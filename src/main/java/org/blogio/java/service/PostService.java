package org.blogio.java.service;

import org.blogio.java.api.response.PostResponse;
import org.blogio.java.api.response.model.PostSimple;
import org.blogio.java.model.Post;
import org.blogio.java.model.PostComment;
import org.blogio.java.model.PostVote;
import org.blogio.java.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private final int ANNOUNCE_MAX_WIDTH = 150;
    private PostRepository postRepository;
    private PostResponse postResponse;

    public PostService(PostRepository postRepository, PostResponse postResponse) {
        this.postRepository = postRepository;
        this.postResponse = postResponse;
    }

    public PostResponse getPosts(int offset, int limit, String mode) {
        List<PostSimple> postSimples = new ArrayList<>();
        int postsCount = postRepository.findCountPosts();
        List<Post> posts = postRepository.findPostsWithOffsetAndLimit(offset, limit);

        posts.forEach(post -> {
            PostSimple postSimple = new PostSimple(post.getId(),
                    post.getTime().getTime(),
                    post.getUser(),
                    post.getTitle(),
                    getAnnounce(post.getText()),
                    getPostVoteCount(post.getPostVotes(), true),
                    getPostVoteCount(post.getPostVotes(), false),
                    getCommentCount(post.getPostComments()),
                    post.getViewCount());

            postSimples.add(postSimple);
        });

        postResponse.setCount(postsCount);
        postResponse.setPosts(postSimples);

        return postResponse;
    }

    private String getAnnounce(String text) {
        return text.substring(0, ANNOUNCE_MAX_WIDTH) + "...";
    }

    private Long getPostVoteCount(List<PostVote> votes, boolean isLike) {
        return votes.stream().filter(p -> p.isValue() == isLike).count();
    }

    private int getCommentCount(List<PostComment> comments) {
        return comments.size();
    }
}
