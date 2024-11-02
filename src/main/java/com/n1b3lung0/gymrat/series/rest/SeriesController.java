package com.n1b3lung0.gymrat.series.rest;

import com.n1b3lung0.gymrat.series.application.create.SeriesCreateRequest;
import com.n1b3lung0.gymrat.series.application.create.SeriesCreator;
import com.n1b3lung0.gymrat.series.application.delete.SeriesDeleter;
import com.n1b3lung0.gymrat.series.application.find.SeriesFinder;
import com.n1b3lung0.gymrat.series.application.find.SeriesResponse;
import com.n1b3lung0.gymrat.series.application.update.SeriesUpdateRequest;
import com.n1b3lung0.gymrat.series.application.update.SeriesUpdater;
import com.n1b3lung0.gymrat.series.domain.Series;
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

@RestController
@RequestMapping("/series")
@RequiredArgsConstructor
public class SeriesController {

    private final SeriesFinder finder;
    private final SeriesCreator creator;
    private final SeriesUpdater updater;
    private final SeriesDeleter deleter;

    private static final String ID_PATH = "/{id}";

    @GetMapping(value = ID_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SeriesResponse> finfById(@PathVariable("id") String id) {
        return ResponseEntity.ok(SeriesResponse.fromSeries(finder.findById(id)));
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody @Valid SeriesCreateRequest request) {
        Series series = creator.create(request);
        URI location = UriComponentsBuilder
                .fromPath("/series/{id}")
                .buildAndExpand(series.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PatchMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SeriesResponse> update(@RequestBody @Valid SeriesUpdateRequest request) {
        return ResponseEntity.ok(SeriesResponse.fromSeries(updater.update(request)));
    }

    @DeleteMapping(value = ID_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        deleter.delete(id);
        return ResponseEntity.noContent().build();
    }
}
