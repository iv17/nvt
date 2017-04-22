package nvt.web.dto;

import nvt.beans.ApartmentType;

public class ApartmentTypeDTO {

	private int id;
	private String name;
	
	
	
	public ApartmentTypeDTO() {
		
	}
	
	
	public ApartmentTypeDTO(ApartmentType apartmentType) {
		id = apartmentType.getId();
		name = apartmentType.getName();
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
