package dev.edwin.daotests;

import dev.edwin.daos.*;
import dev.edwin.entities.Reimbursement;
import org.junit.jupiter.api.*;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ReimbursementDAOTest
{
    private static ReimbursementDAO rdao = ReimbursementDAOHibernate.getRdao();
    private static EmployeeDAO edao = EmployeeDAOHibernate.getEdao();
    private static ExpenseCategoryDAO expenseCategoryDAO = ExpenseCategoryDAOHibernate.getEdao();

    @Test
    @Order(1)
    void createReimbursement()
    {
        Reimbursement r;
        r = new Reimbursement(0,
                300,
                Date.valueOf("2011-10-9"),
                false,
                null,
                "Employee note",
                "Manager Note",
                expenseCategoryDAO.getExpenseCategoryById(1),
                edao.getEmployeeById(1)
                );

        Reimbursement result = rdao.createReimbursement(r);

        Assertions.assertNotEquals(0, result.getRid());
    }

    @Test
    @Order(2)
    void getReimbursementById()
    {
        Reimbursement result = rdao.getReimbursementById(1);
        Assertions.assertEquals(300, result.getAmount());
    }

    @Test
    @Order(4)
    void getAllReimbursement()
    {
        List<Reimbursement> reimbursements = rdao.getAllReimbursement();

        Assertions.assertNotEquals(0, reimbursements.size());
    }

    @Test
    @Order(5)
    void updateReimbursement()
    {
        Reimbursement updateMe = rdao.getReimbursementById(1);
        updateMe.setAmount(400);
        Reimbursement result = rdao.updateReimbursement(updateMe);

        Assertions.assertEquals(400, result.getAmount());
    }

    @Test
    @Order(6)
    void deleteReimbursement()
    {
        Reimbursement slaughter;
        slaughter = new Reimbursement(0, 300, Date.valueOf("2011-10-9"), false, null,
                "Delete me note", "Delete Me Manager Note",
                expenseCategoryDAO.getExpenseCategoryById(1),edao.getEmployeeById(1)
        );
        Reimbursement deleteMe = rdao.createReimbursement(slaughter);
//        Reimbursement deleteMe = rdao.getReimbursementById(2);

        boolean result = rdao.deleteReimbursement(deleteMe);

        Assertions.assertEquals(true, result);

    }
}