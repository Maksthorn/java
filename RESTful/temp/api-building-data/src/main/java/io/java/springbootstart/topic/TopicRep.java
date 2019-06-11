package io.java.springbootstart.topic;

import org.springframework.data.repository.CrudRepository;


//make interface so you dont have to remake all the gets for topic
//inherit methods from Crudrep and pass generic types
public interface TopicRep extends CrudRepository<Topic,String> {
	
	
	
	
}
