package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrdersController;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
	
	@Mock
	private Utils utils;
	
	@Mock
	private OrderDAO dao;
	
	@InjectMocks
	private OrdersController controller;
	
	//@Test
	//public void testCreate() {
		//final Long customerId = 1L, orderItemId = 1L, productId = 1L, productQuantity = 1L;
		//final Double total_cost = 0.00;
		//final Orders expected = new Orders(customerId, orderItemId, productId, productQuantity, total_cost);
		//final Orders created = new Orders(customerId);		
		//Mockito.when(utils.getLong()).thenReturn(customerId, orderItemId, productId, productQuantity);
		//Mockito.when(utils.getDouble()).thenReturn(total_cost);
		//Mockito.when(dao.create(created)).thenReturn(customerId);
		//Mockito.when(dao.create(new Orders(order_id, product_id, product_quantity))
		
		//assertEquals(expected, controller.create());

		//Mockito.verify(utils, Mockito.times(4)).getLong();
		//Mockito.verify(utils, Mockito.times(1)).getDouble();
		//Mockito.verify(dao, Mockito.times(1)).create(created);

//}

	@Test
	public void testReadAll() {
		List<Orders> orders = new ArrayList<>();
		orders.add(new Orders(1L, 1L, 1L, 2L, 0.00));

		Mockito.when(dao.readAll()).thenReturn(orders);

		assertEquals(orders, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	@Test
	public void testUpdate() {
		Orders updated = new Orders(1L, 1L, 2L);

		Mockito.when(this.utils.getLong()).thenReturn(1L, 1L, 2L);
		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(3)).getLong();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	}
	
	@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}
	
	@Test
	public void testDeleteItems() {
		
	final long ItemID = 1L;
	final long ID = 1L;
	
	Mockito.when(utils.getLong()).thenReturn(ItemID, ID);
	Mockito.when(dao.deleteItems(ItemID, ID)).thenReturn(1);
		
	assertEquals(1L, 1L, this.controller.deleteItems());
	
	Mockito.verify(utils, Mockito.times(2)).getLong();
	Mockito.verify(dao, Mockito.times(1)).deleteItems(ItemID, ID);
	
	}
	
	@Test
	public void testAddItems() {
		
		final Long order_id = 1L, product_id = 1L, product_quantity = 2L;
		
		Mockito.when(utils.getLong()).thenReturn(order_id, product_id, product_quantity);
		Mockito.when(dao.create(new Orders(order_id, product_id, product_quantity)));
		
	}
}
