package in.ineuron.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import in.ineuron.model.Employee;

@Repository("empDao")
public class EmployeeDaoImpl implements IEmployeeDao {
	
	private static final String SQL_SELECT_QUERY = "select eid,ename,eage,eaddr from employees";
    
    @Autowired
    private DataSource dataSource;

    @Override
    public List<Employee> findAllEmployees() throws SQLException {
    	System.out.println("DataSource Name :: " + dataSource.getClass().getName());
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(SQL_SELECT_QUERY);
             ResultSet resultSet = pstmt.executeQuery()) {

            List<Employee> empList = new ArrayList<Employee>();
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setEid(resultSet.getInt(1));
                employee.setEname(resultSet.getString(2));
                employee.setEaddress(resultSet.getString(4));
                empList.add(employee);
            }
            return empList;
        }
    }
}
