package nvt.web.dto;

import nvt.beans.OutdoorFeature;

public class OutdoorFeatureDTO {

	protected int id;
	protected String name;
	
	
	public OutdoorFeatureDTO() {
		
	}
	
	public OutdoorFeatureDTO(OutdoorFeature outdoorFeature) {
		id = outdoorFeature.getId();
		name = outdoorFeature.getName();	
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
