package com.n1b3lung0.gymrat.series.application.create;

import com.n1b3lung0.gymrat.common.log.application.LogConstants;
import com.n1b3lung0.gymrat.series.domain.Series;
import com.n1b3lung0.gymrat.series.domain.SeriesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class SeriesCreator {
    private final SeriesRepository repository;

    @Transactional
    public Series create(SeriesCreateRequest request) {

        Series series = request.toSeries(
                request.getSerialNumber(),
                request.getRepetitionsToDo(),
                request.getRepetitionsDone(),
                request.getIntensity(),
                request.getWeight(),
                request.getStartSeries(),
                request.getEndSeries(),
                request.getRestTime()
        );

        Series created = repository.save(series);
        log.debug(LogConstants.CREATED, "SERIES", created);
        return created;
    }
}
