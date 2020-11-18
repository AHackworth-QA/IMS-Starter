package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.Utils;


public class OrdersController implements CrudController<Orders> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	private OrderDAO orderDAO;
	private Utils utils;
	
	public OrdersController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
		
	}
	
	@Override
	public Orders create() {
		LOGGER.info("Please enter a customer id");
		Long customerid = utils.getLong();
		Orders order = orderDAO.create(new Orders(customerid));
		LOGGER.info("Order created");
		LOGGER.info(order);
		LOGGER.info("Please enter order id");
		Long order_id = utils.getLong();
		LOGGER.info("Please enter product id");
		Long product_id = utils.getLong();
		LOGGER.info("Please enter product quantity");
		Long product_quantity = utils.getLong();
		Orders orders = orderDAO.addItem(new Orders(order_id, product_id, product_quantity));
		return orders;
		
	}

	
	public Orders addItems() {
	LOGGER.info("Please enter order id");
	Long order_id = utils.getLong();
	LOGGER.info("Please enter product id");
	Long product_id = utils.getLong();
	LOGGER.info("Please enter product quantity");
	Long product_quantity = utils.getLong();
	Orders orders = orderDAO.addItem(new Orders(order_id, product_id, product_quantity));
	return orders;
	}
	
	@Override
	public List<Orders> readAll() {
		List<Orders> orders = orderDAO.readAll();
		for (Orders order : orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}
	
	@Override
	public Orders update() {
		LOGGER.info("Please enter the id of the order you would like to update");
		Long order_id = utils.getLong();
		LOGGER.info("Please enter an item id");
		Long product_id = utils.getLong();
		LOGGER.info("Please enter an amount");
		Long order_quantity = utils.getLong();
		Orders order = orderDAO.update(new Orders(order_id, product_id, order_quantity));
		LOGGER.info("Order Updated");
		return order;
	}
	
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long order_id = utils.getLong();
		return orderDAO.delete(order_id);
	}
	
	public int deleteItems() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		Long product_id = utils.getLong();
		LOGGER.info("Please enter the orderitemId you would like to delete");
		Long orderitem_id = utils.getLong();
		return orderDAO.deleteItems(product_id, orderitem_id);
		
	}
}
