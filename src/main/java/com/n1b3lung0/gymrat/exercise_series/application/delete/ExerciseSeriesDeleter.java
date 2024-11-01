package com.n1b3lung0.gymrat.exercise_series.application.delete;

import com.n1b3lung0.gymrat.common.log.application.LogConstants;
import com.n1b3lung0.gymrat.exercise_series.application.find.ExerciseSeriesFinder;
import com.n1b3lung0.gymrat.exercise_series.domain.ExerciseSeries;
import com.n1b3lung0.gymrat.exercise_series.domain.ExerciseSeriesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExerciseSeriesDeleter {
    private final ExerciseSeriesRepository repository;
    private final ExerciseSeriesFinder finder;

    @Transactional
    public void delete(String id) {
        ExerciseSeries exerciseSeries = finder.findById(id);
        assert exerciseSeries != null;
        ExerciseSeries deleted = exerciseSeries.delete(exerciseSeries, "n1b3lung0");
        repository.save(deleted);
        log.debug(LogConstants.DELETED, "EXERCISE-SERIES", deleted);
    }
}
