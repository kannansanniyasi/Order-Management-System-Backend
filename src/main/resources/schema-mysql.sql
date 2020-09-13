DROP TABLE IF EXISTS orders;
CREATE TABLE orders(order_id bigint not null AUTO_INCREMENT,customer_name varchar(20) not null,order_date varchar(50) not null,
shipping_address varchar(200) not null,product_name varchar(20) not null,order_tems varchar(20) not null,total varchar(20) not null,
                  CONSTRAINT order_id_pk PRIMARY KEY(order_id));
                  
                  DROP TABLE IF EXISTS product;
				  
				  
				    CREATE TABLE product(product_id bigint not null AUTO_INCREMENT,product_name varchar(20) not null,
				  quantity varchar(30) not null,price varchar(20) not null,
                   CONSTRAINT product_id_pk PRIMARY KEY(product_id));
                   
                   DROP TABLE IF EXISTS items;
				  
				  
				  CREATE TABLE items(item_id bigint not null AUTO_INCREMENT,product_id bigint not null,order_id bigint not null,
                   CONSTRAINT item_id_pk PRIMARY KEY(item_id),CONSTRAINT product_id_fk FOREIGN KEY(product_id) REFERENCES product(product_id),
                   CONSTRAINT order_id_fk FOREIGN KEY(order_id) REFERENCES orders(order_id));
                   
                   
                   INSERT INTO product(product_name,quantity,price) VALUES('Coconut Oil','2ltr','4.5');
                   INSERT INTO product(product_name,quantity,price) VALUES('Rice','5Kg','4.5');
                   INSERT INTO product(product_name,quantity,price) VALUES('Wheet','10kg','6.5');