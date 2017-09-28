package nvt.web.dto;

import java.util.List;

public class CreateCommentResponseDTO {

	private RealEstateDTO realEstate;
	private List<RealEstateCommentDTO> comments;
	private List<RealEstateRatingDTO> ratings;
	private List<RealEstateReportDTO> reports;
	
	
	public CreateCommentResponseDTO() {
		
	}


	public CreateCommentResponseDTO(RealEstateDTO realEstate, List<RealEstateCommentDTO> comments) {
		super();
		this.realEstate = realEstate;
		this.comments = comments;
	}

	public CreateCommentResponseDTO(RealEstateDTO realEstate, List<RealEstateCommentDTO> comments, List<RealEstateRatingDTO> ratings) {
		super();
		this.realEstate = realEstate;
		this.comments = comments;
		this.ratings = ratings;
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


	public List<RealEstateRatingDTO> getRatings() {
		return ratings;
	}


	public void setRatings(List<RealEstateRatingDTO> ratings) {
		this.ratings = ratings;
	}


	public List<RealEstateReportDTO> getReports() {
		return reports;
	}


	public void setReports(List<RealEstateReportDTO> reports) {
		this.reports = reports;
	}


	
}
