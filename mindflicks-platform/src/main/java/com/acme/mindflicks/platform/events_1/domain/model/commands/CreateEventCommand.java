package com.acme.mindflicks.platform.events_1.domain.model.commands;

import java.util.Date;

/**
 * Command to create an event
 * @param title The title of the event
 * @param description The description of the event
 * @param startDate The start date of the event
 * @param endDate The end date of the event
 * @summary Command to create an event
 */
public record CreateEventCommand(String title, String description, Date startDate, Date endDate) {

    public CreateEventCommand {
        if (title == null || title.isBlank())
            throw new IllegalArgumentException("title cannot be null or empty");
        if (description == null || description.isBlank())
            throw new IllegalArgumentException("description cannot be null or empty");
        if (startDate == null)
            throw new IllegalArgumentException("startDate cannot be null");
        if (endDate == null)
            throw new IllegalArgumentException("endDate cannot be null");
        if (endDate.before(startDate))
            throw new IllegalArgumentException("endDate cannot be before startDate");
    }
}
