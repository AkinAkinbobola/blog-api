package dev.akinbobobla.blogapi.services;

import dev.akinbobobla.blogapi.dtos.CreatePostDto;
import dev.akinbobobla.blogapi.dtos.UpdatePostDto;
import dev.akinbobobla.blogapi.entities.Blog;
import dev.akinbobobla.blogapi.repositories.BlogRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public Blog createPost(CreatePostDto dto) {
        Blog blog = new Blog();
        blog.setTitle(dto.title());
        blog.setContent(dto.content());
        blog.setCategory(dto.category());
        blog.setTags(dto.tags());
        blog.setCreatedAt(LocalDateTime.now());
        blog.setUpdatedAt(LocalDateTime.now());
        return blogRepository.save(blog);
    }

    public Blog updatePost(Integer id, UpdatePostDto dto) {
        Blog blog = blogRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, Blog.class.getName()));

        if(dto.title() != null) {
            blog.setTitle(dto.title());
        }

        if(dto.content() != null) {
            blog.setContent(dto.content());
        }

        if (dto.category() != null) {
            blog.setCategory(dto.category());
        }

        if(dto.tags() != null && !dto.tags().isEmpty()) {
            blog.setTags(dto.tags());
        }

        blog.setUpdatedAt(LocalDateTime.now());

        return blogRepository.save(blog);
    }

    public List<Blog> getAllPosts() {
        return blogRepository.findAll();
    }

    public Blog getPostById(Integer id) {
        return blogRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, Blog.class.getName()));
    }

    public void deletePost(Integer id) {
        blogRepository.deleteById(id);
    }

}
