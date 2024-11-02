package com.acme.mindflicks.platform.events_1.interfaces.rest;

import com.acme.mindflicks.platform.events_1.domain.model.aggregates.Event;
import com.acme.mindflicks.platform.events_1.domain.services.EventCommandService;
import com.acme.mindflicks.platform.events_1.domain.services.EventQueryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/events", produces = APPLICATION_JSON_VALUE)
public class EventController {
    private final EventCommandService eventCommandService;
    private final EventQueryService eventQueryService;

    public EventController(EventCommandService eventCommandService, EventQueryService eventQueryService) {
        this.eventCommandService = eventCommandService;
        this.eventQueryService = eventQueryService;
    }

    @PostMapping
    public ResponseEntity<EventResource> createEvent(CreateEventResource resource) {
        Optional<Event> event = eventCommandService.handle(CreateEventCommandFromResourceAssembler.toCommandFromResource(resource));
        return event.map(evt -> new ResponseEntity<>(EventResourceFromEntityAssembler.toResourceFromEntity(evt), CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
