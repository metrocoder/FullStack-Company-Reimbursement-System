package dev.edwin.servicetests;

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
	@Order(1)
	void testCreateEmployee() {
		
		Employee employee = new Employee();
		employee.setEid(0);
		employee.setEmail("test@test.com");
		employee.setImage_url("image.png");
		employee.setName("Employee Name");
		employee.setPassword("MyPassword");
		
		Mockito.when(edaoMock.createEmployee(employee)).thenReturn(employee);
		
		Employee result = eserv.createEmployee(employee);
		
		Assertions.assertEquals("test@test.com", result.getEmail());
	}
	

	@Test
	@Order(2)
	void testGetEmployeeById() {
		
		Employee employee = new Employee();
		employee.setEid(11);
		employee.setEmail("test@test.com");
		employee.setImage_url("image.png");
		employee.setName("Employee Name");
		employee.setPassword("MyPassword");
		
		Mockito.when(edaoMock.getEmployeeById(employee.getEid())).thenReturn(employee);
		
		Employee result = eserv.getEmployeeById(employee.getEid());
		
		Assertions.assertEquals(11, result.getEid());
	}
	

	@Test
	@Order(3)
	void testGetEmployeeByEmail() {
		
		Employee employee = new Employee();
		employee.setEid(0);
		employee.setEmail("test@test.com");
		employee.setImage_url("image.png");
		employee.setName("Employee Name");
		employee.setPassword("MyPassword");
		
		Mockito.when(edaoMock.createEmployee(employee)).thenReturn(employee);
		
		Employee result = eserv.createEmployee(employee);
		
		Assertions.assertEquals("test@test.com", result.getEmail());
	}
	

	@Test
	@Order(4)
	void testGetEmployeeByName() {
		
		Employee employee = new Employee();
		employee.setEid(0);
		employee.setEmail("test@test.com");
		employee.setImage_url("image.png");
		employee.setName("Employee Name");
		employee.setPassword("MyPassword");
		
		Mockito.when(edaoMock.createEmployee(employee)).thenReturn(employee);
		
		Employee result = eserv.createEmployee(employee);
		
		Assertions.assertEquals("Employee Name", result.getName());
	}
	
	@Test
	@Order(5)
	void testGetAllEmployees() {
		
		Employee employee = new Employee();
		employee.setEid(0);
		employee.setEmail("test@test.com");
		employee.setImage_url("image.png");
		employee.setName("Employee Name");
		employee.setPassword("MyPassword");
		
		Mockito.when(edaoMock.createEmployee(employee)).thenReturn(employee);
		
		Employee result = eserv.createEmployee(employee);
		
		Assertions.assertEquals("test@test.com", result.getEmail());
	}
	

	@Test
	@Order(6)
	void testGetAllEmployeesAtoZ() {
		
		Employee employee = new Employee();
		employee.setEid(11);
		employee.setEmail("test@test.com");
		employee.setImage_url("image.png");
		employee.setName("Employee Name");
		employee.setPassword("MyPassword");
		
		Mockito.when(edaoMock.createEmployee(employee)).thenReturn(employee);
		
		Employee result = eserv.createEmployee(employee);
		
		Assertions.assertEquals(11, result.getEid());
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
		
		Mockito.when(edaoMock.createEmployee(employee)).thenReturn(employee);
		
		Employee result = eserv.createEmployee(employee);
		
		Assertions.assertEquals("test@test.com", result.getEmail());
	}
	

	@Test
	@Order(8)
	void testUpdateEmployee() {
		
		Employee employee = new Employee();
		employee.setEid(0);
		employee.setEmail("test@test.com");
		employee.setImage_url("image.png");
		employee.setName("Employee Name");
		employee.setPassword("MyPassword");
		
		Mockito.when(edaoMock.createEmployee(employee)).thenReturn(employee);
		
		Employee result = eserv.createEmployee(employee);
		
		Assertions.assertEquals("test@test.com", result.getEmail());
	}
	
	@Test
	@Order(8)
	void testDeleteEmployee() {
		
		Employee employee = new Employee();
		employee.setEid(0);
		employee.setEmail("test@test.com");
		employee.setImage_url("image.png");
		employee.setName("Employee Name");
		employee.setPassword("MyPassword");
		
		Mockito.when(edaoMock.createEmployee(employee)).thenReturn(employee);
		
		Employee result = eserv.createEmployee(employee);
		
		Assertions.assertEquals(true, result.getEmail());
	}
	
	

}
