package com.n1b3lung0.gymrat.workout.application.create;

import com.n1b3lung0.gymrat.common.log.application.LogConstants;
import com.n1b3lung0.gymrat.workout.domain.Workout;
import com.n1b3lung0.gymrat.workout.domain.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class WorkoutCreator {
    private final WorkoutRepository repository;

    @Transactional
    public Workout create(WorkoutCreateRequest request) {
        Workout workout = request.toWorkout(
                request.getStartWorkout(),
                request.getEndWorkout()
        );

        Workout created = repository.save(workout);
        log.debug(LogConstants.CREATED, "WORKOUT", created);
        return created;
    }
}
