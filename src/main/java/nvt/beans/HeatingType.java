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
@Table(name = "heating_type")
public class HeatingType implements Serializable {

	private static final long serialVersionUID = 251263305970765363L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false , unique = true)
	protected int id;
	
	@Column(name = "name", unique = false, nullable = false)
	protected String name;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "heatingType")
	protected Set<RealEstate> realEstates;

	
	
	public HeatingType() {
		
	}
	

	public HeatingType(String name) {
		this.name = name;
	}
	

	public HeatingType(String name, Set<RealEstate> realEstates) {
		this.name = name;
		this.realEstates = realEstates;
	}

	
	public HeatingType(int id, String name, Set<RealEstate> realEstates) {
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
