package com.acme.mindflicks.platform.events_1.application.internal;

import com.acme.mindflicks.platform.events_1.domain.model.commands.CreateEventCommand;
import com.acme.mindflicks.platform.events_1.domain.model.aggregates.Event;
import com.acme.mindflicks.platform.events_1.domain.services.EventCommandService;
import com.acme.mindflicks.platform.events_1.infrastructure.persistence.jpa.EventRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventCommandServiceImpl implements EventCommandService {

    private final EventRepository eventRepository;

    public EventCommandServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    /**
     * Handles the create Event command
     *
     * @param command The create Event command
     * @throws IllegalArgumentException if the title or start date is null or empty
     * @see CreateEventCommand
     */
    @Override
    public Optional<Event> handle(CreateEventCommand command) {
        if (eventRepository.existsByTitleAndStartDate(command.title(), command.startDate())) {
            throw new IllegalArgumentException("Event with this title and start date already exists");
        }
        var event = new Event(command);
        var createdEvent = eventRepository.save(event);
        return Optional.of(createdEvent);
    }
}
