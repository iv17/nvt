package nvt.web.dto;

import nvt.beans.Location;

public class LocationDTO {

	protected int id;
	protected double coord1;
	protected double coord2;
	protected String city;
	protected String block;
	protected String street;
	protected String zipCode;
	
	
	
	public LocationDTO() {
		
	}
	
	
	public LocationDTO(Location location) {
		this(location.getId(),
				location.getCoord1(),
				location.getCoord2(),
				location.getCity(),
				location.getBlock(),
				location.getStreet(),
				location.getZipCode());
	}

	
	public LocationDTO(int id, double coord1, double coord2, String city, String block, String street, String zipCode) {
		this.id = id;
		this.coord1 = coord1;
		this.coord2 = coord2;
		this.city = city;
		this.block = block;
		this.street = street;
		this.zipCode = zipCode;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCoord1() {
		return coord1;
	}

	public void setCoord1(double coord1) {
		this.coord1 = coord1;
	}

	public double getCoord2() {
		return coord2;
	}

	public void setCoord2(double coord2) {
		this.coord2 = coord2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	
}
