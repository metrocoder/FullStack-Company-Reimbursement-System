package dev.edwin.servicetests;

import dev.edwin.daos.ExpenseCategoryDAO;
import dev.edwin.entities.ExpenseCategory;
import dev.edwin.services.ExpenseCategoryService;
import dev.edwin.services.ExpenseCategoryServiceImp;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ExpenseCategoryServiceTest {

    private ExpenseCategoryService expenseCategoryService = ExpenseCategoryServiceImp.getEserv();

    @Test
    @Order(1)
    void createExpenseCategory() {
        ExpenseCategory ec = new ExpenseCategory(0, "Leisure", "leisure.png");
        ExpenseCategory result = expenseCategoryService.createExpenseCategory(ec);

        Assertions.assertNotEquals(0, result.getCid());
    }

    @Test
    @Order(2)
    void getExpenseCategoryById() {
        ExpenseCategory result = expenseCategoryService.getExpenseCategoryById(1);

        Assertions.assertEquals("Crude Oil",result.getTitle() );
    }

    @Test
    @Order(3)
    void getExpenseCategoryByTitle() {
        ExpenseCategory result = expenseCategoryService.getExpenseCategoryByTitle("Crude Oil");

        Assertions.assertEquals(1, result.getCid());
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
        ExpenseCategory updateMe = expenseCategoryService.getExpenseCategoryById(2);
        updateMe.setTitle("Battery Power");
        ExpenseCategory result = expenseCategoryService.updateExpenseCategory(updateMe);

        Assertions.assertEquals("Battery Power", result.getTitle());
    }

    @Test
    @Order(6)
    void deleteExpenseCategory() {
        ExpenseCategory slaughterMe = new ExpenseCategory(0, "Service Delete", "leisure.png");
        ExpenseCategory deleteMe = expenseCategoryService.createExpenseCategory(slaughterMe);
        boolean result = expenseCategoryService.deleteExpenseCategory(deleteMe);

        Assertions.assertEquals(true, result);

    }
}