package com.n1b3lung0.gymrat.user.domain.exception;

import com.n1b3lung0.gymrat.common.exception.application.ExceptionConstants;
import com.n1b3lung0.gymrat.common.exception.domain.NotValid;

import java.io.Serial;

public final class UserPasswordNotValid extends NotValid {

    @Serial
    private static final long serialVersionUID = -1L;

    public UserPasswordNotValid(String password, String reason) {
        super(ExceptionConstants.USER_PASSWORD_NOT_VALID, password, reason);
    }
}
