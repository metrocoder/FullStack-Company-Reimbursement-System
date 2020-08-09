package dev.edwin.daotests;

import org.junit.jupiter.api.*;

import dev.edwin.daos.ManagerDAO;
import dev.edwin.daos.ManagerDAOImp;
import dev.edwin.entities.Manager;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ManagerDAOTest
{
	
	private ManagerDAO mdao = ManagerDAOImp.getMdao();


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
	}

	@Test
	@Order(3)
	void getManagerById() {
		Manager result = mdao.getManagerById(1);
		Assertions.assertEquals("Boss One", result.getName());

	}

	@Test
	@Order(6)
	void updateManager()
	{
		List<Manager> update = mdao.getAllManagers();
		update.get(0).setName("Nombre Nuevo");
//		System.out.println(update);
		Manager result = mdao.updateManager(update.get(0));
		System.out.println(result);
		Assertions.assertEquals("Nombre Nuevo", result.getName());
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
