package dev.edwin.servicetests;

import dev.edwin.daos.ManagerDAO;
import dev.edwin.entities.Manager;
import dev.edwin.services.ManagerService;
import dev.edwin.services.ManagerServiceImp;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ManagerServiceTest
{

    private static ManagerService mserv = ManagerServiceImp.getMserv();

    @Test
    @Order(1)
    void createManager()
    {
        List<Manager> managers = new ArrayList<Manager>();
        managers.add(new Manager(0, "One@test.com", "password0", "One", "image.png"));

        Manager result = mserv.createManager(managers.get(0));

        Assertions.assertNotEquals(0, result.getMgid());
    }

    @Test
    @Order(2)
    void getManagerById()
    {
        Manager result = mserv.getManagerById(1);

        Assertions.assertEquals(1, result.getMgid());

//        System.out.println(result);
    }

    @Test
    @Order(3)
    void getManagerByName()
    {
        Manager result = mserv.getManagerByName("One");

        Assertions.assertEquals("One", result.getName());
    }

    @Test
    @Order(4)
    void getManagerByEmail()
    {
        Manager result = mserv.getManagerByEmail("One@test.com");
        Assertions.assertEquals("One@test.com", result.getEmail());
    }

    @Test
    @Order(5)
    void getAllManagers()
    {
        List<Manager> managers = mserv.getAllManagers();

        Assertions.assertNotEquals(0, managers.size());
    }

    @Test
    @Order(6)
    void updateManager()
    {
        List<Manager> managers = mserv.getAllManagers();
        Manager updateMe = managers.get(managers.size()-1);
        updateMe.setPassword("ServicePass!");
        Manager result = mserv.updateManager(updateMe);

        Assertions.assertEquals("ServicePass!", result.getPassword());
    }

    @Test
    @Order(7)
    void deleteManager()
    {
        List<Manager> managers = mserv.getAllManagers();
        Manager deleteMe = managers.get(managers.size()-1);
        boolean result = mserv.deleteManager(deleteMe);

        Assertions.assertNotEquals(false, result);
    }
}