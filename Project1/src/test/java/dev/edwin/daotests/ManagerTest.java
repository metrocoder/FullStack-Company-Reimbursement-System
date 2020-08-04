package dev.edwin.daotests;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import dev.edwin.daos.ManagerDAO;
import dev.edwin.daos.ManagerDAOHibernate;
import dev.edwin.entities.Manager;

class ManagerTest {
	
	private static ManagerDAO mdao = ManagerDAOHibernate.getMdao();

	@Test
	@Order(1)
	void testCreateManager() {
		Manager manager = new Manager(0, "manager0@test.com", "password0", "Boss One" , "image.png");
		Manager result = mdao.createManager(manager);
		
		Assertions.assertNotEquals(0, result.getMgid());
	}
	
	
	@Test
	@Order(2)
	void testGetAllManagers() {
		
		List<Manager> result = mdao.getAllManagers();
		
		Assertions.assertNotEquals(0, result.size());
		
		System.out.println(result);
	}
	
	

}
