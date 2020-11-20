package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Orders> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	@Override 
	public Orders modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderId = resultSet.getLong("order_id");
		Long orderItemId = resultSet.getLong("orderitem_id");
		Long customerId = resultSet.getLong("customer_id");
		Long productId = resultSet.getLong("product_id");
		Long orderQuantity = resultSet.getLong("order_quantity");
		Double totalCost = resultSet.getDouble("total_cost");
		return new Orders(orderId, customerId, orderItemId, productId, orderQuantity, totalCost);	
	}
	
	public Orders modelFromResultSet2(ResultSet resultSet) throws SQLException {
		Long orderId = resultSet.getLong("order_id");
		Long customerId = resultSet.getLong("customer_id");
		return new Orders(orderId, customerId);	
	}
	
	public Orders modelFromResultSet3(ResultSet resultSet) throws SQLException {
		Long orderId = resultSet.getLong("order_id");
		Long orderItemId = resultSet.getLong("orderitem_id");
		Long productId = resultSet.getLong("product_id");
		Long orderQuantity = resultSet.getLong("order_quantity");
		Double totalCost = resultSet.getDouble("total_cost");
		return new Orders(orderId, orderItemId, productId, orderQuantity, totalCost);
	
	}
	
	public Orders modelFromResultSet4(ResultSet resultSet) throws SQLException {
		Long orderId = resultSet.getLong("order_id");
		Long productId = resultSet.getLong("product_id");
		Long orderQuantity = resultSet.getLong("order_quantity");
		return new Orders(orderId, productId, orderQuantity);
	}
	
	public List<Orders> readAll() { 
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select o.order_id, o.customer_id, oi.orderitem_id, oi.product_id, oi.order_quantity, oi.total_cost from `orders` o join `order_items` oi on o.order_id=oi.order_id");) {
			List<Orders> order = new ArrayList<>();
			while (resultSet.next()) {
				order.add(modelFromResultSet(resultSet));
			}
			return order;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}
	
	public Orders readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY order_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet2(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
		
	}
	
	public Orders readLatestAddItem() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM order_items ORDER BY order_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet4(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
		
	}
		//Make sure this bit works!!
	@Override
	public Orders create(Orders orders) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("INSERT INTO orders(customer_id) values(" + orders.getCustomer_id() + ")");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	public Orders addItem(Orders orders) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("INSERT INTO order_items(order_id, product_id, order_quantity) values(" + orders.getOrder_id() + "," + orders.getProduct_id() + "," + orders.getOrder_quantity() + ")");
			ResultSet resultSet = statement.executeQuery("SELECT product_value FROM items WHERE product_id = " + orders.getProduct_id());
			while(resultSet.next()) {
				Double total_cost = resultSet.getDouble("product_value");
				orders.setTotal_cost(total_cost * orders.getOrder_quantity());
				LOGGER.info(orders.getTotal_cost());
				statement.executeUpdate("UPDATE order_items SET total_cost = " + orders.getTotal_cost() + " WHERE order_id = " + orders.getOrder_id() + " AND product_id = " + orders.getProduct_id());
			}
			return readLatestAddItem();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	
	public Orders readOrder(Long order_id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM order_items where order_id = " + order_id);) {
			resultSet.next();
			return modelFromResultSet3(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
		//do this one on the big screen its easier 
	@Override
	public Orders update(Orders orders) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("update order_items set order_id ='" + orders.getOrder_id() + "', product_id ="
					+ orders.getProduct_id() + ", order_quantity =" + orders.getOrder_quantity());
			return readOrder(orders.getOrder_id());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
		
	@Override
	public int delete(long order_id) { 
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from order_items where order_id = " + order_id);
			return statement.executeUpdate("delete from orders where order_id = " + order_id);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}
	
	
	//use this as a remove item
	 
	public int deleteItems(long product_id, long orderitem_id) { 
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			return statement.executeUpdate("delete from order_items where product_id = " + product_id + " AND orderitem_id = " + orderitem_id);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}
}



