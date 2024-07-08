package in.ineuron.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "OTM_PHONE_NUMBER")
@RequiredArgsConstructor
public class PhoneNumber {

	PhoneNumber(){
		System.out.println("PhoneNumber 0 param constructor :: ");
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long regNo;

	@NonNull
	private Long phoneNo;

	@NonNull
	private String provider;
	
	@NonNull
	private String type;

	@ManyToOne(targetEntity = Person.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	//@JoinColumn(name = "PERSON_ID", referencedColumnName = "pid")
	private Person person;

	@Override
	public String toString() {
		return "PhoneNumber [regNo=" + regNo + ", phoneNo=" + phoneNo + ", provider=" + provider + ", type=" + type
				+ "]";
	}
	
}


