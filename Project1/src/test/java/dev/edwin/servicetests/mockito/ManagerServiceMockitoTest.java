package dev.edwin.servicetests.mockito;


import dev.edwin.daos.ManagerDAO;
import dev.edwin.entities.Manager;
import dev.edwin.services.ManagerService;
import dev.edwin.services.ManagerServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.inject.Inject;


class ManagerServiceMockitoTest {

    @Inject
    private ManagerDAO mdaoMock;

    @InjectMocks
    private  ManagerService mserv = ManagerServiceImp.getMserv();

    @BeforeEach
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
    }




    @Test
    @Order(1)
    void  testCreateManager() {

        Manager m = new Manager();
        m.setMgid(20);
        m.setEmail("emailer@email.com");
        m.setEmployees(null);
        m.setImage_url("image URL");
        m.setName("Robo Lord");
        m.setPassword("password");


        Mockito.when(mdaoMock.createManager(m)).thenReturn(m);

        Manager result = mserv.createManager(m);
        Assertions.assertEquals(20, result.getMgid());

//        Mockito.verify(mdaoMock.createManager(managers.get(0))).getMgid();

    }
//
//    @Test
//    @Order(2)
//    void getManagerById() {
//    }
//
//    @Test
//    @Order(3)
//    void getManagerByEmail() {
//    }
//
//    @Test
//    @Order(4)
//    void getManagerByName() {
//    }
//
//    @Test
//    @Order(5)
//    void getAllManagers() {
//    }
//
//    @Test
//    @Order(6)
//    void updateManager() {
//    }
//
//    @Test
//    @Order(7)
//    void deleteManager() {
//    }
}