package com.n1b3lung0.gymrat.user.domain.exception;

import com.n1b3lung0.gymrat.common.exception.application.ExceptionConstants;
import com.n1b3lung0.gymrat.common.exception.domain.NotValid;

import java.io.Serial;

public class UserNotValid extends NotValid {
    @Serial
    private static final long serialVersionUID = -1L;

    public UserNotValid(String field, String value, String reason) {
        super(ExceptionConstants.USER_NOT_VALID, field, value, reason);
    }
}
