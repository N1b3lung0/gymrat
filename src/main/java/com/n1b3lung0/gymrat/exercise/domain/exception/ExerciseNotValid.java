package com.n1b3lung0.gymrat.exercise.domain.exception;

import com.n1b3lung0.gymrat.common.exception.domain.NotValid;

import java.io.Serial;

public final class ExerciseNotValid extends NotValid {

    @Serial
    private static final long serialVersionUID = -1L;

    public ExerciseNotValid(String name, String reason) {
        super("Exercise '%s' is not valid. Reason: '%s'", name, reason);
    }
}
