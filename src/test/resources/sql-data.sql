INSERT INTO `ims`.`customers` (`first_name`, `last_name`, `email`) VALUES ('jordan', 'harrison', 'jordan.harrison@gmail.com');
INSERT INTO `ims`.`items` (product_name, product_value, stock) VALUES ('Bike', 20.00, 2);
INSERT INTO `ims`.`orders` (customer_id) VALUES (1);
INSERT INTO `ims`.`order_items` (order_id, product_id, order_quantity, total_cost) VALUES (1, 1, 2, 0.00); 