package nvt.beans;

import java.io.Serializable;
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

@Entity
@Table(name = "real_estate")
public class RealEstate implements Serializable {

	private static final long serialVersionUID = -3904766471545287896L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false , unique = true)
	protected int id;
	
	@Column(name = "name", unique = false, nullable = false)
	protected String name;
	
	@Column(name = "description", unique = false, nullable = false)
	protected String description;
	
	@Column(name = "price", unique = false, nullable = false)
	protected double price;
	
	@Column(name = "surface", unique = false, nullable = false)
	protected double surface;
	
	@Column(name = "floor", unique = false, nullable = false)
	protected int floor;
	
	@Column(name = "rooms", unique = false, nullable = false)
	protected int rooms;
	
	@Column(name = "bathrooms", unique = false, nullable = false)
	protected int bathrooms;
	
	@Column(name = "constructedYear", unique = false, nullable = false)
	protected int constructedYear;
	
	@Column(name = "filed", unique = false, nullable = false)
	protected boolean filed;
	
	@Column(name = "furnished", unique = false, nullable = false)
	protected boolean furnished;
	
	@ManyToOne
	@JoinColumn(name = "location_id", referencedColumnName = "id", nullable = false)
	protected Location location;
	
	@ManyToOne
	@JoinColumn(name = "real_estate_type_id", referencedColumnName = "id", nullable = false)
	protected RealEstateType realEstateType;
		
	@ManyToOne
	@JoinColumn(name = "heating_type_id", referencedColumnName = "id", nullable = true)
	protected HeatingType heatingType;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "realEstate")
	protected Set<Image> images;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "realEstate")
	protected Set<RealEstateIndoors> indoors;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "realEstate")
	protected Set<RealEstateOutdoors> outdoors;

	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "realEstate")
	protected Set<Advertisement> advertisements;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "realEstate")
	protected Set<RealEstateComment> comments;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "realEstate")
	protected Set<RealEstateRating> ratings;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "realEstate")
	protected Set<RealEstateReport> reports;

	
	
	public RealEstate() {
		
	}
	
	
	public RealEstate(String name, String description, double price, double surface, int floor, int rooms,
			int bathrooms, int constructedYear, boolean filed, boolean furnished,
			Location location, RealEstateType realEstateType, HeatingType heatingType) {
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
	}
	
	
	public RealEstate(String name, String description, double price, double surface, int floor, int rooms,
			int bathrooms, int constructedYear, boolean filed, boolean furnished,
			Location location, RealEstateType realEstateType, HeatingType heatingType,
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
		this.images = images;
	}

	
	public RealEstate(String name, String description, double price, double surface,
			int floor, int rooms, int bathrooms, int constructedYear, boolean filed,
			boolean furnished, Location location, RealEstateType realEstateType,
			HeatingType heatingType, Set<Image> images, 
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
		this.images = images;
		this.indoors = indoors;
		this.outdoors = outdoors;
	}


	public RealEstate(String name, String description, double price, double surface, 
			int floor, int rooms, int bathrooms, int constructedYear, boolean filed,
			boolean furnished, Location location, RealEstateType realEstateType, 
			HeatingType heatingType, Set<Image> images,
			Set<RealEstateIndoors> indoors, Set<RealEstateOutdoors> outdoors,
			Set<Advertisement> advertisements, Set<RealEstateComment> comments,
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
		this.images = images;
		this.indoors = indoors;
		this.outdoors = outdoors;
		this.advertisements = advertisements;
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

	public Set<Advertisement> getAdvertisements() {
		return advertisements;
	}

	public void setAdvertisements(Set<Advertisement> advertisements) {
		this.advertisements = advertisements;
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
	
	
	
}
