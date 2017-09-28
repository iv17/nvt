package nvt.web.dto;

public class CreateRateRequestDTO {

	private int realEstateId;
	private int rate;
	
	
	public CreateRateRequestDTO() {

	}
	
	public CreateRateRequestDTO(int realEstateId, int rate) {
		super();
		this.realEstateId = realEstateId;
		this.rate = rate;
	}
	
	public int getRealEstateId() {
		return realEstateId;
	}
	public void setRealEstateId(int realEstateId) {
		this.realEstateId = realEstateId;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	
	
	
}
