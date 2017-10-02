package nvt.web.dto;

import nvt.beans.RealEstateIndoors;

public class RealEstateIndoorsDTO {

	protected int id;
	protected RealEstateDTO realEstate;
	protected IndoorFeatureDTO indoorFeature;
	
	public RealEstateIndoorsDTO() {
		
	}

	public RealEstateIndoorsDTO(RealEstateIndoors indoors) {
		id = indoors.getId();
		if(indoors.getRealEstate() != null) {
			realEstate = new RealEstateDTO(indoors.getRealEstate()); 
		}
		if(indoors.getIndoorFeature() != null) {
			indoorFeature = new IndoorFeatureDTO(indoors.getIndoorFeature());
		}
		
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
