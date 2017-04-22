package nvt.web.dto;

import nvt.beans.RealEstateIndoors;

public class RealEstateIndoorsDTO {

	private int id;
	private RealEstateDTO realEstateDTO;
	private IndoorFeatureDTO indoorFeatureDTO;
	
	
	
	public RealEstateIndoorsDTO(RealEstateIndoors indoors) {
		id = indoors.getId();
		realEstateDTO = new RealEstateDTO(indoors.getRealEstate()); 
		indoorFeatureDTO = new IndoorFeatureDTO(indoors.getIndoorFeature());
	}
	

	public RealEstateIndoorsDTO(int id, RealEstateDTO realEstateDTO, IndoorFeatureDTO indoorFeatureDTO) {
		this.id = id;
		this.realEstateDTO = realEstateDTO;
		this.indoorFeatureDTO = indoorFeatureDTO;
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
	
	public IndoorFeatureDTO getIndoorFeatureDTO() {
		return indoorFeatureDTO;
	}
	
	public void setIndoorFeatureDTO(IndoorFeatureDTO indoorFeatureDTO) {
		this.indoorFeatureDTO = indoorFeatureDTO;
	}
	
	
}
