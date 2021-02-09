DROP DATABASE IF EXISTS authors;

CREATE DATABASE IF NOT EXISTS authors;
USE authors;

CREATE TABLE author (
    `id`   VARCHAR(100) PRIMARY KEY,
    `name` VARCHAR(100)
);

CREATE TABLE works (
    `id`    VARCHAR(100) PRIMARY KEY,
    `title` TEXT
);

CREATE TABLE work_author (
    `author_id` VARCHAR(100) REFERENCES author (id),
    `work_id`   VARCHAR(100) REFERENCES works (id),
    PRIMARY KEY (author_id, work_id)
);

CREATE TABLE editions (
    `id`           VARCHAR(100) PRIMARY KEY,
    `edition_name` TEXT,
    `no_pages`     INTEGER,
    `isbn13`       TEXT,
    `works_id`     TEXT REFERENCES works (`id`)
)