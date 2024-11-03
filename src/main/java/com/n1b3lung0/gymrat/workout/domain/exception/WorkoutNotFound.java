package com.n1b3lung0.gymrat.workout.domain.exception;

import com.n1b3lung0.gymrat.common.exception.application.ExceptionConstants;
import com.n1b3lung0.gymrat.common.exception.domain.NotFound;

import java.io.Serial;

public class WorkoutNotFound extends NotFound {

    @Serial
    private static final long serialVersionUID = -1L;

    public WorkoutNotFound(String field, String value) {
        super(ExceptionConstants.WORKOUT_NOT_FOUND, field, value);
    }
}
