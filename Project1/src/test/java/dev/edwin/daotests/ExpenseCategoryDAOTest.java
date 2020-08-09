package dev.edwin.daotests;

import dev.edwin.daos.ExpenseCategoryDAO;
import dev.edwin.daos.ExpenseCategoryDAOImp;
import dev.edwin.entities.ExpenseCategory;
import org.junit.jupiter.api.*;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ExpenseCategoryDAOTest {

    private static ExpenseCategoryDAO ecdao = ExpenseCategoryDAOImp.getEdao();

    @Test
    @Order(1)
    void createExpenseCategory()
    {
        ExpenseCategory ec = new ExpenseCategory(0, "Title", "catImage.png");
        ExpenseCategory result = ecdao.createExpenseCategory(ec);

        Assertions.assertNotEquals(0, result.getCid());
    }

    @Test
    @Order(2)
    void getExpenseCategoryById() {
        ExpenseCategory result = ecdao.getExpenseCategoryById(7);

        Assertions.assertEquals("catImage.png", result.getImage_url());
    }

    @Test
    @Order(3)
    void getAllExpeneseCategories() {
        List<ExpenseCategory> expenseCategories = ecdao.getAllExpenseCategories();

        Assertions.assertNotEquals(0, expenseCategories.size());
    }

    @Test
    @Order(4)
    void updateExpenseCategory() {
        ExpenseCategory expenseCategory = ecdao.getExpenseCategoryById(1);
        expenseCategory.setTitle("Crude Oil");
        ExpenseCategory result = ecdao.updateExpenseCategory(expenseCategory);

        Assertions.assertEquals("Crude Oil", result.getTitle());
    }

    @Test
    @Order(5)
    void deleteExpenseCategory()
    {
        ExpenseCategory sheep = new ExpenseCategory(0, "Delete Me!", "DeleteImage.png");
        ExpenseCategory deleteMe = ecdao.createExpenseCategory(sheep);
        boolean result = ecdao.deleteExpenseCategory(deleteMe);

        Assertions.assertNotEquals(false, result);

    }
}