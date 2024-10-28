package com.n1b3lung0.gymrat.exercise.infrastructure;

import com.n1b3lung0.gymrat.common.criteria.domain.Page;
import com.n1b3lung0.gymrat.common.criteria.infrastructure.PaginationAndSorting;
import com.n1b3lung0.gymrat.exercise.domain.Exercise;
import com.n1b3lung0.gymrat.exercise.domain.ExerciseRepository;
import com.n1b3lung0.gymrat.exercise.domain.ExerciseSearchCriteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface ExerciseJpaRepository extends ExerciseRepository, JpaRepository<Exercise, UUID>, JpaSpecificationExecutor<Exercise> {

    default Page<Exercise> find(ExerciseSearchCriteria criteria) {
        org.springframework.data.domain.Page<Exercise> page = findAll(
                ExerciseSpecification.byCriteria(criteria),
                PaginationAndSorting.asPageable(criteria.getPagination(), criteria.getSorting())
        );
        return new Page<>(page.getContent(), page.getNumber(), page.getSize(), page.isFirst(), page.isLast());
    }
}
