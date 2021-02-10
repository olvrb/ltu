USE CustomLibrary;

SELECT *
FROM Rental
         JOIN RentalSummary RS ON '01637b06-6b94-11eb-9731-d243d976c166' = RS.RentalSummaryNr
         JOIN Customer C ON C.CustomerNr = RS.CustomerNr