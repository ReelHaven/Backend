package com.acme.mindflicks.platform.content.domain.services;

import com.acme.mindflicks.platform.content.domain.model.aggregates.Content;
import com.acme.mindflicks.platform.content.domain.model.queries.GetContentByIdQuery;
import com.acme.mindflicks.platform.content.domain.model.queries.GetContentByNameQuery;

import java.util.Optional;

public interface ContentQueryService {
    Optional<Content> handle(GetContentByIdQuery query);

    Optional<Content> handle(GetContentByNameQuery query);
}