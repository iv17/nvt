package nvt.web.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nvt.beans.Image;
import nvt.beans.RealEstate;

public class RealEstateDTO {

	protected int id;
	protected String name;
	protected String description;
	protected double price;
	protected double surface;
	protected int floor;
	protected int rooms;
	protected int bathrooms;
	protected int constructedYear;
	protected boolean filed;
	protected boolean furnished;
	protected LocationDTO location;
	protected RealEstateTypeDTO realEstateType;
	protected HeatingTypeDTO heatingType;
	protected Date posted;
	protected Date updated;
	protected int duration;
	protected UserDTO user;
	protected AdvertisementTypeDTO advertisementType;
	protected ImageDTO image; 
	protected Set<ImageDTO> images = new HashSet<ImageDTO>(); 
	protected Set<RealEstateCommentDTO> comments;
	protected Set<RealEstateRatingDTO> ratings;
	protected Set<RealEstateReportDTO> reports;
	protected Set<RealEstateIndoorsDTO> indoors;
	protected Set<RealEstateOutdoorsDTO> outdoors;


	
	public RealEstateDTO() {
		
	}
	
	
	public RealEstateDTO(RealEstate realEstate) {
		id = realEstate.getId();	
		name = realEstate.getName();
		description = realEstate.getDescription(); 
		price = realEstate.getPrice();
		surface = realEstate.getSurface(); 
		floor = realEstate.getFloor();
		rooms = realEstate.getRooms();
		bathrooms = realEstate.getBathrooms();
		constructedYear = realEstate.getConstructedYear(); 
		filed = realEstate.isFiled();
		furnished = realEstate.isFurnished();
		
		if(realEstate.getUser() != null) {
			user = new UserDTO(realEstate.getUser());
		}
		if(realEstate.getAdvertisementType() != null) {
			advertisementType = new AdvertisementTypeDTO(realEstate.getAdvertisementType());	
		}
		if(realEstate.getLocation() != null) {
			location = new LocationDTO(realEstate.getLocation());	
		}
		if(realEstate.getRealEstateType() != null) {
			realEstateType = new RealEstateTypeDTO(realEstate.getRealEstateType());
		}
		if(realEstate.getHeatingType() != null) {
			heatingType = new HeatingTypeDTO(realEstate.getHeatingType());	
		}
		posted = realEstate.getPosted();
		updated = realEstate.getUpdated();
		duration = realEstate.getDuration();

		if(realEstate.getImages() != null) {
			Set<Image> im = realEstate.getImages();
			List<Image> temp = new ArrayList<Image>();
			for (Image image : im) {
				temp.add(image);
			}
			
			for (int i = 0; i < temp.size(); i++) {
				image = new ImageDTO(temp.get(i));
				image.setBroj(i);
				images.add(image);
			}
		}
		
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getSurface() {
		return surface;
	}

	public void setSurface(double surface) {
		this.surface = surface;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	public int getBathrooms() {
		return bathrooms;
	}

	public void setBathrooms(int bathrooms) {
		this.bathrooms = bathrooms;
	}

	public int getConstructedYear() {
		return constructedYear;
	}

	public void setConstructedYear(int constructedYear) {
		this.constructedYear = constructedYear;
	}

	public boolean isFiled() {
		return filed;
	}

	public void setFiled(boolean filed) {
		this.filed = filed;
	}

	public boolean isFurnished() {
		return furnished;
	}

	public void setFurnished(boolean furnished) {
		this.furnished = furnished;
	}

	public LocationDTO getLocation() {
		return location;
	}

	public void setLocation(LocationDTO location) {
		this.location = location;
	}

	public RealEstateTypeDTO getRealEstateType() {
		return realEstateType;
	}

	public void setRealEstateType(RealEstateTypeDTO realEstateType) {
		this.realEstateType = realEstateType;
	}

	public HeatingTypeDTO getHeatingType() {
		return heatingType;
	}

	public void setHeatingType(HeatingTypeDTO heatingType) {
		this.heatingType = heatingType;
	}

	public Date getPosted() {
		return posted;
	}

	public void setPosted(Date posted) {
		this.posted = posted;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public AdvertisementTypeDTO getAdvertisementType() {
		return advertisementType;
	}

	public void setAdvertisementType(AdvertisementTypeDTO advertisementType) {
		this.advertisementType = advertisementType;
	}

	public Set<ImageDTO> getImages() {
		return images;
	}

	public void setImages(Set<ImageDTO> images) {
		this.images = images;
	}

	
	public Set<RealEstateIndoorsDTO> getIndoors() {
		return indoors;
	}

	public void setIndoors(Set<RealEstateIndoorsDTO> indoors) {
		this.indoors = indoors;
	}

	public Set<RealEstateOutdoorsDTO> getOutdoors() {
		return outdoors;
	}

	public void setOutdoors(Set<RealEstateOutdoorsDTO> outdoors) {
		this.outdoors = outdoors;
	}

	public Set<RealEstateCommentDTO> getComments() {
		return comments;
	}

	public void setComments(Set<RealEstateCommentDTO> comments) {
		this.comments = comments;
	}

	public Set<RealEstateRatingDTO> getRatings() {
		return ratings;
	}

	public void setRatings(Set<RealEstateRatingDTO> ratings) {
		this.ratings = ratings;
	}

	public Set<RealEstateReportDTO> getReports() {
		return reports;
	}

	public void setReports(Set<RealEstateReportDTO> reports) {
		this.reports = reports;
	}

	public ImageDTO getImage() {
		return image;
	}

	public void setImage(ImageDTO image) {
		this.image = image;
	}

	
}
