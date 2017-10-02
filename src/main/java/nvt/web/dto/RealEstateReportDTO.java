package nvt.web.dto;

import java.util.Date;

import nvt.beans.RealEstateReport;

public class RealEstateReportDTO {

	protected int id;
	protected Date posted;
	protected RealEstateDTO realEstate;
	protected UserDTO user;
	
	
	
	public RealEstateReportDTO() {
		
	}
	
	
	public RealEstateReportDTO(RealEstateReport realEstateReport) {
		id = realEstateReport.getId();
		posted = realEstateReport.getPosted();
		if(realEstateReport.getRealEstate() != null) {
			realEstate = new RealEstateDTO(realEstateReport.getRealEstate());
		}
		if(realEstateReport.getUser() != null) {
			user = new UserDTO(realEstateReport.getUser());
		}
		
		
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPosted() {
		return posted;
	}

	public void setPosted(Date posted) {
		this.posted = posted;
	}

	public RealEstateDTO getRealEstate() {
		return realEstate;
	}

	public void setRealEstate(RealEstateDTO realEstate) {
		this.realEstate = realEstate;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	
}
