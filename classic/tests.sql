USE classicmodels;

/*
SELECT DISTINCT g.spelare, g.lagid, g.goalTid
FROM faMatch m
         JOIN faGoal g ON g.matchid = m.id
WHERE m.stadion = 'Old Trafford'
  AND ((g.lagid = m.lag2 AND m.lag1 <> 'ARS') OR (g.lagid = m.lag1
    AND m.lag2 <> 'ARS'));
 */

/*
SELECT DISTINCT g.lagid, g.goalTid
FROM faMatch m
         JOIN faGoal g ON g.matchid = m.id
WHERE m.stadion = 'Wembley'
  AND ((g.lagid = m.lag2 AND m.lag1 <> 'ARS') OR (g.lagid = m.lag1
    AND m.lag2 <> 'ARS'));



SELECT DISTINCT g.spelare, g.lagid, g.goalTid
FROM faMatch m
         JOIN faGoal g ON g.matchid = m.id
WHERE m.stadion = 'Wembley'
  AND ((g.lagid = m.lag2 AND m.lag1 <> 'ARS') OR (g.lagid = m.lag1
    AND m.lag2 <> 'ARS'));

/*
SELECT DISTINCT g.spelare, g.lagid, g.goalTid
FROM faMatch m
         JOIN faGoal g ON g.matchid = m.id
WHERE m.lag1 <> 'ARS'
  AND m.lag2 <> 'ARS';
 */


/*
SELECT DISTINCT g.spelare, g.lagid, g.goalTid
FROM faMatch m
         JOIN faGoal g ON g.matchid = m.id
WHERE m.stadion = 'Wembley'
  AND (
        (g.lagid = m.lag2 AND m.lag1 <> 'Arsenal')
        OR
        (g.lagid = m.lag1 AND m.lag2 <> 'Arsenal')
    );
 */


/*
SELECT ls.namn
FROM Ltu_Student ls,
     Kurs_Stud ls,
     Kurs_Tillfalle kt,
     Ltu_Kurs lk
WHERE ls.studID = ks.studID
  AND ks.kursTillfalleID = kt.kurstillfalleID
  AND kt.kursNr = lk.kursNr
  AND lk.kursID = 'D0004N'
  AND kt.year = '2020';

SELECT ls.namn
FROM Ltu_Student ls,
     Kurs_Stud ks,
     Kurs_Tillfalle kt,
     Ltu_Kurs lk
WHERE ls.studID = ks.studID
  AND ks.kursTillfalleID = kt.kurstillfalleID
  AND kt.kursNr = lk.kursNr
  AND lk.kursID = 'D0004N'
  AND kt.year = '2020';

SELECT namn
FROM Ltu_Student
WHERE studID IN (SELECT studID
                 FROM kurs_Stud
                 WHERE kursTillfalleID IN (SELECT kursTillfalleID
                                           FROM Kurs_Tillfalle
                                           WHERE year = '2020'
                                             AND kursNr IN (SELECT kursNr
                                                            FROM Ltu_Kurs
                                                            WHERE kursID = ('D0004N'))));

SELECT namn
FROM Ltu_Student
WHERE studID IN (SELECT studID
                 FROM kurs_Stud
                 WHERE kursTillfalleID IN (SELECT kursTillfalleID
                                           FROM Kurs_Tillfalle
                                           WHERE year = '2020'
                                             AND kursNr = (SELECT kursNr
                                                           FROM Ltu_Kurs
                                                           WHERE kursID = ('D0004N'))));

SELECT ls.namn
FROM (((Ltu_Student ls INNER JOIN Kurs_Stud ks ON ls.studID = ks.studID)
    INNER JOIN Kurs_Tillfalle kt ON ks.kursTillfalleID = kt.kurstillfalleID)
         INNER JOIN Ltu_Kurs lk ON kt.kursNr = lk.kursNr)
WHERE lk.kursID = 'D0004N'
  AND kt.year = '2020';

SELECT customerName
FROM ((customers
         INNER JOIN orders o ON customers.customerNumber = o.customerNumber) inner join);
 */

/*
SELECT lk.kursID, SUM(*) Antal
FROM Kurs_Stud ks,
     Kurs_Tillfalle kt,
     Ltu_Kurs lk
WHERE ks.kursTillfalleID = kt.kursTillfalleID
  AND kt.kursNr = lk.kursNr
  AND lk.kursID = 'D0004N'
  AND year = '2018'
GROUP BY lk.kursID;



SELECT COUNT(*) Antal
FROM Kurs_Stud ks,
     Kurs_Tillfalle kt,
     Ltu_Kurs lk
WHERE ks.kursTillfalleID = kt.kursTillfalleID
  AND kt.kursNr = lk.kursNr
  AND lk.kursID = 'D0004N'
  AND year = '2018';

/*
SELECT lk.kursID, COUNT(*) Antal
FROM Kurs_Stud ks
         INNER JOIN Kurs_Tillfalle kt ON ks.kursTillfalleID = kt.kursTillfalleID
         INNER JOIN Ltu_Kurs lk ON kt.kursNr = lk.kursNr
WHERE lk.kursID = 'D0004N'
  AND year = '2018'
GROUP BY lk.kursID;


SELECT lk.kursID, COUNT(*) Antal
FROM Kurs_Stud ks
         INNER JOIN Kurs_Tillfalle kt ON ks.kursTillfalleID = kt.kursTillfalleID
         INNER JOIN Ltu_Kurs lk ON kt.kursNr = lk.kursNr
WHERE lk.kursID = 'D0004N'
  AND year = '2018'
GROUP BY lk.kursID;



SELECT lk.kursID, COUNT(*) Antal
FROM Kurs_Stud ks,
     Kurs_Tillfalle kt,
     Ltu_Kurs lk
WHERE ks.kursTillfalleID = kt.kursTillfalleID
  AND kt.kursNr = lk.kursNr
  AND lk.kursID = 'D0004N'
  AND year = '2018'
GROUP BY lk.kursID;
 */



SELECT lp.namn, lp.avd
FROM Ltu_Personal lp
WHERE lp.persID NOT IN (SELECT kl.persID
                        FROM Kur_Larare kl,
                             Kurs_Tillfalle kt
                        WHERE kl.kurTillfalleID = kt.kursTillfalleID);

/*
SELECT lp.namn, lp.avd
FROM Ltu_Personal lp
WHERE lp.persID IN (SELECT kl.persID
                    FROM Kur_Larare kl,
                         Kurs_Tillfalle kt
                    WHERE kl.kurTillfalleID = kt.kursTillfalleID);
 */

SELECT lp.namn, lp.avd
FROM Kurs_Tillfalle kt
         LEFT JOIN Kur_Larare kl ON kl.kurTillfalleID = kt.kursTillfalleID
         INNER JOIN Ltu_Personal lp ON lp.persID = kl.persID
WHERE kl.persID IS NULL;

SELECT lp.namn, lp.avd
FROM Kurs_Tillfalle kt
         INNER JOIN Kur_Larare kl ON kl.kurTillfalleID = kt.kursTillfalleID
         LEFT JOIN Ltu_Personal lp ON lp.persID = kl.persID
WHERE kl.persID IS NULL;

SELECT lp.namn, lp.avd
FROM Kurs_Tillfalle kt
         INNER JOIN Kur_Larare kl ON kl.kurTillfalleID = kt.kursTillfalleID
         RIGHT JOIN Ltu_Personal lp ON lp.persID = kl.persID
WHERE kl.persID IS NULL;