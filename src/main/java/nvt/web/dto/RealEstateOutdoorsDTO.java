package nvt.web.dto;

import nvt.beans.RealEstateOutdoors;

public class RealEstateOutdoorsDTO {

	private int id;
	private RealEstateDTO realEstateDTO;
	private OutdoorFeatureDTO outdoorFeatureDTO;
	
	
	
	public RealEstateOutdoorsDTO(RealEstateOutdoors outdoors) {
		id = outdoors.getId();
		realEstateDTO = new RealEstateDTO(outdoors.getRealEstate());
		outdoorFeatureDTO = new OutdoorFeatureDTO(outdoors.getOutdoorFeature());
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RealEstateDTO getRealEstateDTO() {
		return realEstateDTO;
	}

	public void setRealEstateDTO(RealEstateDTO realEstateDTO) {
		this.realEstateDTO = realEstateDTO;
	}

	public OutdoorFeatureDTO getOutdoorFeatureDTO() {
		return outdoorFeatureDTO;
	}

	public void setOutdoorFeatureDTO(OutdoorFeatureDTO outdoorFeatureDTO) {
		this.outdoorFeatureDTO = outdoorFeatureDTO;
	}
	
	
}
