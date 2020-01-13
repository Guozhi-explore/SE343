--
-- Set default database
--
USE ebook;

--
-- Create table `cart`
--
CREATE TABLE cart (
  user_id int(11) NOT NULL,
  book_id int(11) NOT NULL,
  number int(11) DEFAULT NULL,
  PRIMARY KEY (user_id, book_id)
)
ENGINE = INNODB,
AVG_ROW_LENGTH = 2340,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

--
-- Create foreign key
--
ALTER TABLE cart
ADD CONSTRAINT cart_ibfk_1 FOREIGN KEY (user_id)
REFERENCES users (user_id) ON DELETE CASCADE;

--
-- Create foreign key
--
ALTER TABLE cart
ADD CONSTRAINT cart_ibfk_2 FOREIGN KEY (book_id)
REFERENCES book (book_id) ON DELETE CASCADE;