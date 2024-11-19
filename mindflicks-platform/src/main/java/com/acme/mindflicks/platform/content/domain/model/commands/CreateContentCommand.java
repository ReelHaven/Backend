package com.acme.mindflicks.platform.content.domain.model.commands;

public record CreateContentCommand(Long creatorId, String type, String title, String description, 
                                   String category, String objective, String feeling, String list, String image) {

    public CreateContentCommand {
        if (creatorId == null) {
            throw new IllegalArgumentException("creatorId cannot be null");
        }
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("type cannot be null or empty");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title cannot be null or empty");
        }
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("description cannot be null or empty");
        }
        if (category == null || category.isBlank()) {
            throw new IllegalArgumentException("category cannot be null or empty");
        }
        if (objective == null || objective.isBlank()) {
            throw new IllegalArgumentException("objective cannot be null or empty");
        }
        if (feeling == null || feeling.isBlank()) {
            throw new IllegalArgumentException("feeling cannot be null or empty");
        }
        if (list == null || list.isBlank()) {
            throw new IllegalArgumentException("list cannot be null or empty");
        }
        if (image == null || image.isBlank()) {
            throw new IllegalArgumentException("image cannot be null or empty");
        }
    }
}