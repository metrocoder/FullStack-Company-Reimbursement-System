package dev.edwin.daos;

import dev.edwin.entities.ExpenseCategory;

import java.util.List;

public interface ExpenseCategoryDAO {
//    CRUD ops

    ExpenseCategory createExpenseCategory(ExpenseCategory expenseCategory);

//    READ
    ExpenseCategory getExpenseCategoryById(int cid);
    ExpenseCategory getExpenseCategoryByTitle(String title);
    List<ExpenseCategory> getAllExpeneseCategories();

//    UPDATE
    ExpenseCategory updateExpenseCategory(ExpenseCategory expenseCategory);

//    DELETE
    boolean deleteExpenseCategory(ExpenseCategory expenseCategory);

}
