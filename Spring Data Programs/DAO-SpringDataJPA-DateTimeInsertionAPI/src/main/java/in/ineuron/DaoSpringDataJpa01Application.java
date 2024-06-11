package in.ineuron;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.bo.Customer;
import in.ineuron.service.ICustomerMgmtService;


@SpringBootApplication
public class DaoSpringDataJpa01Application {

	public static void main(String[] args) {
		ApplicationContext factory = SpringApplication.run(DaoSpringDataJpa01Application.class, args);

		ICustomerMgmtService service = factory.getBean(ICustomerMgmtService.class);

		service.getAllCustomers().forEach(System.out::println);
		
		((ConfigurableApplicationContext) factory).close();
		

		/*
		 * List<Customer> customers = new ArrayList<Customer>(); customers.add(new
		 * Customer("Sachin", "MI", LocalDateTime.of(1968, 11, 1, 15, 0, 12),
		 * LocalTime.of(10, 45), LocalDate.now())); customers.add(new Customer("Kohli",
		 * "RCB", LocalDateTime.of(1980, 11, 1, 15, 0, 12), LocalTime.of(10, 45),
		 * LocalDate.now())); customers.add(new Customer("Dhoni", "CSK",
		 * LocalDateTime.of(1975, 11, 1, 15, 0, 12), LocalTime.of(10, 45),
		 * LocalDate.now()));
		 * 
		 * Iterable<Customer> customerList = service.registerAllCustomers(customers);
		 * 
		 * customerList.forEach(customer->System.out.println(customer));
		 */

		/*
		 * Customer customer = new Customer("dravid", "RCB", LocalDateTime.of(1973, 11,
		 * 1, 15, 0, 12), LocalTime.of(10, 45), LocalDate.now());
		 * 
		 * String status = service.registerCustomer(customer);
		 * System.out.println(status);
		 */
		
	}
}

