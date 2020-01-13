--
-- Set default database
--
USE ebook;

--
-- Create table `orders`
--
CREATE TABLE orders (
  order_id int(11) NOT NULL AUTO_INCREMENT,
  user_id int(11) DEFAULT NULL,
  order_time datetime DEFAULT NULL,
  total_money varchar(20) DEFAULT NULL,
  PRIMARY KEY (order_id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 100246,
AVG_ROW_LENGTH = 126,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

--
-- Create foreign key
--
ALTER TABLE orders
ADD CONSTRAINT orders_ibfk_1 FOREIGN KEY (user_id)
REFERENCES users (user_id) ON DELETE CASCADE;