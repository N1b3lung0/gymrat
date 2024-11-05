package com.n1b3lung0.gymrat.exercise_series.rest;

import com.n1b3lung0.gymrat.common.base.rest.BaseRestController;
import com.n1b3lung0.gymrat.common.swagger.rest.CreatedRes;
import com.n1b3lung0.gymrat.common.swagger.rest.NoContentRes;
import com.n1b3lung0.gymrat.common.swagger.rest.NotFoundRes;
import com.n1b3lung0.gymrat.common.swagger.rest.OkRes;
import com.n1b3lung0.gymrat.common.swagger.rest.SecurityRes;
import com.n1b3lung0.gymrat.exercise.application.find.ExerciseResponse;
import com.n1b3lung0.gymrat.exercise.application.update.ExerciseUpdateRequest;
import com.n1b3lung0.gymrat.exercise_series.application.create.ExerciseSeriesCreateRequest;
import com.n1b3lung0.gymrat.exercise_series.application.create.ExerciseSeriesCreator;
import com.n1b3lung0.gymrat.exercise_series.application.delete.ExerciseSeriesDeleter;
import com.n1b3lung0.gymrat.exercise_series.application.find.ExerciseSeriesFinder;
import com.n1b3lung0.gymrat.exercise_series.application.find.ExerciseSeriesResponse;
import com.n1b3lung0.gymrat.exercise_series.application.update.ExerciseSeriesUpdater;
import com.n1b3lung0.gymrat.exercise_series.domain.ExerciseSeries;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
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

import static com.n1b3lung0.gymrat.common.swagger.rest.SwaggerConstants.CREATE_EXERCISE_SERIES;
import static com.n1b3lung0.gymrat.common.swagger.rest.SwaggerConstants.DELETE_EXERCISE_SERIES;
import static com.n1b3lung0.gymrat.common.swagger.rest.SwaggerConstants.FIND_EXERCISE_SERIES_BY_ID;
import static com.n1b3lung0.gymrat.common.swagger.rest.SwaggerConstants.UPDATE_EXERCISE_SERIES;

@RestController
@RequestMapping("/exercise-series")
@RequiredArgsConstructor
@Tag(name = "Exercises-Series", description = "Endpoints to perform operations with exercises-series")
public class ExerciseSeriesController extends BaseRestController {

    private final ExerciseSeriesFinder finder;
    private final ExerciseSeriesCreator creator;
    private final ExerciseSeriesUpdater updater;
    private final ExerciseSeriesDeleter deleter;

    @OkRes
    @NotFoundRes
    @SecurityRes
    @GetMapping(value = ID_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = FIND_EXERCISE_SERIES_BY_ID, description = FIND_EXERCISE_SERIES_BY_ID)
    public ResponseEntity<ExerciseSeriesResponse> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok(ExerciseSeriesResponse.fromExerciseSeries(finder.findById(id)));
    }

    @CreatedRes
    @SecurityRes
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = CREATE_EXERCISE_SERIES, description = CREATE_EXERCISE_SERIES)
    public ResponseEntity<Void> create(@RequestBody @Valid ExerciseSeriesCreateRequest request) {
        ExerciseSeries saved = creator.create(request);
        URI location = UriComponentsBuilder
                .fromPath("/exercise-series/{id}")
                .buildAndExpand(saved.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @OkRes
    @NotFoundRes
    @SecurityRes
    @PatchMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = UPDATE_EXERCISE_SERIES, description = UPDATE_EXERCISE_SERIES)
    public ResponseEntity<ExerciseResponse> update(@RequestBody @Valid ExerciseUpdateRequest request) {
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }

    @NoContentRes
    @NotFoundRes
    @SecurityRes
    @DeleteMapping(value = ID_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = DELETE_EXERCISE_SERIES, description = DELETE_EXERCISE_SERIES)
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        deleter.delete(id);
        return ResponseEntity.noContent().build();
    }
}
