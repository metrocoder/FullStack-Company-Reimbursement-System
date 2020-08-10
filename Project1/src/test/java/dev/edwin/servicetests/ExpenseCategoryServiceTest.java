package dev.edwin.servicetests;

import dev.edwin.daos.ExpenseCategoryDAO;
import dev.edwin.entities.ExpenseCategory;
import dev.edwin.services.ExpenseCategoryService;
import dev.edwin.services.ExpenseCategoryServiceImp;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ExpenseCategoryServiceTest {

    private ExpenseCategoryService expenseCategoryService = ExpenseCategoryServiceImp.getEserv();

    @Test
    @Order(1)
    void createExpenseCategory() {
        ExpenseCategory ec = new ExpenseCategory(0, "One", "One.png");
        ExpenseCategory result = expenseCategoryService.createExpenseCategory(ec);

        Assertions.assertNotEquals(0, result.getCid());
    }

    @Test
    @Order(2)
    void getExpenseCategoryById() {
        ExpenseCategory result = expenseCategoryService.getExpenseCategoryById(2);

        Assertions.assertEquals(2,result.getCid() );
    }

    @Test
    @Order(3)
    void getExpenseCategoryByTitle() {
        ExpenseCategory result = expenseCategoryService.getExpenseCategoryByTitle("One");

        Assertions.assertEquals("One", result.getTitle());
    }

    @Test
    @Order(4)
    void getAllExpenseCategories() {
        List<ExpenseCategory> expenseCategories = expenseCategoryService.getAllExpenseCategories();

        Assertions.assertNotEquals(0, expenseCategories.size());
    }

    @Test
    @Order(5)
    void updateExpenseCategory() {
        List<ExpenseCategory> expenseCategories =expenseCategoryService.getAllExpenseCategories();
        ExpenseCategory updateMe = expenseCategories.get(expenseCategories.size()-1);
        updateMe.setTitle("Battery Power");
        ExpenseCategory result = expenseCategoryService.updateExpenseCategory(updateMe);

        Assertions.assertEquals("Battery Power", result.getTitle());
    }

    @Test
    @Order(6)
    void deleteExpenseCategory() {
        List<ExpenseCategory> expenseCategories =expenseCategoryService.getAllExpenseCategories();
        ExpenseCategory deleteMe = expenseCategories.get(expenseCategories.size()-1);
        boolean result = expenseCategoryService.deleteExpenseCategory(deleteMe);

        Assertions.assertEquals(true, result);

    }
}