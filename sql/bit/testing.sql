USE bit2;


-- Lista namnet på alla lärare som har en angiven kompetens.
SELECT Fnamn, Enamn
FROM Larare
         JOIN Lararkompetens Lk ON Larare.Lararid = Lk.Lararid
         JOIN Kompetens K ON Lk.Kompetensid = K.Kompetensid
WHERE Beskrivning = 'python';

-- Registrera kursdeltagare på ett kurstillfälle.
/*
INSERT INTO KursTillfallesElev (KursTillfallesId, ElevId) VALUE
    ((SELECT KursTillfallesId
      FROM KursTillfalle
               JOIN Kurs K ON KursTillfalle.KursId = K.KursId
      WHERE KursNamn = 'Python introduktion'), 5);

SELECT FNamn, ENamn FROM KursTillfallesElev
    JOIN KursTillfalle KT ON KursTillfallesElev.KursTillfallesId = KT.KursTillfallesId
    JOIN Kurs K ON KT.KursId = K.KursId
    JOIN Elev E ON KursTillfallesElev.ElevId = E.ElevId
WHERE KursNamn = 'Python introduktion';

 */

-- Lista kursdeltagare för namngiven företagskund för en specifik kurs.
SELECT FNamn, ENamn, KursNamn
FROM KursTillfallesElev
         JOIN Elev E ON KursTillfallesElev.ElevId = E.ElevId
         RIGHT OUTER JOIN ForetagsElev FE ON E.ElevId = FE.ElevId
         JOIN Foretag F ON FE.ForetagsId = F.ForetagsId
         JOIN KursTillfalle KT ON KursTillfallesElev.KursTillfallesId = KT.KursTillfallesId
         JOIN Kurs K ON KT.KursId = K.KursId
WHERE F.Namn = 'Brodpassion'
  AND KursNamn = 'Python introduktion';


-- Lägg till en namngiven lärare till ett kurstillfälle.
/*
INSERT INTO KursTillfallesLarare (KursTillfallesId, LararId) VALUE
    (3, (
        SELECT LararId
        FROM Larare
        WHERE concat(FNamn, ' ', ENamn) LIKE 'divad%'
    ));


SELECT * FROM KursTillfallesLarare
JOIN KursTillfalle KT ON KursTillfallesLarare.KursTillfallesId = KT.KursTillfallesId
JOIN Larare L ON KursTillfallesLarare.LararId = L.LararId
WHERE KT.KursTillfallesId = 3;

 */

-- Visa sammanställning av provresultat (medelvärde av provresultat) för angivet kursnamn och tidsperiod grupperat per kurstillfälle.
SELECT KT.KursTillfallesId, AVG(Betyg)
FROM Kurs
         JOIN KursTillfalle KT ON Kurs.KursId = KT.KursId
         JOIN KursTillfallesElev KTE ON KT.KursTillfallesId = KTE.KursTillfallesId
WHERE KursNamn = 'Python introduktion'
GROUP BY KT.KursTillfallesId;

-- Visa lista på anställda lärare (namn) som för tillfället inte undervisar.

SELECT FNamn, ENamn
FROM Larare
WHERE LararId NOT IN (SELECT Larare.LararId
                      FROM Larare
                               LEFT JOIN KursTillfallesLarare KTL ON Larare.LararId = KTL.LararId
                      WHERE KursTillfallesId IS NULL
);