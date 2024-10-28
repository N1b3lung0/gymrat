package com.n1b3lung0.gymrat.common.criteria.domain;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Value
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class Page<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = -1L;

    List<T> content;
    int number;
    int size;
    boolean firstPage;
    boolean lastPage;
}
