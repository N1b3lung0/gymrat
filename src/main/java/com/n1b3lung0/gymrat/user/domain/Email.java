package com.n1b3lung0.gymrat.user.domain;

import com.n1b3lung0.gymrat.common.exception.application.ExceptionConstants;
import com.n1b3lung0.gymrat.user.domain.exception.EmailNotValid;
import jakarta.persistence.Embeddable;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serial;
import java.io.Serializable;

@Data
@Embeddable
public final class Email implements Serializable {

    @Serial
    private static final long serialVersionUID = -1L;

    private final String value;

    public Email(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String email) {
        if (StringUtils.isBlank(email)) {
            throw new IllegalArgumentException(ExceptionConstants.EMAIL_REQUIRED);
        }
        if (!email.matches("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,20}$")) {
            throw new EmailNotValid(email, ExceptionConstants.EMAIL_DEFAULT_REASON);
        }
    }
}
