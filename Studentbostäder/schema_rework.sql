
DROP database if exists lucidtest;
CREATE database lucidtest;

USE lucidtest;

CREATE TABLE `Hyresratt` (
  `LagenhetsId` VARCHAR(6),
  `GatuNamn` VARCHAR(50),
  `GatuNummer` VARCHAR(10),
  `PostNummer` INT(6),
  `Beskrivning` VARCHAR(1024),
  `AntalRum` INT(2),
  PRIMARY KEY (`LagenhetsId`)
);

CREATE TABLE `Hyresgast` (
  `HyresgastId` VARCHAR(6),
  `Personnummer` VARCHAR(12),
  `ENamn` VARCHAR(50),
  `FNamn` VARCHAR(50),
  PRIMARY KEY (`HyresgastId`),
  KEY `AK` (`Personnummer`)
);

CREATE TABLE `Hyresavtal` (
  `AvtalsId` VARCHAR(6),
  `StartDatum` DATE NOT NULL,
  `SlutDatum` DATE NOT NULL,
  `Hyra` DECIMAL(6) NOT NULL,
  PRIMARY KEY (`AvtalsId`)
);

CREATE TABLE `HyresrattsGast` (
  `HyresrattsGastId` VARCHAR(6),
  `HyresrattsId` VARCHAR(6),
  `HyresgastId` VARCHAR(6),
  `HyresavtalsId` VARCHAR(6) NOT NULL,
  PRIMARY KEY (`HyresrattsGastId`),
  FOREIGN KEY (`HyresrattsId`) REFERENCES Hyresratt(`LagenhetsId`),
  FOREIGN KEY (`HyresgastId`) REFERENCES Hyresgast(`HyresgastId`),
  FOREIGN KEY (`HyresavtalsId`) REFERENCES Hyresavtal(`AvtalsId`)
);

CREATE TABLE `Hyresinbetalning` (
  `TransaktionsId` VARCHAR(18),
  `Summa` INT,
  `Datum` DATE,
  `Betalad` BOOL,
  `HyresrattsGastId` VARCHAR(6),
  PRIMARY KEY (`TransaktionsId`),
  FOREIGN KEY (`HyresrattsGastId`) REFERENCES HyresrattsGast(`HyresrattsGastId`)
);

CREATE TABLE `Inspektion` (
  `InspektionsId` VARCHAR(6),
  `HyresrattId` VARCHAR(6) NOT NULL,
  `Datum` DATE,
  FOREIGN KEY (`HyresrattId`) REFERENCES Hyresratt(LagenhetsId),
  PRIMARY KEY (`InspektionsId`)
);


CREATE TABLE `Anmarkning` (
  `AnmarkningsId` VARCHAR(6),
  `InspektionsId` VARCHAR(6) NOT NULL,
  `HyresgastId` VARCHAR(6) NOT NULL,
  `Beskrivning` VARCHAR(1024),
  `FixDatum` DATETIME,
  PRIMARY KEY (`AnmarkningsId`),
  FOREIGN KEY (`InspektionsId`) REFERENCES Inspektion(InspektionsId),
  FOREIGN KEY (`HyresgastId`) REFERENCES Hyresgast(HyresgastId)
);



