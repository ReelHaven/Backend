package com.acme.mindflicks.platform.events_1.infrastructure.persistence.jpa;

import com.acme.mindflicks.platform.events_1.domain.model.aggregates.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * JPA repository for Event entity
 * @summary JPA repository for Event entity
 * This interface extends JpaRepository, which provides all the CRUD operations for the Event entity.
 * It extends JpaRepository with Event as the entity and Long as the type of the primary key.
 */
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    /**
     * Find all events by title
     * @param title The title of the event
     * @return List of events with the specified title
     */
    List<Event> findAllByTitle(String title);

    /**
     * Check if an Event exists by title and startDate
     * @param title The title of the event
     * @param startDate The start date of the event
     * @return True if an Event exists with the specified title and start date, false otherwise
     */
    boolean existsByTitleAndStartDate(String title, Date startDate);

    /**
     * Find an event by title and start date
     * @param title The title of the event
     * @param startDate The start date of the event
     * @return Optional containing the Event if found, otherwise empty
     */
    Optional<Event> findByTitleAndStartDate(String title, Date startDate);
}
