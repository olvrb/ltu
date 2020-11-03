use lucidtest;

-- Hitta lediga rum med villkor
SELECT GatuNamn, GatuNummer, (AntalRum - COUNT(H.HyresgastId)) AS LedigaRum
FROM HyresrattsGast
    JOIN Hyresgast H on H.HyresgastId = HyresrattsGast.HyresgastId
    RIGHT JOIN Hyresratt H2 on HyresrattsGast.HyresrattsId = H2.LagenhetsId
WHERE 3 > 0
GROUP BY GatuNamn, GatuNummer, AntalRum;

-- Se sin egen hyra?
SELECT Hyra FROM HyresrattsGast
    JOIN Hyresavtal H on HyresrattsGast.HyresavtalsId = H.AvtalsId
WHERE HyresgastId = '000001';

-- Se alla sina egna anmärkningar
SELECT GatuNamn, GatuNummer, AnmarkningsId, Anmarkning.Beskrivning, FixDatum FROM Anmarkning
    JOIN Hyresgast ON Anmarkning.AnmarkningsId = Hyresgast.HyresgastId
    JOIN HyresrattsGast HG on Hyresgast.HyresgastId = HG.HyresgastId
    JOIN Hyresratt H on HG.HyresrattsId = H.LagenhetsId
WHERE Hyresgast.HyresgastId = '000001';

-- Hur lång tid kvar på kontrakt?
SELECT FLOOR((UNIX_TIMESTAMP(SlutDatum) - UNIX_TIMESTAMP()) / 86400) FROM Hyresavtal
    JOIN HyresrattsGast HG on Hyresavtal.AvtalsId = HG.HyresavtalsId
WHERE HyresgastId = '000001';

-- Hur många lediga bostäder i en hyresrätt?
SELECT (AntalRum - COUNT(*))
FROM Hyresratt
         JOIN HyresrattsGast HG on Hyresratt.LagenhetsId = HG.HyresrattsId
WHERE LagenhetsId = '000001';

-- Hur många anmärkningar har en specifik hyresgäst?
SELECT COUNT(AnmarkningsId)
FROM anmarkning
         JOIN hyresgast ON anmarkning.HyresgastId = hyresgast.HyresgastId
WHERE Personnummer = '0204150092'
GROUP BY Hyresgast.HyresgastId, Personnummer, ENamn, FNamn;

-- Vad betalade en specifik student sist i hyra?
SELECT H.Summa
FROM HyresrattsGast
    JOIN Hyresinbetalning H on HyresrattsGast.HyresrattsGastId = H.HyresrattsGastId
WHERE HyresrattsGast.HyresgastId = '000001'
ORDER BY H.Datum DESC
LIMIT 1;

-- Vilka studenter har minst hyra?
SELECT FNamn, ENamn, Personnummer, H.HyresgastId, Hyra
FROM Hyresavtal
         JOIN HyresrattsGast HG on Hyresavtal.AvtalsId = HG.HyresavtalsId
    JOIN Hyresgast H on HG.HyresgastId = H.HyresgastId
WHERE Hyra = (SELECT MIN(Hyra) FROM Hyresavtal);

-- Ändra hyra på en hyresrätt.
UPDATE Hyresavtal
JOIN HyresrattsGast HG on Hyresavtal.AvtalsId = HG.HyresavtalsId
SET Hyra = '4000'
WHERE HyresgastId = '000001'
   OR HyresgastId = '000002';

-- Vilka individer har anmärkningar just nu?
SELECT Personnummer, ENamn, FNamn
FROM anmarkning
         JOIN hyresgast ON anmarkning.HyresgastId = hyresgast.HyresgastId;

-- Alla anmärkningar som finns det att fixa just nu? Med adress och hyresgast namn?
SELECT GatuNamn, GatuNummer, FNamn, ENamn, Anmarkning.Beskrivning
FROM Anmarkning
LEFT JOIN Inspektion I on Anmarkning.InspektionsId = I.InspektionsId
    JOIN Hyresratt H2 on I.HyresrattId = H2.LagenhetsId
LEFT JOIN Hyresgast H on Anmarkning.HyresgastId = H.HyresgastId
WHERE FixDatum IS NULL;

-- Vilken är nästa hyresrätt att inspektera?
SELECT LagenhetsId, GatuNamn, GatuNummer, Datum
FROM Hyresratt
         JOIN Inspektion ON Hyresratt.LagenhetsId = Inspektion.HyresrattId
GROUP BY LagenhetsId, GatuNamn, GatuNummer, Datum
ORDER BY Inspektion.Datum DESC
LIMIT 1;

-- När hyresrätten senast fått en inspektion?
SELECT Datum
FROM Inspektion
         JOIN Hyresratt H on Inspektion.HyresrattId = H.LagenhetsId
WHERE LagenhetsId = '000001'
GROUP BY LagenhetsId, Datum
ORDER BY Datum DESC
LIMIT 1;