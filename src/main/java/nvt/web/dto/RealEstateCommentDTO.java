package nvt.web.dto;

import java.util.Date;

import nvt.beans.RealEstateComment;

public class RealEstateCommentDTO {

	private int id;
	private String comment;
	private Date posted;
	private RealEstateDTO realEstate;
	private UserDTO user;

	
	public RealEstateCommentDTO() {
		
	}
	
	
	public RealEstateCommentDTO(RealEstateComment realEstateComment) {
		id = realEstateComment.getId();
		comment = realEstateComment.getComment(); 
		posted = realEstateComment.getPosted();
		if(realEstateComment.getRealEstate() != null) {
			realEstate = new RealEstateDTO(realEstateComment.getRealEstate());
		}
		if(realEstateComment.getUser() != null) {
			user = new UserDTO(realEstateComment.getUser());
		}
		
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
