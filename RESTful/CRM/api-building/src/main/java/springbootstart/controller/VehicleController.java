package springbootstart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springbootstart.entity.Vehicle;
import springbootstart.service.VehicleService;

@RestController
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@GetMapping("/")
	public String homePage(){
		return ("<h1>Welcome</h1>");
	}
	
	 // this is for the api without a db
	@RequestMapping("/Vehicles")
	public List<Vehicle> getVehicles() {
		return vehicleService.getAllVehicles();
	}
	
	@RequestMapping("/Vehicles/{id}")
	//bind pathvariable to {id}
	public Vehicle getVehicle(@PathVariable int id) {
		return vehicleService.getVehicle(id);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value="/Vehicles")
	//post request is going to contain a json of vehicle 
	//take requestbody and convert it to Vehicle type
	public void addVehicle(@RequestBody Vehicle vehicle) {
		vehicleService.addVehicle(vehicle);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, value="/Vehicles/{id}")
	//post request is going to contain a json of vehicle 
	//take requestbody and convert it to Vehicle type
	public void updateVehicle(@RequestBody Vehicle vehicle, @PathVariable int id) {
		vehicleService.updateVehicle(id,vehicle);
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE, value="/Vehicles/{id}")
	//post request is going to contain a json of vehicle 
	//take requestbody and convert it to Vehicle type
	public void deleteVehicle(@RequestBody Vehicle vehicle, @PathVariable int id) {
		vehicleService.deleteVehicle(id);
	}
	
}
