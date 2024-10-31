package com.n1b3lung0.gymrat.exercise_series.rest;

import com.n1b3lung0.gymrat.exercise_series.application.create.ExerciseSeriesCreateRequest;
import com.n1b3lung0.gymrat.exercise_series.application.create.ExerciseSeriesCreator;
import com.n1b3lung0.gymrat.exercise_series.application.delete.ExerciseSeriesDeleter;
import com.n1b3lung0.gymrat.exercise_series.application.find.ExerciseSeriesFinder;
import com.n1b3lung0.gymrat.exercise_series.application.find.ExerciseSeriesResponse;
import com.n1b3lung0.gymrat.exercise_series.application.update.ExerciseSeriesUpdater;
import com.n1b3lung0.gymrat.exercise_series.domain.ExerciseSeries;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/exercise-series")
@RequiredArgsConstructor
public class ExerciseSeriesController {

    private final ExerciseSeriesFinder finder;
    private final ExerciseSeriesCreator creator;
    private final ExerciseSeriesUpdater updater;
    private final ExerciseSeriesDeleter deleter;

    private static final String ID_PATH = "/{id}";

    @GetMapping(value = ID_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExerciseSeriesResponse> findById(@PathVariable String id) {
        return ResponseEntity.ok(ExerciseSeriesResponse.fromExerciseSeries(finder.findById(id)));
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody @Valid ExerciseSeriesCreateRequest request) {
        ExerciseSeries saved = creator.create(request);
        URI location = UriComponentsBuilder
                .fromPath("/exercise-series/{id}")
                .buildAndExpand(saved.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
