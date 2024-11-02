package com.acme.mindflicks.platform.content.domain.model.queries;

public record GetContentByIdQuery(Long contentId) {
    public GetContentByIdQuery {
        if (contentId == null) {
            throw new IllegalArgumentException("contentId cannot be null");
        }
    }
}