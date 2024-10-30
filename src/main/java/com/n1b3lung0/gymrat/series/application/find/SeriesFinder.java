package com.n1b3lung0.gymrat.series.application.find;

import com.n1b3lung0.gymrat.common.uuid.UUIDUtils;
import com.n1b3lung0.gymrat.series.domain.Series;
import com.n1b3lung0.gymrat.series.domain.SeriesRepository;
import com.n1b3lung0.gymrat.series.domain.exception.SeriesNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SeriesFinder {

    private final SeriesRepository repository;

    @Transactional(readOnly = true)
    public Series findById(String id) {
        return repository.findById(UUIDUtils.fromString(id))
                .orElseThrow(() -> new SeriesNotFound("id", id));
    }
}
