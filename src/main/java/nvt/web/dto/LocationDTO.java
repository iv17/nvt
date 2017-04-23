package nvt.web.dto;

import nvt.beans.Location;

public class LocationDTO {

	private int id;
	private double coord1;
	private double coord2;
	private String city;
	private String block;
	private String street;
	private String zipCode;
	
	
	public LocationDTO() {
		
	}
	
	
	public LocationDTO(Location location) {
		id = location.getId();
		coord1 = location.getCoord1();
		coord2 = location.getCoord2();
		city = location.getCity();
		block = location.getBlock();
		street = location.getStreet();
		zipCode = location.getZipCode();
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
