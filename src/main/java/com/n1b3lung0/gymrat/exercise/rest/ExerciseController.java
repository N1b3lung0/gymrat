package com.n1b3lung0.gymrat.exercise.rest;

import com.n1b3lung0.gymrat.exercise.application.create.ExerciseCreateRequest;
import com.n1b3lung0.gymrat.exercise.application.create.ExerciseCreator;
import com.n1b3lung0.gymrat.exercise.application.delete.ExerciseDeleter;
import com.n1b3lung0.gymrat.exercise.application.find.ExerciseFinder;
import com.n1b3lung0.gymrat.exercise.application.find.ExerciseResponse;
import com.n1b3lung0.gymrat.exercise.application.update.ExerciseUpdateRequest;
import com.n1b3lung0.gymrat.exercise.application.update.ExerciseUpdater;
import com.n1b3lung0.gymrat.exercise.domain.Exercise;
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
@RequestMapping("/exercises")
@RequiredArgsConstructor
public class ExerciseController {

    private final ExerciseFinder finder;
    private final ExerciseCreator creator;
    private final ExerciseUpdater updater;
    private final ExerciseDeleter deleter;

    private static final String NAME_PATH = "/{name}";

    @GetMapping(value = NAME_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExerciseResponse> findByName(@PathVariable String name) {
        return ResponseEntity.ok(ExerciseResponse.fromExercise(finder.findByName(name)));
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@Valid @RequestBody ExerciseCreateRequest request) {
        Exercise saved = creator.create(request);
        URI location = UriComponentsBuilder
                .fromPath("/exercises/{id}")
                .buildAndExpand(saved.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PatchMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExerciseResponse> update(@Valid @RequestBody ExerciseUpdateRequest request) {
        return ResponseEntity.ok(ExerciseResponse.fromExercise(updater.update(request)));
    }

    @DeleteMapping(value = NAME_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable String name) {
        deleter.delete(name);
        return ResponseEntity.noContent().build();
    }
}
