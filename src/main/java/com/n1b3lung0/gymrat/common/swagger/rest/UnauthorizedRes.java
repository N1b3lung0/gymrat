package com.n1b3lung0.gymrat.common.swagger.rest;

import com.n1b3lung0.gymrat.common.exception.rest.ApiError;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD, ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@ApiResponse(
        description = SwaggerConstants.UNAUTHORIZED_DESCRIPTION,
        responseCode = SwaggerConstants.UNAUTHORIZED_CODE,
        content = { @Content( schema = @Schema(implementation = ApiError.class)) })
public @interface UnauthorizedRes {
}
