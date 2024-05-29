package in.ineuron.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.ineuron.bo.EmployeeBO;

@Repository(value = "dao")
public class EmployeeDaoImpl implements IEmployeeDAO {

	private static final String SQL_INSERT_QUERY = 
			"INSERT INTO EMPLOYEE('ename','eage','eaddress','esalary','hikeAmount') values(?,?,?,?,?)";
	private static final String SQL_SELECT_QUERY = 
			"SELECT eid,ename,eage,eaddress,esalary,hikeAmount from EMPLOYEE where eid=?";
	
	static {
		System.out.println("EmployeeDaoImpl.class file is loading...");
	}

	public EmployeeDaoImpl() {
		System.out.println("EmployeeDaoImpl :: Zero param constructor...");
	}

	@Autowired
	private DataSource datasource;

	@Override
	public EmployeeBO save(EmployeeBO bo) {
		try(Connection connection = datasource.getConnection(); PreparedStatement pstmt=connection.prepareStatement(SQL_INSERT_QUERY)){
			pstmt.setString(1, bo.getEname());
			pstmt.setInt(2, bo.getEage());
			pstmt.setString(3,bo.getEaddress());
			pstmt.setFloat(4, bo.getEsalary());
			pstmt.setFloat(5,bo.getHikeAmount());
			
			try(Connection conn = datasource.getConnection(); PreparedStatement prstmt=connection.prepareStatement(SQL_SELECT_QUERY);ResultSet generatedKeys = pstmt.getGeneratedKeys();){
				EmployeeBO ebo = new EmployeeBO();
				if (generatedKeys.next()) {
					int empid=generatedKeys.getInt(1);
					prstmt.setInt(1,empid);
					ebo.setEid(empid);
				}
				
				ResultSet rs=prstmt.executeQuery();
				
				ebo.setEname(rs.getString(1));
				ebo.setEage(rs.getInt(2));
				ebo.setEaddress(rs.getString(3));
				ebo.setEsalary(rs.getFloat(4));
				ebo.setHikeAmount(rs.getFloat(5));
				
				return ebo;
			}
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public String toString() {
		return "EmployeeDaoImpl [datasource=" + datasource + "]";
	}

}
