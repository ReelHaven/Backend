package com.acme.mindflicks.platform.content.interfaces.rest;

import com.acme.mindflicks.platform.content.domain.model.aggregates.Content;
import com.acme.mindflicks.platform.content.domain.model.queries.*;
import com.acme.mindflicks.platform.content.domain.services.ContentCommandService;
import com.acme.mindflicks.platform.content.domain.services.ContentQueryService;
import com.acme.mindflicks.platform.content.interfaces.rest.resources.ContentResource;
import com.acme.mindflicks.platform.content.interfaces.rest.resources.CreateContentResource;
import com.acme.mindflicks.platform.content.interfaces.rest.transform.ContentResourceFromEntityAssembler;
import com.acme.mindflicks.platform.content.interfaces.rest.transform.CreateContentCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//import java.util.Map;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/content", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Content", description = "Operations related to content")
public class ContentController {
    private final ContentQueryService contentQueryService;
    private final ContentCommandService contentCommandService;

    public ContentController(ContentQueryService contentQueryService, ContentCommandService contentCommandService) {
        this.contentQueryService = contentQueryService;
        this.contentCommandService = contentCommandService;
    }

    @Operation(
            summary = "Create content",
            description = "Create content with the provided parameters"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Content created"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
    })
    @PostMapping
    public ResponseEntity<ContentResource> createContent(@RequestBody CreateContentResource resource) {
        Optional<Content> content = contentCommandService
                .handle(CreateContentCommandFromResourceAssembler.toCommand(resource));
        return content.map(source -> new ResponseEntity<>(ContentResourceFromEntityAssembler.toResourceFromEntity(source), CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @Operation(
            summary = "Get all content",
            description = "Get all content in database"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "get All Content"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
    })
    @GetMapping("/contents")
    public ResponseEntity<List<ContentResource>> getAllContents() {
        var getAllContentsQuery = new GetAllContentQuery();
        var contents = contentQueryService.handle(getAllContentsQuery);
        if (contents.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var contentResources = contents.stream()
                .map(ContentResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(contentResources);
    }

    private ResponseEntity<List<ContentResource>> getAllContentsByTitle(String title) {
        var getAllContentsByTitleQuery = new GetAllContentByTitleQuery(title);
        var contents = contentQueryService.handle(getAllContentsByTitleQuery);
        if (contents.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var contentResources = contents.stream()
                .map(ContentResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(contentResources);
    }

    private ResponseEntity<List<ContentResource>> getAllContentsByType(String type) {
        var getAllContentsByTypeQuery = new GetAllContentByTypeQuery(type);
        var contents = contentQueryService.handle(getAllContentsByTypeQuery);
        if (contents.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var contentResources = contents.stream()
                .map(ContentResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(contentResources);
    }

    private ResponseEntity<List<ContentResource>> getAllContentsByCategory(String category) {
        var getAllContentsByCategoryQuery = new GetAllContentByCategoryQuery(category);
        var contents = contentQueryService.handle(getAllContentsByCategoryQuery);
        if (contents.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var contentResources = contents.stream()
                .map(ContentResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(contentResources);
    }

    private ResponseEntity<List<ContentResource>> getAllContentsByCreatorId(String creatorId) {
        var getAllContentsByCreatorIdQuery = new GetAllContentByCreatorIdQuery(creatorId);
        var contents = contentQueryService.handle(getAllContentsByCreatorIdQuery);
        if (contents.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var contentResources = contents.stream()
                .map(ContentResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(contentResources);
    }

    private ResponseEntity<ContentResource> getContentsByTitleAndCreatorId(String title, String creatorId) {
        var getContentsByTitleAndCreatorIdQuery = new GetContentByTitleAndCreatorId(title, creatorId);
        var content = contentQueryService.handle(getContentsByTitleAndCreatorIdQuery);
        if (content.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return content.map(source ->  ResponseEntity.ok(ContentResourceFromEntityAssembler.toResourceFromEntity(source)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(
            summary = "Get content with param",
            description = "Get content with the provided parameters"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get Content"),
            @ApiResponse(responseCode = "404", description = "Bad Request"),
    })
    @GetMapping
    /*public ResponseEntity<?> getContentWithParameters(@Parameter(name= "params", hidden = true) @RequestParam Map<String, String> params) {
        if (params.containsKey("title") && params.containsKey("creatorId")) {
            return getContentsByTitleAndCreatorId(params.get("title"), params.get("creatorId"));
        } else if (params.containsKey("title")) {
            return getAllContentsByTitle(params.get("title"));
        } else if (params.containsKey("type")) {
            return getAllContentsByType(params.get("type"));
        } else if (params.containsKey("category")) {
            return getAllContentsByCategory(params.get("category"));
        } else if (params.containsKey("creatorId")) {
            return getAllContentsByCreatorId(params.get("creatorId"));
        }
        return ResponseEntity.badRequest().build();
    }*/

    public ResponseEntity<?> getContentWithParameters(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String creatorId,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String category) {

        if (title != null && creatorId != null) {
            return getContentsByTitleAndCreatorId(title, creatorId);
        } else if (title != null) {
            return getAllContentsByTitle(title);
        } else if (type != null) {
            return getAllContentsByType(type);
        } else if (category != null) {
            return getAllContentsByCategory(category);
        } else if (creatorId != null) {
            return getAllContentsByCreatorId(creatorId);
        }
        return ResponseEntity.badRequest().build();
    }


}
