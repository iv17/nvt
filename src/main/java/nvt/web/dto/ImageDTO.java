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
		this(image.getId(),
				image.getName(),
				image.getFile(),
				new RealEstateDTO(image.getRealEstate()),
				new UserDTO(image.getUser()),
				new CompanyDTO(image.getCompany()));
	}
	
	
	public ImageDTO(int id, String name, String file, RealEstateDTO realEstateDTO, UserDTO userDTO, CompanyDTO companyDTO) {
		this.id = id;
		this.name = name;
		this.file = file;
		this.realEstateDTO = realEstateDTO;
		this.userDTO = userDTO;
		this.companyDTO = companyDTO;
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
