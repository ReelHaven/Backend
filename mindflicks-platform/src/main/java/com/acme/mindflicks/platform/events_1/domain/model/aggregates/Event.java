package com.acme.mindflicks.platform.events_1.domain.model.aggregates;

import com.acme.mindflicks.platform.events_1.domain.model.commands.CreateEventCommand;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Event extends AbstractAggregateRoot<Event> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    @Column(nullable = false)
    private String title;

    @Getter
    @Column(nullable = false)
    private String description;

    @Getter
    @Column(nullable = false)
    private Date startDate;

    @Getter
    @Column(nullable = false)
    private Date endDate;

    @Column(nullable = false, updatable = false)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @LastModifiedDate
    private Date updatedAt;

    protected Event() {}

    /**
     * @summary Constructor for Event
     * It creates a new Event instance based on the CreateEventCommand command.
     * @param command - The CreateEventCommand command
     */
    public Event(CreateEventCommand command) {
        this.title = command.title();
        this.description = command.description();
        this.startDate = command.startDate();
        this.endDate = command.endDate();
    }
}
