package dev.edwin.servicetests;

import dev.edwin.entities.Employee;
import dev.edwin.entities.ExpenseCategory;
import dev.edwin.entities.Reimbursement;
import dev.edwin.services.*;
import org.junit.jupiter.api.*;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ReimbursementServiceTest
{

    private static ReimbursementService rserv = ReimbursementServiceImp.getRserv();

    @Test
    @Order(1)
    void createReimbursement()
    {
        Reimbursement r;
        r = new Reimbursement(0,
                624,
                "2020-8-6",
                1,
                "2000-01-06",
                "Service Employee note",
                "Service Manager Note",
                2,
                10
        );

        Reimbursement result = rserv.createReimbursement(r);

        Assertions.assertNotEquals(0, result.getRid());
    }

    @Test
    @Order(2)
    void getReimbursementById()
    {
        List<Reimbursement> reimbursements = rserv.getAllReimbursement();
        Reimbursement result = rserv.getReimbursementById(reimbursements.get(reimbursements.size()-1).getRid());

        Assertions.assertEquals(2, result.getCid());
    }

    @Test
    @Order(3)
    void getAllReimbursement()
    {
        List<Reimbursement> reimbursements = rserv.getAllReimbursement();

        Assertions.assertNotEquals(0, reimbursements.size());
    }

    @Test
    @Order(4)
    void updateReimbursement()
    {
        List<Reimbursement> reimbursements = rserv.getAllReimbursement();
        Reimbursement updateMe = reimbursements.get(reimbursements.size()-1);
        updateMe.setEmployee_note("I'm broke son! Where my money at!");
        Reimbursement result = rserv.updateReimbursement(updateMe);

        Assertions.assertEquals("I'm broke son! Where my money at!",result.getEmployee_note());

    }

    @Test
    @Order(30)
    void deleteReimbursement()
    {
        List<Reimbursement> reimbursements = rserv.getAllReimbursement();
        Reimbursement deleteMe = reimbursements.get(reimbursements.size()-1);
        boolean result = rserv.deleteReimbursement(deleteMe);

        Assertions.assertEquals(true, result);

    }



    @Test
    @Order(5)
    void getReimbursementByEmployee()
    {
        List<Reimbursement> r = rserv.getReimbursementByEmployee(10);
        Assertions.assertNotEquals(0, r.size());

    }

    @Test
    @Order(6)
    void getReimbursementByCategory()
    {
        List<Reimbursement> r = rserv.getReimbursementByCategory(2);

        Assertions.assertNotEquals(0, r.size());
    }

    @Test
    @Order(7)
    void getReimbursementByManager()
    {
        List<Reimbursement> r = rserv.getReimbursementByManager(1);

        Assertions.assertNotEquals(0, r.size());
    }

    @Test
    @Order(8)
    void getReimbursementsApproved()
    {
        List<Reimbursement> result = rserv.getReimbursementsApproved();

        Assertions.assertNotEquals(0, result.size());
    }

    @Test
    @Order(9)
    void getReimbursementsDenied()
    {
        List<Reimbursement> result = rserv.getReimbursementsDenied();

        Assertions.assertNotEquals(0, result.size());
    }

    @Test
    @Order(10)
    void getReimbursementsAmountAscending()
    {
        List<Reimbursement> result = rserv.getReimbursementsAmountAscending();

        Assertions.assertNotEquals(0, result.size());
    }

    @Test
    @Order(11)
    void getReimbursementsAmountDescending()
    {
        List<Reimbursement> result = rserv.getReimbursementsAmountDescending();

        Assertions.assertNotEquals(0, result.size());
    }

    @Test
    @Order(12)
    void getReimbursementsStatusDateAscending()
    {
        List<Reimbursement> result = rserv.getReimbursementsStatusDateAscending();

        Assertions.assertNotEquals(0, result.size());
    }

    @Test
    @Order(13)
    void getReimbursementsStatusDateDescending()
    {
        List<Reimbursement> result = rserv.getReimbursementsStatusDateDescending();

        Assertions.assertNotEquals(0, result.size());
    }

    @Test
    @Order(14)
    void getReimbursementsSubmitDateAscending()
    {
        List<Reimbursement> result = rserv.getReimbursementsSubmitDateAscending();

        Assertions.assertNotEquals(0, result.size());
    }

    @Test
    @Order(15)
    void getReimbursementsSubmitDateDescending()
    {
        List<Reimbursement> result = rserv.getReimbursementsSubmitDateDescending();

        Assertions.assertNotEquals(0, result.size());
    }

}