package dev.edwin.servicetests.mockito;

import dev.edwin.daos.ReimbursementDAO;
import dev.edwin.entities.Manager;
import dev.edwin.entities.Reimbursement;
import dev.edwin.services.ReimbursementService;
import dev.edwin.services.ReimbursementServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
    void createReimbursement()
    {
        Reimbursement r = new Reimbursement(
                20,200, Date.valueOf("2017-10-04"),false, null,
                "Employee Note","Manager notes",null,null);


        Mockito.when(rdao.createReimbursement(r)).thenReturn(r);
        Reimbursement result = rserv.createReimbursement(r);

        Assertions.assertNotEquals(0, result.getRid());

//        Verifies that we Mocked the mdao in mserv
        Mockito.verify(rdao).createReimbursement(r);
    }

    @Test
    @Order(2)
    void getReimbursementById() {
        Reimbursement reimbursement = new Reimbursement(
                20,200, Date.valueOf("2017-10-04"),false, null,
                "Employee Note","Manager notes",null,null);

        Mockito.when(rdao.getReimbursementById(reimbursement.getRid())).thenReturn(reimbursement);
        Reimbursement result = rserv.getReimbursementById(reimbursement.getRid());

        Assertions.assertEquals(20, result.getRid());
        System.out.println(reimbursement);
        Mockito.verify(rdao).getReimbursementById(reimbursement.getRid());

    }

    @Test
    @Order(3)
    void getAllReimbursement() {

        List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
        reimbursements.add(new Reimbursement(
                20,200, Date.valueOf("2017-10-04"),false, null,
                "Employee Note","Manager notes",null,null));

        reimbursements.add(new Reimbursement(
                22,400, Date.valueOf("2017-10-04"),false, null,
                "Employee Note","Manager notes",null,null));

        Mockito.when(rdao.getAllReimbursement()).thenReturn(reimbursements);

        List<Reimbursement> results = rserv.getAllReimbursement();

        Assertions.assertEquals(2, results.size());
    }

    @Test
    @Order(4)
    void updateReimbursement() {
        Reimbursement reimbursement = new Reimbursement(
                20,200, Date.valueOf("2017-10-04"),false, null,
                "Employee Note","Manager notes",null,null);

        Mockito.when(rdao.updateReimbursement(reimbursement)).thenReturn(reimbursement);
        Reimbursement result = rserv.updateReimbursement(reimbursement);

        Assertions.assertEquals(200, result.getAmount());
        Mockito.verify(rdao).updateReimbursement(reimbursement);
    }

    @Test
    @Order(5)
    void deleteReimbursement() {

        Reimbursement reimbursement = new Reimbursement(
                20,200, Date.valueOf("2017-10-04"),false, null,
                "Employee Note","Manager notes",null,null);

        Mockito.when(rdao.deleteReimbursement(reimbursement)).thenReturn(true);
        boolean result = rserv.deleteReimbursement(reimbursement);

        Assertions.assertEquals(true, result);
        Mockito.verify(rdao).deleteReimbursement(reimbursement);
    }
}