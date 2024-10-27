CREATE TABLE exercises
(
    id   UUID    NOT NULL,
    name VARCHAR NOT NULL,
    description VARCHAR,
    level VARCHAR(255),
    primary_muscle VARCHAR(255),
    created_at TIMESTAMP WITHOUT TIME ZONE,
    created_by VARCHAR,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    updated_by VARCHAR,
    active BOOLEAN,
    deleted_at TIMESTAMP WITHOUT TIME ZONE,
    deleted_by VARCHAR,
    CONSTRAINT pk_exercises PRIMARY KEY (id)
);

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

ALTER TABLE exercises
    ADD CONSTRAINT uc_exercises_name UNIQUE (name);

CREATE TABLE routines
(
    exercise_id UUID NOT NULL,
    routine    VARCHAR(255)
);

ALTER TABLE routines
    ADD CONSTRAINT fk_routines_on_exercise FOREIGN KEY (exercise_id) REFERENCES exercises (id);

ALTER TABLE exercises
    ALTER COLUMN level TYPE VARCHAR(255) USING (level::VARCHAR(255));

ALTER TABLE routines
    ALTER COLUMN routine TYPE VARCHAR(255) USING (routine::VARCHAR(255));

CREATE TABLE secondary_muscles
(
    exercise_id      UUID NOT NULL,
    secondary_muscle VARCHAR(255)
);

ALTER TABLE secondary_muscles
    ADD CONSTRAINT fk_secondary_muscles_on_exercise FOREIGN KEY (exercise_id) REFERENCES exercises (id);

ALTER TABLE secondary_muscles
    ALTER COLUMN secondary_muscle TYPE VARCHAR(255) USING (secondary_muscle::VARCHAR(255));
