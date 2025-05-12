package com.n1b3lung0.gymrat.user.application.find;

import com.n1b3lung0.gymrat.user.domain.User;
import com.n1b3lung0.gymrat.user.domain.UserRepository;
import com.n1b3lung0.gymrat.user.domain.exception.UserNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserFinder {

    private final UserRepository repository;

    @Transactional(readOnly = true)
    public User findById(String id) {
        return repository.findById(UUID.fromString(id))
                .orElseThrow(() -> new UserNotFound("id", id));
    }

    @Transactional(readOnly = true)
    public User findByEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new UserNotFound("email", email));
    }
}
