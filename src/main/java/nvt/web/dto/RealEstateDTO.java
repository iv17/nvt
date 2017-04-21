package nvt.web.dto;

import java.util.Set;

import nvt.beans.Image;
import nvt.beans.RealEstate;
import nvt.beans.RealEstateIndoors;
import nvt.beans.RealEstateOutdoors;

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
	protected LocationDTO locationDTO;
	protected RealEstateTypeDTO realEstateTypeDTO;
	protected HeatingTypeDTO heatingTypeDTO;
	protected Set<Image> images; 
	protected Set<RealEstateIndoors> indoorsDTO;
	protected Set<RealEstateOutdoors> outdoorsDTO;
	
	
	
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
		locationDTO = new LocationDTO(realEstate.getLocation());
		realEstateTypeDTO = new RealEstateTypeDTO(realEstate.getRealEstateType());
		heatingTypeDTO = new HeatingTypeDTO(realEstate.getHeatingType());
		//images = realEstate.getImages();
		indoorsDTO = realEstate.getIndoors();
		outdoorsDTO = realEstate.getOutdoors();
	}
	
	/*
	public RealEstateDTO(int id, String name, String description, double price, double surface,
			int floor, int rooms, int bathrooms, int constructedYear, boolean filed,
			boolean furnished, LocationDTO locationDTO, RealEstateTypeDTO realEstateTypeDTO, 
			HeatingTypeDTO heatingTypeDTO, Set<Image> images, 
			Set<RealEstateIndoors> indoorsDTO, Set<RealEstateOutdoors> outdoorsDTO) {
		this.id = id;
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
		this.locationDTO = locationDTO;
		this.realEstateTypeDTO = realEstateTypeDTO;
		this.heatingTypeDTO = heatingTypeDTO;
		this.images = images;
		this.indoorsDTO = indoorsDTO;
		this.outdoorsDTO = outdoorsDTO;
	}
	*/

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
	
	public LocationDTO getLocationDTO() {
		return locationDTO;
	}

	public void setLocationDTO(LocationDTO locationDTO) {
		this.locationDTO = locationDTO;
	}

	public RealEstateTypeDTO getRealEstateTypeDTO() {
		return realEstateTypeDTO;
	}

	public void setRealEstateTypeDTO(RealEstateTypeDTO realEstateTypeDTO) {
		this.realEstateTypeDTO = realEstateTypeDTO;
	}

	public HeatingTypeDTO getHeatingTypeDTO() {
		return heatingTypeDTO;
	}

	public void setHeatingTypeDTO(HeatingTypeDTO heatingTypeDTO) {
		this.heatingTypeDTO = heatingTypeDTO;
	}

	public Set<Image> getImages() {
		return images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}

	public Set<RealEstateIndoors> getIndoorsDTO() {
		return indoorsDTO;
	}

	public void setIndoorsDTO(Set<RealEstateIndoors> indoorsDTO) {
		this.indoorsDTO = indoorsDTO;
	}

	public Set<RealEstateOutdoors> getOutdoorsDTO() {
		return outdoorsDTO;
	}

	public void setOutdoorsDTO(Set<RealEstateOutdoors> outdoorsDTO) {
		this.outdoorsDTO = outdoorsDTO;
	}




	
}
