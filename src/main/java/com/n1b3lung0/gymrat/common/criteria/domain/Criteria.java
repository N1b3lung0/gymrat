package com.n1b3lung0.gymrat.common.criteria.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public abstract class Criteria implements Serializable {

    @Serial
    private static final long serialVersionUID = -1L;

    private final Pagination pagination;
    private final Sorting sorting;
}
