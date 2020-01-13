--
-- Set default database
--
USE ebook;

--
-- Create table `order_item`
--
CREATE TABLE order_item (
  order_id int(11) NOT NULL,
  book_id int(11) NOT NULL,
  number int(11) DEFAULT NULL,
  PRIMARY KEY (order_id, book_id)
)
ENGINE = INNODB,
AVG_ROW_LENGTH = 117,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

--
-- Create foreign key
--
ALTER TABLE order_item
ADD CONSTRAINT order_item_ibfk_2 FOREIGN KEY (book_id)
REFERENCES book (book_id);

--
-- Create foreign key
--
ALTER TABLE order_item
ADD CONSTRAINT order_item_ibfk_3 FOREIGN KEY (order_id)
REFERENCES orders (order_id);