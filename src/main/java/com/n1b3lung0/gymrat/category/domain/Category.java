package com.n1b3lung0.gymrat.category.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
public final class Category implements Serializable {

    @Serial
    private static final long serialVersionUID = -1L;

    @Id
    @GeneratedValue
    @With
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private final UUID id;

    @With
    @Column(name = "name", nullable = false, unique = true)
    private final String name;
}
