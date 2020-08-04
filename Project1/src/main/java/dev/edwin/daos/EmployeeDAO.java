package dev.edwin.daos;

import java.util.List;

import dev.edwin.entities.Employee;

public interface EmployeeDAO 
{
	Employee createEmployee(Employee employee);
	
	Employee getEmployeeById(int eid);
	Employee getEmployeeByEmail(String email);
	Employee getEmployeeByName(String name);
	
	List<Employee> getAllEmployees();
	
	Employee updateEmployee(Employee employee);
	
	boolean deleteEmployee(Employee employee);

}
