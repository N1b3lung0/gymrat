package com.n1b3lung0.gymrat.workout.rest;

import com.n1b3lung0.gymrat.workout.application.create.WorkoutCreateRequest;
import com.n1b3lung0.gymrat.workout.application.create.WorkoutCreator;
import com.n1b3lung0.gymrat.workout.application.delete.WorkoutDeleter;
import com.n1b3lung0.gymrat.workout.application.find.WorkoutFinder;
import com.n1b3lung0.gymrat.workout.application.find.WorkoutResponse;
import com.n1b3lung0.gymrat.workout.application.update.WorkoutUpdateRequest;
import com.n1b3lung0.gymrat.workout.application.update.WorkoutUpdater;
import com.n1b3lung0.gymrat.workout.domain.Workout;
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

@RestController
@RequestMapping("/workouts")
@RequiredArgsConstructor
public class WorkoutController {

    private final WorkoutFinder finder;
    private final WorkoutCreator creator;
    private final WorkoutUpdater updater;
    private final WorkoutDeleter deleter;

    private static final String ID_PATH = "/{id}";

    @GetMapping(value = ID_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WorkoutResponse> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok(WorkoutResponse.fromWorkout(finder.findById(id)));
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody @Valid WorkoutCreateRequest request) {
        Workout workout = creator.create(request);
        URI location = UriComponentsBuilder
                .fromPath("/workouts/{id}")
                .buildAndExpand(workout.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PatchMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WorkoutResponse> update(@RequestBody @Valid WorkoutUpdateRequest request) {
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }

    @DeleteMapping(value = ID_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        deleter.delete(id);
        return ResponseEntity.noContent().build();
    }
}
