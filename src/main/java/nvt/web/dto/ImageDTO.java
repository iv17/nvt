package nvt.web.dto;

import nvt.beans.Image;

public class ImageDTO {

	protected int id; 
	protected String name; 
	protected String file;
	protected RealEstateDTO realEstate;
	protected UserDTO user;
	protected CompanyDTO company;
	
	
	
	public ImageDTO(Image image) {
		id = image.getId();
		name = image.getName();
		file = image.getFile();
		//realEstate = new RealEstateDTO(image.getRealEstate());
		//user = new UserDTO(image.getUser());
		//company = new CompanyDTO(image.getCompany());
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

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public RealEstateDTO getRealEstate() {
		return realEstate;
	}

	public void setRealEstate(RealEstateDTO realEstate) {
		this.realEstate = realEstate;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public CompanyDTO getCompany() {
		return company;
	}

	public void setCompany(CompanyDTO company) {
		this.company = company;
	}
	
}
