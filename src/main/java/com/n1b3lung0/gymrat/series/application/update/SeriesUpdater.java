package com.n1b3lung0.gymrat.series.application.update;

import com.n1b3lung0.gymrat.common.log.application.LogConstants;
import com.n1b3lung0.gymrat.series.application.find.SeriesFinder;
import com.n1b3lung0.gymrat.series.domain.RestTime;
import com.n1b3lung0.gymrat.series.domain.Series;
import com.n1b3lung0.gymrat.series.domain.SeriesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class SeriesUpdater {
    private final SeriesFinder finder;
    private final SeriesRepository repository;

    @Transactional
    public Series update(SeriesUpdateRequest request) {
        Series series = finder.findById(request.getId());

        Integer serialNumber = request.getSerialNumber();
        if (serialNumber != null && !serialNumber.equals(series.getSerialNumber())) {
            series = series.withSerialNumber(serialNumber);
        }

        Integer repetitionsToDo = request.getRepetitionsToDo();
        if (repetitionsToDo != null && !repetitionsToDo.equals(series.getRepetitionsToDo())) {
            series = series.withRepetitionsToDo(repetitionsToDo);
        }

        Integer repetitionsDone = request.getRepetitionsDone();
        if (repetitionsDone != null && !repetitionsDone.equals(series.getRepetitionsDone())) {
            series = series.withRepetitionsDone(repetitionsDone);
        }

        Integer intensity = request.getIntensity();
        if (intensity != null && !intensity.equals(series.getIntensity())) {
            series = series.withIntensity(intensity);
        }

        Float weight = request.getWeight();
        if (weight != null && !weight.equals(series.getWeight())) {
            series = series.withWeight(weight);
        }

        RestTime restTime = request.getRestTime();
        if (restTime != null && !restTime.equals(series.getRestTime())) {
            series = series.withRestTime(restTime);
        }

        Series updated = series.update(series, "n1b3lung0");
        series = repository.save(updated);
        log.debug(LogConstants.UPDATED, "SERIES", series);
        return series;
    }
}
