USE CustomLibrary;

DROP TRIGGER IF EXISTS UpdateRentalUp;
CREATE TRIGGER UpdateRentalUp
    AFTER INSERT
    ON Rental
    FOR EACH ROW
BEGIN
    UPDATE
        Rental
            JOIN RentalSummary RS ON Rental.RentalSummaryNr = RS.RentalSummaryNr
            JOIN Customer C ON C.CustomerNr = RS.CustomerNr
    SET CurrentlyBorrowed = CurrentlyBorrowed + 1
    WHERE RentalNr = new.RentalNr;
END;

DROP TRIGGER IF EXISTS UpdateRentalDown;
CREATE TRIGGER UpdateRentalDown
    AFTER UPDATE
    ON Rental
    FOR EACH ROW
BEGIN
    IF old.Returned = new.Returned THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Book already returned.';
    END IF;
    IF new.Returned = TRUE THEN
        UPDATE
            Rental
                JOIN RentalSummary RS ON Rental.RentalSummaryNr = RS.RentalSummaryNr
                JOIN Customer C ON C.CustomerNr = RS.CustomerNr
        SET CurrentlyBorrowed = CurrentlyBorrowed - 1
        WHERE RentalNr = new.RentalNr;
    END IF;
END;


DROP TRIGGER IF EXISTS MaxRental;
CREATE TRIGGER MaxRental
    BEFORE INSERT
    ON Rental
    FOR EACH ROW 
BEGIN
    -- Get corresponding Customer
    SELECT C.Type, c.CurrentlyBorrowed, c.Pincode
    INTO @customerType, @currentlyBorrowed, @pin
    FROM RentalSummary
             JOIN Customer C ON C.CustomerNr = RentalSummary.CustomerNr
    WHERE new.RentalSummaryNr = RentalSummary.RentalSummaryNr;


    IF @customerType = 'RESEARCHER' THEN
        IF @currentlyBorrowed >= 20 THEN
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Researchers can only borrow 20 books at once.';
        END IF;
    ELSEIF @customerType = 'TEACHER' THEN
        IF @currentlyBorrowed >= 10 THEN
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Teachers can only borrow 10 books at once.';
        END IF;
    ELSEIF @customerType = 'STUDENT' THEN
        IF @currentlyBorrowed >= 5 THEN
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Students can only borrow 5 books at once.';
        END IF;
    END IF;
END;


DROP PROCEDURE IF EXISTS CreateCustomer;
CREATE PROCEDURE CreateCustomer(IN Name VARCHAR(100),
                                IN PersonNr VARCHAR(12),
                                IN `Email` VARCHAR(1000),
                                IN `Phone` VARCHAR(20),
                                IN `Pincode` VARCHAR(4),
                                IN `Type` ENUM ('RESEARCHER', 'TEACHER', 'STUDENT'))
BEGIN
    INSERT INTO Customer
    VALUES (UUID(), Name, PersonNr, Email, Phone, Pincode, 0, Type);
END;