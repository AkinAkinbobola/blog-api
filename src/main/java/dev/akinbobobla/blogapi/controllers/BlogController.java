package dev.akinbobobla.blogapi.controllers;

import dev.akinbobobla.blogapi.dtos.BlogDto;
import dev.akinbobobla.blogapi.entities.Blog;
import dev.akinbobobla.blogapi.services.BlogService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/api/v1/blog")
    @ResponseStatus(HttpStatus.CREATED)
    Blog createPost(@Valid @RequestBody BlogDto dto) {
        return blogService.createPost(dto);
    }
}
