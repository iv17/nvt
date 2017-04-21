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
@Table(name = "outdoor_feature")
public class OutdoorFeature implements Serializable {

	private static final long serialVersionUID = -3554056384710589120L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false , unique = true)
	private int id;
	
	@Column(name = "name", unique = false, nullable = false)
	private String name;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "realEstate") @JsonIgnore
	private Set<RealEstateOutdoors> outdoors;
	
	
	
	public OutdoorFeature() {
		
	}
	

	public OutdoorFeature(String name) {
		this.name = name;
	}

	
	public OutdoorFeature(String name, Set<RealEstateOutdoors> outdoors) {
		this.name = name;
		this.outdoors = outdoors;
	}

	
	public OutdoorFeature(int id, String name, Set<RealEstateOutdoors> outdoors) {
		this.id = id;
		this.name = name;
		this.outdoors = outdoors;
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

	public Set<RealEstateOutdoors> getOutdoors() {
		return outdoors;
	}

	public void setOutdoors(Set<RealEstateOutdoors> outdoors) {
		this.outdoors = outdoors;
	}

	
}
