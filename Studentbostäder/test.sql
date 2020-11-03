use lucidtest;

SELECT FNamn, ENamn, Hyra FROM Hyresgast
    JOIN Hyresavtal H on Hyresgast.HyresgastId = H.HyresgastId;