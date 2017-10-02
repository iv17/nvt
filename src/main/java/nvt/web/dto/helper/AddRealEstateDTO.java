package nvt.web.dto.helper;

import java.util.ArrayList;

public class AddRealEstateDTO {

	protected int id;
	protected String name;
	protected String description;
	protected double price;
	protected double surface;
	protected int floor;
	protected int rooms;
	protected int bathrooms;
	protected int constructedYear;
	protected String filed;
	protected String furnished;
	
	protected ArrayList<SelectedAdvertisementTypeDTO> selectedAdvertisementTypes;
	protected ArrayList<SelectedRealEstateTypeDTO> selectedRealEstateTypes;
	protected ArrayList<SelectedHeatingTypeDTO> selectedHeatingTypes;
	
	protected ArrayList<Double> latlng;
	protected ArrayList<SelectedIndoorFeatureDTO> selectedIndoors;
	protected ArrayList<SelectedOutdoorFeatureDTO> selectedOutdoors;
	protected ArrayList<String> images;
	
	
	public AddRealEstateDTO() {
		
	}
	
	public AddRealEstateDTO(int id, String name, String description, double price, double surface, int floor, int rooms,
			int bathrooms, int constructedYear, String filed, String furnished,
			ArrayList<SelectedAdvertisementTypeDTO> selectedAdvertisementTypes,
			ArrayList<SelectedRealEstateTypeDTO> selectedRealEstateTypes,
			ArrayList<SelectedHeatingTypeDTO> selectedHeatingTypes) {
		super();
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
		this.selectedAdvertisementTypes = selectedAdvertisementTypes;
		this.selectedRealEstateTypes = selectedRealEstateTypes;
		this.selectedHeatingTypes = selectedHeatingTypes;
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
	
	public String getFiled() {
		return filed;
	}
	
	public void setFiled(String filed) {
		this.filed = filed;
	}
	
	public String getFurnished() {
		return furnished;
	}
	
	public void setFurnished(String furnished) {
		this.furnished = furnished;
	}
	
	public ArrayList<SelectedAdvertisementTypeDTO> getSelectedAdvertisementTypes() {
		return selectedAdvertisementTypes;
	}
	
	public void setSelectedAdvertisementTypes(ArrayList<SelectedAdvertisementTypeDTO> selectedAdvertisementTypes) {
		this.selectedAdvertisementTypes = selectedAdvertisementTypes;
	}
	
	public ArrayList<SelectedRealEstateTypeDTO> getSelectedRealEstateTypes() {
		return selectedRealEstateTypes;
	}
	
	public void setSelectedRealEstateTypes(ArrayList<SelectedRealEstateTypeDTO> selectedRealEstateTypes) {
		this.selectedRealEstateTypes = selectedRealEstateTypes;
	}
	
	public ArrayList<SelectedHeatingTypeDTO> getSelectedHeatingTypes() {
		return selectedHeatingTypes;
	}
	
	public void setSelectedHeatingTypes(ArrayList<SelectedHeatingTypeDTO> selectedHeatingTypes) {
		this.selectedHeatingTypes = selectedHeatingTypes;
	}
	
	public ArrayList<Double> getLatlng() {
		return latlng;
	}
	
	public void setLatlng(ArrayList<Double> latlng) {
		this.latlng = latlng;
	}
	
	public ArrayList<SelectedIndoorFeatureDTO> getSelectedIndoors() {
		return selectedIndoors;
	}
	
	public void setSelectedIndoors(ArrayList<SelectedIndoorFeatureDTO> selectedIndoors) {
		this.selectedIndoors = selectedIndoors;
	}
	
	public ArrayList<SelectedOutdoorFeatureDTO> getSelectedOutdoors() {
		return selectedOutdoors;
	}
	
	public void setSelectedOutdoors(ArrayList<SelectedOutdoorFeatureDTO> selectedOutdoors) {
		this.selectedOutdoors = selectedOutdoors;
	}
	
	public ArrayList<String> getImages() {
		return images;
	}
	
	public void setImages(ArrayList<String> images) {
		this.images = images;
	}

}
