package com.n1b3lung0.gymrat.user.domain.exception;

import com.n1b3lung0.gymrat.common.exception.application.ExceptionConstants;
import com.n1b3lung0.gymrat.common.exception.domain.NotFound;

import java.io.Serial;

public final class UserNotFound extends NotFound {

    @Serial
    private static final long serialVersionUID = -1L;

    public UserNotFound(String field, String value) {
        super(ExceptionConstants.USER_NOT_FOUND, field, value);
    }
}
