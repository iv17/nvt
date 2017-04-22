package nvt.web.dto;

import nvt.beans.RealEstateType;

public class RealEstateTypeDTO {

	private int id;
	private String name;
	
	
	
	public RealEstateTypeDTO() {
		
	}
	
	
	public RealEstateTypeDTO(RealEstateType realEstateType) {
		id = realEstateType.getId();
		name = realEstateType.getName();
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
	
	
}
