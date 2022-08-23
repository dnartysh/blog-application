package org.blogio.java.repository;

import org.blogio.java.model.Tag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends CrudRepository<Tag, Integer> {
    @Query(value = "select * from tags where name like :tagName", nativeQuery = true)
    List<Tag> findTagsByTagName(@Param("tagName") String tagName);
}
