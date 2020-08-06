package dev.edwin.daos;

import dev.edwin.entities.ExpenseCategory;
import dev.edwin.entities.Reimbursement;
import dev.edwin.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ExpenseCategoryDAOHibernate implements ExpenseCategoryDAO {
    private static SessionFactory sf = HibernateUtil.getSessionFactory();

    private static ExpenseCategoryDAO edao = null;

    private ExpenseCategoryDAOHibernate() {
    }

    public static ExpenseCategoryDAO getEdao() {
        if(edao == null)
            edao = new ExpenseCategoryDAOHibernate();
        return edao;
    }

    @Override
    public ExpenseCategory createExpenseCategory(ExpenseCategory expenseCategory) {
        Session s = sf.openSession();
        s.beginTransaction();

        s.save(expenseCategory);

        s.getTransaction().commit();
        s.close();

        return expenseCategory;
    }

    @Override
    public ExpenseCategory getExpenseCategoryById(int cid) {
        Session s = sf.openSession();

        ExpenseCategory result = s.get(ExpenseCategory.class, cid);
        s.close();

        return result;
    }


    @Override
    public List<ExpenseCategory> getAllExpeneseCategories() {
        Session s = sf.openSession();

        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery<ExpenseCategory> cq = cb.createQuery(ExpenseCategory.class);
        Root<ExpenseCategory> rootEntry = cq.from(ExpenseCategory.class);
        CriteriaQuery<ExpenseCategory> all = cq.select(rootEntry);

        TypedQuery<ExpenseCategory> allQuery = s.createQuery(all);
        return allQuery.getResultList();
    }

    @Override
    public ExpenseCategory updateExpenseCategory(ExpenseCategory expenseCategory) {
        Session s = sf.openSession();
        s.beginTransaction();

        s.update(expenseCategory);

        s.getTransaction().commit();
        s.close();

        return expenseCategory;
    }

    @Override
    public boolean deleteExpenseCategory(ExpenseCategory expenseCategory) {
        try {

            Session s = sf.openSession();
            s.beginTransaction();

            s.delete(expenseCategory);

            s.getTransaction().commit();
            s.close();

            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return false;
    }
}
