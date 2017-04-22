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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "advertisement_type")
public class AdvertisementType implements Serializable {

	private static final long serialVersionUID = 2674016724820324552L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false , unique = true)
	private int id;

	@Column(name = "name", unique = false, nullable = false)
	private String name;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "advertisementType") @JsonIgnore
	private Set<RealEstate> realEstates;

	
	
	public AdvertisementType() {
		
	}
	
	
	public AdvertisementType(String name) {
		this.name = name;
	}

	
	public AdvertisementType(String name, Set<RealEstate> realEstates) {
		this.name = name;
		this.realEstates = realEstates;
	}
	

	public AdvertisementType(int id, String name, Set<RealEstate> realEstates) {
		
		this.id = id;
		this.name = name;
		this.realEstates = realEstates;
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

	public Set<RealEstate> getRealEstates() {
		return realEstates;
	}

	public void setRealEstates(Set<RealEstate> realEstates) {
		this.realEstates = realEstates;
	}

	
	
}
