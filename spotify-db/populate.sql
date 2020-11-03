USE spotify;

SET @DEATH = UUID();
SET @HARDWIRED = UUID();
SET @AJFA = UUID();
SET @HILL = UUID();
SET @GAME = UUID();
SET @PECK = UUID();
SET @SMOOTH = UUID();

SET @METALLICA = UUID();
SET @VULFPECK = UUID();
SET @CORY = UUID();

INSERT INTO Album (AlbumId, Name, ReleaseDate, Type)
VALUES (@DEATH, 'Death Magnetic', STR_TO_DATE('2008-08-18', '%Y-%m-%d'), 'LP'),
       (@HARDWIRED, 'Hardwired', STR_TO_DATE('2016-08-18', '%Y-%m-%d'), 'LP'),
       (@AJFA, '...And Justice for All', STR_TO_DATE('1988-08-18', '%Y-%m-%d'), 'LP'),
       (@HILL, 'Hill Climber', STR_TO_DATE('2018-08-18', '%Y-%m-%d'), 'LP'),
       (@GAME, 'The Beautiful Game', STR_TO_DATE('2016-08-18', '%Y-%m-%d'), 'LP'),
       (@PECK, 'Mit Peck', STR_TO_DATE('2011-08-18', '%Y-%m-%d'), 'EP'),
       (@SMOOTH, 'Smooth Move', STR_TO_DATE('2020-08-18', '%Y-%m-%d'), 'Single');

INSERT INTO Song (SongId, Name, Explicit, Length, Likedness, AlbumId)
VALUES (UUID(), 'That Was Just Your Life ', FALSE, 300, 100, @DEATH),
       (UUID(), 'The End of the Line ', FALSE, 300, 100, @DEATH),
       (UUID(), 'Broken, Beat & Scarred ', FALSE, 300, 100, @DEATH),
       (UUID(), 'The Day That Never Comes ', FALSE, 300, 100, @DEATH),
       (UUID(), 'All Nightmare Long ', FALSE, 300, 100, @DEATH),
       (UUID(), 'Cyanide ', FALSE, 300, 100, @DEATH),
       (UUID(), 'The Unforgiven III ', FALSE, 300, 100, @DEATH),
       (UUID(), 'The Judas Kiss ', FALSE, 300, 100, @DEATH),
       (UUID(), 'Suicide & Redemption ', FALSE, 300, 100, @DEATH),
       (UUID(), 'My Apocalypse', FALSE, 300, 100, @DEATH),
       (UUID(), 'Atlas Rise!', FALSE, 300, 100, @HARDWIRED),
       (UUID(), 'Dyers Eve', FALSE, 300, 100, @AJFA),
       (UUID(), 'It Gets Funkier IV', FALSE, 300, 100, @HILL),
       (UUID(), 'Animal Spirits', FALSE, 300, 100, @GAME),
       (UUID(), 'Beastly', FALSE, 300, 100, @PECK),
       (UUID(), 'Smooth Move', FALSE, 300, 100, @SMOOTH);

INSERT INTO Artist (ArtistId, Name, About)
VALUES (@METALLICA, 'Metallica', 'band band'),
       (@VULFPECK, 'Vulfpeck', 'funk band'),
       (@CORY, 'Cory Wong', 'solo funk');

INSERT INTO ArtistAlbum (ArtistId, AlbumId)
VALUES (@METALLICA, @DEATH),
       (@METALLICA, @HARDWIRED),
       (@METALLICA, @AJFA),
       (@VULFPECK, @HILL),
       (@VULFPECK, @GAME),
       (@VULFPECK, @PECK),
       (@CORY, @SMOOTH);