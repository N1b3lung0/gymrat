package com.n1b3lung0.gymrat.exercise.rest;

import com.n1b3lung0.gymrat.common.base.rest.BaseRestController;
import com.n1b3lung0.gymrat.common.criteria.application.PageResponse;
import com.n1b3lung0.gymrat.common.swagger.rest.CreatedRes;
import com.n1b3lung0.gymrat.common.swagger.rest.NoContentRes;
import com.n1b3lung0.gymrat.common.swagger.rest.NotFoundRes;
import com.n1b3lung0.gymrat.common.swagger.rest.OkRes;
import com.n1b3lung0.gymrat.common.swagger.rest.SecurityRes;
import com.n1b3lung0.gymrat.exercise.application.create.ExerciseCreateRequest;
import com.n1b3lung0.gymrat.exercise.application.create.ExerciseCreator;
import com.n1b3lung0.gymrat.exercise.application.delete.ExerciseDeleter;
import com.n1b3lung0.gymrat.exercise.application.find.ExerciseFindRequest;
import com.n1b3lung0.gymrat.exercise.application.find.ExerciseFinder;
import com.n1b3lung0.gymrat.exercise.application.find.ExerciseResponse;
import com.n1b3lung0.gymrat.exercise.application.update.ExerciseUpdateRequest;
import com.n1b3lung0.gymrat.exercise.application.update.ExerciseUpdater;
import com.n1b3lung0.gymrat.exercise.domain.Exercise;
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

import static com.n1b3lung0.gymrat.common.swagger.rest.SwaggerConstants.CREATE_EXERCISE;
import static com.n1b3lung0.gymrat.common.swagger.rest.SwaggerConstants.DELETE_EXERCISE;
import static com.n1b3lung0.gymrat.common.swagger.rest.SwaggerConstants.FIND_EXERCISE_BY_CRITERIA;
import static com.n1b3lung0.gymrat.common.swagger.rest.SwaggerConstants.FIND_EXERCISE_BY_NAME;
import static com.n1b3lung0.gymrat.common.swagger.rest.SwaggerConstants.UPDATE_EXERCISE;

@RestController
@RequestMapping("/exercises")
@RequiredArgsConstructor
@Tag(name = "Exercises", description = "Endpoints to perform operations with exercises")
public class ExerciseController extends BaseRestController {

    private final ExerciseFinder finder;
    private final ExerciseCreator creator;
    private final ExerciseUpdater updater;
    private final ExerciseDeleter deleter;

    @OkRes
    @NotFoundRes
    @SecurityRes
    @GetMapping(value = NAME_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = FIND_EXERCISE_BY_NAME, description = FIND_EXERCISE_BY_NAME)
    public ResponseEntity<ExerciseResponse> findByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(ExerciseResponse.fromExercise(finder.findByName(name)));
    }

    @OkRes
    @SecurityRes
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = FIND_EXERCISE_BY_CRITERIA, description = FIND_EXERCISE_BY_CRITERIA)
    public ResponseEntity<PageResponse<ExerciseResponse>> findByCriteria(@Valid ExerciseFindRequest request) {
        return ResponseEntity.ok(finder.find(request));
    }

    @CreatedRes
    @SecurityRes
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = CREATE_EXERCISE, description = CREATE_EXERCISE)
    public ResponseEntity<Void> create(@RequestBody @Valid ExerciseCreateRequest request) {
        Exercise saved = creator.create(request);
        URI location = UriComponentsBuilder
                .fromPath("/exercises/{id}")
                .buildAndExpand(saved.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @OkRes
    @NotFoundRes
    @SecurityRes
    @PatchMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = UPDATE_EXERCISE, description = UPDATE_EXERCISE)
    public ResponseEntity<ExerciseResponse> update(@Valid @RequestBody ExerciseUpdateRequest request) {
        return ResponseEntity.ok(ExerciseResponse.fromExercise(updater.update(request)));
    }

    @NoContentRes
    @NotFoundRes
    @SecurityRes
    @DeleteMapping(value = NAME_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = DELETE_EXERCISE, description = DELETE_EXERCISE)
    public ResponseEntity<Void> delete(@PathVariable("name") String name) {
        deleter.delete(name);
        return ResponseEntity.noContent().build();
    }
}
