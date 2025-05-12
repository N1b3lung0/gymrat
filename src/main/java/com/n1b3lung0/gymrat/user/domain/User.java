package com.n1b3lung0.gymrat.user.domain;

import com.n1b3lung0.gymrat.common.audit.domain.AuditFields;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.With;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "users")
@Value
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = -1L;

    @Id
    @GeneratedValue
    UUID id;

    @With
    @Column(name = "username", nullable = false, unique = true)
    String username;

    @With
    @Column(name = "password", nullable = false)
    UserPassword password;

    @With
    @Column(name = "email", nullable = false, unique = true)
    String email;

    @With
    @Column(name = "first_name", nullable = false)
    String firstName;

    @With
    @Column(name = "last_name_1", nullable = false)
    String lastName1;

    @With
    @Column(name = "last_name_2")
    String lastName2;

    @With
    @Embedded
    AuditFields auditFields;
}
