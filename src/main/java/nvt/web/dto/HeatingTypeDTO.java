package nvt.web.dto;

import nvt.beans.HeatingType;

public class HeatingTypeDTO {

	protected int id;
	protected String name;
	
	
	public HeatingTypeDTO() {
		
	}
	
	
	public HeatingTypeDTO(HeatingType heatingType) {
		id = heatingType.getId();
		name = heatingType.getName();
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
