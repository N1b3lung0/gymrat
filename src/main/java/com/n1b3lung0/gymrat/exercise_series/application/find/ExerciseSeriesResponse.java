package com.n1b3lung0.gymrat.exercise_series.application.find;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.n1b3lung0.gymrat.common.audit.domain.AuditFields;
import com.n1b3lung0.gymrat.exercise.application.find.ExerciseResponse;
import com.n1b3lung0.gymrat.exercise.domain.Exercise;
import com.n1b3lung0.gymrat.exercise_series.domain.ExerciseSeries;
import com.n1b3lung0.gymrat.series.application.find.SeriesResponse;
import com.n1b3lung0.gymrat.series.domain.Series;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExerciseSeriesResponse {

    private String id;

    private ExerciseResponse exercise;

    private Set<SeriesResponse> series;

    @EqualsAndHashCode.Exclude
    private AuditFields auditFields;

    public static ExerciseSeriesResponse fromExerciseSeries(ExerciseSeries exerciseSeries) {
        assert exerciseSeries != null;
        Exercise exercise = exerciseSeries.getExercise();
        Set<Series> series = exerciseSeries.getSeries();
        AuditFields auditFields = exerciseSeries.getAuditFields();
        assert auditFields != null;
        return new ExerciseSeriesResponse(
                String.valueOf(exerciseSeries.getId()),
                exercise != null ? ExerciseResponse.fromExercise(exercise) : null,
                series != null
                        ? series.stream()
                        .map(SeriesResponse::fromSeries)
                        .collect(Collectors.toSet())
                        : null,
                auditFields
        );
    }
}
