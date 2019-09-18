package springbootstart.repo;

import org.springframework.data.repository.CrudRepository;

import springbootstart.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
