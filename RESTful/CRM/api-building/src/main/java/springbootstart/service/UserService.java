package springbootstart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springbootstart.entity.User;
import springbootstart.repo.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	
	public List<User> getAllUsers(){
		List<User> user = new ArrayList<>();
		userRepository.findAll()
		.forEach(user :: add);
		return user;
	}
	
	public User getUser(int id) {
		return userRepository.findOne(id);
		//cast int to string to compare in lambda
		//return vehicles.stream().filter(v -> Integer.toString(v.getVehicleID()).equals(id)).findFirst().get();
		//return vehicles.stream().filter(v -> v.getVehicleID().equals(id)).findFirst().get();
	}

	public void addUser(User user) {
		userRepository.save(user);
	}

	public void updateUser(int id,User user) {
		/*for(int i = 0; i < vehicles.size(); i++) {
			Vehicle v = vehicles.get(i);
			//loop through Vehicles and compare ID
			if(Integer.toString(v.getVehicleID()).equals(id)){
				vehicles.set(i, vehicle);
				return;
			}
		}*/
		userRepository.save(user);
		
	}
	
	public void deleteUser(int id) {
		userRepository.delete(id);
		//vehicles.removeIf(v -> Integer.toString(v.getVehicleID()).equals(id));
		
	}

}
