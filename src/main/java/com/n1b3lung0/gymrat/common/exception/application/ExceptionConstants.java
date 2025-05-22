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

    // WORKOUT
    public static final String WORKOUT_NOT_FOUND = "A Workout with %s '%s' could not be found";

    // USER
    public static final String USER_NOT_FOUND = "User with %s '%s' could not be found";
    public static final String USER_NOT_VALID = "User '%s' is not valid. Reason: %s";
    public static final String USERNAME_REPEATED = "A user with username %s has already been created";
    public static final String GROUP_ROLES_AND_PERMISSIONS_MISMATCH = "The number of group roles and groups with permissions must be the same";
    public static final String USERNAME_LENGTH_NOT_VALID = "Username must be between {min} and {max} characters long";
    public static final String USER_DELETE_NOT_ALLOWED = "User delete not allowed. Reason: %s";
    public static final String DEFAULT_USER_CANNOT_BE_REMOVED = "Default user cannot be removed";
    public static final String USER_UPDATE_NOT_ALLOWED = "User update not allowed. Reason: %s";
    public static final String DEFAULT_USER_CANNOT_BE_UPDATED = "Default user cannot be updated";

    // USER PASSWORD
    public static final String USER_PASSWORD_REQUIRED = "User password is required";
    public static final String USER_PASSWORD_NOT_VALID = "User password '%s' is not a valid value. Reason: %s";
    public static final String PASSWORD_DEFAULT_REASON = "Password must contain between 8 and 20 characters with no whitespaces. It must contain at least one digit, one uppercase letter, one lowercase letter and one special character (!@#$%&*()-+=^)";
    public static final String USER_PASSWORD_UPDATE_NOT_ALLOWED = "User password update not allowed. Reason: %s";
    public static final String WRONG_OLD_PASSWORD = "Old password is wrong";
    public static final String WRONG_REPEATED_PASSWORD = "New password and repeated password don't match";

    // EMAIL
    public static final String EMAIL_REQUIRED = "Email is required";
    public static final String EMAIL_NOT_VALID = "Email '%s' is not a valid value. Reason: %s";
    public static final String EMAIL_DEFAULT_REASON = "Email must contain any numbers, letters or RFC 5322 allowed characters followed by an @ symbol and any number of domain names separated by dots (e.g.: 'some.valid_name@thirdlevel.secondlevel.firstlevel')";

}
