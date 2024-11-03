package com.n1b3lung0.gymrat.workout.application.find;

import com.n1b3lung0.gymrat.common.uuid.UUIDUtils;
import com.n1b3lung0.gymrat.workout.domain.Workout;
import com.n1b3lung0.gymrat.workout.domain.WorkoutRepository;
import com.n1b3lung0.gymrat.workout.domain.exception.WorkoutNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WorkoutFinder {

    private final WorkoutRepository repository;

    @Transactional(readOnly = true)
    public Workout findById(String id) {
        return repository.findById(UUIDUtils.fromString(id))
                .orElseThrow(() -> new WorkoutNotFound("id", id));
    }
}
