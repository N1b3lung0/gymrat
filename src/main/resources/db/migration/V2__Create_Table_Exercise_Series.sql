CREATE TABLE exercise_series
(
    id          UUID NOT NULL,
    exercise_id UUID NOT NULL,
    CONSTRAINT pk_exercise_series PRIMARY KEY (id)
);

ALTER TABLE exercise_series
    ADD CONSTRAINT FK_EXERCISE_SERIES_ON_EXERCISE FOREIGN KEY (exercise_id) REFERENCES exercises (id);