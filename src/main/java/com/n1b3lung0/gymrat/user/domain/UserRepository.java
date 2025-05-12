package com.n1b3lung0.gymrat.user.domain;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    Optional<User> findById(UUID id);

    User save(User user);

    Optional<User> findByEmail(String email);
}
