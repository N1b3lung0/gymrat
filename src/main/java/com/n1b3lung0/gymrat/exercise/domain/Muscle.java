package com.n1b3lung0.gymrat.exercise.domain;

import lombok.Getter;

@Getter
public enum Muscle {
    CHEST("chest"),
    BACK("back"),
    SHOULDER("shoulder"),
    BICEPS("biceps"),
    TRICEPS("triceps"),
    CUADRICEPS("cuadriceps"),
    HAMSTRINGS("hamstrings"),
    GLUTEAL("gluteal"),
    CORE("core"),
    LUMBAR("lumbar"),
    CALFS("calfs"),
    ABDUCTORS("abductors"),
    ADDUCTORS("adductors"),
    FOREARMS("forearms"),
    TRAPEZE("trapeze");

    private final String name;

    Muscle(String name) {
        this.name = name;
    }

}
