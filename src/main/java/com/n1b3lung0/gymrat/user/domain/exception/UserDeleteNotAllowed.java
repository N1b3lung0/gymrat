package com.n1b3lung0.gymrat.user.domain.exception;

import com.n1b3lung0.gymrat.common.exception.application.ExceptionConstants;
import com.n1b3lung0.gymrat.common.exception.domain.NotAllowed;

import java.io.Serial;

public final class UserDeleteNotAllowed extends NotAllowed {

    @Serial
    private static final long serialVersionUID = -1L;

    public UserDeleteNotAllowed(String reason) {
        super(String.format(ExceptionConstants.USER_DELETE_NOT_ALLOWED, reason));
    }
}
