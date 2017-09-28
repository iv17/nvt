package nvt.web.dto;

public class CreateCommentRequestDTO {

	private int realEstateId;
	private String text;
	
	
	public CreateCommentRequestDTO() {
		
	}
	
	public CreateCommentRequestDTO(int realEstateId, String text) {
	
		this.realEstateId = realEstateId;
		this.text = text;
	}
	
	public int getRealEstateId() {
		return realEstateId;
	}

	public void setRealEstateId(int realEstateId) {
		this.realEstateId = realEstateId;
	}

	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	
}
