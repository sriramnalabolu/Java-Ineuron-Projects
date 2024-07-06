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

		String status = service.savePerson(person);
		System.out.println(status);

	}

}
