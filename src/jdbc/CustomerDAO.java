package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO extends DataAccessObject {
	private static final String FIND_BY_ID = ""
			+ "SELECT customer_id, first_name, last_name "
			+ "FROM customer "
			+ "WHERE customer_id = ?";
	
	public CustomerDAO(Connection connection) {
		super(connection);
	}
	
	public Customer findById(long id) {
		Customer customer = new Customer();
		try {
			PreparedStatement statement = this.connection.prepareStatement(FIND_BY_ID);
			statement.setLong(1, id);
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				customer.setId(results.getLong("customer_id"));
				customer.setFirstName(results.getString("first_name"));
				customer.setLastName(results.getString("last_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return customer;
	}

}
