package com.n1b3lung0.gymrat.exercise.domain.exception;

import com.n1b3lung0.gymrat.common.exception.application.ExceptionConstants;
import com.n1b3lung0.gymrat.common.exception.domain.NotFound;

import java.io.Serial;

public final class ExerciseNotFound extends NotFound {

    @Serial
    private static final long serialVersionUID = -1L;

    public ExerciseNotFound(String field, String value) {
        super(ExceptionConstants.EXERCISE_NOT_FOUND, field, value);
    }
}
