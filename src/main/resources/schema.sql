CREATE TABLE IF NOT EXISTS products (
  idproducts int(5) NOT NULL AUTO_INCREMENT,
  product_name varchar(45) DEFAULT NULL,
  product_description varchar(45) DEFAULT NULL,
  product_price FLOAT (15) DEFAULT NULL,
  PRIMARY KEY(idproducts)
);

CREATE TABLE IF NOT EXISTS users (
  id int(5) NOT NULL AUTO_INCREMENT,
  username varchar(45) DEFAULT NULL,
  password varchar(100) DEFAULT NULL,
  role varchar(100) DEFAULT NULL,
  PRIMARY KEY(id)
);