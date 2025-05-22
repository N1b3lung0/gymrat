package com.n1b3lung0.gymrat.user.application.create;

import com.n1b3lung0.gymrat.common.exception.application.ExceptionConstants;
import com.n1b3lung0.gymrat.user.domain.Email;
import com.n1b3lung0.gymrat.user.domain.User;
import com.n1b3lung0.gymrat.user.domain.UserPassword;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequest {

    @NotBlank
    @Size(min = 4, max = 20, message = ExceptionConstants.USERNAME_LENGTH_NOT_VALID)
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String repeatedPassword;

    @NotBlank
    private String email;

    @NotBlank
    private String firstName;

    private String lastName1;

    private String lastName2;

    public User toUser(
            UserPassword encodedPassword
    ) {
        return User.create(
                username,
                encodedPassword,
                new Email(email),
                firstName,
                lastName1,
                lastName2
        );
    }
}
