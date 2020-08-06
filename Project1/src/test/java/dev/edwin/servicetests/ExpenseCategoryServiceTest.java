package dev.edwin.servicetests;

import dev.edwin.entities.ExpenseCategory;
import dev.edwin.services.ExpenseCategoryService;
import dev.edwin.services.ExpenseCategoryServiceImp;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseCategoryServiceTest {

    private ExpenseCategoryService expenseCategoryService = ExpenseCategoryServiceImp.getEserv();

    @Test
    @Order(1)
    void createExpenseCategory() {
    }

    @Test
    void getExpenseCategoryById() {
    }

    @Test
    void getExpenseCategoryByTitle() {
    }

    @Test
    void getAllExpenseCategories() {
    }

    @Test
    void updateExpenseCategory() {
    }

    @Test
    void deleteExpenseCategory() {
    }
}