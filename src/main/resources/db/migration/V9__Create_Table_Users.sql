CREATE TABLE users
(
    id          UUID NOT NULL,
    username    VARCHAR NOT NULL,
    password    VARCHAR NOT NULL,
    email       VARCHAR NOT NULL,
    first_name  VARCHAR NOT NULL,
    last_name_1 VARCHAR NOT NULL,
    last_name_2 VARCHAR,
    created_at  TIMESTAMP WITHOUT TIME ZONE,
    created_by  VARCHAR,
    updated_at  TIMESTAMP WITHOUT TIME ZONE,
    updated_by  VARCHAR,
    active      BOOLEAN,
    deleted_at  TIMESTAMP WITHOUT TIME ZONE,
    deleted_by  VARCHAR,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE users
    ADD CONSTRAINT uc_users_email UNIQUE (email);

ALTER TABLE users
    ADD CONSTRAINT uc_users_username UNIQUE (username);