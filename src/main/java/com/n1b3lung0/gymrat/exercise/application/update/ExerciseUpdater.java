package com.n1b3lung0.gymrat.exercise.application.update;

import com.n1b3lung0.gymrat.common.audit.domain.AuditFields;
import com.n1b3lung0.gymrat.common.exception.application.ExceptionConstants;
import com.n1b3lung0.gymrat.common.log.application.LogConstants;
import com.n1b3lung0.gymrat.exercise.application.find.ExerciseFinder;
import com.n1b3lung0.gymrat.exercise.domain.Exercise;
import com.n1b3lung0.gymrat.exercise.domain.ExerciseRepository;
import com.n1b3lung0.gymrat.exercise.domain.Level;
import com.n1b3lung0.gymrat.exercise.domain.Muscle;
import com.n1b3lung0.gymrat.exercise.domain.Routine;
import com.n1b3lung0.gymrat.exercise.domain.exception.ExerciseNotValid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.SetUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExerciseUpdater {
    private final ExerciseFinder finder;
    private final ExerciseRepository repository;

    @Transactional
    public Exercise update(ExerciseUpdateRequest request) {
        Exercise exercise = finder.findById(request.getId());

        String name = request.getName();
        if (StringUtils.isNotBlank(name) && !StringUtils.equals(name, exercise.getName())) {
            if (repository.findByName(name).isPresent()) {
                throw new ExerciseNotValid(name, String.format(ExceptionConstants.EXERCISE_REPEATED, name));
            }
            exercise = exercise.withName(name);
        }

        Level level = request.getLevel();
        if (level != null && !level.equals(exercise.getLevel())) {
            exercise = exercise.withLevel(level);
        }

        Set<Routine> routines = request.getRoutines();
        if (routines != null && !SetUtils.isEqualSet(routines, exercise.getRoutines())) {
            exercise = exercise.withRoutines(routines);
        }

        Muscle primaryMuscle = request.getPrimaryMuscle();
        if (primaryMuscle != null && !primaryMuscle.equals(exercise.getPrimaryMuscle())) {
            exercise = exercise.withPrimaryMuscle(primaryMuscle);
        }

        Set<Muscle> secondaryMuscles = request.getSecondaryMuscles();
        if (secondaryMuscles != null && !SetUtils.isEqualSet(secondaryMuscles, exercise.getSecondaryMuscles())) {
            exercise = exercise.withSecondaryMuscles(secondaryMuscles);
        }

        AuditFields auditFields = exercise.getAuditFields();
        exercise = repository.save(exercise.withAuditFields(auditFields.update("n1b3lung0")));
        log.debug(LogConstants.UPDATED, "EXERCISE", exercise);
        return exercise;
    }

}
