DELIMITER //

CREATE PROCEDURE `hszmdp`.`spr_createTrackingEntry`(IN eventName varchar(2), IN eventValue varchar(255), IN UID INT)
BEGIN
    INSERT INTO hszmdp.tracking (userID, trackDate, parentEvent, value)
    VALUES (UID, NOW(), eventName, eventValue);
END//
DELIMITER;