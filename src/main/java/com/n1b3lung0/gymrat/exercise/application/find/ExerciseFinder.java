package com.n1b3lung0.gymrat.exercise.application.find;

import com.n1b3lung0.gymrat.common.criteria.application.PageResponse;
import com.n1b3lung0.gymrat.common.criteria.domain.Page;
import com.n1b3lung0.gymrat.common.uuid.UUIDUtils;
import com.n1b3lung0.gymrat.exercise.domain.Exercise;
import com.n1b3lung0.gymrat.exercise.domain.ExerciseRepository;
import com.n1b3lung0.gymrat.exercise.domain.exception.ExerciseNotFound;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExerciseFinder {
    private final ExerciseRepository repository;

    @Transactional(readOnly = true)
    public Exercise findById(String id) {
        return repository.findById(UUIDUtils.fromString(id))
                .orElseThrow(() -> new ExerciseNotFound("id", id));
    }

    @Transactional(readOnly = true)
    public PageResponse<ExerciseResponse> find(ExerciseFindRequest request) {
        Page<Exercise> page = repository.find(request.toCriteria());
        return new PageResponse<>(
                page,
                page.getContent().stream()
                        .map(ExerciseResponse::fromExercise)
                        .collect(Collectors.toList())
        );
    }
}
