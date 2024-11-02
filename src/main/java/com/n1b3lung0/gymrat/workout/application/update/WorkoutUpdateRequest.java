package com.n1b3lung0.gymrat.workout.application.update;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutUpdateRequest {

    @NotBlank
    private String id;

    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
}
