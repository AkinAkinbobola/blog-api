package dev.akinbobobla.blogapi.services;

import dev.akinbobobla.blogapi.dtos.BlogDto;
import dev.akinbobobla.blogapi.entities.Blog;
import dev.akinbobobla.blogapi.repositories.BlogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public Blog createPost(BlogDto dto) {
        Blog blog = new Blog();
        blog.setTitle(dto.title());
        blog.setContent(dto.content());
        blog.setCategory(dto.category());
        blog.setTags(dto.tags());
        blog.setCreatedAt(LocalDateTime.now());
        blog.setUpdatedAt(LocalDateTime.now());
        return blogRepository.save(blog);
    }

}
