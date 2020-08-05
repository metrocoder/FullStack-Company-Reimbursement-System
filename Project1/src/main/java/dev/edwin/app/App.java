package dev.edwin.app;

import dev.edwin.controllers.EmployeeController;
import dev.edwin.controllers.ExpenseCategoryController;
import dev.edwin.controllers.ManagerController;
import dev.edwin.entities.Employee;
import dev.edwin.entities.ExpenseCategory;
import dev.edwin.entities.Manager;
import io.javalin.Javalin;

public class App {

	public static void main(String[] args) {
		Javalin app = Javalin.create(
				config->{config.enableCorsForAllOrigins();}
				).start(7000);

//		########################
//		EMPLOYEE
// 		########################
		app.put("/employee", EmployeeController.createEmployee);

		app.get("/employees", EmployeeController.getAllEmployees);
		app.get("/employee/:eid", EmployeeController.getEmployeeById);

		app.post("/employee", EmployeeController.updateEmployee);
		app.delete("/employee", EmployeeController.deleteEmployee);
//		########################
//		EXPENSE_CATEGORY
// 		########################
		app.put("/expense-category", ExpenseCategoryController.createExpenseCategory);

		app.get("/expense-categories", ExpenseCategoryController.getAllExpenseCategories);
		app.get("/expense-category/:cid", ExpenseCategoryController.getExpenseCategoryById);

		app.post("/expense-category", ExpenseCategoryController.updateExpenseCategory);
		app.delete("/expense-category", ExpenseCategoryController.deleteExpenseCategory);
//		########################
//		MANAGERS
// 		########################
		app.put("/manager", ManagerController.createManager);

		app.get("/managers", ManagerController.getAllManagers);
		app.get("/manager/:mid", ManagerController.getManagerById);

		app.post("/manager", ManagerController.updateManager);
		app.delete("/manager", ManagerController.deleteManager);
//		########################
//		REIMBURSEMENT
// 		########################
		app.put("/expense-category", ExpenseCategoryController.createExpenseCategory);

		app.get("/expense-categories", ExpenseCategoryController.getAllExpenseCategories);
		app.get("/expense-category/:cid", ExpenseCategoryController.getExpenseCategoryById);

		app.post("/expense-category", ExpenseCategoryController.updateExpenseCategory);
		app.delete("/expense-category", ExpenseCategoryController.deleteExpenseCategory);


	}



}
