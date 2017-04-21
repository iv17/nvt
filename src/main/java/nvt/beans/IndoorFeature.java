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
@Table(name = "indoor_feature")
public class IndoorFeature implements Serializable {

	private static final long serialVersionUID = 4302427538406048788L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false , unique = true)
	private int id;
	
	@Column(name = "name", unique = false, nullable = false)
	private String name;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "realEstate") @JsonIgnore
	private Set<RealEstateIndoors> indoors;
	
	
	
	public IndoorFeature() {
	
	}

	
	public IndoorFeature(String name) {
		this.name = name;
	}

	
	public IndoorFeature(String name, Set<RealEstateIndoors> indoors) {
		this.name = name;
		this.indoors = indoors;
	}

	
	public IndoorFeature(int id, String name, Set<RealEstateIndoors> indoors) {
		this.id = id;
		this.name = name;
		this.indoors = indoors;
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

	public Set<RealEstateIndoors> getIndoors() {
		return indoors;
	}

	public void setIndoors(Set<RealEstateIndoors> indoors) {
		this.indoors = indoors;
	}


	
}
