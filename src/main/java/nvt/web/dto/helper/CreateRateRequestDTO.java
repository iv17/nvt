package nvt.web.dto.helper;

public class CreateRateRequestDTO {

	protected int realEstateId;
	protected int rate;
	
	
	public CreateRateRequestDTO() {

	}
	
	public CreateRateRequestDTO(int realEstateId, int rate) {
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
