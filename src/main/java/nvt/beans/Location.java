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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "location")
public class Location implements Serializable {

	private static final long serialVersionUID = 5633522419843258510L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false , unique = true)
	protected int id;
	
	@Column(name = "coord1", unique = false, nullable = false)
	protected double coord1;
	
	@Column(name = "coord2", unique = false, nullable = false)
	protected double coord2;
	
	@Column(name = "city", unique = false, nullable = false)
	protected String city;
	
	@Column(name = "block", unique = false, nullable = false)
	protected String block;
	
	@Column(name = "street", unique = false, nullable = false)
	protected String street;
	
	@Column(name = "zipCode", unique = false, nullable = false)
	protected String zipCode;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "location")
	protected Set<RealEstate> realEstates;

	
	
	public Location() {
		
	}

	
	public Location(double coord1, double coord2, String city, String block, String street, String zipCode) {	
		this.coord1 = coord1;
		this.coord2 = coord2;
		this.city = city;
		this.block = block;
		this.street = street;
		this.zipCode = zipCode;
	}

	
	public Location(double coord1, double coord2, String city, String block, String street, String zipCode,
			Set<RealEstate> realEstates) {
		this.coord1 = coord1;
		this.coord2 = coord2;
		this.city = city;
		this.block = block;
		this.street = street;
		this.zipCode = zipCode;
		this.realEstates = realEstates;
	}

	
	public Location(int id, double coord1, double coord2, String city, String block, String street, String zipCode,
			Set<RealEstate> realEstates) {
	
		this.id = id;
		this.coord1 = coord1;
		this.coord2 = coord2;
		this.city = city;
		this.block = block;
		this.street = street;
		this.zipCode = zipCode;
		this.realEstates = realEstates;
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

	public Set<RealEstate> getRealEstates() {
		return realEstates;
	}

	public void setRealEstates(Set<RealEstate> realEstates) {
		this.realEstates = realEstates;
	}
	
	
}
