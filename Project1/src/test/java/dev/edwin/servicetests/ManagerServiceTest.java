package dev.edwin.servicetests;

import dev.edwin.daos.ManagerDAO;
import dev.edwin.entities.Manager;
import dev.edwin.services.ManagerService;
import dev.edwin.services.ManagerServiceImp;
import org.junit.jupiter.api.*;

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
        Manager manager = new Manager(0, "ServiceManager@test.com", "password0", "Serv Boss", "image.png");

        Manager result = mserv.createManager(manager);

        Assertions.assertNotEquals(0, result.getMgid());
    }

    @Test
    @Order(2)
    void getManagerById()
    {
        Manager result = mserv.getManagerById(1);

        Assertions.assertEquals("Nombre Nuevo", result.getName());

        System.out.println(result);
    }

    @Test
    @Order(3)
    void getManagerByName()
    {
        Manager result = mserv.getManagerByName("Serv Boss");

        Assertions.assertEquals("Serv Boss", result.getName());
    }

    @Test
    @Order(4)
    void getManagerByEmail()
    {
        Manager result = mserv.getManagerByEmail("ServiceManager@test.com");
        Assertions.assertEquals("ServiceManager@test.com", result.getEmail());
    }

    @Test
    @Order(5)
    void getAllManagers()
    {
        List<Manager> managers = mserv.getAllManagers();
        System.out.println(managers);
        Assertions.assertNotEquals(-0, managers.size());
    }

    @Test
    @Order(6)
    void updateManager()
    {
        Manager updateMe = mserv.getManagerById(1);
        updateMe.setPassword("ServicePass!");
        Manager result = mserv.updateManager(updateMe);

        Assertions.assertEquals("ServicePass!", result.getPassword());
    }

    @Test
    @Order(7)
    void deleteManager()
    {
        Manager manager;
        manager= new Manager(0, "DeleteServiceManager@test.com", "Del3te", "Deleted Boss", "image.png");

        Manager deleteMe = mserv.createManager(manager);
        boolean result = mserv.deleteManager(deleteMe);

        Assertions.assertNotEquals(false, result);
    }
}