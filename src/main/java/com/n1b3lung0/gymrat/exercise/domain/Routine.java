package com.n1b3lung0.gymrat.exercise.domain;

import lombok.Getter;

@Getter
public enum Routine {
    PUSH("push"),
    PULL("pull"),
    LEG("leg"),
    FULLBODY("fullbody"),
    UPPERBODY("upperbody"),
    ARMS("arms"),
    SHOULDERS("shoulders");

    private final String type;

    Routine(String type) {
        this.type = type;
    }

}
