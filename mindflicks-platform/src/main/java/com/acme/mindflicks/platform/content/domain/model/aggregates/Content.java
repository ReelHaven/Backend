package com.acme.mindflicks.platform.content.domain.model.aggregates;

import com.acme.mindflicks.platform.content.domain.model.commands.CreateContentCommand;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(nullable = false)
    @Getter
    private String creatorId;

    @Column(nullable = false)
    @Getter
    private String type;

    @Column(nullable = false)
    @Getter
    private String title;

    @Column(nullable = false)
    @Getter
    private String description;

    @Column(nullable = false)
    @Getter
    private String category;

    @Column(nullable = false)
    @Getter
    private String objective;

    @Column(nullable = false)
    @Getter
    private String feeling;

    @Column(nullable = false)
    @Getter
    private String image;

    /*
    @Column(nullable = true, updatable = false)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = true)
    @LastModifiedDate
    private Date updatedAt;
*/
    protected  Content() {}

    public Content(CreateContentCommand command) {
        this.type = command.type();
        this.creatorId = command.creatorId();
        this.title = command.title();
        this.description = command.description();
        this.category = command.category();
        this.objective = command.objective();
        this.feeling = command.feeling();
        this.image = command.image();
    }
}
