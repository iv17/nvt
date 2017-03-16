package nvt.web.dto;

import nvt.beans.ApartmentType;

public class ApartmentTypeDTO {

	protected int id;
	protected String name;
	
	
	
	public ApartmentTypeDTO() {
		
	}
	
	
	public ApartmentTypeDTO(ApartmentType apartmentType) {
		this(apartmentType.getId(), apartmentType.getName());
	}

	
	public ApartmentTypeDTO(int id, String name) {
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
