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
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


class ManagerServiceMockitoTest {

    @Mock
    private ManagerDAO mdaoMock;

    @InjectMocks
    private  ManagerService mserv = ManagerServiceImp.getMserv();

    @BeforeEach
    public void setUp() {

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
        Assertions.assertNotEquals(0, result.getMgid());

//        Verifies that we Mocked the mdao in mserv
        Mockito.verify(mdaoMock).createManager(m);



    }

    @Test
    @Order(2)
    void getManagerById() {

        Manager m = new Manager();
        m.setMgid(20);
        m.setEmail("emailer@email.com");
        m.setEmployees(null);
        m.setImage_url("image URL");
        m.setName("Robo Lord");
        m.setPassword("password");

        Mockito.when(mdaoMock.getManagerById(m.getMgid())).thenReturn(m);
        Manager result = mserv.getManagerById(m.getMgid());
        Assertions.assertEquals(20, result.getMgid());

//        Verifies that we Mocked the mdao in mserv
        Mockito.verify(mdaoMock).getManagerById(m.getMgid());
    }

    @Test
    @Order(3)
    void getManagerByEmail() {
        Manager m = new Manager();
        m.setMgid(20);
        m.setEmail("emailer@email.com");
        m.setEmployees(null);
        m.setImage_url("image URL");
        m.setName("Robo Lord");
        m.setPassword("password");

        Mockito.when(mdaoMock.getManagerByEmail(m.getEmail())).thenReturn(m);
        Manager result = mserv.getManagerByEmail(m.getEmail());
        Assertions.assertEquals("emailer@email.com", result.getEmail());

//        Verifies that we Mocked the mdao in mserv
        Mockito.verify(mdaoMock).getManagerByEmail(m.getEmail());
    }

    @Test
    @Order(4)
    void getManagerByName() {
        Manager m = new Manager();
        m.setMgid(20);
        m.setEmail("emailer@email.com");
        m.setEmployees(null);
        m.setImage_url("image URL");
        m.setName("Robo Lord");
        m.setPassword("password");

        Mockito.when(mdaoMock.getManagerByName(m.getName())).thenReturn(m);
        Manager result = mserv.getManagerByName(m.getName());
        Assertions.assertEquals("Robo Lord", result.getName());

//        Verifies that we Mocked the mdao in mserv
        Mockito.verify(mdaoMock).getManagerByName(m.getName());
    }

    @Test
    @Order(5)
    void getAllManagers() {

        List<Manager> ms = new ArrayList<Manager>();
        Manager m = new Manager();
        m.setMgid(20);
        m.setEmail("emailer@email.com");
        m.setEmployees(null);
        m.setImage_url("image URL");
        m.setName("Robo Lord");
        m.setPassword("password");
        ms.add(m);
        ms.add(new Manager(30, "RoboText@roro.com", "0101010","Senor Robo","Robo.png"));


        Mockito.when(mdaoMock.getAllManagers()).thenReturn(ms);
        List<Manager> results = mserv.getAllManagers();
        Assertions.assertNotEquals(1, results.size());

//        Verifies that we Mocked the mdao in mserv
        Mockito.verify(mdaoMock).getAllManagers();
    }

    @Test
    @Order(6)
    void updateManager() {
        Manager m = new Manager();
        m.setMgid(20);
        m.setEmail("emailer@email.com");
        m.setEmployees(null);
        m.setImage_url("image URL");
        m.setName("Robo Lord");
        m.setPassword("password");

        m.setName("Updated name");
        Mockito.when(mdaoMock.updateManager(m)).thenReturn(m);
        Manager results = mserv.updateManager(m);
        Assertions.assertNotEquals("Robo Lord", results.getName());

//        Verifies that we Mocked the mdao in mserv
        Mockito.verify(mdaoMock).updateManager(m);
    }

    @Test
    @Order(7)
    void deleteManager() {

        Manager m = new Manager();
        m.setMgid(20);
        m.setEmail("emailer@email.com");
        m.setEmployees(null);
        m.setImage_url("image URL");
        m.setName("Robo Lord");
        m.setPassword("password");

        m.setName("Updated name");
        Mockito.when(mdaoMock.deleteManager(m)).thenReturn(true);
        boolean result = mserv.deleteManager(m);
        Assertions.assertNotEquals(false,result);

//        Verifies that we Mocked the mdao in mserv
        Mockito.verify(mdaoMock).deleteManager(m);
    }
}