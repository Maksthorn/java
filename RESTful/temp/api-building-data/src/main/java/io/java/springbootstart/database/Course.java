package io.java.springbootstart.database;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.java.springbootstart.topic.Topic;

//makes this an entity in database
@Entity
public class Course {
	//makes id primary key
	@Id
	private String id;
	private String name;
	private String Description;
	
	private Topic topic;
	public Course() {	
	
	}	
	
	public Course(String id, String name, String description, String topicId) {
		super();
		this.id = id;
		this.name = name;
		Description = description;
		this.topic= new Topic(topicId, "", "");
	}
	
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
}
