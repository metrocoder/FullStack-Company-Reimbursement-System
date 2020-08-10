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
    void  getManagerByName() {

        Manager m = new Manager();
        m.setMgid(20);
        m.setEmail("emailer@email.com");
        m.setImage_url("image URL");
        m.setName("Robo Lord");
        m.setPassword("password");

        Manager m2 = new Manager();
        m.setMgid(11);
        m.setEmail("emailer@email.com");
        m.setImage_url("image URL");
        m.setName("Robo");
        m.setPassword("password");

        List<Manager> managers = new ArrayList<Manager>();
        managers.add(m);
        managers.add(m2);

        Mockito.when(mdaoMock.getAllManagers()).thenReturn(managers);
        Manager result = mserv.getManagerByName("Robo");
        Assertions.assertNotEquals(0, result.getMgid());

//        Verifies that we Mocked the mdao in mserv
        Mockito.verify(mdaoMock).getAllManagers();



    }

    @Test
    @Order(2)
    void  getManagerByEmail() {

        Manager m = new Manager();
        m.setMgid(20);
        m.setEmail("emailOne@email.com");
        m.setImage_url("image URL");
        m.setName("Robo Lord");
        m.setPassword("password");

        Manager m2 = new Manager();
        m.setMgid(11);
        m.setEmail("emailTwo@email.com");
        m.setImage_url("image URL");
        m.setName("Robo");
        m.setPassword("password");

        List<Manager> managers = new ArrayList<Manager>();
        managers.add(m);
        managers.add(m2);

        Mockito.when(mdaoMock.getAllManagers()).thenReturn(managers);
        Manager result = mserv.getManagerByEmail("emailTwo@email.com");
        Assertions.assertEquals("emailTwo@email.com", result.getEmail());

//        Verifies that we Mocked the mdao in mserv
        Mockito.verify(mdaoMock).getAllManagers();



    }



//    @Test
//    @Order(5)
//    void getAllManagers() {
//
//        List<Manager> ms = new ArrayList<Manager>();
//        Manager m = new Manager();
//        m.setMgid(20);
//        m.setEmail("emailer@email.com");
//        m.setEmployees(null);
//        m.setImage_url("image URL");
//        m.setName("Robo Lord");
//        m.setPassword("password");
//        ms.add(m);
//        ms.add(new Manager(30, "RoboText@roro.com", "0101010","Senor Robo","Robo.png"));
//
//
//        Mockito.when(mdaoMock.getAllManagers()).thenReturn(ms);
//        List<Manager> results = mserv.getAllManagers();
//        Assertions.assertNotEquals(1, results.size());
//
////        Verifies that we Mocked the mdao in mserv
//        Mockito.verify(mdaoMock).getAllManagers();
//    }

//    @Test
//    @Order(6)
//    void updateManager() {
//        Manager m = new Manager();
//        m.setMgid(20);
//        m.setEmail("emailer@email.com");
////        m.setEmployees(null);
//        m.setImage_url("image URL");
//        m.setName("Robo Lord");
//        m.setPassword("password");
//
//        m.setName("Updated name");
//        Mockito.when(mdaoMock.updateManager(m)).thenReturn(m);
//        Manager results = mserv.updateManager(m);
//        Assertions.assertNotEquals("Robo Lord", results.getName());
//
////        Verifies that we Mocked the mdao in mserv
//        Mockito.verify(mdaoMock).updateManager(m);
//    }
//
//    @Test
//    @Order(7)
//    void deleteManager() {
//
//        Manager m = new Manager();
//        m.setMgid(20);
//        m.setEmail("emailer@email.com");
////        m.setEmployees(null);
//        m.setImage_url("image URL");
//        m.setName("Robo Lord");
//        m.setPassword("password");
//
//        m.setName("Updated name");
//        Mockito.when(mdaoMock.deleteManager(m)).thenReturn(true);
//        boolean result = mserv.deleteManager(m);
//        Assertions.assertNotEquals(false,result);
//
////        Verifies that we Mocked the mdao in mserv
//        Mockito.verify(mdaoMock).deleteManager(m);
//    }
}