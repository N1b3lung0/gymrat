package com.n1b3lung0.gymrat.common.exception.domain;

import java.io.Serial;

public class NotFound extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -1L;

    public NotFound(String message, String field, String value) {
        super(String.format(message, field, value));
    }
}
