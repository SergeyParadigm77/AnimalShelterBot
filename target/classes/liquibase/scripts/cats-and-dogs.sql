--liquibase formatted sql

-- changeset DIvanov:1
CREATE TABLE IF NOT EXISTS cats
(
    cat_id                  BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    nickname                TEXT NOT NULL,
    breed                   TEXT NOT NULL,
    age                     BIGINT NOT NULL,
    note                    TEXT NOT NULL
);

-- changeset DIvanov:2
CREATE TABLE IF NOT EXISTS dogs
(
    dog_id                  BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    nickname                TEXT NOT NULL,
    breed                   TEXT NOT NULL,
    age                     BIGINT NOT NULL,
    note                    TEXT NOT NULL
);

-- changeset DIvanov:3
CREATE TABLE IF NOT EXISTS users
(
    user_id                 BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name                    TEXT NOT NULL,
    surname                 TEXT NOT NULL,
    age                     BIGINT NOT NULL,
    phone_number            BIGINT NOT NULL,
    email_address           TEXT NOT NULL,
    address                 TEXT NOT NULL
);

-- changeset DIvanov:4
CREATE TABLE IF NOT EXISTS volunteers
(
    volunteer_id            BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name                    TEXT NOT NULL,
    surname                 TEXT NOT NULL,
    age                     BIGINT NOT NULL,
    phone_number            BIGINT NOT NULL,
    email_address           TEXT NOT NULL
);