package com.acme.mindflicks.platform.events.interfaces.rest;

public record CreateEventResource(String title, String contentId) {

    public CreateEventResource {
        if (title == null || title.isBlank())
            throw new IllegalArgumentException("title cannot be null or empty");
        if (contentId == null || contentId.isBlank())
            throw new IllegalArgumentException("contentId cannot be null or empty");
    }
}
