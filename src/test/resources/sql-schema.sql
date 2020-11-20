drop schema ims;
CREATE SCHEMA IF NOT EXISTS `ims`;

use `ims`; 

create table `ims`.`customers`(
customer_id INT unique not null auto_increment,
first_name VARCHAR(60), 
last_name VARCHAR(60),
email VARCHAR(60),
PRIMARY KEY (customer_id));

create table `ims`.`orders`(
`order_id` INT unique not null auto_increment,
`customer_id` INT not null,
PRIMARY KEY (order_id),
FOREIGN KEY (customer_id) REFERENCES `customers`(customer_id));

create table `ims`.`items`(
product_id INT unique not null auto_increment,
product_name VARCHAR(60),
product_value DECIMAL(4,2),
stock INT, 
PRIMARY KEY (product_id));   

create table `ims`.`order_items`(
orderitem_id INT unique not null auto_increment,
total_cost DECIMAL(4,2),
order_quantity INT, 
product_id INT not null,
order_id INT not null,
PRIMARY KEY (orderitem_id),
FOREIGN KEY (product_id) REFERENCES `items`(product_id),
FOREIGN KEY (order_id) REFERENCES `orders`(order_id));