package dev.akinbobobla.blogapi.dtos;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record CreatePostDto(
        @NotEmpty(message = "Title cannot be empty")
        String title,

        @NotEmpty(message = "Content cannot be empty")
        String content,

        @NotEmpty(message = "Category cannot be empty")
        String category,

        @NotEmpty(message = "Tags cannot be empty")
        List<String> tags
) {
}
