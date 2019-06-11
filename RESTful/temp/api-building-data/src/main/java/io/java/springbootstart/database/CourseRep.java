package io.java.springbootstart.database;

import org.springframework.data.repository.CrudRepository;


//make interface so you dont have to remake all the gets for topic
//inherit methods from Crudrep and pass generic types
public interface CourseRep extends CrudRepository<Course,String> {
	
	
	
	
}
