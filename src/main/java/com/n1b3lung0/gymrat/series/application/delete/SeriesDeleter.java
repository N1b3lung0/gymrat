package com.n1b3lung0.gymrat.series.application.delete;

import com.n1b3lung0.gymrat.common.audit.domain.AuditFields;
import com.n1b3lung0.gymrat.common.log.application.LogConstants;
import com.n1b3lung0.gymrat.series.application.find.SeriesFinder;
import com.n1b3lung0.gymrat.series.domain.Series;
import com.n1b3lung0.gymrat.series.domain.SeriesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class SeriesDeleter {
    private final SeriesFinder finder;
    private final SeriesRepository repository;

    @Transactional
    public void delete(String id) {
        Series series = finder.findById(id);
        AuditFields auditFields = series.getAuditFields();
        Series deleted = series.withAuditFields(auditFields.delete("n1b3lung0"));
        repository.save(deleted);
        log.debug(LogConstants.DELETED, "SERIES", deleted);
    }
}
