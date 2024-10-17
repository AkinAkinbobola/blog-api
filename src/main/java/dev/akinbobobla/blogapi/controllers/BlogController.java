package dev.akinbobobla.blogapi.controllers;

import dev.akinbobobla.blogapi.dtos.CreatePostDto;
import dev.akinbobobla.blogapi.dtos.UpdatePostDto;
import dev.akinbobobla.blogapi.entities.Blog;
import dev.akinbobobla.blogapi.services.BlogService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/api/v1/posts")
    @ResponseStatus(HttpStatus.CREATED)
    Blog createPost(@Valid @RequestBody CreatePostDto dto) {
        return blogService.createPost(dto);
    }

    @PutMapping("/api/v1/posts/{id}")
    Blog updatePost(@PathVariable Integer id, @Valid @RequestBody UpdatePostDto dto) {
        return blogService.updatePost(id, dto);
    }

    @GetMapping("/api/v1/posts")
    List<Blog> getAllPosts() {
        return blogService.getAllPosts();
    }

    @GetMapping("/api/v1/posts/{id}")
    Blog getPostById(@PathVariable Integer id) {
        return blogService.getPostById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePost(@PathVariable Integer id) {
        blogService.deletePost(id);
    }
}
