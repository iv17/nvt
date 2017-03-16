package nvt.web.dto;

import java.util.Date;

import nvt.beans.RealEstateRating;

public class RealEstateRatingDTO {

	protected int id;
	protected int rate;
	protected Date posted;
	protected RealEstateDTO realEstateDTO;
	protected UserDTO userDTO;

	public RealEstateRatingDTO() {
		
	}
	
	
	public RealEstateRatingDTO(RealEstateRating realEstateRating) {
		this(realEstateRating.getId(),
				realEstateRating.getRate(),
				realEstateRating.getPosted(),
				new RealEstateDTO(realEstateRating.getRealEstate()),
				new UserDTO(realEstateRating.getUser()));
	}

	
	public RealEstateRatingDTO(int id, int rate, Date posted, RealEstateDTO realEstateDTO, 
			UserDTO userDTO) {
		this.id = id;
		this.rate = rate;
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
