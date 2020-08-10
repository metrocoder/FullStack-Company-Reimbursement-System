package dev.edwin.servicetests;


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
				"one@email.com",
				"testPass",
				"one",
				"testImg.png",
				7);

		Employee result = eserv.createEmployee(e);

		Assertions.assertNotEquals(0, result.getEid());
	}

	@Test
	@Order(2)
	void getEmployeeById()
	{
		Employee result = eserv.getEmployeeById(10);

		Assertions.assertEquals(10,result.getEid() );
	}

	@Test
	@Order(3)
	void getEmployeeByEmail()
	{
		Employee result = eserv.getEmployeeByEmail("one@email.com");

		Assertions.assertEquals("one@email.com", result.getEmail());
	}

	@Test
	@Order(4)
	void getEmployeeByName()
	{
		Employee result = eserv.getEmployeeByName("one");

		Assertions.assertEquals("one", result.getName());
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

		Assertions.assertNotEquals(0, employees.size());
	}

	@Test
	@Order(7)
	void getAllEmployeesNameZtoA()
	{
		List<Employee> employees = eserv.getAllEmployeesNameZtoA();

		Assertions.assertNotEquals(0, employees.size());
	}

	@Test
	@Order(8)
	void updateEmployee()
	{
		List<Employee> employees = eserv.getAllEmployees();
		Employee updateMe = employees.get(employees.size()-1);
		updateMe.setName("Anthony Tony");
		Employee result = eserv.updateEmployee(updateMe);

		Assertions.assertEquals("Anthony Tony", result.getName());
	}

	@Test
	@Order(9)
	void deleteEmployee()
	{

		List<Employee> employees = eserv.getAllEmployees();
		Employee deleteMe = employees.get(employees.size()-1);
		boolean result = eserv.deleteEmployee(deleteMe);

		Assertions.assertEquals(true, result);
	}

	@Test
	@Order(10)
	void getEmployeesByManager()
	{
		List<Employee> result = eserv.getEmployeeByManager(1);
		System.out.println(result);
		Assertions.assertNotEquals(0,result.size());
	}


}
