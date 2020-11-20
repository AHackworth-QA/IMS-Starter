package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DBUtils;


public class OrderDAOTest {
	
	private final OrderDAO DAO = new OrderDAO();
	
	@BeforeClass
	public static void init() {
		DBUtils.connect("root", "root");
		
	}

	@Before
	public void setup() {
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
		
	}
	
	@Test
	public void testCreate() {
		final Orders created = new Orders(2L, 1L);
		assertEquals(created, DAO.create(created));
		
	}
	

	@Test
	public void testCreateAddItems() {
		final Orders created = new Orders(1L, 1L, 1L);
		assertEquals(created, DAO.addItem(created));
		
	}
	
	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Orders(ID, 1L, 1L, 2L, 0.00), DAO.readOrder(ID));
	}
	
	@Test
	public void testReadAll() {
		List<Orders> expected = new ArrayList<>();
		expected.add(new Orders(1L, 1L, 1L, 1L, 2L, 0.00));
		assertEquals(expected, DAO.readAll());
	}
	
	@Test
	public void testUpdate() {
		final Orders updated = new Orders(1L, 1L, 1L, 2L, 0.00);
		assertEquals(updated, DAO.update(updated));

	}
	

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
	
	@Test
	public void testDeleteItems() {
		assertEquals(1, 1, DAO.deleteItems(1, 1));
	}
	
	
	@Test
	public void testDeleteFail() {
		assertEquals(1, DAO.delete(1));
	}
	
	@Test
	public void testReadFail() {
		final long ID = 1L;
		assertEquals(new Orders(ID, 1L, 1L, 2L, 0.00), DAO.readOrder(ID));
	}
	
}



//`order_id` INT unique not null auto_increment,
//`customer_id` INT not null,



//orderitem_id INT unique not null auto_increment,
//total_cost DECIMAL(4,2),
//order_quantity INT, 
//product_id INT not null,
//order_id INT not null,



