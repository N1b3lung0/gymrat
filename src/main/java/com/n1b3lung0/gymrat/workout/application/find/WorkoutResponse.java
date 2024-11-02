package com.n1b3lung0.gymrat.workout.application.find;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutResponse {

    private String id;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
}
