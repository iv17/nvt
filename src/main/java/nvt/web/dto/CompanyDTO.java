package nvt.web.dto;

import java.util.HashSet;
import java.util.Set;

import nvt.beans.Company;
import nvt.beans.Image;

public class CompanyDTO {

	private int id;
	private String name;
	private String password;
	private String propertyNo;
	private String phoneNumber;
	private String webAddress;
	private LocationDTO location;
	private WorkingTimeDTO workingTime;
	private Set<ImageDTO> images; 
	
	public ImageDTO toDTO(Image image) {
		ImageDTO imageDTO = new ImageDTO();
		
		imageDTO.setId(image.getId());
		imageDTO.setName(image.getName());
		imageDTO.setFile(image.getFile());
		
		return imageDTO;
	}
	
	
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
		
		images = new HashSet<ImageDTO>();
		for (Image image : company.getImages()) {
			ImageDTO imageDTO = toDTO(image);
			images.add(imageDTO);
		}
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

	public Set<ImageDTO> getImages() {
		return images;
	}

	public void setImages(Set<ImageDTO> images) {
		this.images = images;
	}
	
	

}
