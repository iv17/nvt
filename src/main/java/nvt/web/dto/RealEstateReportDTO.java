package nvt.web.dto;

import java.util.Date;

import nvt.beans.RealEstateReport;

public class RealEstateReportDTO {

	private int id;
	private String report;
	private Date posted;
	private RealEstateDTO realEstate;
	private UserDTO user;
	
	
	
	public RealEstateReportDTO() {
		
	}
	
	
	public RealEstateReportDTO(RealEstateReport realEstateReport) {
		id = realEstateReport.getId();
		report = realEstateReport.getReport();
		posted = realEstateReport.getPosted();
		realEstate = new RealEstateDTO(realEstateReport.getRealEstate());
		user = new UserDTO(realEstateReport.getUser());
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
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
