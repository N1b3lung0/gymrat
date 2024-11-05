package com.n1b3lung0.gymrat.workout.application.delete;

import com.n1b3lung0.gymrat.common.log.application.LogConstants;
import com.n1b3lung0.gymrat.workout.application.find.WorkoutFinder;
import com.n1b3lung0.gymrat.workout.domain.Workout;
import com.n1b3lung0.gymrat.workout.domain.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class WorkoutDeleter {
    private final WorkoutRepository repository;
    private final WorkoutFinder finder;

    @Transactional
    public void delete(String id) {
        Workout workout = finder.findById(id);
        Workout deleted = workout.delete(workout, "n1b3lung0");
        repository.save(deleted);
        log.debug(LogConstants.DELETED, "WORKOUT", deleted);
    }
}
