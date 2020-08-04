package dev.edwin.daos;

import java.util.List;

import dev.edwin.entities.Manager;

public interface ManagerDAO {

//	CRUD
	Manager createManager(Manager manager);
	
//	READ
	Manager getManagerById(int mgid);
	Manager getManagerByEmail(String email);
	Manager getManagerByName(String name);
	List<Manager> getAllManagers();
	
	
//	Update
	Manager updateManager(Manager manager);
	
//	DELETE
	boolean deleteManager(Manager manager);
}
