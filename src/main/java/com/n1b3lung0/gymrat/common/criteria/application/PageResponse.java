package com.n1b3lung0.gymrat.common.criteria.application;

import com.n1b3lung0.gymrat.common.criteria.domain.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResponse<T> {

    private List<T> items;
    private int pageNumber;
    private int pageSize;
    private boolean firstPage;
    private boolean lastPage;

    public PageResponse(Page<?> page, List<T> items) {
        this.items = items;
        this.pageNumber = page.getNumber();
        this.pageSize = page.getSize();
        this.firstPage = page.isFirstPage();
        this.lastPage = page.isLastPage();
    }
}
