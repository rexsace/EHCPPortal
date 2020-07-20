package jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCExecutor {
	private Connection connection = null;
	
	public JDBCExecutor() {
		DatabaseConnectionManager dcm = new DatabaseConnectionManager(
				"localhost", "hplussport",
				"postgres", "password");
		
		try {
			this.connection = dcm.getConnection();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Customer searchCustomer() {
		CustomerDAO customerDAO = new CustomerDAO(this.connection);
		return customerDAO.findById(10000);
	}
}
