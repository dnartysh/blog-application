package org.blogio.java.repository;

import org.blogio.java.model.Tag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TagRepository extends CrudRepository<Tag, Integer> {
    @Query(value = "select * from tags where name like :tagName", nativeQuery = true)
    List<Tag> findTagsByTagName(@Param("tagName") String tagName);

    @Query(value = "select tags.id, name, count(*) as count from tags, tag2post where tags.id = tag2post.tag_id group by id, name order by count desc limit 1", nativeQuery = true)
    Tag findMostPopularTag();

    @Query(value = "select count(*) from tag2post where tag_id = :tagId", nativeQuery = true)
    int findCountPostsByTagId(@Param("tagId") int tagId);
}
