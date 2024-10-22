package com.n1b3lung0.gymrat.common.audit.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.With;

import java.io.Serial;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Value
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Embeddable
public class AuditFields implements Serializable {

    @Serial
    private static final long serialVersionUID = -1L;

    @EqualsAndHashCode.Exclude
    @Column(name = "created_at")
    ZonedDateTime createdAt;

    @EqualsAndHashCode.Exclude
    @Column(name = "created_by")
    String createdBy;

    @EqualsAndHashCode.Exclude
    @With(AccessLevel.PRIVATE)
    @Column(name = "updated_at")
    ZonedDateTime updatedAt;

    @EqualsAndHashCode.Exclude
    @With(AccessLevel.PRIVATE)
    @Column(name = "updated_by")
    String updatedBy;

    @EqualsAndHashCode.Exclude
    @With(AccessLevel.PRIVATE)
    @Column(name = "active")
    Boolean active;

    @EqualsAndHashCode.Exclude
    @With(AccessLevel.PRIVATE)
    @Column(name = "deleted_at")
    ZonedDateTime deletedAt;

    @EqualsAndHashCode.Exclude
    @With(AccessLevel.PRIVATE)
    @Column(name = "deleted_by")
    String deletedBy;

    public static AuditFields create(
            String createdBy
    ) {
        return new AuditFields(
                ZonedDateTime.now(),
                createdBy,
                null,
                null,
                Boolean.TRUE,
                null,
                null
        );
    }

    public AuditFields update(String updatedBy) {
        return withUpdatedAt(ZonedDateTime.now()).withUpdatedBy(updatedBy);
    }

    public AuditFields delete(String deletedBy) {
        return withActive(Boolean.FALSE)
                .withDeletedAt(ZonedDateTime.now())
                .withDeletedBy(deletedBy);
    }
}
