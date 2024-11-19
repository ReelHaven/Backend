package com.acme.mindflicks.platform.events.interfaces.rest;

import com.acme.mindflicks.platform.events.domain.model.commands.CreateEventCommand;

/**
 * Assembler to convert a CreateEventResource to a CreateEventCommand
 */
public class CreateEventCommandFromResourceAssembler {
    public static CreateEventCommand toCommandFromResource(CreateEventResource resource) {
        return new CreateEventCommand(resource.title(), resource.contentId());
    }
}
