package nvt.web.dto;

import nvt.beans.IndoorFeature;

public class IndoorFeatureDTO {

	protected int id;
	protected String name;
	
	
	public IndoorFeatureDTO() {
		
	}
	
	public IndoorFeatureDTO(IndoorFeature indoorFeature) {
		id = indoorFeature.getId();
		name = indoorFeature.getName();
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
