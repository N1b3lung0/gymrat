package com.n1b3lung0.gymrat.series.application.create;

import com.n1b3lung0.gymrat.common.audit.domain.AuditFields;
import com.n1b3lung0.gymrat.series.domain.RestTime;
import com.n1b3lung0.gymrat.series.domain.Series;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeriesCreateRequest {

    private Integer serialNumber;

    private Integer repetitionsToDo;

    private Integer repetitionsDone;

    private Integer intensity;

    private Float weight;

    private ZonedDateTime startSeries;

    private ZonedDateTime endSeries;

    private RestTime restTime;

    public Series toSeries(
            Integer serialNumber,
            Integer repetitionsToDo,
            Integer repetitionsDone,
            Integer intensity,
            Float weight,
            ZonedDateTime startSeries,
            ZonedDateTime endSeries,
            RestTime restTime
    ) {
        return Series.create(
                serialNumber,
                repetitionsToDo,
                repetitionsDone,
                intensity,
                weight,
                startSeries,
                endSeries,
                restTime,
                "n1b3lung0"
        );
    }
}