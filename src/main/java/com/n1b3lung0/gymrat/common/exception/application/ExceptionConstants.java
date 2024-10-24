package com.n1b3lung0.gymrat.common.exception.application;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class ExceptionConstants {

    // EXERCISE
    public static final String EXERCISE_NOT_FOUND = "An exercise with ''%s '%s' could not be found";
    public static final String EXERCISE_NOT_VALID = "Exercise '%s' is not valid. Reason: '%s'";
    public static final String EXERCISE_REPEATED = "An exercise with name %s has already been created";
}
