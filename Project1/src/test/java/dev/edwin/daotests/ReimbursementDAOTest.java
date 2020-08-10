package dev.edwin.daotests;

import dev.edwin.daos.*;
import dev.edwin.entities.Reimbursement;
import org.junit.jupiter.api.*;

import java.sql.Date;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ReimbursementDAOTest
{
    private static ReimbursementDAO rdao = ReimbursementDAOImp.getRdao();
    private static EmployeeDAO edao = EmployeeDAOImp.getEdao();
    private static ExpenseCategoryDAO expenseCategoryDAO = ExpenseCategoryDAOImp.getEdao();

    @Test
    @Order(1)
    void createReimbursement()
    {
        Reimbursement r;
        r = new Reimbursement(0,
                300,
                "2011-10-9",
                0,
                "2000-01-01",
                "Employee note",
                "Manager Note",
                2,
                10
                );

        Reimbursement result = rdao.createReimbursement(r);

        Assertions.assertNotEquals(0, result.getRid());

        System.out.println(result);
    }

    @Test
    @Order(2)
    void getReimbursementById()
    {
        List<Reimbursement> reimbursements = rdao.getAllReimbursement();
        Reimbursement result = rdao.getReimbursementById(reimbursements.get(reimbursements.size()-1).getRid());
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
        List<Reimbursement> reimbursements = rdao.getAllReimbursement();
        Reimbursement updateMe = rdao.getReimbursementById(reimbursements.get(reimbursements.size()-1).getRid());
        updateMe.setAmount(400);
        Reimbursement result = rdao.updateReimbursement(updateMe);

        Assertions.assertEquals(400, result.getAmount());
    }

    @Test
    @Order(6)
    void deleteReimbursement()
    {
        List<Reimbursement> reimbursements = rdao.getAllReimbursement();
        Reimbursement deleteMe = rdao.getReimbursementById(reimbursements.get(reimbursements.size()-1).getRid());

        boolean result = rdao.deleteReimbursement(deleteMe);

        Assertions.assertEquals(true, result);

    }
}