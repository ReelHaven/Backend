package com.acme.mindflicks.platform.events_1.domain.model.queries;

/**
 * Query to get an event by title
 * @param title The title of the event
 * @summary Query to get an event by title
 */
public record GetEventByTitleQuery(String title) {
    public GetEventByTitleQuery {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title cannot be null or empty");
        }
    }
}
