package dev.edwin.servicetests.mockito;

import dev.edwin.daos.ReimbursementDAO;
import dev.edwin.entities.Manager;
import dev.edwin.entities.Reimbursement;
import dev.edwin.services.ReimbursementService;
import dev.edwin.services.ReimbursementServiceImp;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ReimbursementServiceTest {

    @Mock
    private ReimbursementDAO rdao;

    @InjectMocks
    private ReimbursementService rserv = ReimbursementServiceImp.getRserv();

    @BeforeEach
    public void setUp() {

        MockitoAnnotations.initMocks(this);
    }


    @Test
    @Order(1)
    void getReimbursementByEmployee()
    {
        List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
        reimbursements.add(new Reimbursement(1,
                100,
                "2020-11-01",
                0, "2000-01-01",
                "Employee Note",
                "Manager Note", 1, 1));
        reimbursements.add(new Reimbursement(2,
                200,
                "2020-11-02",
                1, "2000-01-01",
                "Employee Note",
                "Manager Note", 2, 2));
        Mockito.when(rdao.getAllReimbursement()).thenReturn(reimbursements);

        List<Reimbursement> results = rserv.getReimbursementByEmployee(2);

        Assertions.assertNotEquals(0,results.size());
    }

    @Test
    @Order(2)
    void getReimbursementByCategory()
    {
        List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
        reimbursements.add(new Reimbursement(1,
                100,
                "2020-11-01",
                0, "2000-01-01",
                "Employee Note",
                "Manager Note", 1, 1));
        reimbursements.add(new Reimbursement(2,
                200,
                "2020-11-02",
                1, "2000-01-01",
                "Employee Note",
                "Manager Note", 2, 2));
        Mockito.when(rdao.getAllReimbursement()).thenReturn(reimbursements);

        List<Reimbursement> results = rserv.getReimbursementByCategory(2);

        Assertions.assertNotEquals(0,results.size());
    }

    @Test
    @Order(4)
    void getReimbursementsApproved()
    {
        List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
        reimbursements.add(new Reimbursement(1,
                100,
                "2020-11-01",
                0, "2000-01-01",
                "Employee Note",
                "Manager Note", 1, 1));
        reimbursements.add(new Reimbursement(2,
                200,
                "2020-11-02",
                1, "2000-01-01",
                "Employee Note",
                "Manager Note", 2, 2));
        Mockito.when(rdao.getAllReimbursement()).thenReturn(reimbursements);

        List<Reimbursement> results = rserv.getReimbursementsApproved();

        Assertions.assertNotEquals(0,results.size());
    }

    @Test
    @Order(5)
    void getReimbursementsDenied()
    {
        List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
        reimbursements.add(new Reimbursement(1,
                100,
                "2020-11-01",
                0, "2000-01-01",
                "Employee Note",
                "Manager Note", 1, 1));
        reimbursements.add(new Reimbursement(2,
                200,
                "2020-11-02",
                1, "2000-01-01",
                "Employee Note",
                "Manager Note", 2, 2));
        Mockito.when(rdao.getAllReimbursement()).thenReturn(reimbursements);

        List<Reimbursement> results = rserv.getReimbursementsDenied();

        Assertions.assertNotEquals(0,results.size());
    }

    @Test
    @Order(6)
    void getReimbursementsAmountAscending()
    {
        List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
        reimbursements.add(new Reimbursement(1,
                100,
                "2020-11-01",
                0, "2000-01-01",
                "Employee Note",
                "Manager Note", 1, 1));
        reimbursements.add(new Reimbursement(2,
                200,
                "2020-11-02",
                1, "2000-01-01",
                "Employee Note",
                "Manager Note", 2, 2));
        Mockito.when(rdao.getAllReimbursement()).thenReturn(reimbursements);

        List<Reimbursement> results = rserv.getReimbursementsAmountAscending();

        Assertions.assertNotEquals(0,results.size());
    }

    @Test
    @Order(7)
    void getReimbursementsAmountDescending()
    {
        List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
        reimbursements.add(new Reimbursement(1,
                100,
                "2020-11-01",
                0, "2000-01-01",
                "Employee Note",
                "Manager Note", 1, 1));
        reimbursements.add(new Reimbursement(2,
                200,
                "2020-11-02",
                1, "2000-01-01",
                "Employee Note",
                "Manager Note", 2, 2));
        Mockito.when(rdao.getAllReimbursement()).thenReturn(reimbursements);

        List<Reimbursement> results = rserv.getReimbursementsAmountDescending();

        Assertions.assertNotEquals(0,results.size());
    }

    @Test
    @Order(8)
    void getReimbursementsStatusDateAscending()
    {
        List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
        reimbursements.add(new Reimbursement(1,
                100,
                "2020-11-01",
                0, "2000-01-01",
                "Employee Note",
                "Manager Note", 1, 1));
        reimbursements.add(new Reimbursement(2,
                200,
                "2020-11-02",
                1, "2000-01-01",
                "Employee Note",
                "Manager Note", 2, 2));
        Mockito.when(rdao.getAllReimbursement()).thenReturn(reimbursements);

        List<Reimbursement> results = rserv.getReimbursementsStatusDateAscending();

        Assertions.assertNotEquals(0,results.size());
    }

    @Test
    @Order(9)
    void getReimbursementsStatusDateDescending()
    {
        List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
        reimbursements.add(new Reimbursement(1,
                100,
                "2020-11-01",
                0, "2000-01-01",
                "Employee Note",
                "Manager Note", 1, 1));
        reimbursements.add(new Reimbursement(2,
                200,
                "2020-11-02",
                1, "2000-01-01",
                "Employee Note",
                "Manager Note", 2, 2));
        Mockito.when(rdao.getAllReimbursement()).thenReturn(reimbursements);

        List<Reimbursement> results = rserv.getReimbursementsStatusDateDescending();

        Assertions.assertNotEquals(0,results.size());
    }

    @Test
    @Order(10)
    void getReimbursementsSubmitDateAscending()
    {
        List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
        reimbursements.add(new Reimbursement(1,
                100,
                "2020-11-01",
                0, "2000-01-01",
                "Employee Note",
                "Manager Note", 1, 1));
        reimbursements.add(new Reimbursement(2,
                200,
                "2020-11-02",
                1, "2000-01-01",
                "Employee Note",
                "Manager Note", 2, 2));
        Mockito.when(rdao.getAllReimbursement()).thenReturn(reimbursements);

        List<Reimbursement> results = rserv.getReimbursementsSubmitDateAscending();

        Assertions.assertNotEquals(0,results.size());
    }

    @Test
    @Order(11)
    void getReimbursementsSubmitDateDescending()
    {
        List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
        reimbursements.add(new Reimbursement(1,
                100,
                "2020-11-01",
                0, "2000-01-01",
                "Employee Note",
                "Manager Note", 1, 1));
        reimbursements.add(new Reimbursement(2,
                200,
                "2020-11-02",
                1, "2000-01-01",
                "Employee Note",
                "Manager Note", 2, 2));
        Mockito.when(rdao.getAllReimbursement()).thenReturn(reimbursements);

        List<Reimbursement> results = rserv.getReimbursementsSubmitDateDescending();

        Assertions.assertNotEquals(0,results.size());
    }
}