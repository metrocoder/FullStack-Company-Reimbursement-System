package dev.edwin.servicetests;

import dev.edwin.services.ReimbursementService;
import dev.edwin.services.ReimbursementServiceImp;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ReimbursementServiceTest
{

    private static ReimbursementService rserv = ReimbursementServiceImp.getRserv();
    
    @Test
    @Order(1)
    void createReimbursement()
    {
    }

    @Test
    @Order(2)
    void getReimbursementById()
    {
    }

    @Test
    @Order(3)
    void getAllReimbursement()
    {
    }

    @Test
    @Order(4)
    void updateReimbursement()
    {
    }

    @Test
    @Order(5)
    void deleteReimbursement()
    {
    }
}