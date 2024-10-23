package com.n1b3lung0.gymrat.exercise.application.create;

import com.n1b3lung0.gymrat.exercise.domain.Exercise;
import com.n1b3lung0.gymrat.exercise.domain.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExerciseCreator {
    private final ExerciseRepository repository;

    public Exercise create(ExerciseCreateRequest request) {
        String name = request.getName();

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if (repository.findByName(name).isPresent()) {
            throw new IllegalArgumentException("Exercise with name " + name + " already exists");
        }

        Exercise exercise = request.toExercise(name);
        Exercise created = repository.save(exercise);
        log.debug("Created Exercise with name {} and id {}", name, created.getId());
        return created;
    }
}
