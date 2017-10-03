package nvt.web.dto.helper;

import java.util.List;

import nvt.web.dto.RealEstateCommentDTO;
import nvt.web.dto.RealEstateDTO;
import nvt.web.dto.RealEstateIndoorsDTO;
import nvt.web.dto.RealEstateOutdoorsDTO;
import nvt.web.dto.RealEstateReportDTO;

public class RealEstateResponseDTO {

	protected RealEstateDTO realEstate;
	protected List<RealEstateCommentDTO> comments;
	protected RatingsResponseDTO ratings;
	protected List<RealEstateReportDTO> reports;
	protected List<RealEstateIndoorsDTO> indoors;
	protected List<RealEstateOutdoorsDTO> outdoors;
	
	
	public RealEstateResponseDTO() {
		
	}


	public RealEstateResponseDTO(RealEstateDTO realEstate, List<RealEstateCommentDTO> comments,
			RatingsResponseDTO ratings, List<RealEstateReportDTO> reports, List<RealEstateIndoorsDTO> indoors,
			List<RealEstateOutdoorsDTO> outdoors) {
		this.realEstate = realEstate;
		this.comments = comments;
		this.ratings = ratings;
		this.reports = reports;
		this.indoors = indoors;
		this.outdoors = outdoors;
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

	public RatingsResponseDTO getRatings() {
		return ratings;
	}

	public void setRatings(RatingsResponseDTO ratings) {
		this.ratings = ratings;
	}

	public List<RealEstateReportDTO> getReports() {
		return reports;
	}

	public void setReports(List<RealEstateReportDTO> reports) {
		this.reports = reports;
	}

	public List<RealEstateIndoorsDTO> getIndoors() {
		return indoors;
	}

	public void setIndoors(List<RealEstateIndoorsDTO> indoors) {
		this.indoors = indoors;
	}

	public List<RealEstateOutdoorsDTO> getOutdoors() {
		return outdoors;
	}

	public void setOutdoors(List<RealEstateOutdoorsDTO> outdoors) {
		this.outdoors = outdoors;
	}
	
}
