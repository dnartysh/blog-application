package org.blogio.java.service;

import org.blogio.java.api.response.PostResponse;
import org.blogio.java.api.response.model.PostResponseModel;
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
        postResponse.setCount(getCountPosts());
        postResponse.setPosts(getPostResponseModels(getPostsByMode(offset, limit, mode)));

        return postResponse;
    }

    public PostResponse getPostsByQuery(int offset, int limit, String query) {
        List<Post> posts = postRepository.findPostsByQueryWithOffsetAndLimit(offset, limit, "%" + query + "%");

        postResponse.setCount(posts.size());
        postResponse.setPosts(getPostResponseModels(posts));

        return postResponse;
    }

    private List<PostResponseModel> getPostResponseModels(List<Post> posts) {
        List<PostResponseModel> postSimples = new ArrayList<>();

        posts.forEach(post -> {
            PostResponseModel postSimple = new PostResponseModel(post.getId(),
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

        return postSimples;
    }

    private int getCountPosts() {
        return postRepository.findCountPosts();
    }

    private List<Post> getPostsByMode(int offset, int limit, String mode) {
        switch (mode) {
            case "popular":
                return postRepository.findPopularPostsWithOffsetAndLimit(offset, limit);
            case "best":
                return postRepository.findBestPostsWithOffsetAndLimit(offset, limit);
            case "early":
                return postRepository.findEarlyPostsWithOffsetAndLimit(offset, limit);
            default:
                return postRepository.findPostsWithOffsetAndLimit(offset, limit);
        }
    }

    private String getAnnounce(String text) {
        if (text.length() < ANNOUNCE_MAX_WIDTH) {
            return text + "...";
        } else {
            return text.substring(0, ANNOUNCE_MAX_WIDTH) + "...";
        }
    }

    private Long getPostVoteCount(List<PostVote> votes, boolean isLike) {
        return votes.stream().filter(p -> p.isValue() == isLike).count();
    }

    private int getCommentCount(List<PostComment> comments) {
        return comments.size();
    }
}
