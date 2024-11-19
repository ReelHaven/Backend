package com.acme.mindflicks.platform.events.interfaces.rest;

import com.acme.mindflicks.platform.events.domain.model.aggregates.Event;

public class EventResourceFromEntityAssembler {
    public static EventResource toResourceFromEntity(Event entity){
        return new EventResource(entity.getId(), entity.getTitle(), entity.getContentId());
    }
}
