//drop database `ims`;

create database if not exists `ims`; 

use `ims`; 
create table `ims`.`customers`(
customer_id INT unique not null auto_increment,
first_name VARCHAR(60), 
last_name VARCHAR(60),
email VARCHAR(60),
PRIMARY KEY (customer_id));


create table `ims`.`orders`(
order_id INT unique not null auto_increment,
customer_id INT not null,
PRIMARY KEY (order_id),
FOREIGN KEY (customer_id) REFERENCES `customers`(customer_id));

create table `ims`.`items`(
product_id INT unique not null auto_increment,
product_name VARCHAR(60),
product_value DECIMAL(4,2),
stock INT, 
PRIMARY KEY (product_id));   

