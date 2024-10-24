package com.n1b3lung0.gymrat.exercise.domain.exception;

import com.n1b3lung0.gymrat.common.exception.domain.AlreadyExists;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public final class ExerciseAlreadyExists extends AlreadyExists {

    @Serial
    private static final long serialVersionUID = -1L;

    public ExerciseAlreadyExists(String name) {
        super("An exercise with name %s has already been created", name);
    }
}
