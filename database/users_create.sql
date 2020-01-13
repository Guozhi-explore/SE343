--
-- Set default database
--
USE ebook;

--
-- Create table `users`
--
CREATE TABLE users (
  user_id int(11) NOT NULL AUTO_INCREMENT,
  account varchar(100) DEFAULT NULL,
  password varchar(100) DEFAULT NULL,
  mailbox varchar(100) DEFAULT NULL,
  status varchar(20) DEFAULT NULL,
  ismanager tinyint(1) DEFAULT NULL,
  PRIMARY KEY (user_id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 54,
AVG_ROW_LENGTH = 1638,
CHARACTER SET utf8,
COLLATE utf8_general_ci;