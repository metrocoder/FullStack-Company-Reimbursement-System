package dev.edwin.services;

import dev.edwin.entities.Manager;

import java.util.List;

public interface ManagerService {

//    CRUD
    Manager createManager(Manager manager);

//    Read
    Manager getManagerById(int mgid);
    Manager getManagerByEmail(String email);
    Manager getManagerByName(String name);
    List<Manager> getAllManagers();

//    Update
    Manager updateManager(Manager manager);

//    Delete
    boolean deleteManager(Manager manager);
}
