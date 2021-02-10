DROP DATABASE IF EXISTS CustomLibrary;

CREATE DATABASE CustomLibrary;
USE CustomLibrary;

CREATE TABLE `Customer` (
    `CustomerNr`        VARCHAR(36) PRIMARY KEY,
    `Name`              VARCHAR(100)                              NOT NULL,
    `PersonNr`          VARCHAR(12)                               NOT NULL UNIQUE,
    `Email`             VARCHAR(1000),
    `Phone`             VARCHAR(20),
    `Pincode`           VARCHAR(4)                                NOT NULL,
    `CurrentlyBorrowed` INT, -- DD
    `Type`              ENUM ('RESEARCHER', 'TEACHER', 'STUDENT') NOT NULL
);

CREATE TABLE `RentalSummary` (
    `RentalSummaryNr` VARCHAR(36) PRIMARY KEY,
    `CustomerNr`      VARCHAR(36) NOT NULL,
    FOREIGN KEY (CustomerNr) REFERENCES Customer (CustomerNr) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE `Creator` (
    `CreatorNr`   VARCHAR(36),
    `Name`        VARCHAR(1000) NOT NULL,
    `Description` VARCHAR(1500),
    PRIMARY KEY (`CreatorNr`)
);

CREATE TABLE `Category` (
    `CategoryNr` VARCHAR(36) PRIMARY KEY,
    `Name`       VARCHAR(200),
    `Type`       ENUM ('DVD', 'BOOK', 'REF', 'COURSE') NOT NULL
);

CREATE TABLE `RentalObject` (
    `ObjectNr`   VARCHAR(36) PRIMARY KEY,
    `Title`      VARCHAR(1500) NOT NULL,
    `CategoryId` VARCHAR(36),
    FOREIGN KEY (CategoryId) REFERENCES Category (CategoryNr) ON UPDATE CASCADE ON DELETE SET NULL
);

CREATE TABLE `CreatorRentalObject` (
    `CreatorNr` VARCHAR(36),
    `ObjectNr`  VARCHAR(36),
    PRIMARY KEY (CreatorNr, ObjectNr),
    FOREIGN KEY (CreatorNr) REFERENCES Creator (CreatorNr) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (ObjectNr) REFERENCES RentalObject (ObjectNr) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE `Edition` (
    `ISBN`            VARCHAR(13) PRIMARY KEY,
    `CreatorName`     VARCHAR(5000), -- DD
    `PublicationYear` DATE,
    `Publisher`       VARCHAR(100),
    `Count`           INT,           -- DD
    `ObjectNr`        VARCHAR(36) NOT NULL,
    FOREIGN KEY (ObjectNr) REFERENCES RentalObject (ObjectNr) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE `PhysicalCopy` (
    `PhysicalCopyNr` VARCHAR(36) PRIMARY KEY,
    `Location`       VARCHAR(100),
    `EditionNr`      VARCHAR(36) NOT NULL,
    FOREIGN KEY (EditionNr) REFERENCES Edition (ISBN) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE `Rental` (
    `RentalNr`        VARCHAR(36) PRIMARY KEY,
    `StartDate`       DATE        NOT NULL,
    `EndDate`         DATE        NOT NULL,
    `Returned`        BOOL DEFAULT FALSE,
    `PhysicalCopyNr`  VARCHAR(36) NOT NULL,
    `RentalSummaryNr` VARCHAR(36),
    FOREIGN KEY (PhysicalCopyNr) REFERENCES PhysicalCopy (PhysicalCopyNr) ON UPDATE CASCADE ON DELETE NO ACTION,
    FOREIGN KEY (RentalSummaryNr) REFERENCES RentalSummary (RentalSummaryNr) ON UPDATE CASCADE ON DELETE SET NULL
);
