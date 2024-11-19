package com.acme.mindflicks.platform.content.domain.model.queries;

public record GetContentByNameQuery(String name) {
    public GetContentByNameQuery {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null or empty");
        }
    }
}
