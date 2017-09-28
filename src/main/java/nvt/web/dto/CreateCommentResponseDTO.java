package nvt.web.dto;

import java.util.List;

public class CreateCommentResponseDTO {

	private RealEstateDTO realEstate;
	private List<RealEstateCommentDTO> comments;
	
	
	public CreateCommentResponseDTO() {
		
	}


	public CreateCommentResponseDTO(RealEstateDTO realEstate, List<RealEstateCommentDTO> comments) {
		super();
		this.realEstate = realEstate;
		this.comments = comments;
	}


	public RealEstateDTO getRealEstate() {
		return realEstate;
	}


	public void setRealEstate(RealEstateDTO realEstate) {
		this.realEstate = realEstate;
	}


	public List<RealEstateCommentDTO> getComments() {
		return comments;
	}


	public void setComments(List<RealEstateCommentDTO> comments) {
		this.comments = comments;
	}


	
}
