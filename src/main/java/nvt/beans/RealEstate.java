package nvt.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "real_estate")
public class RealEstate implements Serializable {

	private static final long serialVersionUID = -3904766471545287896L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false , unique = true)
	private int id;

	@Column(name = "name", unique = false, nullable = false)
	private String name;

	@Column(name = "description", unique = false, nullable = false)
	private String description;

	@Column(name = "price", unique = false, nullable = false)
	private double price;

	@Column(name = "surface", unique = false, nullable = false)
	private double surface;

	@Column(name = "floor", unique = false, nullable = false)
	private int floor;

	@Column(name = "rooms", unique = false, nullable = false)
	private int rooms;

	@Column(name = "bathrooms", unique = false, nullable = false)
	private int bathrooms;

	@Column(name = "constructedYear", unique = false, nullable = false)
	private int constructedYear;

	@Column(name = "filed", unique = false, nullable = false)
	private boolean filed;

	@Column(name = "furnished", unique = false, nullable = false)
	private boolean furnished;

	@ManyToOne @JsonIgnore
	@JoinColumn(name = "location_id", referencedColumnName = "id", nullable = false)
	private Location location;

	@ManyToOne @JsonIgnore
	@JoinColumn(name = "real_estate_type_id", referencedColumnName = "id", nullable = false)
	private RealEstateType realEstateType;

	@ManyToOne @JsonIgnore
	@JoinColumn(name = "heating_type_id", referencedColumnName = "id", nullable = true) 
	private HeatingType heatingType;

	//advertisement
	@Column(name = "posted", unique = false, nullable = true)
	private Date posted;

	@Column(name = "updated", unique = false, nullable = true)
	private Date updated;

	@Column(name = "duration", unique = false, nullable = true)
	private int duration;

	@Column(name = "inappropriate", unique = false, nullable = true)
	private boolean inappropriate;

	@Column(name = "verified", unique = false, nullable = true)
	private boolean verified;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "agent_id", referencedColumnName = "id", nullable = true)
	private Agent agent;

	@ManyToOne 
	@JoinColumn(name = "advertisement_type_id", referencedColumnName = "id", nullable = true)
	private AdvertisementType advertisementType;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, mappedBy = "realEstate") @JsonIgnore
	private Set<Image> images;

	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "realEstate") @JsonIgnore
	private Set<RealEstateIndoors> indoors;

	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "realEstate") @JsonIgnore
	private Set<RealEstateOutdoors> outdoors;

	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "realEstate") @JsonIgnore
	private Set<RealEstateComment> comments;

	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "realEstate") @JsonIgnore
	private Set<RealEstateRating> ratings;

	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "realEstate") @JsonIgnore
	private Set<RealEstateReport> reports;



	public RealEstate() {

	}


	public RealEstate(String name, String description, double price, double surface, int floor, int rooms,
			int bathrooms, int constructedYear, boolean filed, boolean furnished,
			Location location, RealEstateType realEstateType, HeatingType heatingType,
			Date posted, Date updated, Integer duration, Boolean inappropriate, Boolean verified,
			Agent agent, AdvertisementType advertisementType) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.surface = surface;
		this.floor = floor;
		this.rooms = rooms;
		this.bathrooms = bathrooms;
		this.constructedYear = constructedYear;
		this.filed = filed;
		this.furnished = furnished;
		this.location = location;
		this.realEstateType = realEstateType;
		this.heatingType = heatingType;
		this.posted = posted;
		this.updated = updated;
		this.duration = duration;
		this.inappropriate = inappropriate;
		this.verified = verified;
		this.agent = agent;
		this.advertisementType = advertisementType;
	}


	public RealEstate(String name, String description, double price, double surface, int floor, int rooms,
			int bathrooms, int constructedYear, boolean filed, boolean furnished,
			Location location, RealEstateType realEstateType, HeatingType heatingType,
			Date posted, Date updated, Integer duration, Boolean inappropriate, Boolean verified,
			Agent agent, AdvertisementType advertisementType,
			Set<Image> images) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.surface = surface;
		this.floor = floor;
		this.rooms = rooms;
		this.bathrooms = bathrooms;
		this.constructedYear = constructedYear;
		this.filed = filed;
		this.furnished = furnished;
		this.location = location;
		this.realEstateType = realEstateType;
		this.heatingType = heatingType;
		this.posted = posted;
		this.updated = updated;
		this.duration = duration;
		this.inappropriate = inappropriate;
		this.verified = verified;
		this.agent = agent;
		this.advertisementType = advertisementType;
		this.images = images;
	}


	public RealEstate(String name, String description, double price, double surface,
			int floor, int rooms, int bathrooms, int constructedYear, boolean filed,
			boolean furnished, Location location, RealEstateType realEstateType,
			HeatingType heatingType, Date posted, Date updated, Integer duration, Boolean inappropriate, Boolean verified,
			Agent agent, AdvertisementType advertisementType, Set<Image> images, 
			Set<RealEstateIndoors> indoors, Set<RealEstateOutdoors> outdoors) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.surface = surface;
		this.floor = floor;
		this.rooms = rooms;
		this.bathrooms = bathrooms;
		this.constructedYear = constructedYear;
		this.filed = filed;
		this.furnished = furnished;
		this.location = location;
		this.realEstateType = realEstateType;
		this.heatingType = heatingType;
		this.posted = posted;
		this.updated = updated;
		this.duration = duration;
		this.inappropriate = inappropriate;
		this.verified = verified;
		this.agent = agent;
		this.advertisementType = advertisementType;
		this.images = images;
		this.indoors = indoors;
		this.outdoors = outdoors;
	}


	public RealEstate(String name, String description, double price, double surface, 
			int floor, int rooms, int bathrooms, int constructedYear, boolean filed,
			boolean furnished, Location location, RealEstateType realEstateType, 
			HeatingType heatingType, Date posted, Date updated, Integer duration, Boolean inappropriate, Boolean verified,
			Agent agent, AdvertisementType advertisementType, Set<Image> images,
			Set<RealEstateIndoors> indoors, Set<RealEstateOutdoors> outdoors,
			Set<RealEstateComment> comments,
			Set<RealEstateRating> ratings, Set<RealEstateReport> reports) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.surface = surface;
		this.floor = floor;
		this.rooms = rooms;
		this.bathrooms = bathrooms;
		this.constructedYear = constructedYear;
		this.filed = filed;
		this.furnished = furnished;
		this.location = location;
		this.realEstateType = realEstateType;
		this.heatingType = heatingType;
		this.posted = posted;
		this.updated = updated;
		this.duration = duration;
		this.inappropriate = inappropriate;
		this.verified = verified;
		this.agent = agent;
		this.advertisementType = advertisementType;
		this.images = images;
		this.indoors = indoors;
		this.outdoors = outdoors;
		this.comments = comments;
		this.ratings = ratings;
		this.reports = reports;
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


	public Location getLocation() {
		return location;
	}


	public void setLocation(Location location) {
		this.location = location;
	}


	public RealEstateType getRealEstateType() {
		return realEstateType;
	}


	public void setRealEstateType(RealEstateType realEstateType) {
		this.realEstateType = realEstateType;
	}


	public HeatingType getHeatingType() {
		return heatingType;
	}


	public void setHeatingType(HeatingType heatingType) {
		this.heatingType = heatingType;
	}

	public Date getPosted() {
		return posted;
	}

	public String getPostedString() {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		return sdf.format(posted);
	}

	public void setPosted(Date posted) {
		this.posted = posted;
	}


	public Date getUpdated() {
		return updated;
	}

	public String getUpdatedString() {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		return sdf.format(updated);
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


	public Agent getAgent() {
		return agent;
	}


	public void setAgent(Agent agent) {
		this.agent = agent;
	}


	public AdvertisementType getAdvertisementType() {
		return advertisementType;
	}


	public void setAdvertisementType(AdvertisementType advertisementType) {
		this.advertisementType = advertisementType;
	}


	public Set<Image> getImages() {
		return images;
	}


	public void setImages(Set<Image> images) {
		this.images = images;
	}


	public Set<RealEstateIndoors> getIndoors() {
		return indoors;
	}


	public void setIndoors(Set<RealEstateIndoors> indoors) {
		this.indoors = indoors;
	}


	public Set<RealEstateOutdoors> getOutdoors() {
		return outdoors;
	}


	public void setOutdoors(Set<RealEstateOutdoors> outdoors) {
		this.outdoors = outdoors;
	}


	public Set<RealEstateComment> getComments() {
		return comments;
	}


	public void setComments(Set<RealEstateComment> comments) {
		this.comments = comments;
	}


	public Set<RealEstateRating> getRatings() {
		return ratings;
	}


	public void setRatings(Set<RealEstateRating> ratings) {
		this.ratings = ratings;
	}


	public Set<RealEstateReport> getReports() {
		return reports;
	}


	public void setReports(Set<RealEstateReport> reports) {
		this.reports = reports;
	}


	@Override
	public String toString() {
		return "RealEstate [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", surface=" + surface + ", floor=" + floor + ", rooms=" + rooms + ", bathrooms=" + bathrooms
				+ ", constructedYear=" + constructedYear + ", filed=" + filed + ", furnished=" + furnished
				+ ", location=" + location + ", realEstateType=" + realEstateType + ", heatingType=" + heatingType
				+ ", images=" + images + ", indoors=" + indoors + ", outdoors=" + outdoors + ", comments=" + comments + ", ratings=" + ratings + ", reports=" + reports + "]";
	}



}
