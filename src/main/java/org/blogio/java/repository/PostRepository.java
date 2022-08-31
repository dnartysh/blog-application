package org.blogio.java.repository;

import org.blogio.java.model.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {
    @Query(value = "select count(*) from posts where is_active = true and moderation_status = 'ACCEPTED' and time <= now()", nativeQuery = true)
    int findCountPosts();

    @Query(value = "select * from posts where is_active = true and moderation_status = 'ACCEPTED' " +
            "and time <= now() order by time desc limit :limit offset :offset", nativeQuery = true)
    List<Post> findPostsWithOffsetAndLimit(@Param("offset") int offset, @Param("limit") int limit);

    @Query(value = "select posts.id, posts.is_active, posts.moderation_status, " +
            "posts.moderator_id, posts.text, posts.time, posts.title, posts.view_count, " +
            "posts.user_id, (select count(*) from post_comments where posts.id = post_comments.post_id) as count" +
            " from posts, post_comments where is_active = true and moderation_status = 'ACCEPTED' " +
            "and posts.time <= now() group by posts.id order by count desc limit :limit offset :offset", nativeQuery = true)
    List<Post> findPopularPostsWithOffsetAndLimit(@Param("offset") int offset, @Param("limit") int limit);

    @Query(value = "select id, is_active, moderation_status, moderator_id, text, time, title, view_count, user_id, " +
            "(select count(*) from post_votes where posts.id = post_votes.post_id) as count " +
            "from posts where is_active = true and moderation_status = 'ACCEPTED' and time <= now() " +
            "group by id order by count desc limit :limit offset :offset", nativeQuery = true)
    List<Post> findBestPostsWithOffsetAndLimit(@Param("offset") int offset, @Param("limit") int limit);

    @Query(value = "select * from posts where is_active = true and moderation_status = 'ACCEPTED' " +
            "and time <= now() order by time limit :limit offset :offset", nativeQuery = true)
    List<Post> findEarlyPostsWithOffsetAndLimit(@Param("offset") int offset, @Param("limit") int limit);

    @Query(value = "select * from posts where id in " +
            "(select post_id from tag2post where tag_id = :tagId) and is_active = true " +
            "and moderation_status = 'ACCEPTED' and time <= now()", nativeQuery = true)
    List<Post> findPostsByTagId(@Param("tagId") int tagId);

    @Query(value = "select * from posts where title like :query " +
            "and is_active = true and moderation_status = 'ACCEPTED' " +
            "and time <= now() limit :limit offset :offset", nativeQuery = true)
    List<Post> findPostsByQueryWithOffsetAndLimit(@Param("offset") int offset, @Param("limit") int limit, @Param("query") String query);
}
