package in.ineuron.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@Table(name = "OTM_PERSON")
@RequiredArgsConstructor
public class Person {
	
	Person(){
		System.out.println("Person 0 param constructor :: ");
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;
	
	@NonNull
	private String pname;
	
	@NonNull
	private String paddress;

	@OneToMany(targetEntity = PhoneNumber.class, cascade = CascadeType.ALL,mappedBy="person",fetch=FetchType.EAGER)
	//@JoinColumn(name = "PERSON_ID", referencedColumnName = "pid")
	private Set<PhoneNumber> contactDetails;

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", paddress=" + paddress + "]";
	}

}

