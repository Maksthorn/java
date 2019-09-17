package springbootstart.dao;

import java.util.List;

import springbootstart.entity.Vehicle;

public interface VehicleDAO {
	

		List<Vehicle> findAll();

		void insertVehicle(Vehicle vehicle);

		void updateVehicle(Vehicle vehicle);

		void executeUpdateVehicle(Vehicle vehicle);

		public void deleteVehicle(Vehicle vehicle);

		
	
}
