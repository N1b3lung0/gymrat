package com.n1b3lung0.gymrat.common.vo;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.io.Serial;
import java.io.Serializable;

@Value
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Embeddable
public class File implements Serializable {

    @Serial
    private static final long serialVersionUID = -1L;

    String name;
    String description;
    String url;
}
