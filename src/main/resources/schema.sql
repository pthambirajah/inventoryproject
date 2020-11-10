CREATE TABLE IF NOT EXISTS products (
  idproducts int(5) NOT NULL AUTO_INCREMENT,
  product_name varchar(45) DEFAULT NULL,
  product_description varchar(45) DEFAULT NULL,
  product_price FLOAT (15) DEFAULT NULL,
  PRIMARY KEY(idproducts)
);