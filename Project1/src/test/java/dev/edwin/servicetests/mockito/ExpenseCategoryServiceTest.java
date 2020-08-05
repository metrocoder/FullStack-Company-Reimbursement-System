package dev.edwin.servicetests.mockito;

import dev.edwin.daos.ExpenseCategoryDAO;
import dev.edwin.entities.Employee;
import dev.edwin.entities.ExpenseCategory;
import dev.edwin.services.ExpenseCategoryService;
import dev.edwin.services.ExpenseCategoryServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseCategoryServiceTest {

    @Mock
    private ExpenseCategoryDAO ecdao;

    @InjectMocks
    private ExpenseCategoryService ecserv = ExpenseCategoryServiceImp.getEserv();

    @BeforeEach
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    void createExpenseCategory() {
        ExpenseCategory expenseCategory = new ExpenseCategory(20,"Test Cat","Cat.png");

        Mockito.when(ecdao.createExpenseCategory(expenseCategory)).thenReturn(expenseCategory);
        ExpenseCategory result = ecdao.createExpenseCategory(expenseCategory);

        Assertions.assertEquals("Test Cat", result.getTitle());

        Mockito.verify(ecdao).createExpenseCategory(expenseCategory);
    }

    @Test
    void getExpenseCategoryById() {
        ExpenseCategory expenseCategory = new ExpenseCategory(20,"Test Cat","Cat.png");

        Mockito.when(ecdao.getExpenseCategoryById(expenseCategory.getCid())).thenReturn(expenseCategory);
        ExpenseCategory result = ecdao.getExpenseCategoryById(expenseCategory.getCid());

        Assertions.assertEquals("Test Cat", result.getTitle());

        Mockito.verify(ecdao).getExpenseCategoryById(expenseCategory.getCid());
    }

    @Test
    void getExpenseCategoryByTitle() {
        ExpenseCategory expenseCategory = new ExpenseCategory(20,"Test Cat","Cat.png");

        Mockito.when(ecdao.getExpenseCategoryByTitle(expenseCategory.getTitle())).thenReturn(expenseCategory);
        ExpenseCategory result = ecdao.getExpenseCategoryByTitle(expenseCategory.getTitle());

        Assertions.assertEquals("Test Cat", result.getTitle());

        Mockito.verify(ecdao).getExpenseCategoryByTitle(expenseCategory.getTitle());
    }

    @Test
    void getAllExpenseCategories() {
        List<ExpenseCategory> expenseCategories = new ArrayList<ExpenseCategory>();
        expenseCategories.add(new ExpenseCategory(20,"Test Cat","Cat.png"));
        expenseCategories.add(new ExpenseCategory(21,"Test Cat 1","Cat12.png"));

        Mockito.when(ecdao.getAllExpeneseCategories()).thenReturn(expenseCategories);
        List<ExpenseCategory> result = ecdao.getAllExpeneseCategories();

        Assertions.assertNotEquals(0, result.size());

        Mockito.verify(ecdao).getAllExpeneseCategories();
    }

    @Test
    void updateExpenseCategory() {
        List<ExpenseCategory> expenseCategories = new ArrayList<ExpenseCategory>();
        expenseCategories.add(new ExpenseCategory(20,"Test Cat","Cat.png"));
        expenseCategories.add(new ExpenseCategory(21,"Test Cat 1","Cat12.png"));

        Mockito.when(ecdao.updateExpenseCategory(expenseCategories.get(0))).thenReturn(expenseCategories.get(0));
        ExpenseCategory result = ecdao.updateExpenseCategory(expenseCategories.get(0));

        Assertions.assertEquals(20, result.getCid());

        Mockito.verify(ecdao).updateExpenseCategory(expenseCategories.get(0));
    }

    @Test
    void deleteExpenseCategory() {

        List<ExpenseCategory> expenseCategories = new ArrayList<ExpenseCategory>();
        expenseCategories.add(new ExpenseCategory(20,"Test Cat","Cat.png"));
        expenseCategories.add(new ExpenseCategory(21,"Test Cat 1","Cat12.png"));

        Mockito.when(ecdao.deleteExpenseCategory(expenseCategories.get(0))).thenReturn(true);
        boolean result = ecdao.deleteExpenseCategory(expenseCategories.get(0));

        Assertions.assertNotEquals(false, result);

        Mockito.verify(ecdao).deleteExpenseCategory(expenseCategories.get(0));
    }
}