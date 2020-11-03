DROP DATABASE IF EXISTS spotify;
CREATE DATABASE spotify;

USE spotify;


CREATE TABLE Album (
    `AlbumId`     VARCHAR(36),
    `Name`        VARCHAR(50),
    `ReleaseDate` DATE,
    `Type`        ENUM ('LP', 'EP', 'Single'),
    PRIMARY KEY (`AlbumId`)
);

CREATE TABLE `Song` (
    `SongId`    VARCHAR(36),
    `Name`      VARCHAR(50),
    `Explicit`  BOOL,
    `Length`    INT,
    `Likedness` INT,
    `AlbumId`   VARCHAR(36),
    PRIMARY KEY (`SongId`),
    FOREIGN KEY (AlbumId) REFERENCES Album (AlbumId)
);

CREATE TABLE `Artist` (
    `ArtistId` VARCHAR(36),
    `Name`     VARCHAR(50),
    `About`    VARCHAR(2000),
    PRIMARY KEY (`ArtistId`)
);

CREATE TABLE `ArtistSong` (
    `ArtistId` VARCHAR(36),
    `SongId`   VARCHAR(36),
    PRIMARY KEY (ArtistId, SongId),
    FOREIGN KEY (ArtistId) REFERENCES Artist (ArtistId),
    FOREIGN KEY (SongId) REFERENCES Song (SongId)
);

CREATE TABLE `Playlist` (
    `PlaylistId` VARCHAR(36),
    PRIMARY KEY (`PlaylistId`)
);

CREATE TABLE `PlaylistSong` (
    `SongId`     VARCHAR(36),
    `PlaylistId` VARCHAR(36),
    PRIMARY KEY (SongId, PlaylistId),
    FOREIGN KEY (SongId) REFERENCES Song (SongId),
    FOREIGN KEY (PlaylistId) REFERENCES Playlist (PlaylistId)
);

CREATE TABLE `ArtistAlbum` (
    `ArtistId` VARCHAR(36),
    `AlbumId`  VARCHAR(36),
    PRIMARY KEY (ArtistId, AlbumId),
    FOREIGN KEY (ArtistId) REFERENCES Artist (ArtistId),
    FOREIGN KEY (AlbumId) REFERENCES Album (AlbumId)
);
