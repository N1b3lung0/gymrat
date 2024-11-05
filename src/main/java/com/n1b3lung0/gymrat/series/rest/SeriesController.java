package com.n1b3lung0.gymrat.series.rest;

import com.n1b3lung0.gymrat.common.base.rest.BaseRestController;
import com.n1b3lung0.gymrat.common.swagger.rest.CreatedRes;
import com.n1b3lung0.gymrat.common.swagger.rest.NoContentRes;
import com.n1b3lung0.gymrat.common.swagger.rest.NotFoundRes;
import com.n1b3lung0.gymrat.common.swagger.rest.OkRes;
import com.n1b3lung0.gymrat.common.swagger.rest.SecurityRes;
import com.n1b3lung0.gymrat.series.application.create.SeriesCreateRequest;
import com.n1b3lung0.gymrat.series.application.create.SeriesCreator;
import com.n1b3lung0.gymrat.series.application.delete.SeriesDeleter;
import com.n1b3lung0.gymrat.series.application.find.SeriesFinder;
import com.n1b3lung0.gymrat.series.application.find.SeriesResponse;
import com.n1b3lung0.gymrat.series.application.update.SeriesUpdateRequest;
import com.n1b3lung0.gymrat.series.application.update.SeriesUpdater;
import com.n1b3lung0.gymrat.series.domain.Series;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static com.n1b3lung0.gymrat.common.swagger.rest.SwaggerConstants.CREATE_SERIES;
import static com.n1b3lung0.gymrat.common.swagger.rest.SwaggerConstants.DELETE_SERIES;
import static com.n1b3lung0.gymrat.common.swagger.rest.SwaggerConstants.FIND_SERIES_BY_ID;
import static com.n1b3lung0.gymrat.common.swagger.rest.SwaggerConstants.UPDATE_SERIES;

@RestController
@RequestMapping("/series")
@RequiredArgsConstructor
@Tag(name = "Series", description = "Endpoints to perform operations with series")
public class SeriesController extends BaseRestController {

    private final SeriesFinder finder;
    private final SeriesCreator creator;
    private final SeriesUpdater updater;
    private final SeriesDeleter deleter;

    @OkRes
    @NotFoundRes
    @SecurityRes
    @GetMapping(value = ID_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = FIND_SERIES_BY_ID, description = FIND_SERIES_BY_ID)
    public ResponseEntity<SeriesResponse> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok(SeriesResponse.fromSeries(finder.findById(id)));
    }

    @CreatedRes
    @SecurityRes
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = CREATE_SERIES, description = CREATE_SERIES)
    public ResponseEntity<Void> create(@RequestBody @Valid SeriesCreateRequest request) {
        Series series = creator.create(request);
        URI location = UriComponentsBuilder
                .fromPath("/series/{id}")
                .buildAndExpand(series.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @OkRes
    @NotFoundRes
    @SecurityRes
    @PatchMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = UPDATE_SERIES, description = UPDATE_SERIES)
    public ResponseEntity<SeriesResponse> update(@RequestBody @Valid SeriesUpdateRequest request) {
        return ResponseEntity.ok(SeriesResponse.fromSeries(updater.update(request)));
    }

    @NoContentRes
    @NotFoundRes
    @SecurityRes
    @DeleteMapping(value = ID_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = DELETE_SERIES, description = DELETE_SERIES)
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        deleter.delete(id);
        return ResponseEntity.noContent().build();
    }
}
