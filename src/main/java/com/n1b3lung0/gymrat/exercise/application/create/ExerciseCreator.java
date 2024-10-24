package com.n1b3lung0.gymrat.exercise.application.create;

import com.n1b3lung0.gymrat.exercise.domain.Exercise;
import com.n1b3lung0.gymrat.exercise.domain.ExerciseRepository;
import com.n1b3lung0.gymrat.exercise.domain.exception.ExerciseAlreadyExists;
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

        if (repository.findByName(name).isPresent()) {
            throw new ExerciseAlreadyExists(name);
        }

        Exercise exercise = request.toExercise(
                name,
                request.getLevel(),
                request.getRoutines(),
                request.getPrimaryMuscle(),
                request.getSecondaryMuscles()
        );
        Exercise created = repository.save(exercise);
        log.debug("Created Exercise with name {} and id {}", name, created.getId());
        return created;
    }
}
