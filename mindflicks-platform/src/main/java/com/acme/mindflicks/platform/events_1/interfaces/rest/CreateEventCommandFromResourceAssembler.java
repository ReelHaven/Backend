package com.acme.mindflicks.platform.events_1.interfaces.rest;

import com.acme.mindflicks.platform.events_1.domain.model.commands.CreateEventCommand;

/**
 * Assembler to convert a CreateEventResource to a CreateEventCommand
 */
public class CreateEventCommandFromResourceAssembler {
    public static CreateEventCommand toCommandFromResource(CreateEventResource resource) {
        return new CreateEventCommand(resource.title(), resource.contentId());
    }
}
