package in.ineuron.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.model.Person;
import in.ineuron.model.PhoneNumber;
import in.ineuron.repo.IPersonRepo;
import in.ineuron.repo.IPhoneNumberRepository;

@Service
public class PersonMgmtServiceImpl implements IPersonMgmtService {

	@Autowired
	private IPersonRepo personRepo;

	@Autowired
	private IPhoneNumberRepository phoneRepo;

	@Override
	public String savePerson(Person person) {
		Integer idValue = personRepo.save(person).getPid();
		return "Person and his phoneNumber are saved with id value :: " + idValue;
	}

	@Override
	public String savePhoneNumbers(Iterable<PhoneNumber> numbers) {

		for (PhoneNumber phoneNumber : numbers) {
			phoneRepo.save(phoneNumber);
		}
		return ((Set<PhoneNumber>) numbers).size()+"no of phoneNumbers are saved";
	}
}
