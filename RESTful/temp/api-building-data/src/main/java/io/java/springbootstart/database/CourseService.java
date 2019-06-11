package io.java.springbootstart.database;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	//when spring creates instance of topic class
	//it injects an instance of it
	@Autowired
	private CourseRep courserep;
	
	//this is now a service 
	//creates an immutable list of topics
	//create a new ArrayList to change that and make it mutable

	public List<Course> getAllCourses(){
		//return topics;
		//connect to db , convert to instances
		List<Course> courses = new ArrayList<>();
		//iter over result from find all
		courserep.findAll()
		.forEach(courses :: add);
		
		return courses;
	}
	
	public Course getCourse(String id) {
		//uses lambda to return topic id
		//compare id to id that is passed in and get the first one
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		
		//return id since its passed in as a string in the interface
		//and marked as key in topic
		return courserep.findOne(id);
	
	}
	
	public void addCourse(Course course) {
		//topics.add(topic);
		//save topic to db
	
		courserep.save(course);
	}

	public void updateCourse(Course course) {
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
		courserep.save(course);
		
	}

	public void deleteCourse(String id) {
		
		courserep.delete(id);
		//topics.removeIf(t -> t.getId().equals(id));
	}



}
