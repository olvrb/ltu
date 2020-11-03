USE bit2;

INSERT INTO Kompetens (Beskrivning)
VALUES ('databas'),
       ('python'),
       ('arcgis');

INSERT INTO Foretag (Organisationsnummer, Namn, Telefon, Email)
VALUES ('556826-9814', 'Brodpassion', '0709584232', 'me@brodpassion.se'),
       ('556826-9815', 'Passionbrod', '0709584233', 'me@passionbrod.se');

INSERT INTO Kurs (Kursnamn)
VALUES ('Databas introduktion'),
       ('Python introduktion'),
       ('python med databas');

INSERT INTO Kurs (Kursnamn, Foretagsid)
VALUES ('ArcGIS', 1);


INSERT INTO Datasal (Sal)
VALUES ('E632'),
       ('B192'),
       ('C305');

INSERT INTO Elev (Fnamn, Enamn, Telefon, Email)
VALUES ('revilo', 'yeduob', '0709584231', 'qebuodo1@em.moc'),
       ('rebilo', 'ueduob', '0709584232', 'webuodo1@em.moc'),
       ('renilo', 'ieduob', '0709584233', 'eebuodo1@em.moc'),
       ('remilo', 'oeduob', '0709584234', 'rebuodo1@em.moc'),
       ('företag', 'företagsson', '0709584234', 'rebuodo1@em.moc');

INSERT INTO Larare (Fnamn, Enamn, Telefon, Email)
VALUES ('divad', 'greb', '0701827341', 'dgreb1@em.moc'),
       ('fivad', 'greb', '0701827342', 'dgreb1@em.moc'),
       ('givad', 'greb', '0701827343', 'dgreb1@em.moc'),
       ('hivad', 'greb', '0701827344', 'dgreb1@em.moc');

INSERT INTO Kurstillfalle (Kursid, Datasalsid, Start, Slut)
VALUES (1, 1, STR_TO_DATE('2020-08-17 10:00', '%Y-%m-%d %H:%i'), STR_TO_DATE('2020-08-17 14:00', '%Y-%m-%d %H:%i')),
       (2, 1, STR_TO_DATE('2020-08-17 10:00', '%Y-%m-%d %H:%i'), STR_TO_DATE('2020-08-17 14:00', '%Y-%m-%d %H:%i')),
       (3, 3, STR_TO_DATE('2020-08-17 10:00', '%Y-%m-%d %H:%i'), STR_TO_DATE('2020-08-17 14:00', '%Y-%m-%d %H:%i'));

INSERT INTO Kurstillfalleslarare (Kurstillfallesid, Lararid)
VALUES (1, 1),
       (2, 2),
       (3, 3);

INSERT INTO Kurstillfalleselev (Kurstillfallesid, Elevid, Betyg)
VALUES (1, 1, 50),
       (1, 2, 75),
       (1, 3, 100),
       (2, 3, 25),
       (2, 4, 10);

INSERT INTO Lararkompetens (Lararid, Kompetensid)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (2, 2),
       (2, 3),
       (3, 3),
       (3, 1);

INSERT INTO Kurskompetens (Kursid, Kompetensid)
VALUES (1, 1),
       (2, 2),
       (3, 1),
       (3, 2),
       (4, 3),
       (4, 2);

INSERT INTO Foretagselev (Elevid, Foretagsid)
VALUES (4, 1),
       (5, 2);