CREATE TABLE exercise_series
(
    id          UUID NOT NULL,
    workout_id  UUID NOT NULL,
    exercise_id UUID NOT NULL,
    created_at        TIMESTAMP WITHOUT TIME ZONE,
    created_by        VARCHAR(255),
    updated_at        TIMESTAMP WITHOUT TIME ZONE,
    updated_by        VARCHAR(255),
    active            BOOLEAN,
    deleted_at        TIMESTAMP WITHOUT TIME ZONE,
    deleted_by        VARCHAR(255),
    CONSTRAINT pk_exercise_series PRIMARY KEY (id)
);

ALTER TABLE exercise_series
    ADD CONSTRAINT FK_EXERCISE_SERIES_ON_EXERCISE FOREIGN KEY (exercise_id) REFERENCES exercises (id);

ALTER TABLE exercise_series
    ADD CONSTRAINT FK_EXERCISE_SERIES_ON_WORKOUT FOREIGN KEY (workout_id) REFERENCES workouts (id);
