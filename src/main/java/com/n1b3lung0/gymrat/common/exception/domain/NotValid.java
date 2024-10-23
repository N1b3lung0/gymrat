package com.n1b3lung0.gymrat.common.exception.domain;

import lombok.Getter;

import java.io.Serial;
import java.util.Collections;
import java.util.List;

@Getter
public class NotValid extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -1L;

    private final List<String> errors;

    public NotValid(String message, Object... args) {
        super(String.format(message, args));
        this.errors = Collections.singletonList(String.format(message, args));
    }
}
