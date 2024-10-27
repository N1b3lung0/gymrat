package com.n1b3lung0.gymrat.common.uuid;

import com.n1b3lung0.gymrat.common.exception.application.ExceptionConstants;
import com.n1b3lung0.gymrat.common.exception.domain.NotValid;

import java.io.Serial;

public final class UUIDNotValid extends NotValid {

    @Serial
    private static final long serialVersionUID = -1L;

    public UUIDNotValid(String id) {
        super(ExceptionConstants.UUID_NOT_VALID, id);
    }
}
