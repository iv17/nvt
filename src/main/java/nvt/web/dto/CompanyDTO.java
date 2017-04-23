package nvt.web.dto;

import nvt.beans.Company;

public class CompanyDTO {

	private int id;
	private String name;
	private String password;
	private String propertyNo;
	private String phoneNumber;
	private String webAddress;
	private ImageDTO image;
	private LocationDTO location;
	private WorkingTimeDTO workingTime;

	
	
	public CompanyDTO() {
		
	}
	
	
	public CompanyDTO(Company company) {
		id = company.getId();
		name = company.getName();
		password = company.getPassword();
		propertyNo = company.getPropertyNo();
		phoneNumber = company.getPhoneNumber();
		webAddress = company.getWebAddress();
		location = new LocationDTO(company.getLocation());
		workingTime = new WorkingTimeDTO(company.getWorkingTime());
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPropertyNo() {
		return propertyNo;
	}

	public void setPropertyNo(String propertyNo) {
		this.propertyNo = propertyNo;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getWebAddress() {
		return webAddress;
	}

	public void setWebAddress(String webAddress) {
		this.webAddress = webAddress;
	}

	public ImageDTO getImage() {
		return image;
	}

	public void setImage(ImageDTO image) {
		this.image = image;
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
	
	

}
