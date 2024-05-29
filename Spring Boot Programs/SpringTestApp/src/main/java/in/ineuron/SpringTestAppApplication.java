package in.ineuron;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.dao.IEmployeeDao;
import in.ineuron.model.Employee;

@SpringBootApplication
public class SpringTestAppApplication{
    public static void main(String[] args) throws SQLException {
    	ApplicationContext context = SpringApplication.run(SpringTestAppApplication.class, args);
        System.out.println("No of beans are : " + Arrays.toString(context.getBeanDefinitionNames()));

        IEmployeeDao dao = context.getBean(IEmployeeDao.class);
        try {
            List<Employee> employees = dao.findAllEmployees();
            employees.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ((ConfigurableApplicationContext) context).close();
    }
}
