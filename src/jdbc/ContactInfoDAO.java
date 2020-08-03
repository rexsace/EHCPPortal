package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactInfoDAO extends DataAccessObject{
	private final String GET_CONTACT_INFO = ""
			+ "SELECT c.first_name, c.middle_name, c.last_name, m.mobile_number "
			+ "FROM contact_person as c "
			+ "JOIN mobile_number as m ON c.person_id = m.person_id "
			+ "WHERE c.first_name = ? AND c.last_name = ?";

	private final String GET_FULL_INFO = ""
			+ "SELECT c.first_name, c.middle_name, c.last_name, ch.name as church_name, chr.role, e.email, m.mobile_number "
			+ "FROM contact_person as c "
			+ "JOIN church_role as chr ON chr.person_id = c.person_id "
			+ "JOIN church as ch ON chr.church_id = ch.church_id "
			+ "JOIN mobile_number as m ON m.person_id = c.person_id "
			+ "JOIN email as e ON e.person_id = c.person_id "
			+ "WHERE c.first_name = ? AND c.last_name = ?";
	
	public ContactInfoDAO(Connection connection) {
		super(connection);
	}
	
	public List<ContactInfo> getContactInfo(String first_name,
			String last_name){
		List<ContactInfo> infos = new ArrayList<>();
		
		try {
			PreparedStatement statement = this.connection.prepareStatement(GET_CONTACT_INFO);
			statement.setString(1, first_name);
			statement.setString(2, last_name);
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				ContactInfo info = new ContactInfo();
				info.setFirstName(results.getString("first_name"));
				info.setMiddleName(results.getString("middle_name"));
				info.setLastName(results.getString("last_name"));
				info.setMobileNumber(results.getString("mobile_number"));
				infos.add(info);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		return infos;
	}
	
	public ContactInfo getFullInfo(String first_name, String last_name) {
		ContactInfo info = new ContactInfo();
		try {
			PreparedStatement statement = this.connection.prepareStatement(GET_FULL_INFO);
			statement.setString(1, first_name);
			statement.setString(2, last_name);
			ResultSet results = statement.executeQuery();
			if (results.next()) {
				info.setFirstName(results.getString("first_name"));
				info.setMiddleName(results.getString("middle_name"));
				info.setLastName(results.getString("last_name"));
				info.setChurch(results.getString("church_name"));
				info.setChurchRole(results.getString("role"));
				info.setEmail(results.getString("email"));
				info.setMobileNumber(results.getString("mobile_number"));
			}
			return info;
		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
