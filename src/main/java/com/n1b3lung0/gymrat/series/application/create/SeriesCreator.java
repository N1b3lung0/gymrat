package com.n1b3lung0.gymrat.series.application.create;

import com.n1b3lung0.gymrat.common.log.application.LogConstants;
import com.n1b3lung0.gymrat.common.uuid.UUIDUtils;
import com.n1b3lung0.gymrat.exercise_series.domain.ExerciseSeries;
import com.n1b3lung0.gymrat.exercise_series.domain.ExerciseSeriesRepository;
import com.n1b3lung0.gymrat.exercise_series.domain.exception.ExerciseSeriesNotFound;
import com.n1b3lung0.gymrat.series.domain.Series;
import com.n1b3lung0.gymrat.series.domain.SeriesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class SeriesCreator {
    private final SeriesRepository repository;
    private final ExerciseSeriesRepository exerciseSeriesRepository;

    @Transactional
    public Series create(SeriesCreateRequest request) {

        Series series = request.toSeries(
                request.getSerialNumber(),
                request.getRepetitionsToDo(),
                request.getRepetitionsDone(),
                request.getIntensity(),
                request.getWeight(),
                request.getStartSeries(),
                request.getEndSeries(),
                request.getRestTime()
        );

        Series withExerciseSeries = (request.getExerciseSeriesId() != null)
                ? addExerciseSeries(series, request.getExerciseSeriesId())
                : series;

        Series created = repository.save(withExerciseSeries);
        log.debug(LogConstants.CREATED, "SERIES", created);
        return created;
    }

    public Series addExerciseSeries(Series series, String exerciseSeriesId) {
        ExerciseSeries exerciseSeries = exerciseSeriesRepository
                .findById(UUIDUtils.fromString(exerciseSeriesId))
                .orElseThrow(() -> new ExerciseSeriesNotFound("id", exerciseSeriesId));
        return series.withExerciseSeries(exerciseSeries);
    }
}
