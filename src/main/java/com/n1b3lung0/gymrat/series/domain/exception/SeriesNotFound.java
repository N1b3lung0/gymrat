package com.n1b3lung0.gymrat.series.domain.exception;

import com.n1b3lung0.gymrat.common.exception.application.ExceptionConstants;
import com.n1b3lung0.gymrat.common.exception.domain.NotFound;

import java.io.Serial;

public final class SeriesNotFound extends NotFound {

    @Serial
    private static final long serialVersionUID = -1L;

    public SeriesNotFound(String field, String value) {
        super(ExceptionConstants.SERIES_NOT_FOUND, field, value);
    }
}
