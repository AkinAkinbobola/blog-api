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
@RequestMapping("/api/v1/posts")
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Blog createPost(@Valid @RequestBody CreatePostDto dto) {
        return blogService.createPost(dto);
    }

    @PutMapping("/{id}")
    Blog updatePost(@PathVariable Integer id, @Valid @RequestBody UpdatePostDto dto) {
        return blogService.updatePost(id, dto);
    }

    @GetMapping
    List<Blog> getAllPosts(@RequestParam(name = "term", required = false) String term) {
        return blogService.getAllPosts(term);
    }

    @GetMapping("/{id}")
    Blog getPostById(@PathVariable Integer id) {
        return blogService.getPostById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePost(@PathVariable Integer id) {
        blogService.deletePost(id);
    }
}
