package dev.edwin.daotests;

import dev.edwin.daos.EmployeeDAO;
import dev.edwin.daos.EmployeeDAOHibernate;
import dev.edwin.entities.Employee;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeDAOTest
{

    private static EmployeeDAO edao = EmployeeDAOHibernate.getEdao();
    @Test
    @Order(1)
    void createEmployee()
    {
        Employee e = new Employee(0,
                "employeeEmail@email.com",
                "testPass",
                "My Name",
                "testImg.png");

        Employee result = edao.createEmployee(e);

        Assertions.assertNotEquals(0, result.getEid());
    }

    @Test
    @Order(2)
    void getEmployeeById()
    {
        Employee result = edao.getEmployeeById(1);

        Assertions.assertEquals("testImg.png", result.getImage_url());
    }

    @Test
    @Order(3)
    void getAllEmployees()
    {
        List<Employee> result = edao.getAllEmployees();

        Assertions.assertNotEquals(0, result.size());
    }

    @Test
    @Order(4)
    void updateEmployee()
    {
        Employee updateMe = edao.getEmployeeById(1);
        updateMe.setEmail("MyNewEmail@email.com");
        Employee result = edao.updateEmployee(updateMe);

        Assertions.assertEquals("MyNewEmail@email.com",result.getEmail());
    }

    @Test
    @Order(5)
    void deleteEmployee()
    {
        Employee slaughter = new Employee(0,
                "KillMe@email.com",
                "Im dying",
                "Dead Bro",
                "rip.png");

        Employee deleteMe = edao.createEmployee(slaughter);
        boolean result = edao.deleteEmployee(deleteMe);

        Assertions.assertEquals(true, result);

    }
}