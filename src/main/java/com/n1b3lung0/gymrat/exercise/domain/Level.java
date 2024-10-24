package com.n1b3lung0.gymrat.exercise.domain;

import lombok.Getter;

@Getter
public enum Level {
    BEGINNER("beginner"),
    INTERMEDIATE("intermediate"),
    ADVANCED("advanced");

    private final String type;

    Level(String type) {
        this.type = type;
    }

}
