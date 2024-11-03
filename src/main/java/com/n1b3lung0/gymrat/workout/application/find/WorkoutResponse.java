package com.n1b3lung0.gymrat.workout.application.find;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.n1b3lung0.gymrat.common.audit.domain.AuditFields;
import com.n1b3lung0.gymrat.workout.domain.Workout;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkoutResponse {

    private String id;
    private ZonedDateTime startWorkout;
    private ZonedDateTime endWorkout;

    @EqualsAndHashCode.Exclude
    private AuditFields auditFields;

    public static WorkoutResponse fromWorkout(Workout workout) {
        assert workout != null;
        AuditFields auditFields = workout.getAuditFields();
        assert auditFields != null;
        return new WorkoutResponse(
                String.valueOf(workout.getId()),
                workout.getStartWorkout(),
                workout.getEndWorkout(),
                auditFields
        );
    }
}
