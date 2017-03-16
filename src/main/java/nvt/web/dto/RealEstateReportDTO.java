package nvt.web.dto;

import java.util.Date;

import nvt.beans.RealEstateReport;

public class RealEstateReportDTO {

	protected int id;
	protected String report;
	protected Date posted;
	protected RealEstateDTO realEstateDTO;
	protected UserDTO userDTO;
	
	
	
	public RealEstateReportDTO() {
		
	}
	
	
	public RealEstateReportDTO(RealEstateReport realEstateReport) {
		this(realEstateReport.getId(), 
				realEstateReport.getReport(),
				realEstateReport.getPosted(),
				new RealEstateDTO(realEstateReport.getRealEstate()),
				new UserDTO(realEstateReport.getUser()));
	}
	

	public RealEstateReportDTO(int id, String report, Date posted, RealEstateDTO realEstateDTO,
			UserDTO userDTO) {
		this.id = id;
		this.report = report;
		this.posted = posted;
		this.realEstateDTO = realEstateDTO;
		this.userDTO = userDTO;
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

	public RealEstateDTO getRealEstateDTO() {
		return realEstateDTO;
	}

	public void setRealEstateDTO(RealEstateDTO realEstateDTO) {
		this.realEstateDTO = realEstateDTO;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}


	
}
