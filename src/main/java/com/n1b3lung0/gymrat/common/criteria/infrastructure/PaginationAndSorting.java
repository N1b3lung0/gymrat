package com.n1b3lung0.gymrat.common.criteria.infrastructure;

import com.n1b3lung0.gymrat.common.criteria.domain.Pagination;
import com.n1b3lung0.gymrat.common.criteria.domain.Sorting;
import lombok.experimental.UtilityClass;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@UtilityClass
public final class PaginationAndSorting {

    public static Pageable asPageable(Pagination pagination, Sorting sorting) {
        Sort sort = sorting.isSorted()
                ? Sort.by(Sort.Order.by(sorting.getSortBy())
                    .with(Sort.Direction.fromString(sorting.getSortDirection().getType())))
                : Sort.unsorted();

        if (pagination.isPaginated()) {
            return sorting.isSorted()
                    ? PageRequest.of(pagination.getPageNumber(), pagination.getPageSize(), sort)
                    : PageRequest.of(pagination.getPageNumber(), pagination.getPageSize());
        } else {
            return sorting.isSorted()
                    ? PageRequest.of(0, Integer.MAX_VALUE, sort)
                    : Pageable.unpaged();
        }
    }
}
