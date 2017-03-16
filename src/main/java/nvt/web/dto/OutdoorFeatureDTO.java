package nvt.web.dto;

import nvt.beans.OutdoorFeature;

public class OutdoorFeatureDTO {

	protected int id;
	protected String name;
	
	
	
	public OutdoorFeatureDTO() {
		
	}
	
	
	public OutdoorFeatureDTO(OutdoorFeature outdoorFeature) {
		this(outdoorFeature.getId(), outdoorFeature.getName());	
	}
	

	public OutdoorFeatureDTO(int id, String name) {
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
