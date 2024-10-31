package com.n1b3lung0.gymrat.common.exception.application;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class ExceptionConstants {

    // EXCEPTIONS
    public static final String NOT_FOUND = "The requested content cannot be found";
    public static final String NOT_VALID = "The request is not valid";
    public static final String ALREADY_EXISTS = "The requested content already exists and cannot be created";
    public static final String NOT_ALLOWED = "The requested operation is not allowed";
    public static final String FORBIDDEN = "The user lacks permission to perform the request";
    public static final String ILLEGAL_ARGUMENT = "Illegal argument";
    public static final String DATA_INTEGRITY_VIOLATION = "Data integrity violation";
    public static final String CONSTRAINT_VIOLATION = "Constraint violation";
    public static final String ARGUMENT_NOT_VALID = "Method argument not valid";

    // ID
    public static final String ID_REQUIRED = "Id is required";
    public static final String UUID_NOT_VALID = "'%s' is not a valid UUID";

    // EXERCISE
    public static final String EXERCISE_NOT_FOUND = "An exercise with %s '%s' could not be found";
    public static final String EXERCISE_NOT_VALID = "Exercise '%s' is not valid. Reason: '%s'";
    public static final String EXERCISE_REPEATED = "An exercise with name %s has already been created";
    public static final String EXERCISE_NAME_LENGTH_NOT_VALID = "Name exercise must be between {min} and {max} characters long";

    // SERIES
    public static final String SERIES_NOT_FOUND = "A series with %s '%s' could not be found";

    // EXERCISE-SERIES
    public static final String EXERCISE_SERIES_NOT_FOUND = "An Exercise Series with %s '%s' could not be found";
}
