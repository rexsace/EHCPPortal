package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class JDBCExecutor {
	private Connection connection = null;
	private ContactInfoDAO contact_info;
	private static JDBCExecutor singleton = null;
	
	public JDBCExecutor() {
		DatabaseConnectionManager dcm = new DatabaseConnectionManager(
				"localhost", "ehcpportal",
				"postgres", "password");
		
		try {
			this.connection = dcm.getConnection();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		contact_info = new ContactInfoDAO(this.connection);
	}
	
	public static JDBCExecutor getInstance() {
		if (singleton == null) {
			singleton =  new JDBCExecutor();
		}

		return singleton;
	}
	
	public List<ContactInfo> getContactInfo(String first_name, String last_name){
		return contact_info.getContactInfo(first_name, last_name);
	}
	
	public ContactInfo getFullInfo(String first_name, String last_name) {
		return contact_info.getFullInfo(first_name, last_name);
	}
	
	public static void main(String[] args) {
		DatabaseConnectionManager dcm = new DatabaseConnectionManager(
				"localhost", "ehcpportal",
				"postgres", "password");
		Connection connection = null;
		try {
			connection = dcm.getConnection();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		ContactInfoDAO contactInfo = new ContactInfoDAO(connection);
		contactInfo.getContactInfo("Frank", "Sinatra").forEach(System.out::println);
	}
}
