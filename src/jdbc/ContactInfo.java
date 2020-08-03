package jdbc;

public class ContactInfo {
	private String first_name;
	private String middle_name;
	private String last_name;
	private String church;
	private String church_role;
	private String email;
	private String mobile_number;
	
	public String getFirstName() {
		return first_name;
	}
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}
	public String getMiddleName() {
		return middle_name;
	}
	public void setMiddleName(String middle_name) {
		this.middle_name = middle_name;
	}
	public String getLastName() {
		return last_name;
	}
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}
	public String getChurch() {
		return church;
	}
	public void setChurch(String church) {
		this.church = church;
	}
	public String getChurchRole() {
		return church_role;
	}
	public void setChurchRole(String church_role) {
		this.church_role = church_role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobile_number;
	}
	public void setMobileNumber(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	
	@Override
	public String toString() {
		return "ContactInfo [first_name=" + first_name + ", middle_name=" + middle_name + ", last_name=" + last_name
				+ ", mobile_number=" + mobile_number + "]";
	}
	
	
}
