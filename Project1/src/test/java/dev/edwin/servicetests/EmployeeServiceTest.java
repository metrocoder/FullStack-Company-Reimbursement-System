package dev.edwin.servicetests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dev.edwin.services.EmployeeService;
import dev.edwin.services.EmployeeServiceImp;

class EmployeeServiceTest {
	
	EmployeeService eserv = EmployeeServiceImp.getEserv();

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
