USE CustomLibrary;


SET @per = uuid();
SET @per2 = uuid();
SET @per3 = uuid();

INSERT INTO Customer (CustomerNr, Name, PersonNr, Email, Phone, Pincode, CurrentlyBorrowed, Type)
VALUES (@per, 'per', '0304150072', 'aspodfk@gmail.com', '0709584231', '1111', 0, 'STUDENT'),
       (@per2, 'per2', '0404150072', 'aspodfk@gmail.com', '0709584231', '1111', 0, 'TEACHER'),
       (@per3, 'per3', '0504150072', 'aspodfk@gmail.com', '0709584231', '1111', 0, 'RESEARCHER');


SET @rentPer = uuid();
SET @rentPer2 = uuid();
SET @rentPer3 = uuid();
INSERT INTO RentalSummary (RentalSummaryNr, CustomerNr)
VALUES (@rentPer, @per),
       (@rentPer2, @per2),
       (@rentPer3, @per3);


SET @obj = uuid();
INSERT INTO RentalObject (ObjectNr, Title, CategoryId)
VALUES (@obj, 'book nr 1', NULL);

INSERT INTO Edition (ISBN, CreatorName, PublicationYear, Publisher, Count, ObjectNr)
VALUES ('123456789123', 'boop', DATE('2021-01-01'), 'boop publishing', 10, @obj);

SET @physCop = uuid();
INSERT INTO PhysicalCopy (PhysicalCopyNr, Location, EditionNr)
VALUES (@physCop, 'back row', '123456789123');

INSERT INTO Rental (RentalNr, StartDate, EndDate, PhysicalCopyNr, RentalSummaryNr)
VALUES (uuid(), curdate(), curdate() + 10, @physCop, @rentPer),
       (uuid(), curdate(), curdate() + 10, @physCop, @rentPer),
       (uuid(), curdate(), curdate() + 10, @physCop, @rentPer),
       (uuid(), curdate(), curdate() + 10, @physCop, @rentPer),
       (uuid(), curdate(), curdate() + 10, @physCop, @rentPer);


INSERT INTO Rental (RentalNr, StartDate, EndDate, PhysicalCopyNr, RentalSummaryNr)
VALUES (uuid(), curdate(), curdate() + 10, @physCop, @rentPer);

UPDATE Rental
SET Returned = TRUE
WHERE RentalNr = '7ca73b80-6b95-11eb-9731-d243d976c166';