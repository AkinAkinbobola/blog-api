package dev.akinbobobla.blogapi.repositories;

import dev.akinbobobla.blogapi.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
}
