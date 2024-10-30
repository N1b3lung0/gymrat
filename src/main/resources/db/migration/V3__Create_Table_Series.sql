CREATE TABLE series
(
    id                 UUID NOT NULL,
    serial_number      INTEGER,
    repetitions_to_do  INTEGER,
    repetitions_done   INTEGER,
    intensity          INTEGER,
    weight             FLOAT,
    start_series       TIMESTAMP WITHOUT TIME ZONE,
    end_series         TIMESTAMP WITHOUT TIME ZONE,
    rest_time          VARCHAR(255),
    exercise_series_id UUID NOT NULL,
    created_at         TIMESTAMP WITHOUT TIME ZONE,
    created_by         VARCHAR,
    updated_at         TIMESTAMP WITHOUT TIME ZONE,
    updated_by         VARCHAR,
    active             BOOLEAN,
    deleted_at         TIMESTAMP WITHOUT TIME ZONE,
    deleted_by         VARCHAR,
    CONSTRAINT pk_series PRIMARY KEY (id)
);

ALTER TABLE series
    ADD CONSTRAINT FK_SERIES_ON_EXERCISE_SERIES FOREIGN KEY (exercise_series_id) REFERENCES exercise_series (id);
