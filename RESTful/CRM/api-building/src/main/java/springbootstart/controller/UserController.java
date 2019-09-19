package springbootstart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springbootstart.entity.User;
import springbootstart.service.UserService;

@RequestMapping("/admin")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	 // this is for the api without a db
	@RequestMapping("/Users")
	public List<User> getUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping("/Users/{id}")
	//bind pathvariable to {id}
	public User getVehicle(@PathVariable int id) {
		return userService.getUser(id);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value="/Users")
	//post request is going to contain a json of User 
	//take requestbody and convert it to Vehicle type
	public void addVehicle(@RequestBody User user) {
		userService.addUser(user);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, value="/Users/{id}")
	//post request is going to contain a json of User 
	//take requestbody and convert it to Vehicle type
	public void updateVehicle(@RequestBody User user, @PathVariable int id) {
		userService.updateUser(id,user);
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE, value="/Users/{id}")
	//post request is going to contain a json of vehicle 
	//take requestbody and convert it to Vehicle type
	public void deleteVehicle(@RequestBody User user, @PathVariable int id) {
		userService.deleteUser(id);
	}
}
