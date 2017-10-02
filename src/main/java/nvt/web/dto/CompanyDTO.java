package nvt.web.dto;

import java.util.Date;

import nvt.beans.Company;

public class CompanyDTO {

	protected int id;
	protected String username;
	protected String propertyNo;
	protected String email;
	protected String webAddress;
	protected String phoneNumber;
	protected String password;
	protected String repeated_password;
	protected LocationDTO location;
	protected WorkingTimeDTO workingTime;
	protected Date date;
	protected ImageDTO companyImage; 
	public CompanyDTO() {
		
	}
	
	
	public CompanyDTO(Company company) {
		id = company.getId();
		username = company.getUsername();
		propertyNo = company.getPropertyNo();
		email = company.getEmail();
		webAddress = company.getWebAddress();
		phoneNumber = company.getPhoneNumber();
		password = company.getPassword();
		if(company.getLocation() != null) {
			location = new LocationDTO(company.getLocation());
		}
		if(company.getWorkingTime() != null) {
			workingTime = new WorkingTimeDTO(company.getWorkingTime());
		}
		if(company.getCompanyImage() != null) {
			companyImage = new ImageDTO(company.getCompanyImage());
		}
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPropertyNo() {
		return propertyNo;
	}

	public void setPropertyNo(String propertyNo) {
		this.propertyNo = propertyNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebAddress() {
		return webAddress;
	}

	public void setWebAddress(String webAddress) {
		this.webAddress = webAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public LocationDTO getLocation() {
		return location;
	}

	public void setLocation(LocationDTO location) {
		this.location = location;
	}

	public WorkingTimeDTO getWorkingTime() {
		return workingTime;
	}

	public void setWorkingTime(WorkingTimeDTO workingTime) {
		this.workingTime = workingTime;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ImageDTO getCompanyImage() {
		return companyImage;
	}

	public void setCompanyImage(ImageDTO companyImage) {
		this.companyImage = companyImage;
	}

}
