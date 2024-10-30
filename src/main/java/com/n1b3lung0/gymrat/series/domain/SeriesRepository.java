package com.n1b3lung0.gymrat.series.domain;

import java.util.Optional;
import java.util.UUID;

public interface SeriesRepository {
    Optional<Series> findById(UUID id);
    Series save(Series series);
}
