package nvt.web.dto;

import nvt.beans.RealEstateIndoors;

public class RealEstateIndoorsDTO {

	private int id;
	private RealEstateDTO realEstate;
	private IndoorFeatureDTO indoorFeature;
	
	
	
	public RealEstateIndoorsDTO(RealEstateIndoors indoors) {
		id = indoors.getId();
		realEstate = new RealEstateDTO(indoors.getRealEstate()); 
		indoorFeature = new IndoorFeatureDTO(indoors.getIndoorFeature());
	}
	

	public RealEstateIndoorsDTO(int id, RealEstateDTO realEstate, IndoorFeatureDTO indoorFeature) {
		this.id = id;
		this.realEstate = realEstate;
		this.indoorFeature = indoorFeature;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RealEstateDTO getRealEstate() {
		return realEstate;
	}

	public void setRealEstate(RealEstateDTO realEstate) {
		this.realEstate = realEstate;
	}

	public IndoorFeatureDTO getIndoorFeature() {
		return indoorFeature;
	}

	public void setIndoorFeature(IndoorFeatureDTO indoorFeature) {
		this.indoorFeature = indoorFeature;
	}
	
	
}
