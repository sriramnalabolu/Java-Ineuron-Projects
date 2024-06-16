package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.dto.CustomerDTO;
import in.ineuron.service.ICustomerMgmtService;

@SpringBootApplication
public class DaoSpringDataJpaMongoDbCrudAppApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(DaoSpringDataJpaMongoDbCrudAppApplication.class, args);
		
		ICustomerMgmtService service = applicationContext.getBean(ICustomerMgmtService.class);
	
		System.out.println(service.removeCustomer("666cdc421d30f2106506affe"));
		
		((ConfigurableApplicationContext) applicationContext).close();
		
		/*
		 * System.out.println(service.registerCustomer(new CustomerDTO(45, "rohit",
		 * 110.0f))); 
		 * 
		 * 
		 * 
		 * service.findAllCustomers().forEach(System.out::println);
		 * 
		 * 
		 * System.out.println(service.registerCustomer(new CustomerDTO(3,"nitin", 330.0f)));
		 * 
		 * 
		 * 
		 * service.fetchCustomerByBillAmount(340.50f,500.05f).forEach(System.out::println);
		*  service.fetchCustomerByUsingAddressAndHavingMobileNo("MI","RCB").forEach(System.out::println);
		 * 
		 * 
		 * 
		 */		 
		
		//System.out.println(service.registerCustomer(new CustomerDTO(18, "kohli", 450.05f, "RCB", 999555776L)));
		
				
	}
}

