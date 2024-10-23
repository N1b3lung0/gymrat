package com.n1b3lung0.gymrat.common.exception.domain;

import java.io.Serial;

public class Forbidden extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -1L;

    public Forbidden(String reason) {
        super(reason);
    }
}
