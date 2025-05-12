package com.n1b3lung0.gymrat.user.domain;

import com.n1b3lung0.gymrat.common.exception.application.ExceptionConstants;
import com.n1b3lung0.gymrat.user.domain.exception.UserPasswordNotValid;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.With;
import org.apache.commons.lang3.StringUtils;

import java.io.Serial;
import java.io.Serializable;

@Value
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Embeddable
public class UserPassword implements Serializable {

    @Serial
    private static final long serialVersionUID = -1L;

    @Transient
    String value;

    @With
    String encoded;

    private void validate(String password) {
        if (StringUtils.isBlank(password)) {
            throw new IllegalArgumentException(ExceptionConstants.USER_PASSWORD_REQUIRED);
        }
        if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$")) {
            throw new UserPasswordNotValid(password, ExceptionConstants.PASSWORD_DEFAULT_REASON);
        }
    }
}
