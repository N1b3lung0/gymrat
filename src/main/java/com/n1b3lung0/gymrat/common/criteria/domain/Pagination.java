package com.n1b3lung0.gymrat.common.criteria.domain;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.io.Serial;
import java.io.Serializable;

@Value
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Pagination implements Serializable {

    @Serial
    private static final long serialVersionUID = -1L;

    boolean paginated;
    Integer pageNumber;
    Integer pageSize;

    public static Pagination unpaged() {
        return new Pagination(false, null, null);
    }

    public static Pagination of(Integer pageNumber, Integer pageSize) {
        return new Pagination(Boolean.TRUE, pageNumber, pageSize);
    }
}
