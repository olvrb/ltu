USE spotify;

-- select all songs of an artist
SELECT Song.Name
FROM Song
         JOIN Album A ON A.AlbumId = Song.AlbumId
         JOIN ArtistAlbum AA ON A.AlbumId = AA.AlbumId
         JOIN Artist A2 ON AA.ArtistId = A2.ArtistId
WHERE A2.Name LIKE 'Metallica%';

-- select all songs of an album
SELECT *
FROM Song
WHERE AlbumId = (SELECT AlbumId
                 FROM Album
                 WHERE Album.Name = 'Death Magnetic');

-- select all artists of an album
SELECT *
FROM Album
         JOIN ArtistAlbum AA ON Album.AlbumId = AA.AlbumId
         JOIN Artist A ON AA.ArtistId = A.ArtistId
WHERE Album.Name = 'Mit Peck';

-- select all albums of an artist
SELECT *
FROM Album
         JOIN ArtistAlbum AA ON Album.AlbumId = AA.AlbumId
         JOIN Artist A ON AA.ArtistId = A.ArtistId
WHERE A.Name = 'Metallica';

-- select an artists LPs
SELECT Album.Name
FROM Album
         JOIN ArtistAlbum AA ON Album.AlbumId = AA.AlbumId
         JOIN Artist A ON AA.ArtistId = A.ArtistId
WHERE A.Name = 'Metallica'
  AND Album.Type = 'LP';

-- select an artists EP and Singles
SELECT *
FROM Album
         JOIN ArtistAlbum AA ON Album.AlbumId = AA.AlbumId
         JOIN Artist A ON AA.ArtistId = A.ArtistId
WHERE A.ArtistId = '90f6c704-142e-11eb-9ddc-275c5aae5cc2'
  AND (Album.Type = 'EP' OR Album.Type = 'Single');



SET @query = 'Death';
-- General search
SELECT *
FROM ((SELECT Song.Name AS SongName, A.Name AS AlbumName, A2.Name AS ArtistName, SongId, 'Song' AS Type
       FROM Song
                JOIN Album A ON Song.AlbumId = A.AlbumId
                JOIN ArtistAlbum AA ON A.AlbumId = AA.AlbumId
                JOIN Artist A2 ON AA.ArtistId = A2.ArtistId)
      UNION ALL
      (SELECT NULL AS SongName, Album.Name AS AlbumName, A3.Name AS ArtistName, Album.AlbumId, 'Album' AS Type
       FROM Album
                JOIN ArtistAlbum AA2 ON Album.AlbumId = AA2.AlbumId
                JOIN Artist A3 ON AA2.ArtistId = A3.ArtistId)
      UNION ALL
      (SELECT NULL AS SongName, NULL AS AlbumName, Name AS ArtistName, ArtistId, 'Artist' AS Type
       FROM Artist)) AS R
WHERE SongName LIKE CONCAT(@query, '%')
   OR AlbumName LIKE CONCAT(@query, '%')
   OR ArtistName LIKE CONCAT(@query, '%');