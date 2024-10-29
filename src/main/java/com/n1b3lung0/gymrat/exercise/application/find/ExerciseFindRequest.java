package com.n1b3lung0.gymrat.exercise.application.find;

import com.n1b3lung0.gymrat.common.criteria.domain.Pagination;
import com.n1b3lung0.gymrat.common.criteria.domain.SortDirection;
import com.n1b3lung0.gymrat.common.criteria.domain.Sorting;
import com.n1b3lung0.gymrat.exercise.domain.ExerciseSearchCriteria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseFindRequest {

    private String query;
    private Integer page;
    private Integer size;
    private String sortBy;
    private SortDirection sortDirection;

    public ExerciseSearchCriteria toCriteria() {
        Pagination pagination = page != null && size != null
                ? Pagination.of(page, size)
                : Pagination.unpaged();
        Sorting sorting = StringUtils.isNotBlank(sortBy) && sortDirection != null
                ? Sorting.of(StringUtils.lowerCase(sortBy), sortDirection)
                : Sorting.byDefault();
        return new ExerciseSearchCriteria(pagination, sorting, query);
    }
}
