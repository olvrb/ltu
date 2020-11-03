DROP DATABASE IF EXISTS bit2;
CREATE DATABASE bit2;
USE bit2;

CREATE TABLE `Kompetens` (
  `KompetensId` INT AUTO_INCREMENT,
  `Beskrivning` VARCHAR(50),
  PRIMARY KEY (`KompetensId`)
);

CREATE TABLE `Foretag` (
  `ForetagsId` INT AUTO_INCREMENT,
  `OrganisationsNummer` VARCHAR(11),
  `Namn` VARCHAR(50),
  `Telefon` VARCHAR(17),
  `Email` VARCHAR(150),
  PRIMARY KEY (`ForetagsId`),
  KEY `AK` (`OrganisationsNummer`)
);

CREATE TABLE `Kurs` (
  `KursId` INT AUTO_INCREMENT,
  `KursNamn` VARCHAR(50),
  `ForetagsId` INT,
  PRIMARY KEY (`KursId`),
  FOREIGN KEY (ForetagsId) REFERENCES Foretag(ForetagsId)
);

CREATE TABLE `Datasal` (
  `DatasalsId` INT AUTO_INCREMENT,
  `Sal` VARCHAR(6),
  PRIMARY KEY (`DatasalsId`)
);

CREATE TABLE `Elev` (
  `ElevId` INT AUTO_INCREMENT,
  `FNamn` VARCHAR(50),
  `ENamn` VARCHAR(50),
  `Telefon` VARCHAR(17),
  `Email` VARCHAR(150),
  PRIMARY KEY (`ElevId`)
);

CREATE TABLE `Larare` (
  `LararId` INT AUTO_INCREMENT,
  `FNamn` VARCHAR(50),
  `ENamn` VARCHAR(50),
  `Telefon` VARCHAR(17),
  `Email` VARCHAR(150),
  PRIMARY KEY (`LararId`)
);

CREATE TABLE `KursTillfalle` (
  `KursTillfallesId` INT AUTO_INCREMENT,
  `KursId` INT NOT NULL, -- en och endast en
  `DatasalsId` INT NOT NULL, -- Måste alltid ha en datasal tilldelad
  `Start` DATETIME,
  `Slut` DATETIME,
  PRIMARY KEY (`KursTillfallesId`),
  FOREIGN KEY (KursId) REFERENCES Kurs(KursId),
  FOREIGN KEY (DatasalsId) REFERENCES Datasal(DatasalsId)
);

CREATE TABLE `KursTillfallesLarare` (
  `KursTillfallesId` INT,
  `LararId` INT,
  PRIMARY KEY (KursTillfallesId, LararId),
  FOREIGN KEY (KursTillfallesId) REFERENCES KursTillfalle(KursTillfallesId),
  FOREIGN KEY (LararId) REFERENCES Larare(LararId)
);

CREATE TABLE `KursTillfallesElev` (
  `KursTillfallesId` INT,
  `ElevId` INT,
  `Betyg` INT,
  PRIMARY KEY (KursTillfallesId, ElevId),
  FOREIGN KEY (KursTillfallesId) REFERENCES KursTillfalle(KursTillfallesId),
  FOREIGN KEY (ElevId) REFERENCES Elev(ElevId)
);


CREATE TABLE `LararKompetens` (
  `LararId` INT,
  `KompetensId` INT,
  PRIMARY KEY (LararId, KompetensId),
  FOREIGN KEY (LararId) REFERENCES Larare(LararId),
  FOREIGN KEY (KompetensId) REFERENCES Kompetens(KompetensId)
);


CREATE TABLE `KursKompetens` (
  `KursId` INT,
  `KompetensId` INT,
  PRIMARY KEY (KursId, KompetensId),
  FOREIGN KEY (KursId) REFERENCES Kurs(KursId),
  FOREIGN KEY (KompetensId) REFERENCES Kompetens(KompetensId)
);

CREATE TABLE `ForetagsElev` (
  `ElevId` INT,
  `ForetagsId` INT,
  PRIMARY KEY (ElevId, ForetagsId),
  FOREIGN KEY (ElevId) REFERENCES Elev(ElevId),
  FOREIGN KEY (ForetagsId) REFERENCES Foretag(ForetagsId)
);


