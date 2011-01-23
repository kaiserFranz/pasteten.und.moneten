DELIMITER //

CREATE PROCEDURE `hszmdp`.`spr_insertBookingEntry` (IN bookingId int, IN balanceId INT, IN strucId INT, IN bookingValue FLOAT)
BEGIN
    INSERT INTO hszmdp.buchung (buchID, bilanzID, strukID, buchBetrag, buchDatum)
    VALUES (bookingId, balanceId, strucId, bookigValue, NOW());
END

DELIMITER //