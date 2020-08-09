package dev.edwin.services;

import java.util.List;

import dev.edwin.entities.Employee;

public interface EmployeeService 
{
//	CREATE
	Employee createEmployee(Employee employee);
	
//	READ
	Employee getEmployeeById(int eid);
	Employee getEmployeeByEmail(String email);
	Employee getEmployeeByName(String name);
	List<Employee> getEmployeeByManager(int mgid);
	List<Employee> getAllEmployees();
	List<Employee> getAllEmployeesNameAtoZ();
	List<Employee> getAllEmployeesNameZtoA();
	
//	UPDATE
	Employee updateEmployee(Employee employee);
	
//	DELETE
	boolean deleteEmployee(Employee employee);

}
