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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "company")
public class Company implements Serializable {

	private static final long serialVersionUID = 991372987353234682L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false , unique = true)
	private int id;

	@Column(name = "property_no", unique = true, nullable = false)
	private String propertyNo;

	@Column(name = "name", unique = true, nullable = false)
	private String name;

	@Column(name = "password", unique = false, nullable = false)
	private String password;

	@Column(name = "phone_number", unique = false, nullable = false)
	private String phoneNumber;

	@Column(name = "web_address", unique = false, nullable = false)
	private String webAddress;

	@ManyToOne @JsonIgnore
	@JoinColumn(name = "location_id", referencedColumnName = "id", nullable = false)
	private Location location;

	@ManyToOne @JsonIgnore
	@JoinColumn(name = "working_time_id", referencedColumnName = "id", nullable = false)
	private WorkingTime workingTime;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, mappedBy = "company") @JsonIgnore
	private Set<Image> images;

	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "company") @JsonIgnore
	private Set<Agent> agents;



	public Company() {

	}


	public Company(String propertyNo, String name, String password, String phoneNumber, 
			String webAddress, Location location, WorkingTime workingTime) {	
		this.propertyNo = propertyNo;
		this.name = name;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.webAddress = webAddress;
		this.location = location;
		this.workingTime = workingTime;
	}


	public Company(String name, String propertyNo, String password, String phoneNumber, 
			String webAddress, Location location, Set<Agent> agents) {
		this.name = name;
		this.propertyNo = propertyNo;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.webAddress = webAddress;
		this.location = location;
		this.agents = agents;
	}


	public Company(int id, String propertyNo, String name, String password, String phoneNumber,
			String webAddress, Location location, WorkingTime workingTime, Set<Image> images,
			Set<Agent> agents) {

		this.id = id;
		this.propertyNo = propertyNo;
		this.name = name;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.webAddress = webAddress;
		this.location = location;
		this.workingTime = workingTime;
		this.agents = agents;
		this.images = images;
		
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPropertyNo() {
		return propertyNo;
	}

	public void setPropertyNo(String propertyNo) {
		this.propertyNo = propertyNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getWebAddress() {
		return webAddress;
	}

	public void setWebAddress(String webAddress) {
		this.webAddress = webAddress;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public WorkingTime getWorkingTime() {
		return workingTime;
	}

	public void setWorkingTime(WorkingTime workingTime) {
		this.workingTime = workingTime;
	}
	
	public Set<Image> getImages() {
		return images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}
	
	public Set<Agent> getAgents() {
		return agents;
	}

	public void setAgents(Set<Agent> agents) {
		this.agents = agents;
	}



}
