package nvt.web.dto;

import nvt.beans.Image;

public class ImageDTO {

	protected int id; 
	protected String name; 
	protected String file;
	protected RealEstateDTO realEstateDTO;
	protected UserDTO userDTO;
	protected CompanyDTO companyDTO;
	
	
	
	public ImageDTO(Image image) {
		id = image.getId();
		name = image.getName();
		file = image.getFile();
		//realEstateDTO = new RealEstateDTO(image.getRealEstate());
		//userDTO = new UserDTO(image.getUser());
		//companyDTO = new CompanyDTO(image.getCompany());
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

	public RealEstateDTO getRealEstateDTO() {
		return realEstateDTO;
	}

	public void setRealEstateDTO(RealEstateDTO realEstateDTO) {
		this.realEstateDTO = realEstateDTO;
	}
	
	
	
	
}
