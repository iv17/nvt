package nvt.web.dto;

import java.util.Date;

import nvt.beans.RealEstateRating;

public class RealEstateRatingDTO {

	private int id;
	private int rate;
	private Date posted;
	private RealEstateDTO realEstateDTO;
	private UserDTO userDTO;

	public RealEstateRatingDTO() {
		
	}
	
	
	public RealEstateRatingDTO(RealEstateRating realEstateRating) {
		id = realEstateRating.getId();
		rate = realEstateRating.getRate();
		posted = realEstateRating.getPosted();
		realEstateDTO = new RealEstateDTO(realEstateRating.getRealEstate());
		userDTO = new UserDTO(realEstateRating.getUser());
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
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
