package nvt.web.dto;

public class RegistrationDTO {

	protected String email;
	protected String username;
	protected String password;
	protected String repeated_password;
	protected String name;
	protected String lastName;
	protected String phoneNumber;
	protected int companyId;
	
	
	
	public RegistrationDTO() {
		
	}



	public RegistrationDTO(String email, String username, String password, String repeated_password, String name,
			String lastName, String phoneNumber, int companyId) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.repeated_password = repeated_password;
		this.name = name;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.companyId = companyId;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getRepeated_password() {
		return repeated_password;
	}



	public void setRepeated_password(String repeated_password) {
		this.repeated_password = repeated_password;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public int getCompanyId() {
		return companyId;
	}



	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	
	
	
	
	
}
