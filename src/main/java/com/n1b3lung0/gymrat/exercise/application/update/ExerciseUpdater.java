package com.n1b3lung0.gymrat.exercise.application.update;

import com.n1b3lung0.gymrat.exercise.application.find.ExerciseFinder;
import com.n1b3lung0.gymrat.exercise.domain.Exercise;
import com.n1b3lung0.gymrat.exercise.domain.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExerciseUpdater {
    private final ExerciseFinder finder;
    private final ExerciseRepository repository;

    @Transactional
    public Exercise update(ExerciseUpdateRequest request) {
        String name = request.getName();
        Exercise exercise = finder.findById(request.getId());
        if (StringUtils.isNotBlank(name) && !StringUtils.equals(name, exercise.getName())) {
            if (repository.findByName(name).isPresent()) {
                throw new RuntimeException("Exercise with name " + name + " already exists");
            }
            exercise = exercise.withName(name);
        }
        exercise = repository.save(exercise);
        log.debug("Updated Exercise with name {}", exercise.getName());
        return exercise;
    }

}
