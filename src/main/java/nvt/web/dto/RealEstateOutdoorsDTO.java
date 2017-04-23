package nvt.web.dto;

import nvt.beans.RealEstateOutdoors;

public class RealEstateOutdoorsDTO {

	private int id;
	private RealEstateDTO realEstate;
	private OutdoorFeatureDTO outdoorFeature;
	
	
	
	public RealEstateOutdoorsDTO() {
		
	}


	public RealEstateOutdoorsDTO(RealEstateOutdoors outdoors) {
		id = outdoors.getId();
		realEstate = new RealEstateDTO(outdoors.getRealEstate());
		outdoorFeature = new OutdoorFeatureDTO(outdoors.getOutdoorFeature());
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

	public OutdoorFeatureDTO getOutdoorFeature() {
		return outdoorFeature;
	}

	public void setOutdoorFeature(OutdoorFeatureDTO outdoorFeature) {
		this.outdoorFeature = outdoorFeature;
	}

	
}
