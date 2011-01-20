-- MySQL dump 9.11
--
-- Host: localhost    Database: hszmdp
-- ------------------------------------------------------
-- Server version	5.1.53

--
-- Table structure for table `tracking`
--

CREATE TABLE tracking (
  trackID int(6) NOT NULL,
  userID int(6) NOT NULL,
  trackDate datetime NOT NULL,
  parentEvent varchar(2) NOT NULL,
  `value` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tracking`
--


--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  userID int(11) NOT NULL AUTO_INCREMENT,
  userName varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  PRIMARY KEY (userID)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO user VALUES (1,'mark','mark');
INSERT INTO user VALUES (2,'jive','jive');
INSERT INTO user VALUES (3,'alex','alex');
INSERT INTO user VALUES (4,'manuel','manuel');
INSERT INTO user VALUES (5,'milo','milo');
INSERT INTO user VALUES (6,'zeljko','zeljko');

