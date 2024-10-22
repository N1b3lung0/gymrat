package com.n1b3lung0.gymrat.category.domain;

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

    @With
    @Embedded
    AuditFields auditFields;

    public static Category create(
            String name,
            String createdBy
    ) {
        return new Category(
                null,
                name,
                AuditFields.create(createdBy)
        );
    }

    public Category delete(Category category, String deletedBy) {
        assert category.auditFields != null;
        AuditFields newAuditFields = category.auditFields.delete(deletedBy);
        return category.withAuditFields(newAuditFields);
    }
}
