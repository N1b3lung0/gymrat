package com.n1b3lung0.gymrat.exercise_series.application.create;

import com.n1b3lung0.gymrat.common.log.application.LogConstants;
import com.n1b3lung0.gymrat.common.uuid.UUIDUtils;
import com.n1b3lung0.gymrat.exercise.domain.Exercise;
import com.n1b3lung0.gymrat.exercise.domain.ExerciseRepository;
import com.n1b3lung0.gymrat.exercise.domain.exception.ExerciseNotFound;
import com.n1b3lung0.gymrat.exercise_series.domain.ExerciseSeries;
import com.n1b3lung0.gymrat.exercise_series.domain.ExerciseSeriesRepository;
import com.n1b3lung0.gymrat.series.domain.Series;
import com.n1b3lung0.gymrat.series.domain.SeriesRepository;
import com.n1b3lung0.gymrat.series.domain.exception.SeriesNotFound;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExerciseSeriesCreator {
    private final ExerciseSeriesRepository repository;
    private final ExerciseRepository exerciseRepository;
    private final SeriesRepository seriesRepository;

    @Transactional
    public ExerciseSeries create(ExerciseSeriesCreateRequest request) {
        ExerciseSeries exerciseSeries = repository.save(request.toExerciseSeries(
                null,
                addExercise(request.getExerciseId())
        ));

        ExerciseSeries withSeries = (request.getSeriesIds() != null)
                ? addSeries(exerciseSeries, request.getSeriesIds())
                : exerciseSeries;
        ExerciseSeries created = repository.save(withSeries);
        log.debug(LogConstants.CREATED, "EXERCISE-SERIES", created);
        return created;
    }

    private ExerciseSeries addSeries(ExerciseSeries exerciseSeries, Set<String> seriesIds) {
        Set<Series> series = seriesIds.stream()
                .map(id -> seriesRepository.findById(UUIDUtils.fromString(id))
                        .orElseThrow(() -> new SeriesNotFound("id", id)))
                .collect(Collectors.toSet());
        return exerciseSeries.withSeries(series);
    }

    private Exercise addExercise(String exerciseId) {
        return exerciseRepository.findById(UUIDUtils.fromString(exerciseId))
                .orElseThrow(() -> new ExerciseNotFound("id", exerciseId));
    }
}
