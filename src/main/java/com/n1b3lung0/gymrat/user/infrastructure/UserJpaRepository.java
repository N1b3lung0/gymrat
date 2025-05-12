package com.n1b3lung0.gymrat.user.infrastructure;

import com.n1b3lung0.gymrat.user.domain.User;
import com.n1b3lung0.gymrat.user.domain.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface UserJpaRepository extends UserRepository, JpaRepository<User, UUID>, JpaSpecificationExecutor<User> {
}
