package dev.akinbobobla.blogapi.dtos;

import java.time.LocalDateTime;
import java.util.List;

public record UpdatePostDto(
        Integer id,
        String title,
        String content,
        String category,
        List<String> tags,
        LocalDateTime updatedAt,
        LocalDateTime createdAt
) {
}
