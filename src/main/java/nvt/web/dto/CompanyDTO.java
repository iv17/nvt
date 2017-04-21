package nvt.web.dto;

import nvt.beans.Company;

public class CompanyDTO {

	protected int id;
	protected String name;
	protected String password;
	protected String propertyNo;
	protected String phoneNumber;
	protected String webAddress;
	protected ImageDTO imageDTO;
	protected LocationDTO locationDTO;
	protected WorkingTimeDTO workingTimeDTO;

	
	
	public CompanyDTO() {
		
	}
	
	
	public CompanyDTO(Company company) {
		id = company.getId();
		name = company.getName();
		password = company.getPassword();
		propertyNo = company.getPropertyNo();
		phoneNumber = company.getPhoneNumber();
		webAddress = company.getWebAddress();
		locationDTO = new LocationDTO(company.getLocation());
		workingTimeDTO = new WorkingTimeDTO(company.getWorkingTime());
	}

	
	public CompanyDTO(int id, String name, String password, String propertyNo, 
			String phoneNumber, String webAddress, ImageDTO imageDTO, 
			LocationDTO locationDTO, WorkingTimeDTO workingTimeDTO) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.propertyNo = propertyNo;
		this.phoneNumber = phoneNumber;
		this.webAddress = webAddress;
		this.imageDTO = imageDTO;
		this.locationDTO = locationDTO;
		this.workingTimeDTO = workingTimeDTO;
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

	public ImageDTO getImageDTO() {
		return imageDTO;
	}

	public void setImageDTO(ImageDTO imageDTO) {
		this.imageDTO = imageDTO;
	}

	public LocationDTO getLocationDTO() {
		return locationDTO;
	}

	public void setLocationDTO(LocationDTO locationDTO) {
		this.locationDTO = locationDTO;
	}

	public WorkingTimeDTO getWorkingTimeDTO() {
		return workingTimeDTO;
	}

	public void setWorkingTimeDTO(WorkingTimeDTO workingTimeDTO) {
		this.workingTimeDTO = workingTimeDTO;
	}

	

}
