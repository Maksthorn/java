package springbootstart.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springbootstart.entity.Vehicle;

@Repository
// entity type and data type of ID 
public interface VehicleRepository extends CrudRepository <Vehicle, String>{
	//https://medium.com/better-programming/building-a-spring-boot-rest-api-part-iii-integrating-mysql-database-and-jpa-81391404046a
	//leave for now idk what its meant to do
}
