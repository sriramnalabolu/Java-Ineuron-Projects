package in.ineuron.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
//Any unknown properties coming into java object for binding to ignore we use the annotation
@JsonIgnoreProperties(ignoreUnknown=true)
public class Customer {
	private Integer id;
	private String firstName;
	private String lastName;
	private Boolean active;
	
	// HAS-A property 
	private Address address;
	  
	// Array property 
	private String[] languages;
	
}

