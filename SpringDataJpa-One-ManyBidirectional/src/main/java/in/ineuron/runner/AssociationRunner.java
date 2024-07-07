package in.ineuron.runner;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.ineuron.model.Person;
import in.ineuron.model.PhoneNumber;
import in.ineuron.service.IPersonMgmtService;

@Component
public class AssociationRunner implements CommandLineRunner {

	@Autowired
	private IPersonMgmtService service;

	@Override
	public void run(String... args) throws Exception {

		//Save Operation Parent to Child
		
		// Create a parent object
		Person person = new Person("hyder", "RCB");

		// Create a child object
		PhoneNumber p1 = new PhoneNumber(9998887775L, "airtel", "office");
		PhoneNumber p2 = new PhoneNumber(8889997775L, "jio", "residence");
		
		//link parent to child
		p1.setPerson(person);
		p2.setPerson(person);

		Set<PhoneNumber> contactDetails = Set.of(p1, p2);

		//link child to parent
		person.setContactDetails(contactDetails);

		//Save Operation w.r.t Person table
		String status = service.savePerson(person);
		System.out.println(status);


		
		//Save Operation Child to Parent
		
		// Create a parent object
		Person person1 = new Person("Nitin", "MI");

		// Create a child object
		PhoneNumber p3 = new PhoneNumber(6665554445L, "BSNL", "office");
		PhoneNumber p4 = new PhoneNumber(3332221115L, "Reliance", "residence");

		//link parent to child
		p3.setPerson(person1);
		p4.setPerson(person1);
		
		Set<PhoneNumber> contactDetails1 = Set.of(p3, p4);

		//link child to parent
		person1.setContactDetails(contactDetails1);
		
		//Save Operation w.r.t PhoneNumber table
		String status1 = service.savePhoneNumbers(contactDetails1);
		System.out.println(status1);
	}
	
}

