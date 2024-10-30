package com.n1b3lung0.gymrat.series.application.find;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeriesResponse {

    private String id;

    private Integer serialNumber;

    private Integer repetitionsToDo;

    private Integer repetitionsDone;

    private Integer intensity;

    private Float weight;

    private ZonedDateTime startSeries;

    private ZonedDateTime endSeries;

    private RestTime restTime;

    @EqualsAndHashCode.Exclude
    private AuditFields auditFields;

    public static SeriesResponse fromSeries(Series series) {
        assert series != null;
        AuditFields auditFields = series.getAuditFields();
        assert auditFields != null;
        return new SeriesResponse(
                String.valueOf(series.getId()),
                series.getSerialNumber(),
                series.getRepetitionsToDo(),
                series.getRepetitionsDone(),
                series.getIntensity(),
                series.getWeight(),
                series.getStartSeries(),
                series.getEndSeries(),
                series.getRestTime(),
                auditFields
        );
    }
}
