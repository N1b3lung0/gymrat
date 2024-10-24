package com.n1b3lung0.gymrat.exercise.application.find;

import com.n1b3lung0.gymrat.exercise.domain.Exercise;
import com.n1b3lung0.gymrat.exercise.domain.ExerciseRepository;
import com.n1b3lung0.gymrat.exercise.domain.exception.ExerciseNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExerciseFinder {
    private final ExerciseRepository repository;

    @Transactional(readOnly = true)
    public Exercise findByName(String name) {
        return repository.findByName(name)
                .orElseThrow(() -> new ExerciseNotFound("name", name));
    }

    @Transactional(readOnly = true)
    public Exercise findById(String id) {
        return repository.findById(UUID.fromString(id))
                .orElseThrow(() -> new ExerciseNotFound("id", id));
    }
}
