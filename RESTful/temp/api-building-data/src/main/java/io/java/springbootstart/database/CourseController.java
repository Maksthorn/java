package io.java.springbootstart.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//this controller handles all these requests  

import io.java.springbootstart.topic.Topic;


//marks class as controller
@RestController
public class CourseController {
	//declare dependency to inject
	@Autowired
	private CourseService courseService;
	
	
	//URL mapping get request
	@RequestMapping("/topics")
	// Response gets auto converted to JSON as a HTTP request
	//return list of topic objects
	public List<Course> getTopics() {
		//call arrays aslist method
		return courseService.getAllCourses();
	}
	
	
	//maps URL
	@RequestMapping("/topics/{topicId}/courses/{id}")
	//{variable} is used to handle variables in mapping
	//whatever is used as variable in mapping pass it to @PathVariable  
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	//map  post request to /topics
	@RequestMapping(method = RequestMethod.POST , value ="/topics/{topicId}/courses")
	//send object 
	public void addCourse(@RequestBody Course course , @PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
		
	}
	
	//map  update request to /topics/{topic id}
	@RequestMapping(method = RequestMethod.PUT , value ="/topics/{topicId}/courses/{id}")
	//send object 
	public void updateCourse(@RequestBody Course course , @PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(course);
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE , value = "/topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		 courseService.deleteCourse(id);
		
	}
	
	
}
