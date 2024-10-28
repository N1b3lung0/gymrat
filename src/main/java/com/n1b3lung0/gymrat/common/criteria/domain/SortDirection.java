package com.n1b3lung0.gymrat.common.criteria.domain;

import lombok.Getter;

@Getter
public enum SortDirection {
    ASC("asc"),
    DESC("desc");

    private final String type;

    SortDirection(String type) {
        this.type = type;
    }
}
