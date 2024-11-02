package com.acme.mindflicks.platform.content.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Content extends AbstractAggregateRoot<Content> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long contentId;

    @Getter
    private Long creatorId;

    @Getter
    private String type;

    @Getter
    private String title;

    @Getter
    private String description;

    @Getter
    private String category;

    @Getter
    private String objective;

    @Getter
    private String feeling;

    @Getter
    private String list;

    @Getter
    private String image;

    protected Content() {}

    public Content(Long creatorId, String type, String title, String description, String category, 
                   String objective, String feeling, String list, String image) {
        this.creatorId = creatorId;
        this.type = type;
        this.title = title;
        this.description = description;
        this.category = category;
        this.objective = objective;
        this.feeling = feeling;
        this.list = list;
        this.image = image;
    }
}