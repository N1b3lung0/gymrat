package com.n1b3lung0.gymrat.common.swagger.rest;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class SwaggerConstants {

    public static final String OK_CODE = "200";
    public static final String OK_DESCRIPTION = "OK. Request has been successfully fulfilled";

    public static final String CREATED_CODE = "201";
    public static final String CREATED_DESCRIPTION = "CREATED. Resource has been succesfully created";

    public static final String NO_CONTENT_CODE = "204";
    public static final String NO_CONTENT_DESCRIPTION = "NO CONTENT. Request has been successfully fulfilled. No content has been retrieved";

    public static final String BAD_REQUEST_CODE = "400";
    public static final String BAD_REQUEST_DESCRIPTION = "BAD REQUEST. Request with errors";

    public static final String UNAUTHORIZED_CODE = "401";
    public static final String UNAUTHORIZED_DESCRIPTION = "UNAUTHORIZED. Request is not authorized";

    public static final String FORBIDDEN_CODE = "403";
    public static final String FORBIDDEN_DESCRIPTION = "FORBIDDEN. Request is not allowed";

    public static final String NOT_FOUND_CODE = "404";
    public static final String NOT_FOUND_DESCRIPTION = "NOT FOUND. Resource could not be found";

    public static final String SERVER_ERROR_CODE = "500";
    public static final String SERVER_ERROR_DESCRIPTION = "INTERNAL SERVER ERROR. Request could not be fulfilled due to an unexpected error";

    // EXERCISE
    public static final String FIND_EXERCISE_BY_NAME = "Find an exercise by its unique name";
    public static final String FIND_EXERCISE_BY_CRITERIA = "Get a filtered, sorted and paginated list of exercises";
    public static final String CREATE_EXERCISE = "Create an exercise";
    public static final String UPDATE_EXERCISE = "Update a given exercise";
    public static final String DELETE_EXERCISE = "Delete a given exercise";

    // SERIES
    public static final String FIND_SERIES_BY_ID = "Find a series by its unique id";
    public static final String CREATE_SERIES = "Create a series";
    public static final String UPDATE_SERIES = "Update a given series";
    public static final String DELETE_SERIES = "Delete a given series";

    // EXERCISE-SERIES
    public static final String FIND_EXERCISE_SERIES_BY_ID = "Find an exercise-series by its unique id";
    public static final String CREATE_EXERCISE_SERIES = "Create an exercise-series";
    public static final String UPDATE_EXERCISE_SERIES = "Update a given exercise-series";
    public static final String DELETE_EXERCISE_SERIES = "Delete a given exercise-series";

    // WORKOUT
    public static final String FIND_WORKOUT_BY_ID = "Find a workout by its unique id";
    public static final String CREATE_WORKOUT = "Create a workout";
    public static final String UPDATE_WORKOUT = "Update a given workout";
    public static final String DELETE_WORKOUT = "Delete a given workout";
}
