USE CustomLibrary;

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

