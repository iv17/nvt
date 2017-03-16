package nvt.web.dto;

import nvt.beans.RealEstateType;

public class RealEstateTypeDTO {

	protected int id;
	protected String name;
	
	
	
	public RealEstateTypeDTO() {
		
	}
	
	
	public RealEstateTypeDTO(RealEstateType realEstateType) {
		this(realEstateType.getId(), realEstateType.getName());
	}

	
	public RealEstateTypeDTO(int id, String name) {
		this.id = id;
		this.name = name;
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
