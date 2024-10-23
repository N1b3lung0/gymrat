package com.n1b3lung0.gymrat.exercise.application.delete;

import com.n1b3lung0.gymrat.exercise.application.find.ExerciseFinder;
import com.n1b3lung0.gymrat.exercise.domain.Exercise;
import com.n1b3lung0.gymrat.exercise.domain.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExerciseDeleter {
    private final ExerciseFinder finder;
    private final ExerciseRepository repository;

    @Transactional
    public void delete(String name) {
        Exercise exercise = finder.findByName(name);
        Exercise deleted = exercise.delete(exercise, "n1b3lung0");
        repository.save(deleted);
        log.debug("Deleting exercise with name {}", name);
    }
}
