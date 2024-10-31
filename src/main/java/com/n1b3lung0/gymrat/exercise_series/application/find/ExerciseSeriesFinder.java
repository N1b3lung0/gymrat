package com.n1b3lung0.gymrat.exercise_series.application.find;

import com.n1b3lung0.gymrat.common.uuid.UUIDUtils;
import com.n1b3lung0.gymrat.exercise_series.domain.ExerciseSeries;
import com.n1b3lung0.gymrat.exercise_series.domain.ExerciseSeriesRepository;
import com.n1b3lung0.gymrat.exercise_series.domain.exception.ExerciseSeriesNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ExerciseSeriesFinder {

    private final ExerciseSeriesRepository repository;

    @Transactional(readOnly = true)
    public ExerciseSeries findById(String id) {
        return repository.findById(UUIDUtils.fromString(id))
                .orElseThrow(() -> new ExerciseSeriesNotFound("id", id));
    }
}
