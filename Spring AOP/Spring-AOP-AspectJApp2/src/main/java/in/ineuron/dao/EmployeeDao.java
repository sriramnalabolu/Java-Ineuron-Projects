package in.ineuron.dao;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class EmployeeDao {
	public String saveEmployee() {	 
		System.out.println("Employee Object is saved...");
		return "Employee Data saved with the id is 5";
	}
}



