package com.n1b3lung0.gymrat.exercise.infrastructure;

import com.n1b3lung0.gymrat.exercise.domain.Exercise;
import com.n1b3lung0.gymrat.exercise.domain.ExerciseSearchCriteria;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import java.util.Locale;

@UtilityClass
public final class ExerciseSpecification {
    public static Specification<Exercise> byCriteria(ExerciseSearchCriteria criteria) {
        Specification<Exercise> specification = Specification.where(null);
        String query = criteria.getQuery();
        if (StringUtils.isNotBlank(query)) {
            Specification<Exercise> byName = byFieldValueLike("name", query);
            Specification<Exercise> byDescription = byFieldValueLike("description", query);
            specification = specification.and(byName.or(byDescription));
        }
        return specification;
    }

    private static Specification<Exercise> byFieldValueLike(String field, String value) {
        return ((root, query, cb) -> cb.like(
                cb.lower(cb.function("unaccent", String.class, root.get(field))),
                "%" + StringUtils.lowerCase(StringUtils.stripAccents(value), Locale.ROOT) + "%"
        ));
    }
}
