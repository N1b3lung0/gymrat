CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE categories
(
    id   UUID    NOT NULL,
    name VARCHAR NOT NULL,
    CONSTRAINT pk_categories PRIMARY KEY (id)
);

ALTER TABLE categories
    ADD CONSTRAINT uc_categories_name UNIQUE (name);