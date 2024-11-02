package com.acme.mindflicks.platform.events_1.interfaces.rest;

import com.acme.mindflicks.platform.events_1.domain.model.aggregates.Event;

public class EventResourceFromEntityAssembler {
    public static EventResource toResourceFromEntity(Event entity){
        return new EventResource(entity.getId(), entity.getTitle(), entity.getContentId());
    }
}
