package nvt.web.dto;

import nvt.beans.IndoorFeature;

public class IndoorFeatureDTO {

	private int id;
	private String name;
	
	
	public IndoorFeatureDTO() {
		
	}
	
	
	public IndoorFeatureDTO(IndoorFeature indoorFeature) {
		id = indoorFeature.getId();
		name = indoorFeature.getName();
	}

	
	public IndoorFeatureDTO(int id, String name) {
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
