package io.java.springbootstart.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	//when spring creates instance of topic class
	//it injects an instance of it
	@Autowired
	private TopicRep topicrep;
	
	//this is now a service 
	//creates an immutable list of topics
	//create a new ArrayList to change that and make it mutable

	public List<Topic> getAllTopics(){
		//return topics;
		//connect to db , convert to instances
		List<Topic> topics = new ArrayList<>();
		//iter over result from find all
		topicrep.findAll()
		.forEach(topics :: add);
		
		return topics;
	}
	
	public Topic getTopic(String id) {
		//uses lambda to return topic id
		//compare id to id that is passed in and get the first one
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		
		//return id since its passed in as a string in the interface
		//and marked as key in topic
		return topicrep.findOne(id);
	
	}
	
	public void addTopic(Topic topic) {
		//topics.add(topic);
		//save topic to db
	
		topicrep.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		//loop through the list of topics
		/*for(int i =0; i < topics.size(); i++) {
			//topic at index
			Topic t = topics.get(i);
			//compare id of topic to id passed in 
			if(t.getId().equals(id)) {
				//if it matches set topic at index
				topics.set(i , topic);
				return;
			}
		}*/
		
		//if it exists it will be updated else it will be inserted
		topicrep.save(topic);
		
	}

	public void deleteTopic(String id) {
		
		topicrep.delete(id);
		//topics.removeIf(t -> t.getId().equals(id));
	}



}
