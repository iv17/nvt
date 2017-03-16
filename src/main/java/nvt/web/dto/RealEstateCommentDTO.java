package nvt.web.dto;

import java.util.Date;

import nvt.beans.RealEstateComment;

public class RealEstateCommentDTO {

	protected int id;
	protected String comment;
	protected Date posted;
	protected RealEstateDTO realEstateDTO;
	protected UserDTO userDTO;

	
	
	public RealEstateCommentDTO() {
		
	}
	
	
	public RealEstateCommentDTO(RealEstateComment realEstateComment) {
		this(realEstateComment.getId(),
				realEstateComment.getComment(), 
				realEstateComment.getPosted(),
				new RealEstateDTO(realEstateComment.getRealEstate()),
				new UserDTO(realEstateComment.getUser()));
	}
	

	public RealEstateCommentDTO(int id, String comment, Date posted, 
			RealEstateDTO realEstateDTO, UserDTO userDTO) {
		this.id = id;
		this.comment = comment;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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
