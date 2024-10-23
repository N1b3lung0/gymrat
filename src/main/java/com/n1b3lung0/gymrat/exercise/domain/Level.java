package com.n1b3lung0.gymrat.exercise.domain;

public enum Level {
    BEGINNERS("beginners"),
    INTERMEDIATE("intermediate"),
    ADVANCED("advanced");

    private final String type;

    Level(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
