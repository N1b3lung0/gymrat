package com.n1b3lung0.gymrat.series.application.update;

import com.n1b3lung0.gymrat.series.domain.RestTime;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeriesUpdateRequest {

    @NotBlank
    private String id;

    private Integer serialNumber;

    private Integer repetitionsToDo;

    private Integer repetitionsDone;

    private Integer intensity;

    private Float weight;

    private ZonedDateTime startSeries;

    private ZonedDateTime endSeries;

    private RestTime restTime;
}
