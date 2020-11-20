package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;


public class ItemDAOTest {
	
	private final ItemDAO DAO = new ItemDAO();
	
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
	final Item created = new Item(2L, "Trike", 21.00, 2L);
	assertEquals(created, DAO.create(created));
}

@Test
public void testReadAll() {
	List<Item> expected = new ArrayList<>();
	expected.add(new Item(1L, "Bike", 20.00, 2L));
	assertEquals(expected, DAO.readAll());
}

@Test
public void testReadLatest() {
	assertEquals(new Item(1L, "Bike", 20.00, 2L), DAO.readLatest());
}

@Test
public void testReadItem() {
	final long ID = 1L;
	assertEquals(new Item(ID, "Bike", 20.00, 2L), DAO.readItem(ID));
}

@Test
public void testUpdate() {
	final Item updated = new Item(1L, "Bike", 20.00, 2L);
	assertEquals(updated, DAO.update(updated));

}

@Test
public void testDelete() {
	assertEquals(0, DAO.delete(0));
}

@Test 
public void UpdateFail() {
	final Item update = new Item(3L, "HI", 20.00, 3L);
	assertNull(DAO.update(update)); 
}

@Test 
public void UpdateFail2() {
	final Item update = new Item(1L, "Hi' ; , ", 20.00, 3L);
	assertNull(DAO.update(update));
	
}


	
}

