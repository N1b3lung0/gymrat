package com.n1b3lung0.gymrat.workout.rest;

import com.n1b3lung0.gymrat.common.base.rest.BaseRestController;
import com.n1b3lung0.gymrat.common.swagger.rest.CreatedRes;
import com.n1b3lung0.gymrat.common.swagger.rest.NoContentRes;
import com.n1b3lung0.gymrat.common.swagger.rest.NotFoundRes;
import com.n1b3lung0.gymrat.common.swagger.rest.OkRes;
import com.n1b3lung0.gymrat.common.swagger.rest.SecurityRes;
import com.n1b3lung0.gymrat.workout.application.create.WorkoutCreateRequest;
import com.n1b3lung0.gymrat.workout.application.create.WorkoutCreator;
import com.n1b3lung0.gymrat.workout.application.delete.WorkoutDeleter;
import com.n1b3lung0.gymrat.workout.application.find.WorkoutFinder;
import com.n1b3lung0.gymrat.workout.application.find.WorkoutResponse;
import com.n1b3lung0.gymrat.workout.application.update.WorkoutUpdateRequest;
import com.n1b3lung0.gymrat.workout.application.update.WorkoutUpdater;
import com.n1b3lung0.gymrat.workout.domain.Workout;
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

import static com.n1b3lung0.gymrat.common.swagger.rest.SwaggerConstants.CREATE_WORKOUT;
import static com.n1b3lung0.gymrat.common.swagger.rest.SwaggerConstants.DELETE_WORKOUT;
import static com.n1b3lung0.gymrat.common.swagger.rest.SwaggerConstants.FIND_WORKOUT_BY_ID;
import static com.n1b3lung0.gymrat.common.swagger.rest.SwaggerConstants.UPDATE_WORKOUT;

@RestController
@RequestMapping("/workouts")
@RequiredArgsConstructor
@Tag(name = "Workouts", description = "Endpoints to perform operations with workouts")
public class WorkoutController extends BaseRestController {

    private final WorkoutFinder finder;
    private final WorkoutCreator creator;
    private final WorkoutUpdater updater;
    private final WorkoutDeleter deleter;

    @OkRes
    @NotFoundRes
    @SecurityRes
    @GetMapping(value = ID_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = FIND_WORKOUT_BY_ID, description = FIND_WORKOUT_BY_ID)
    public ResponseEntity<WorkoutResponse> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok(WorkoutResponse.fromWorkout(finder.findById(id)));
    }

    @CreatedRes
    @SecurityRes
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = CREATE_WORKOUT, description = CREATE_WORKOUT)
    public ResponseEntity<Void> create(@RequestBody @Valid WorkoutCreateRequest request) {
        Workout workout = creator.create(request);
        URI location = UriComponentsBuilder
                .fromPath("/workouts/{id}")
                .buildAndExpand(workout.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @OkRes
    @NotFoundRes
    @SecurityRes
    @PatchMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = UPDATE_WORKOUT, description = UPDATE_WORKOUT)
    public ResponseEntity<WorkoutResponse> update(@RequestBody @Valid WorkoutUpdateRequest request) {
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }

    @NoContentRes
    @NotFoundRes
    @SecurityRes
    @DeleteMapping(value = ID_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = DELETE_WORKOUT, description = DELETE_WORKOUT)
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        deleter.delete(id);
        return ResponseEntity.noContent().build();
    }
}
