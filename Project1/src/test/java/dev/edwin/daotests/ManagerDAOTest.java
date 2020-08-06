package dev.edwin.daotests;

import java.util.List;

import org.junit.jupiter.api.*;

import dev.edwin.daos.ManagerDAO;
import dev.edwin.daos.ManagerDAOHibernate;
import dev.edwin.entities.Manager;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ManagerDAOTest
{
	
	private ManagerDAO mdao = ManagerDAOHibernate.getMdao();


	@Test
	@Order(1)
	void testCreateManager()
	{
		Manager manager = new Manager(0, "manager0@test.com", "password0", "Boss One", "image.png");
		Manager result = mdao.createManager(manager);
		Assertions.assertNotEquals(0, result.getMgid());
	}
	
	
	@Test
	@Order(2)
	void testGetAllManagers() {
		List<Manager> result = mdao.getAllManagers();
		Assertions.assertNotEquals(0, result.size());

//		System.out.println(result);
	}

	@Test
	@Order(3)
	void getManagerById() {
		Manager result = mdao.getManagerById(1);
		Assertions.assertEquals("Boss One", result.getName());

//		System.out.println(result);
	}

	@Test
	@Order(6)
	void updateManager()
	{
		Manager update = mdao.getManagerById(1);
		update.setPassword("SecurePass!");
		Manager result = mdao.updateManager(update);

		Assertions.assertEquals("SecurePass!", result.getPassword());

	}

	@Test
	@Order(7)
	void deleteManager()
	{
		Manager slaughter = new Manager(0, "manager0@test.com", "password0", "Delete Me", "image.png");
		Manager deleteMe = mdao.createManager(slaughter);
		boolean result = mdao.deleteManager(deleteMe);

		Assertions.assertEquals(true, result);

	}
	
	

}
