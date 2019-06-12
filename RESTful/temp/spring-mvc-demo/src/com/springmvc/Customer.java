package com.springmvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.springmvc.validation.CourseCode;

public class Customer {
	
	private String firstName;
	@NotNull(message="is required")
	@Size(min=1 , message ="is required")
	private String lastName;
	@NotNull(message="is required")
	@Min(value=0,message="must be greater than or equal to 0")
	@Max(value=10,message="must be less than or equal to 10")
	private int freePasses;
	
	@Pattern(regexp="^[a-zA-Z0-9]{5}",message="5 chars/digit limit")
	public String postalCode;
	@CourseCode //import custom annotation look into com.springmvc.validation package for more info
	//@CourseCode(value="test" , message ="must start with test") a way to override the code
	public String courseCode;
	
	
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public Integer getFreePasses() {
		return freePasses;
	}
	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
	
}
