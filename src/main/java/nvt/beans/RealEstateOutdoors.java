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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "real_estate_outdoors")
public class RealEstateOutdoors implements Serializable {

	private static final long serialVersionUID = -3904766471545287896L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false , unique = true)
	private int id;
	
	@ManyToOne @JsonIgnore
	@JoinColumn(name = "real_estate_id", referencedColumnName = "id", nullable = false)
	private RealEstate realEstate;
	
	@ManyToOne @JsonIgnore
	@JoinColumn(name = "outdoor_feature_id", referencedColumnName = "id", nullable = false)
	private OutdoorFeature outdoorFeature;

	
	
	public RealEstateOutdoors() {
		
	}


	public RealEstateOutdoors(RealEstate realEstate, OutdoorFeature outdoorFeature) {
		this.realEstate = realEstate;
		this.outdoorFeature = outdoorFeature;
	}

	
	public RealEstateOutdoors(int id, RealEstate realEstate, OutdoorFeature outdoorFeature) {
		this.id = id;
		this.realEstate = realEstate;
		this.outdoorFeature = outdoorFeature;
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

	public OutdoorFeature getOutdoorFeature() {
		return outdoorFeature;
	}

	public void setOutdoorFeature(OutdoorFeature outdoorFeature) {
		this.outdoorFeature = outdoorFeature;
	}
	


}
