DROP PROCEDURE IF EXISTS `hszmdp`.`spr_login`;

DELIMITER //

CREATE PROCEDURE `hszmdp`.`spr_login` (IN userName varchar(64), IN pw varchar(64), OUT userId INT)
DETERMINISTIC
BEGIN
    DECLARE id INT DEFAULT 0;
    SET id = (
      SELECT USERID
      FROM `user`
      WHERE NAME = userName
      AND PASS = pw);
    SET userId = id;
    CALL spr_createTrackingEntry('LI','User logged in', id);
END//
DELIMITER