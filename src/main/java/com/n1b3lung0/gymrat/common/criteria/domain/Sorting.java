package com.n1b3lung0.gymrat.common.criteria.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.io.Serial;
import java.io.Serializable;

@Value
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Sorting implements Serializable {

    @Serial
    private static final long serialVersionUID = -1L;

    boolean sorted;
    String sortBy;
    SortDirection sortDirection;

    private static final String createdBy = "auditFields.createdBy";

    public static Sorting unsorted() {
        return new Sorting(false, null, null);
    }

    public static Sorting byDefault() {
        return new Sorting(true, createdBy, SortDirection.DESC);
    }

    public static Sorting of(@NotBlank String sortBy, @NotNull SortDirection sortDirection) {
        return new Sorting(true, sortBy, sortDirection);
    }
}
