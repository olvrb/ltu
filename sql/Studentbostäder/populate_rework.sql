USE lucidtest;

INSERT INTO Hyresratt (LagenhetsId, GatuNamn, GatuNummer, PostNummer, Beskrivning, AntalRum) VALUES
    ('000001', 'Väderleden', '3a', 123456, 'fin lägenhet', 4),
    ('000002', 'Väderleden', '3b', 123456, 'fin lägenhet', 4),
    ('000003', 'Vänortsvägen', '10', 123456, 'fin lägenhet', 4),
    ('000004', 'Vänortsvägen', '11', 123456, 'fin lägenhet', 4),
    ('000005', 'Vänortsvägen', '12', 123456, 'fin lägenhet', 4),
    ('000006', 'Munkebergsgatan', '60', 123456, 'fin lägenhet', 4),
    ('000007', 'Munkebergsgatan', '52', 123456, 'fin lägenhet', 4),
    ('000008', 'Munkebergsgatan', '14', 123456, 'fin lägenhet', 4);

INSERT INTO Hyresgast (HyresgastId, Personnummer, ENamn, FNamn) VALUES
    ('000001', '0204150092', 'hans', 'hans'),
    ('000002', '0204150012', 'adam', 'adam'),
    ('000003', '0204150022', 'sara', 'sara'),
    ('000004', '0204150032', 'svante', 'svante'),
    ('000005', '0204150042', 'bianca', 'bianca');

INSERT INTO Hyresavtal (AvtalsId, StartDatum, SlutDatum, Hyra) VALUES
    ('000001', STR_TO_DATE('2020-08-17', '%Y-%m-%d'), STR_TO_DATE('2021-02-17', '%Y-%m-%d'), 3800),
    ('000002', STR_TO_DATE('2020-08-17', '%Y-%m-%d'), STR_TO_DATE('2021-02-17', '%Y-%m-%d'), 3800),
    ('000003', STR_TO_DATE('2020-08-17', '%Y-%m-%d'), STR_TO_DATE('2021-02-17', '%Y-%m-%d'), 3500),
    ('000004', STR_TO_DATE('2020-08-17', '%Y-%m-%d'), STR_TO_DATE('2021-02-17', '%Y-%m-%d'), 3500),
    ('000005', STR_TO_DATE('2020-08-17', '%Y-%m-%d'), STR_TO_DATE('2021-02-17', '%Y-%m-%d'), 4200);

INSERT INTO HyresrattsGast (HyresrattsGastId, HyresrattsId, HyresgastId, HyresavtalsId) VALUES
    ('000001', '000001', '000001', '000001'),
    ('000002', '000001', '000002', '000002'),
    ('000003', '000002', '000003', '000003'),
    ('000004', '000002', '000004', '000004'),
    ('000005', '000003', '000005', '000005');

INSERT INTO Hyresinbetalning (TransaktionsId, Summa, Datum, Betalad, HyresrattsGastId) VALUES
    ('200755610837737155', 3556, STR_TO_DATE('2020-08-25', '%Y-%m-%d'), TRUE, '000001'),
    ('200755610181737155', 4109, STR_TO_DATE('2020-09-25', '%Y-%m-%d'), TRUE, '000001'),
    ('001976177766417059', 3330, STR_TO_DATE('2020-08-25', '%Y-%m-%d'), TRUE, '000002'),
    ('825403053045677411', 4313, STR_TO_DATE('2020-09-25', '%Y-%m-%d'), TRUE, '000002'),
    ('480376567054191569', 3333, STR_TO_DATE('2020-08-25', '%Y-%m-%d'), TRUE, '000003'),
    ('014565851889132443', 3812, STR_TO_DATE('2020-09-25', '%Y-%m-%d'), TRUE, '000003'),
    ('602272664412758244', 4016, STR_TO_DATE('2020-08-25', '%Y-%m-%d'), TRUE, '000004'),
    ('274640776309914309', 3910, STR_TO_DATE('2020-09-25', '%Y-%m-%d'), TRUE, '000004'),
    ('548451982970237177', 4224, STR_TO_DATE('2020-08-25', '%Y-%m-%d'), TRUE, '000005'),
    ('848869277266718495', 4702, STR_TO_DATE('2020-09-25', '%Y-%m-%d'), TRUE, '000005');

INSERT INTO Inspektion (InspektionsId, HyresrattId, Datum) VALUES
    ('000001', '000001', STR_TO_DATE('2020-10-20', '%Y-%m-%d')),
	('000002', '000002', STR_TO_DATE('2020-07-20', '%Y-%m-%d'));

INSERT INTO Anmarkning (AnmarkningsId, InspektionsId, HyresgastId, Beskrivning, FixDatum) VALUES
    ('000001', '000001', '000001', 'Brände ner huset???', STR_TO_DATE('2020-08-20', '%Y-%m-%d')),
    ('000002', '000002', '000002', 'Cat invasion', NULL);


