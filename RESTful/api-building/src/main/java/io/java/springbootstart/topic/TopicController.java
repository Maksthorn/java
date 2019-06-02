package io.java.springbootstart.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//marks class as controller
@RestController
public class TopicController {
	//declare dependancy to inject
	@Autowired
	private TopicService topicService;
	
	
	//URL mapping get request
	@RequestMapping("/topics")
	// Response gets auto converted to JSON as a HTTP request
	//return list of topic objects
	public List<Topic> getTopics() {
		//call arrays aslist method
		return topicService.getAllTopics();
	}
	
	
	//maps URL
	@RequestMapping("/topics/{id}")
	//{variable} is used to handle variables in mapping
	//whatever is used as variable in mapping pass it to @PathVariable  
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	//map  post request to /topics
	@RequestMapping(method = RequestMethod.POST , value ="/topics")
	//send object 
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
		
	}
	
	//map  update request to /topics/{topic id}
	@RequestMapping(method = RequestMethod.PUT , value ="/topics/{id}")
	//send object 
	public void updateTopic(@RequestBody Topic topic , @PathVariable String id) {
		topicService.updateTopic(id, topic);
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE , value = "/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		 topicService.deleteTopic(id);
		
	}
	
	
}
