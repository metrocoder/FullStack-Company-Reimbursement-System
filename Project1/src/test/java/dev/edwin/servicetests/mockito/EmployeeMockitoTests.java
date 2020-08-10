package dev.edwin.servicetests.mockito;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import dev.edwin.daos.EmployeeDAO;
import dev.edwin.entities.Employee;
import dev.edwin.services.EmployeeService;
import dev.edwin.services.EmployeeServiceImp;

import java.util.ArrayList;
import java.util.List;

class EmployeeMockitoTests {
	
	@Mock
	private EmployeeDAO edaoMock;
	
	@InjectMocks
	private EmployeeService eserv = EmployeeServiceImp.getEserv();
	
	 @BeforeEach
	    public void setUp() throws Exception {

	         MockitoAnnotations.initMocks(this);
	    }
	

	@Test
	@Order(3)
	void testGetEmployeeByEmail() {

		Employee employee = new Employee();
		employee.setEid(0);
		employee.setEmail("test1@test.com");
		employee.setImage_url("image.png");
		employee.setName("Employee Name");
		employee.setPassword("MyPassword");
		employee.setMgid(10);

		Employee employee2 = new Employee();
		employee2.setEid(0);
		employee2.setEmail("test2@test.com");
		employee2.setImage_url("image.png");
		employee2.setName("Employee Name");
		employee2.setPassword("MyPassword");
		employee2.setMgid(11);

		List<Employee> employees = new ArrayList<Employee>();
		employees.add(employee);
		employees.add(employee2);

		Mockito.when(edaoMock.getAllEmployees()).thenReturn(employees);
		
		Employee result = eserv.getEmployeeByEmail("test2@test.com");
		
		Assertions.assertEquals("test2@test.com", result.getEmail());
	}
	

	@Test
	@Order(4)
	void testGetEmployeeByName() {

		Employee employee = new Employee();
		employee.setEid(0);
		employee.setEmail("test@test.com");
		employee.setImage_url("image.png");
		employee.setName("One");
		employee.setPassword("MyPassword");
		employee.setMgid(10);

		Employee employee2 = new Employee();
		employee2.setEid(0);
		employee2.setEmail("test@test.com");
		employee2.setImage_url("image.png");
		employee2.setName("Two");
		employee2.setPassword("MyPassword");
		employee2.setMgid(11);

		List<Employee> employees = new ArrayList<Employee>();
		employees.add(employee);
		employees.add(employee2);

		Mockito.when(edaoMock.getAllEmployees()).thenReturn(employees);
		
		Employee result = eserv.getEmployeeByName("One");
		
		Assertions.assertEquals("One", result.getName());
	}
	

	@Test
	@Order(6)
	void testGetAllEmployeesAtoZ() {

		Employee employee = new Employee();
		employee.setEid(0);
		employee.setEmail("test@test.com");
		employee.setImage_url("image.png");
		employee.setName("One");
		employee.setPassword("MyPassword");
		employee.setMgid(10);

		Employee employee2 = new Employee();
		employee2.setEid(0);
		employee2.setEmail("test@test.com");
		employee2.setImage_url("image.png");
		employee2.setName("Two");
		employee2.setPassword("MyPassword");
		employee2.setMgid(11);

		List<Employee> employees = new ArrayList<Employee>();
		employees.add(employee);
		employees.add(employee2);

		Mockito.when(edaoMock.getAllEmployees()).thenReturn(employees);
		
		List<Employee> result = eserv.getAllEmployeesNameAtoZ();
		
		Assertions.assertNotEquals(0, result.size());
	}
	

	@Test
	@Order(7)
	void testGetAllEmployeesZtoA() {

		Employee employee = new Employee();
		employee.setEid(0);
		employee.setEmail("test@test.com");
		employee.setImage_url("image.png");
		employee.setName("Employee Name");
		employee.setPassword("MyPassword");
		employee.setMgid(10);

		Employee employee2 = new Employee();
		employee2.setEid(0);
		employee2.setEmail("test@test.com");
		employee2.setImage_url("image.png");
		employee2.setName("Employee Name");
		employee2.setPassword("MyPassword");
		employee2.setMgid(11);

		List<Employee> employees = new ArrayList<Employee>();
		employees.add(employee);
		employees.add(employee2);

		Mockito.when(edaoMock.getAllEmployees()).thenReturn(employees);

		List<Employee> result = eserv.getAllEmployeesNameZtoA();

		Assertions.assertNotEquals(0, result.size());
	}

	@Test
	@Order(8)
	void getEmployeeByManager()
	{
		Employee employee = new Employee();
		employee.setEid(0);
		employee.setEmail("test@test.com");
		employee.setImage_url("image.png");
		employee.setName("Employee Name");
		employee.setPassword("MyPassword");
		employee.setMgid(10);

		Employee employee2 = new Employee();
		employee2.setEid(0);
		employee2.setEmail("test@test.com");
		employee2.setImage_url("image.png");
		employee2.setName("Employee Name");
		employee2.setPassword("MyPassword");
		employee2.setMgid(11);

		List<Employee> employees = new ArrayList<Employee>();
		employees.add(employee);
		employees.add(employee2);

		Mockito.when(edaoMock.getAllEmployees()).thenReturn(employees);

		List<Employee> result = eserv.getEmployeeByManager(10);

		Assertions.assertNotEquals(0, result.size());
	}
	
	

}
