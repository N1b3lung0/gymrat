CREATE TABLE workouts
(
    id         UUID NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE,
    created_by VARCHAR,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    updated_by VARCHAR,
    active     BOOLEAN,
    deleted_at TIMESTAMP WITHOUT TIME ZONE,
    deleted_by VARCHAR,
    CONSTRAINT pk_workouts PRIMARY KEY (id)
);
