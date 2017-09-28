package nvt.beans;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "real_estate_rating")
public class RealEstateRating implements Serializable {

	private static final long serialVersionUID = -20971684027194438L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false , unique = true)
	private int id;
	
	@Column(name = "rate", unique = false, nullable = false)
	private int rate;
	
	@Column(name = "posted", unique = false, nullable = true)
	private Date posted;
	
	@ManyToOne @JsonIgnore
	@JoinColumn(name = "real_estate_id", referencedColumnName = "id", nullable = true)
	private RealEstate realEstate;
	
	@ManyToOne @JsonIgnore
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = true)
	private User user;

	
	
	public RealEstateRating() {
	
	}

	
	public RealEstateRating(int rate, Date posted, RealEstate realEstate, User user) {
		this.rate = rate;
		this.posted = posted;
		this.realEstate = realEstate;
		this.user = user;
	}

	
	public RealEstateRating(int id, int rate, Date posted, RealEstate realEstate, User user) {
		this.id = id;
		this.rate = rate;
		this.posted = posted;
		this.realEstate = realEstate;
		this.user = user;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public Date getPosted() {
		return posted;
	}

	public void setPosted(Date posted) {
		this.posted = posted;
	}

	public RealEstate getRealEstate() {
		return realEstate;
	}

	public void setRealEstate(RealEstate realEstate) {
		this.realEstate = realEstate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
