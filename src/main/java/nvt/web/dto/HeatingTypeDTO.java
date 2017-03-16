package nvt.web.dto;

import nvt.beans.HeatingType;

public class HeatingTypeDTO {

	protected int id;
	protected String name;
	
	
	public HeatingTypeDTO() {
		
	}
	
	
	public HeatingTypeDTO(HeatingType heatingType) {
		this(heatingType.getId(), heatingType.getName());
	}

	
	public HeatingTypeDTO(int id, String name) {
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
