package jdbc;

import java.sql.Connection;

public abstract class DataAccessObject {
	protected final Connection connection;
	
	public DataAccessObject(Connection connection) {
		this.connection = connection;
	}
}
