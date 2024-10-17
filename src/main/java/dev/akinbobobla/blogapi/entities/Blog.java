package dev.akinbobobla.blogapi.entities;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Blog {
    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    private String content;

    private String category;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @ElementCollection
    private List<String> tags;
}
