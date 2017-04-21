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
@Table(name = "real_estate_type")
public class RealEstateType implements Serializable {

	private static final long serialVersionUID = -6700267192796811184L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false , unique = true)
	private int id;
	
	@Column(name = "name", unique = false, nullable = false)
	private String name;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "realEstateType") @JsonIgnore
	private Set<RealEstate> realEstates;

	
	
	public RealEstateType() {
	
	}

	
	public RealEstateType(String name) {
		this.name = name;
	}
	
	
	public RealEstateType(String name, Set<RealEstate> realEstates) {
		this.name = name;
		this.realEstates = realEstates;
	}

	
	public RealEstateType(int id, String name, Set<RealEstate> realEstates) {
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
