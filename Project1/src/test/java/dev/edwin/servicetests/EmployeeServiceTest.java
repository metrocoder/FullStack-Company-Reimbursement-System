package dev.edwin.servicetests;

import static org.junit.jupiter.api.Assertions.*;

import dev.edwin.daos.EmployeeDAO;
import dev.edwin.entities.Employee;
import org.junit.jupiter.api.*;

import dev.edwin.services.EmployeeService;
import dev.edwin.services.EmployeeServiceImp;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeServiceTest {
	
	private static EmployeeService eserv = EmployeeServiceImp.getEserv();

	@Test
	@Order(1)
	void createEmployee()
	{
		Employee e = new Employee(0,
				"serviceTest@email.com",
				"testPass",
				"Service Employee",
				"testImg.png");

		Employee result = eserv.createEmployee(e);

		Assertions.assertNotEquals(0, result.getEid());
	}

	@Test
	@Order(2)
	void getEmployeeById()
	{
		Employee result = eserv.getEmployeeById(1);

		Assertions.assertEquals("My Name",result.getName());
	}

	@Test
	@Order(3)
	void getEmployeeByEmail()
	{
		Employee result = eserv.getEmployeeByEmail("MyNewEmail@email.com");

		Assertions.assertEquals("MyNewEmail@email.com", result.getEmail());
	}

	@Test
	@Order(4)
	void getEmployeeByName()
	{
		Employee result = eserv.getEmployeeByName("My Name");

		Assertions.assertEquals("My Name", result.getName());
	}

	@Test
	@Order(5)
	void getAllEmployees()
	{
		List<Employee> employees = eserv.getAllEmployees();

		Assertions.assertNotEquals(0, employees.size());
	}

	@Test
	@Order(6)
	void getAllEmployeesNameAtoZ()
	{
		List<Employee> employees = eserv.getAllEmployeesNameAtoZ();

		Assertions.assertEquals("Service Employee", employees.get(employees.size()-1).getName());
	}

	@Test
	@Order(7)
	void getAllEmployeesNameZtoA()
	{
		List<Employee> employees = eserv.getAllEmployeesNameZtoA();

		Assertions.assertEquals("Service Employee", employees.get(0).getName());
	}

	@Test
	@Order(8)
	void updateEmployee()
	{
		Employee updateMe = eserv.getEmployeeById(1);
		updateMe.setName("Anthony Tony");
		Employee result = eserv.updateEmployee(updateMe);
	}

	@Test
	@Order(9)
	void deleteEmployee()
	{
		Employee gutMe = new Employee(0,
				"slaughter@email.com",
				"hotBoy666",
				"Sgt. Slaughter",
				"noSoul.png");
		Employee destroy = eserv.createEmployee(gutMe);
		boolean result = eserv.deleteEmployee(destroy);

		Assertions.assertEquals(true, result);
	}
}
