package nvt.web.dto;

import java.util.ArrayList;

public class AddRealEstateDTO {

	private int id;
	private String name;
	private String description;
	private double price;
	private double surface;
	private int floor;
	private int rooms;
	private int bathrooms;
	private int constructedYear;
	private String filed;
	private String furnished;
	
	private ArrayList<SelectedAdvertisementTypeDTO> selectedAdvertisementTypes;
	private ArrayList<SelectedRealEstateTypeDTO> selectedRealEstateTypes;
	private ArrayList<SelectedHeatingTypeDTO> selectedHeatingTypes;
	
	
	
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

	
	

}
