package com.n1b3lung0.gymrat.exercise.domain;

import com.n1b3lung0.gymrat.common.criteria.domain.Criteria;
import com.n1b3lung0.gymrat.common.criteria.domain.Pagination;
import com.n1b3lung0.gymrat.common.criteria.domain.Sorting;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public final class ExerciseSearchCriteria extends Criteria implements Serializable {

    @Serial
    private static final long serialVersionUID = -1L;

    private final String query;

    public ExerciseSearchCriteria(Pagination pagination, Sorting sorting) {
        super(pagination, sorting);
        this.query = null;
    }

    public ExerciseSearchCriteria(Pagination pagination, Sorting sorting, String query) {
        super(pagination, sorting);
        this.query = query;
    }


}
