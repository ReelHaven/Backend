package com.acme.mindflicks.platform.events_1.domain.model.queries;

/**
 * Query to get all events by content ID
 * @param contentId The ID of the content
 * @summary Query to get all events by content ID
 */
public record GetAllEventsByContentIdQuery(String contentId) {
    public GetAllEventsByContentIdQuery {
        if (contentId == null || contentId.isBlank()) {
            throw new IllegalArgumentException("contentId cannot be null or empty");
        }
    }
}
