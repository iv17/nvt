package nvt.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "advertisement")
public class Advertisement implements Serializable {

	private static final long serialVersionUID = 1782119100601115639L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false , unique = true)
	private int id;
	
	@Column(name = "posted", unique = false, nullable = true)
	private Date posted;

	@Column(name = "updated", unique = false, nullable = true)
	private Date updated;

	@Column(name = "duration", unique = false, nullable = true)
	private int duration;

	@Column(name = "inappropriate", unique = false, nullable = true)
	private boolean inappropriate;

	@Column(name = "verified", unique = false, nullable = true)
	private boolean verified;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "real_estate_id", referencedColumnName = "id", nullable = true)
	private RealEstate realEstate;

	@ManyToOne 
	@JoinColumn(name = "agent_id", referencedColumnName = "id", nullable = true)
	private Agent agent;

	@ManyToOne 
	@JoinColumn(name = "advertisement_type_id", referencedColumnName = "id", nullable = true)
	private AdvertisementType advertisementType;
	
	

	public Advertisement() {
		
	}

	
	public Advertisement(Date posted, int duration, RealEstate realEstate, 
			Agent agent, AdvertisementType advertisementType) {
		this.posted = posted;
		this.duration = duration;
		this.realEstate = realEstate;
		this.agent = agent;
		this.advertisementType = advertisementType;
	}


	public Advertisement(Date posted, Date updated, int duration, 
			boolean inappropriate, boolean verified, RealEstate realEstate,
			Agent agent, AdvertisementType advertisementType) {
		this.posted = posted;
		this.updated = updated;
		this.duration = duration;
		this.inappropriate = inappropriate;
		this.verified = verified;
		this.realEstate = realEstate;
		this.agent = agent;
		this.advertisementType = advertisementType;
	}

	
	public Advertisement(int id, Date posted, Date updated, int duration,
			boolean inappropriate, boolean verified, RealEstate realEstate, 
			Agent agent, AdvertisementType advertisementType) {
		this.id = id;
		this.posted = posted;
		this.updated = updated;
		this.duration = duration;
		this.inappropriate = inappropriate;
		this.verified = verified;
		this.realEstate = realEstate;
		this.agent = agent;
		this.advertisementType = advertisementType;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPosted() {
		return posted;
	}

	public String getPostedString() {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		return sdf.format(posted);
	}

	public void setPosted(Date posted) {
		this.posted = posted;
	}

	public Date getUpdated() {
		return updated;
	}

	public String getUpdatedString() {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		return sdf.format(updated);
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public boolean isInappropriate() {
		return inappropriate;
	}

	public void setInappropriate(boolean inappropriate) {
		this.inappropriate = inappropriate;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public RealEstate getRealEstate() {
		return realEstate;
	}

	public void setRealEstate(RealEstate realEstate) {
		this.realEstate = realEstate;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public AdvertisementType getAdvertisementType() {
		return advertisementType;
	}

	public void setAdvertisementType(AdvertisementType advertisementType) {
		this.advertisementType = advertisementType;
	}


	@Override
	public String toString() {
		return "Advertisement [id=" + id + ", posted=" + posted + ", updated=" + updated + ", duration=" + duration
				+ ", inappropriate=" + inappropriate + ", verified=" + verified + ", realEstate=" + realEstate
				+ ", agent=" + agent + ", advertisementType=" + advertisementType + "]";
	}
	
	


}
