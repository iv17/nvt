package nvt.web.dto;

import nvt.beans.RealEstateOutdoors;

public class RealEstateOutdoorsDTO {

	protected int id;
	protected RealEstateDTO realEstate;
	protected OutdoorFeatureDTO outdoorFeature;
		
	public RealEstateOutdoorsDTO() {
		
	}

	public RealEstateOutdoorsDTO(RealEstateOutdoors outdoors) {
		id = outdoors.getId();
		if(outdoors.getOutdoorFeature() != null) {
			outdoorFeature = new OutdoorFeatureDTO(outdoors.getOutdoorFeature());
		}
		if(outdoors.getRealEstate() != null) {
			realEstate = new RealEstateDTO(outdoors.getRealEstate());	
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

	public OutdoorFeatureDTO getOutdoorFeature() {
		return outdoorFeature;
	}

	public void setOutdoorFeature(OutdoorFeatureDTO outdoorFeature) {
		this.outdoorFeature = outdoorFeature;
	}

	
}
