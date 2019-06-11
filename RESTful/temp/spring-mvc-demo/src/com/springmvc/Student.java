package com.springmvc;

import java.util.LinkedHashMap;

public class Student {
	private String firstName;
	private String lastName;
	private String country;
	private LinkedHashMap<String , String> countryOptions;
	private String[] operatingSystems;

	public Student() {
		//read country options
		countryOptions = new LinkedHashMap<>();
						  //key -- value
		countryOptions.put("BR", "Brazil");
		countryOptions.put("UK", "United Kingdom");
		countryOptions.put("USA", "United States of America");
		countryOptions.put("GER", "Germany");
		countryOptions.put("POL", "Poland");
		countryOptions.put("IRL", "Ireland");
		
		
	}
	
	public String[] getOperatingSystems() {
		return operatingSystems;
	}
	
	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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
