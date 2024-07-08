package in.ineuron.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.ineuron.model.Person;

public interface IPersonRepo extends JpaRepository<Person, Integer> {
    
	// Full Join (Note: This may cause an error as mentioned in the comment)
	@Query("SELECT p.pid, p.pname, p.paddress, ph.regNo, ph.phoneNo, ph.provider, ph.type FROM Person p FULL JOIN p.contactDetails ph")
    public List<Object[]> fetchDataUsingJoinsByParent();
}

// Inner Join
//@Query("SELECT p.pid, p.pname, p.paddress, ph.regNo, ph.phoneNo, ph.provider, ph.type FROM Person p INNER JOIN p.contactDetails ph")

//Right Join
//@Query("SELECT p.pid, p.pname, p.paddress, ph.regNo, ph.phoneNo, ph.provider, ph.type FROM Person p RIGHT JOIN p.contactDetails ph")

//Left Join	
//@Query("SELECT p.pid, p.pname, p.paddress, ph.regNo, ph.phoneNo, ph.provider, ph.type FROM Person p LEFT JOIN p.contactDetails ph")

