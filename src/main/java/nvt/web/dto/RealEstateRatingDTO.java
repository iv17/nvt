package nvt.web.dto;

import java.util.Date;

import nvt.beans.RealEstateRating;

public class RealEstateRatingDTO {

	protected int id;
	protected int rate;
	protected Date posted;
	protected RealEstateDTO realEstate;
	protected UserDTO user;

	public RealEstateRatingDTO() {
		
	}
	
	public RealEstateRatingDTO(RealEstateRating realEstateRating) {
		id = realEstateRating.getId();
		rate = realEstateRating.getRate();
		posted = realEstateRating.getPosted();
		if(realEstateRating.getRealEstate() != null) {
			realEstate = new RealEstateDTO(realEstateRating.getRealEstate());
		}
		if(realEstateRating.getUser() != null) {
			user = new UserDTO(realEstateRating.getUser());
		}
		
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
