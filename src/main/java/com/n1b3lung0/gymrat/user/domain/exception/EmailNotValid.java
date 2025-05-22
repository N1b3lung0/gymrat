package com.n1b3lung0.gymrat.user.domain.exception;

import com.n1b3lung0.gymrat.common.exception.application.ExceptionConstants;
import com.n1b3lung0.gymrat.common.exception.domain.NotValid;

import java.io.Serial;

public final class EmailNotValid extends NotValid {

  @Serial
  private static final long serialVersionUID = -1L;

  public EmailNotValid(String email, String reason) {
    super(ExceptionConstants.EMAIL_NOT_VALID, email, reason);
  }
}
