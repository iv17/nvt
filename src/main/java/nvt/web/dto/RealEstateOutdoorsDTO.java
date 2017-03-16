package nvt.web.dto;

import nvt.beans.RealEstateOutdoors;

public class RealEstateOutdoorsDTO {

	protected int id;
	protected RealEstateDTO realEstateDTO;
	protected OutdoorFeatureDTO outdoorFeatureDTO;
	
	
	
	public RealEstateOutdoorsDTO(RealEstateOutdoors outdoors) {
		this(outdoors.getId(),
				new RealEstateDTO(outdoors.getRealEstate()), 
				new OutdoorFeatureDTO(outdoors.getOutdoorFeature()));
	}

	
	public RealEstateOutdoorsDTO(int id, RealEstateDTO realEstateDTO, OutdoorFeatureDTO outdoorFeatureDTO) {
		this.id = id;
		this.realEstateDTO = realEstateDTO;
		this.outdoorFeatureDTO = outdoorFeatureDTO;
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
