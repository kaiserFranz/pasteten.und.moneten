DELIMITER //

CREATE PROCEDURE `hszmdp`.`spr_register` (IN userName varchar(64), IN pw varchar(64), OUT userId INT)
BEGIN
     DECLARE id INT;

     INSERT INTO `user` (NAME, PASS)
     VALUES (userName, pw);

     CALL spr_login (userName, pw, id);
     CALL spr_createTrackingEntry('RG','New user created / registered',id);
     SET userId = id;
END//
DELIMITER