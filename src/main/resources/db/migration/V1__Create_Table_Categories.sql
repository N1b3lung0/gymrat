CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE categories
(
    id   UUID    NOT NULL,
    name VARCHAR NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE,
    created_by VARCHAR,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    updated_by VARCHAR,
    active BOOLEAN,
    deleted_at TIMESTAMP WITHOUT TIME ZONE,
    deleted_by VARCHAR,
    CONSTRAINT pk_categories PRIMARY KEY (id)
);

ALTER TABLE categories
    ADD CONSTRAINT uc_categories_name UNIQUE (name);