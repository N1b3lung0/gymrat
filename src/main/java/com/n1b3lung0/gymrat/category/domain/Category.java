package com.n1b3lung0.gymrat.category.domain;

import jakarta.persistence.Column;
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
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "categories")
@Value
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Category implements Serializable {

    @Serial
    private static final long serialVersionUID = -1L;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    UUID id;

    @With
    @Column(name = "name", nullable = false, unique = true)
    String name;

    @With(AccessLevel.PRIVATE)
    @Column(name = "active")
    Boolean active;

    @With(AccessLevel.PRIVATE)
    @Column(name = "deleted_at")
    ZonedDateTime deletedAt;

    @With(AccessLevel.PRIVATE)
    @Column(name = "deleted_by")
    String deletedBy;

    public static Category create(
            String name
    ) {
        return new Category(
                null,
                name,
                Boolean.TRUE,
                null,
                null
        );
    }

    public Category delete() {
        return withActive(Boolean.FALSE)
                .withDeletedAt(ZonedDateTime.now())
                .withDeletedBy(deletedBy);
    }
}
