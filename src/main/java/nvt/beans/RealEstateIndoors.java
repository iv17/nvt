package nvt.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "real_estate_indoors")
public class RealEstateIndoors implements Serializable {

	private static final long serialVersionUID = -3904766471545287896L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false , unique = true)
	protected int id;
	
	@ManyToOne
	@JoinColumn(name = "real_estate_id", referencedColumnName = "id", nullable = false)
	protected RealEstate realEstate;
	
	@ManyToOne
	@JoinColumn(name = "indoor_feature_id", referencedColumnName = "id", nullable = false)
	protected IndoorFeature indoorFeature;

	
	public RealEstateIndoors(RealEstate realEstate, IndoorFeature indoorFeature) {
		this.realEstate = realEstate;
		this.indoorFeature = indoorFeature;
	}

	
	public RealEstateIndoors(int id, RealEstate realEstate, IndoorFeature indoorFeature) {
		this.id = id;
		this.realEstate = realEstate;
		this.indoorFeature = indoorFeature;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RealEstate getRealEstate() {
		return realEstate;
	}

	public void setRealEstate(RealEstate realEstate) {
		this.realEstate = realEstate;
	}

	public IndoorFeature getIndoorFeature() {
		return indoorFeature;
	}

	public void setIndoorFeature(IndoorFeature indoorFeature) {
		this.indoorFeature = indoorFeature;
	}
	
	
	
}
