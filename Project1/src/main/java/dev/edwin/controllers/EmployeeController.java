package dev.edwin.controllers;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import dev.edwin.entities.Employee;
import dev.edwin.services.EmployeeService;
import dev.edwin.services.EmployeeServiceImp;
import io.javalin.http.Handler;

public class EmployeeController 
{

	private static EmployeeService eserv = EmployeeServiceImp.getEserv();
	private static Gson gson = new Gson();
	
	public static Handler createEmployee = (ctx) -> 
	{
		String body = ctx.body();
		
		
		try
		{
			Employee employee = gson.fromJson(body, Employee.class);
			if(employee != null) {
				Employee returned = eserv.createEmployee(employee);
				ctx.result(gson.toJson(returned));
				ctx.status(200);
			}
			else
				ctx.status(404);
			
			
		}catch (Exception e)
		{
			ctx.status(404);
			e.printStackTrace();
		}
		
	};
	
	public static Handler getEmployeeById = (ctx) -> {
		String eid = ctx.pathParam("eid");
	
		try
		{
			Employee employee = eserv.getEmployeeById(Integer.parseInt(eid));
			String json = gson.toJson(employee);		
			ctx.result(json);	
			ctx.status(200);
		} catch (NumberFormatException e)
		{
			ctx.status(404);
			e.printStackTrace();
		}
	};
	
	public static Handler getAllEmployees = (ctx) -> {
//		Can have query to search 
		String name = ctx.queryParam("name");
		String email = ctx.queryParam("email");
		String manager = ctx.queryParam("manager");
		String sort = ctx.queryParam("sort_employee");
		
		List<Employee> employees = new ArrayList<Employee>();
		
		if(name != null)
		{
			employees.add(eserv.getEmployeeByName(name));
		}
		else if (email != null)
		{
			employees.add(eserv.getEmployeeByEmail(email));
		}
		else if (manager != null)
		{
			employees = eserv.getEmployeeByManager(Integer.parseInt(manager));
		}
		else if (sort != null)
		{
			if (sort.compareToIgnoreCase("ASC")==0)
				employees = eserv.getAllEmployeesNameAtoZ();

			if (sort.compareToIgnoreCase("DESC")==0)
				employees = eserv.getAllEmployeesNameZtoA();
		}
		else
		{
			employees = eserv.getAllEmployees();
		}
		
		String json = gson.toJson(employees);
		ctx.result(json);
		ctx.status(200);
	};
	
	
	public static Handler updateEmployee = (ctx) -> {
		String body = ctx.body();
		Employee employee = gson.fromJson(body, Employee.class);
		Employee result = eserv.updateEmployee(employee);
		
		ctx.result(gson.toJson(result));
		ctx.status(202);
		
	};
	
	public static Handler deleteEmployee = (ctx) -> {
		String body = ctx.body();
		Employee employee = gson.fromJson(body, Employee.class);
		try
		{
			boolean result = eserv.deleteEmployee(employee);
			
			 if(result == true)
				 ctx.status(200);
			 else
				 ctx.status(404);
		}catch(NumberFormatException e)
		{
			ctx.status(404);
			e.printStackTrace();
		}
	};
}
