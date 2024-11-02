package com.acme.mindflicks.platform.events_1.domain.model.commands;

/**
 * Command to create an event
 * @param title The title of the event
 * @param contentId the id content of the event
 * @summary Command to create an event
 */
public record CreateEventCommand(String title, String contentId) {

    public CreateEventCommand {
        if (title == null || title.isBlank())
            throw new IllegalArgumentException("title cannot be null or empty");
        if (contentId == null || contentId.isBlank())
            throw new IllegalArgumentException("content cannot be null or empty");
    }
}
