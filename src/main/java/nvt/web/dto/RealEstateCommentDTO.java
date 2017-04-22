package nvt.web.dto;

import java.util.Date;

import nvt.beans.RealEstateComment;

public class RealEstateCommentDTO {

	private int id;
	private String comment;
	private Date posted;
	private RealEstateDTO realEstateDTO;
	private UserDTO userDTO;

	
	
	public RealEstateCommentDTO() {
		
	}
	
	
	public RealEstateCommentDTO(RealEstateComment realEstateComment) {
		id = realEstateComment.getId();
		comment = realEstateComment.getComment(); 
		posted = realEstateComment.getPosted();
		realEstateDTO = new RealEstateDTO(realEstateComment.getRealEstate());
		userDTO = new UserDTO(realEstateComment.getUser());
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
