package com.acme.mindflicks.platform.events.domain.model.queries;

public record GetEventByContentIdQuery(Long id) {
    public GetEventByContentIdQuery {
        if (id == null)
            throw new IllegalArgumentException("id cannot be null");
    }
}
