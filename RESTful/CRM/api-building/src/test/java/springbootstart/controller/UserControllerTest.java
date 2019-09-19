package springbootstart.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import springbootstart.entity.User;

class UserControllerTest {

	@Test
	void testGetUsers() {
		UserController uc = new UserController();
		List<User> users = uc.getUsers();
		fail("Not yet implemented");
	}

	@Test
	void testGetVehicle() {
		fail("Not yet implemented");
	}

	@Test
	void testAddVehicle() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateVehicle() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteVehicle() {
		fail("Not yet implemented");
	}

}
