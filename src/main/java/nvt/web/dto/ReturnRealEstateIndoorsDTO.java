package nvt.web.dto;

import java.util.ArrayList;

public class ReturnRealEstateIndoorsDTO {

	
	private RealEstateDTO realEstateDTO;
	
	private ArrayList<IndoorFeatureDTO> indoorsDTO;

	
	
	public ReturnRealEstateIndoorsDTO() {
	
	}

	public RealEstateDTO getRealEstateDTO() {
		return realEstateDTO;
	}

	public void setRealEstateDTO(RealEstateDTO realEstateDTO) {
		this.realEstateDTO = realEstateDTO;
	}

	public ArrayList<IndoorFeatureDTO> getIndoorsDTO() {
		return indoorsDTO;
	}

	public void setIndoorsDTO(ArrayList<IndoorFeatureDTO> indoorsDTO) {
		this.indoorsDTO = indoorsDTO;
	}
	
	
}
