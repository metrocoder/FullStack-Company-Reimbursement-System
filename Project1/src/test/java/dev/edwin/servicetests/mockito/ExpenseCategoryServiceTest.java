package dev.edwin.servicetests.mockito;

import dev.edwin.daos.ExpenseCategoryDAO;
import dev.edwin.entities.ExpenseCategory;
import dev.edwin.services.ExpenseCategoryService;
import dev.edwin.services.ExpenseCategoryServiceImp;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ExpenseCategoryServiceTest {

    @Mock
    private ExpenseCategoryDAO mockDao;

    @InjectMocks
    private ExpenseCategoryService ecserv = ExpenseCategoryServiceImp.getEserv();

    @BeforeEach
    public void setUp()
    {

        MockitoAnnotations.initMocks(this);
    }


    @Test
    @Order(1)
    void getExpenseCategoryByTitle() {
        List<ExpenseCategory> expenseCategoryArrayList = new ArrayList<ExpenseCategory>();

        ExpenseCategory e = new ExpenseCategory(1,"One","Cat.png");
        ExpenseCategory e2 = new ExpenseCategory(2,"Two","Cat.png");
        expenseCategoryArrayList.add(e);
        expenseCategoryArrayList.add(e2);

        Mockito.when(mockDao.getAllExpenseCategories()).thenReturn(expenseCategoryArrayList);
        ExpenseCategory result = ecserv.getExpenseCategoryByTitle("One");

        Assertions.assertEquals("One", result.getTitle());

        Mockito.verify(mockDao).getAllExpenseCategories();
    }
}