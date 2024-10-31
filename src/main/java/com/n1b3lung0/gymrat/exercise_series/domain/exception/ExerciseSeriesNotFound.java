package com.n1b3lung0.gymrat.exercise_series.domain.exception;

import com.n1b3lung0.gymrat.common.exception.application.ExceptionConstants;
import com.n1b3lung0.gymrat.common.exception.domain.NotFound;

import java.io.Serial;

public class ExerciseSeriesNotFound extends NotFound {

    @Serial
    private static final long serialVersionUID = -1L;

    public ExerciseSeriesNotFound(String field, String value) {
        super(ExceptionConstants.EXERCISE_SERIES_NOT_FOUND, field, value);
    }
}
