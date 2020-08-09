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
    private static EmployeeService employeeService = EmployeeServiceImp.getEserv();
    private static ExpenseCategoryService expenseCategoryService = ExpenseCategoryServiceImp.getEserv();

    @Test
    @Order(1)
    void createReimbursement()
    {
        Reimbursement r;
        r = new Reimbursement(0,
                624,
                "2020-8-6",
                0,
                null,
                "Service Employee note",
                "Service Manager Note",
                1,
                1
        );

        Reimbursement result = rserv.createReimbursement(r);

        Assertions.assertNotEquals(0, result.getRid());
    }

    @Test
    @Order(2)
    void getReimbursementById()
    {
        Reimbursement result = rserv.getReimbursementById(1);

        Assertions.assertEquals(400.0, result.getAmount());
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
        Reimbursement updateMe = rserv.getReimbursementById(1);
        updateMe.setEmployee_note("I'm broke son! Where my money at!");
        Reimbursement result = rserv.updateReimbursement(updateMe);

        Assertions.assertEquals("I'm broke son! Where my money at!",result.getEmployee_note());

    }

    @Test
    @Order(5)
    void deleteReimbursement()
    {
        Reimbursement slaughter;
        slaughter = new Reimbursement(0,
                2000,
                "2020-8-7",
                0,
                null,
                "Delete Service Employee note",
                "Delete Service Manager Note",
                1,
                1
        );

        Reimbursement deleteMe = rserv.createReimbursement(slaughter);
        boolean result = rserv.deleteReimbursement(deleteMe);

        Assertions.assertEquals(true, result);

    }



    @Test
    void getReimbursementByEmployee()
    {
        List<Reimbursement> r = rserv.getReimbursementByEmployee(10);
//        System.out.println(r);
        Assertions.assertNotEquals(0, r.size());

    }

    @Test
    void getReimbursementByCategory()
    {
        List<Reimbursement> r = rserv.getReimbursementByCategory(2);

        Assertions.assertNotEquals(0, r.size());
    }

    @Test
    void getReimbursementByManager()
    {
        List<Reimbursement> r = rserv.getReimbursementByManager(1);
//        System.out.println(r);
        Assertions.assertNotEquals(0, r.size());
    }

    @Test
    void getReimbursementsApproved()
    {
        List<Reimbursement> result = rserv.getReimbursementsApproved();
        System.out.println(result);
        Assertions.assertNotEquals(0, result.size());
    }

    @Test
    void getReimbursementsDenied()
    {
        List<Reimbursement> result = rserv.getReimbursementsDenied();
        System.out.println(result);
        Assertions.assertNotEquals(0, result.size());
    }

    @Test
    void getReimbursementsAmountAscending()
    {
        List<Reimbursement> result = rserv.getReimbursementsAmountAscending();
        System.out.println(result);
        Assertions.assertNotEquals(0, result.size());
    }

    @Test
    void getReimbursementsAmountDescending()
    {
        List<Reimbursement> result = rserv.getReimbursementsAmountDescending();
        System.out.println(result);
        Assertions.assertNotEquals(0, result.size());
    }

    @Test
    void getReimbursementsStatusDateAscending()
    {
        List<Reimbursement> result = rserv.getReimbursementsStatusDateAscending();
        System.out.println(result);
        Assertions.assertNotEquals(0, result.size());
    }

    @Test
    void getReimbursementsStatusDateDescending()
    {
        List<Reimbursement> result = rserv.getReimbursementsStatusDateDescending();
        System.out.println(result);
        Assertions.assertNotEquals(0, result.size());
    }

    @Test
    void getReimbursementsSubmitDateAscending()
    {
        List<Reimbursement> result = rserv.getReimbursementsSubmitDateAscending();
        System.out.println(result);
        Assertions.assertNotEquals(0, result.size());
    }

    @Test
    void getReimbursementsSubmitDateDescending()
    {
        List<Reimbursement> result = rserv.getReimbursementsSubmitDateDescending();
        System.out.println(result);
        Assertions.assertNotEquals(0, result.size());
    }

}