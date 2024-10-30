package com.n1b3lung0.gymrat.series.infrastructure;

import com.n1b3lung0.gymrat.series.domain.Series;
import com.n1b3lung0.gymrat.series.domain.SeriesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface SeriesJpaRepository extends SeriesRepository, JpaRepository<Series, UUID>, JpaSpecificationExecutor<Series> {
}
