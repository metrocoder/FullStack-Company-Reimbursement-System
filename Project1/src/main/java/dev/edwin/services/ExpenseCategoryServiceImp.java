package dev.edwin.services;

import dev.edwin.daos.ExpenseCategoryDAO;
import dev.edwin.entities.ExpenseCategory;

import javax.inject.Inject;
import java.util.List;

public class ExpenseCategoryServiceImp implements ExpenseCategoryService {

    @Inject
    private static ExpenseCategoryDAO edao;

    private static ExpenseCategoryService eserv = null;

    private ExpenseCategoryServiceImp() {
    }

    public static ExpenseCategoryService getEserv() {
        if (eserv == null)
            eserv = new ExpenseCategoryServiceImp();
        return eserv;
    }

    @Override
    public ExpenseCategory createExpenseCategory(ExpenseCategory expenseCategory) {
        return edao.createExpenseCategory(expenseCategory);
    }

    @Override
    public ExpenseCategory getExpenseCategoryById(int cid) {
        return edao.getExpenseCategoryById(cid);
    }

    @Override
    public ExpenseCategory getExpenseCategoryByTitle(String title) {
        List<ExpenseCategory> expenseCategories = edao.getAllExpeneseCategories();

        for (ExpenseCategory e:
             expenseCategories) {
            if (e.getTitle().compareToIgnoreCase(title) == 0)
            {
                return e;
            }
        }

        return null;
    }

    @Override
    public List<ExpenseCategory> getAllExpenseCategories() {
        return edao.getAllExpeneseCategories();
    }

    @Override
    public ExpenseCategory updateExpenseCategory(ExpenseCategory expenseCategory) {
        return edao.updateExpenseCategory(expenseCategory);
    }

    @Override
    public boolean deleteExpenseCategory(ExpenseCategory expenseCategory) {
        return edao.deleteExpenseCategory(expenseCategory);
    }
}
