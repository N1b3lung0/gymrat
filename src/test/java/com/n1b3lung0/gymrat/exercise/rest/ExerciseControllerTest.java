package com.n1b3lung0.gymrat.exercise.rest;

import com.n1b3lung0.gymrat.exercise.application.create.ExerciseCreateRequest;
import com.n1b3lung0.gymrat.exercise.application.create.ExerciseCreator;
import com.n1b3lung0.gymrat.exercise.application.delete.ExerciseDeleter;
import com.n1b3lung0.gymrat.exercise.application.find.ExerciseFinder;
import com.n1b3lung0.gymrat.exercise.application.find.ExerciseResponse;
import com.n1b3lung0.gymrat.exercise.application.update.ExerciseUpdateRequest;
import com.n1b3lung0.gymrat.exercise.application.update.ExerciseUpdater;
import com.n1b3lung0.gymrat.exercise.domain.Exercise;
import com.n1b3lung0.gymrat.exercise.domain.Level;
import com.n1b3lung0.gymrat.exercise.domain.Muscle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.ReflectionTestUtils.setField;

class ExerciseControllerTest {

    private ExerciseFinder finder;
    private ExerciseCreator creator;
    private ExerciseUpdater updater;
    private ExerciseDeleter deleter;

    private ExerciseController controller;

    private Exercise exercise;
    private UUID id;
    String idString;

    @BeforeEach
    void setUp() {
        finder = mock(ExerciseFinder.class);
        creator = mock(ExerciseCreator.class);
        updater = mock(ExerciseUpdater.class);
        deleter = mock(ExerciseDeleter.class);

        controller = new ExerciseController(finder, creator, updater, deleter);

        exercise = Exercise.create(
                "Push Up",
                "A basic exercise for upper body strength.",
                null,
                null,
                Level.BEGINNER,
                null,
                Muscle.BACK,
                null
        );
        id = UUID.randomUUID();
        idString = id.toString();
    }

    @Test
    @DisplayName("findById returns ExerciseResponse with correct ID")
    void findById_returnsExerciseResponse() {
        setField(exercise, "id", id);

        when(finder.findById(id.toString())).thenReturn(exercise);

        ResponseEntity<ExerciseResponse> response = controller.findById(idString);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(idString, Objects.requireNonNull(response.getBody()).getId());
        verify(finder).findById(idString);
    }

    @Test
    void findByCriteria() {
    }

    @Test
    @DisplayName("create returns Created when exercise is successfully created")
    void create_returnsCreatedIfItCanBeSaved() {
        ExerciseCreateRequest request = new ExerciseCreateRequest(
                "Push Up",
                "A basic exercise for upper body strength.",
                null,
                null,
                Level.BEGINNER,
                null,
                Muscle.BACK,
                null
        );

        when(creator.create(request)).thenReturn(exercise);

        ResponseEntity<Void> response = controller.create(request);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(creator).create(request);
    }

    @Test
    @DisplayName("update returns Ok when update is successful")
    void update_returnsOkIfFoundAndUpdated() {
        setField(exercise, "id", UUID.fromString(idString));

        ExerciseUpdateRequest request = new ExerciseUpdateRequest(
                idString,
                "Squat",
                Level.ADVANCED,
                null,
                Muscle.CUADRICEPS,
                null
        );

        when(updater.update(request)).thenReturn(exercise);

        ResponseEntity<ExerciseResponse> response = controller.update(request);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(updater).update(request);
    }

    @Test
    @DisplayName("delete returns No Content when deletion is successful")
    void delete_returnsNoContent() {

        doNothing().when(deleter).delete(idString);

        ResponseEntity<Void> response = controller.delete(idString);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(deleter).delete(idString);
    }
}