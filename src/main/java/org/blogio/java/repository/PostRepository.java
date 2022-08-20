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

    @Query(value = "select * from posts where is_active = true and moderation_status = 'ACCEPTED' and time <= now() limit :limit offset :offset", nativeQuery = true)
    List<Post> findPostsWithOffsetAndLimit(@Param("offset") int offset, @Param("limit") int limit);
}
