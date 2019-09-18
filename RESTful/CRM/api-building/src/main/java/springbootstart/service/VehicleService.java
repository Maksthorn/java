package springbootstart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springbootstart.entity.Vehicle;
import springbootstart.repo.VehicleRepository;

@Service
//services are singletons
public class VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	/*List<Vehicle> vehicles = new ArrayList<>(Arrays.asList(
				
				new Vehicle("4","make 2","model 2",1995,"body style 2","color 2","2222-12-12","trim level 2"),
				new Vehicle("5","make 3","model 3",1997,"body style 3","color 3","3333-13-13","trim level 3")
			));*/
	
	public List<Vehicle> getAllVehicles(){
		List<Vehicle> vehicles = new ArrayList<>();
		vehicleRepository.findAll()
		.forEach(vehicles :: add);
		return vehicles;
	}
	
	public Vehicle getVehicle(int id) {
		return vehicleRepository.findOne(id);
		//cast int to string to compare in lambda
		//return vehicles.stream().filter(v -> Integer.toString(v.getVehicleID()).equals(id)).findFirst().get();
		//return vehicles.stream().filter(v -> v.getVehicleID().equals(id)).findFirst().get();
	}

	public void addVehicle(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
	}

	public void updateVehicle(int id,Vehicle vehicle) {
		/*for(int i = 0; i < vehicles.size(); i++) {
			Vehicle v = vehicles.get(i);
			//loop through Vehicles and compare ID
			if(Integer.toString(v.getVehicleID()).equals(id)){
				vehicles.set(i, vehicle);
				return;
			}
		}*/
		vehicleRepository.save(vehicle);
		
	}
	
	public void deleteVehicle(int id) {
		vehicleRepository.delete(id);
		//vehicles.removeIf(v -> Integer.toString(v.getVehicleID()).equals(id));
		
	}

}
