package dev.akinbobobla.blogapi.repositories;

import dev.akinbobobla.blogapi.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface BlogRepository extends JpaRepository<Blog, Integer> {
    @Query("SELECT b FROM Blog b WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :term, '%')) " +
            "OR LOWER(b.content) LIKE LOWER(CONCAT('%', :term, '%')) " +
            "OR LOWER(b.category) LIKE LOWER(CONCAT('%', :term, '%'))")
    List<Blog> searchByTerm(@Param("term") String term);
}
