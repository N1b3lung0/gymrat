package com.n1b3lung0.gymrat.user.application.create;

import com.n1b3lung0.gymrat.common.exception.application.ExceptionConstants;
import com.n1b3lung0.gymrat.user.domain.User;
import com.n1b3lung0.gymrat.user.domain.UserPassword;
import com.n1b3lung0.gymrat.user.domain.UserRepository;
import com.n1b3lung0.gymrat.user.domain.exception.UserNotValid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserCreator {
    private final UserRepository repository;
    private final PasswordEncoder encoder;

    @Transactional
    public User create(UserCreateRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();

        if (!StringUtils.equals(password, request.getRepeatedPassword())) {
            throw new UserNotValid("username", username, ExceptionConstants.WRONG_REPEATED_PASSWORD);
        } else if (repository.findByUsername(username).isPresent()) {
            throw new UserNotValid("username", username, String.format(ExceptionConstants.USERNAME_REPEATED, username));
        } else {
            UserPassword encodedPassword = new UserPassword(password).withEncoded(encoder.encode(password));
            User user = repository.save(request.toUser(encodedPassword));
            log.debug("User created: {}", user);
            return user;
        }
    }
}
