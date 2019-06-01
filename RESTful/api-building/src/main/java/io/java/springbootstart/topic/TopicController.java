package io.java.springbootstart.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//marks class as controller
@RestController
public class TopicController {
	
	
	
	//URL mapping
	@RequestMapping("/topics")
	// Response gets auto converted to JSON as a HTTP request
	//return list of topic objects
	public List<Topic> getTopics() {
		//call arrays aslist method
		return Arrays.asList(
				//these onjects will be converted to JSON automatically 
				new Topic("spring" , "framework" , "framework description"),
				new Topic("java", "JEE" , "core description"),
				new Topic("typescript","typescript"," typescript description")
				);
	}
	
}
