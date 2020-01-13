--
-- Set default database
--
USE ebook;

--
-- Create table `book`
--
CREATE TABLE book (
  book_id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(100) DEFAULT NULL,
  author varchar(100) DEFAULT NULL,
  isbn varchar(100) DEFAULT NULL,
  price int(6) DEFAULT NULL,
  sales int(6) DEFAULT NULL,
  amount int(6) DEFAULT NULL,
  abstract varchar(10000) DEFAULT NULL,
  img_src varchar(200) DEFAULT NULL,
  PRIMARY KEY (book_id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 18,
AVG_ROW_LENGTH = 2730,
CHARACTER SET utf8,
COLLATE utf8_general_ci;