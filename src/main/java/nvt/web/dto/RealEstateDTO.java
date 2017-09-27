package nvt.web.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nvt.beans.Image;
import nvt.beans.RealEstate;

public class RealEstateDTO {

	private int id;
	private String name;
	private String description;
	private double price;
	private double surface;
	private int floor;
	private int rooms;
	private int bathrooms;
	private int constructedYear;
	private boolean filed;
	private boolean furnished;
	private LocationDTO location;
	private RealEstateTypeDTO realEstateType;
	private HeatingTypeDTO heatingType;
	private Date posted;
	private Date updated;
	private int duration;
	private boolean inappropriate;
	private boolean verified;
	private UserDTO user;
	private AdvertisementTypeDTO advertisementType;
	private ImageDTO image; 
	private Set<ImageDTO> images = new HashSet<>(); 
	private Set<RealEstateCommentDTO> comments;
	private Set<RealEstateRatingDTO> ratings;
	private Set<RealEstateReportDTO> reports;
	private Set<RealEstateIndoorsDTO> indoors;
	private Set<RealEstateOutdoorsDTO> outdoors;


	
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
		
		//location = new LocationDTO(realEstate.getLocation());
		realEstateType = new RealEstateTypeDTO(realEstate.getRealEstateType());
		heatingType = new HeatingTypeDTO(realEstate.getHeatingType());
		posted = realEstate.getPosted();
		updated = realEstate.getUpdated();
		duration = realEstate.getDuration();
		inappropriate = realEstate.isInappropriate();
		verified = realEstate.isVerified();
		//user = new UserDTO(realEstate.getUser());
		advertisementType = new AdvertisementTypeDTO(realEstate.getAdvertisementType());
		
		/*Set<Image> im = realEstate.getImages();
		List<Image> temp = new ArrayList<Image>();
		for (Image image : im) {
			temp.add(image);
		}
		
		for (int i = 0; i < temp.size(); i++) {
			
			image = new ImageDTO(temp.get(i));
			image.setBroj(i);
			images.add(image);
		}*/
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

	public boolean isInappropriate() {
		return inappropriate;
	}

	public void setInappropriate(boolean inappropriate) {
		this.inappropriate = inappropriate;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
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


	@Override
	public String toString() {
		return "RealEstateDTO [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", surface=" + surface + ", floor=" + floor + ", rooms=" + rooms + ", bathrooms=" + bathrooms
				+ ", constructedYear=" + constructedYear + ", filed=" + filed + ", furnished=" + furnished
				+ ", location=" + location + ", realEstateType=" + realEstateType + ", heatingType=" + heatingType
				+ ", posted=" + posted + ", updated=" + updated + ", duration=" + duration + ", inappropriate="
				+ inappropriate + ", verified=" + verified + ", user=" + user + ", advertisementType="
				+ advertisementType + ", image=" + image + ", images=" + images + ", comments=" + comments
				+ ", ratings=" + ratings + ", reports=" + reports + ", indoors=" + indoors + ", outdoors=" + outdoors
				+ "]";
	}
	
	
	
}
