package nvt.web.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import nvt.beans.Image;
import nvt.beans.RealEstate;
import nvt.beans.RealEstateComment;
import nvt.beans.RealEstateIndoors;
import nvt.beans.RealEstateOutdoors;
import nvt.beans.RealEstateRating;
import nvt.beans.RealEstateReport;

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
	private AgentDTO agent;
	private AdvertisementTypeDTO advertisementType;
	private Set<Image> images; 
	private Set<RealEstateIndoorsDTO> indoors;
	private Set<RealEstateOutdoorsDTO> outdoors;
	private Set<RealEstateCommentDTO> comments;
	private Set<RealEstateRatingDTO> ratings;
	private Set<RealEstateReportDTO> reports;
	
	public RealEstateCommentDTO toDTO(RealEstateComment realEstateComment) {
		RealEstateCommentDTO realEstateCommentDTO = new RealEstateCommentDTO();
		
		realEstateCommentDTO.setId(realEstateComment.getId());
		realEstateCommentDTO.setComment(realEstateComment.getComment());
		realEstateCommentDTO.setPosted(realEstateComment.getPosted());
		realEstateCommentDTO.setUser(new UserDTO(realEstateComment.getUser()));
		
		return realEstateCommentDTO;
	}
	
	public RealEstateRatingDTO toDTO(RealEstateRating realEstateRating) {
		RealEstateRatingDTO realEstateRatingDTO = new RealEstateRatingDTO();
		
		realEstateRatingDTO.setId(realEstateRating.getId());
		realEstateRatingDTO.setRate(realEstateRating.getRate());
		realEstateRatingDTO.setPosted(realEstateRating.getPosted());
		realEstateRatingDTO.setUser(new UserDTO(realEstateRating.getUser()));
		
		return realEstateRatingDTO;
	}
	
	public RealEstateReportDTO toDTO(RealEstateReport realEstateReport) {
		RealEstateReportDTO realEstateReportDTO = new RealEstateReportDTO();
		
		realEstateReportDTO.setId(realEstateReport.getId());
		realEstateReportDTO.setReport(realEstateReport.getReport());
		realEstateReportDTO.setPosted(realEstateReport.getPosted());
		realEstateReportDTO.setUser( new UserDTO(realEstateReport.getUser()));
	
		return realEstateReportDTO;
	}
	
	public RealEstateIndoorsDTO toDTO(RealEstateIndoors indoors) {
		RealEstateIndoorsDTO realEstateIndoorsDTO = new RealEstateIndoorsDTO();
		
		realEstateIndoorsDTO.setId(indoors.getId());
		realEstateIndoorsDTO.setIndoorFeature(new IndoorFeatureDTO(indoors.getIndoorFeature()));
		
		return realEstateIndoorsDTO;
	}
	
	public RealEstateOutdoorsDTO toDTO(RealEstateOutdoors outdoors) {
		RealEstateOutdoorsDTO realEstateOudoorsDTO = new RealEstateOutdoorsDTO();
		
		realEstateOudoorsDTO.setId(outdoors.getId());
		realEstateOudoorsDTO.setOutdoorFeature(new OutdoorFeatureDTO(outdoors.getOutdoorFeature()));
		
		return realEstateOudoorsDTO;
	}
	
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
		location = new LocationDTO(realEstate.getLocation());
		realEstateType = new RealEstateTypeDTO(realEstate.getRealEstateType());
		heatingType = new HeatingTypeDTO(realEstate.getHeatingType());
		posted = realEstate.getPosted();
		updated = realEstate.getUpdated();
		duration = realEstate.getDuration();
		inappropriate = realEstate.isInappropriate();
		verified = realEstate.isVerified();
		agent = new AgentDTO(realEstate.getAgent());
		advertisementType = new AdvertisementTypeDTO(realEstate.getAdvertisementType());
		
		comments = new HashSet<RealEstateCommentDTO>();
		for (RealEstateComment realEstateComment : realEstate.getComments()) {
			RealEstateCommentDTO realEstateCommentDTO = toDTO(realEstateComment);
			comments.add(realEstateCommentDTO);
		}
		
		ratings = new HashSet<RealEstateRatingDTO>();
		for (RealEstateRating realEstateRating : realEstate.getRatings()) {
			RealEstateRatingDTO realEstateRatingDTO = toDTO(realEstateRating);
			ratings.add(realEstateRatingDTO);
		}
		
		reports = new HashSet<RealEstateReportDTO>();
		for (RealEstateReport realEstateReport : realEstate.getReports()) {
			RealEstateReportDTO realEstateReportDTO = toDTO(realEstateReport);
			reports.add(realEstateReportDTO);
		}
		
		indoors = new HashSet<RealEstateIndoorsDTO>();
		for(RealEstateIndoors realEstateIndoors : realEstate.getIndoors()) {
			RealEstateIndoorsDTO realEstateIndoorsDTO = toDTO(realEstateIndoors);
			indoors.add(realEstateIndoorsDTO);
		}
		
		outdoors = new HashSet<RealEstateOutdoorsDTO>();
		for(RealEstateOutdoors realEstateOutdoors : realEstate.getOutdoors()) {
			RealEstateOutdoorsDTO realEstateOutdoorsDTO = toDTO(realEstateOutdoors);
			outdoors.add(realEstateOutdoorsDTO);
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

	public AgentDTO getAgent() {
		return agent;
	}

	public void setAgent(AgentDTO agent) {
		this.agent = agent;
	}

	public AdvertisementTypeDTO getAdvertisementType() {
		return advertisementType;
	}

	public void setAdvertisementType(AdvertisementTypeDTO advertisementType) {
		this.advertisementType = advertisementType;
	}

	public Set<Image> getImages() {
		return images;
	}

	public void setImages(Set<Image> images) {
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
	
	
	
}
