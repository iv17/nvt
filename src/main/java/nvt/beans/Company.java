package nvt.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "company")
public class Company extends User {

	private static final long serialVersionUID = 991372987353234682L;


	@Column(name = "property_no", unique = true, nullable = false)
	private String propertyNo;

	@Column(name = "web_address", unique = false, nullable = false)
	private String webAddress;

	@ManyToOne @JsonIgnore
	@JoinColumn(name = "location_id", referencedColumnName = "id", nullable = true)
	private Location location;

	@OneToOne(mappedBy = "company")
	private Image companyImage;
	
	@ManyToOne @JsonIgnore
	@JoinColumn(name = "working_time_id", referencedColumnName = "id", nullable = true)
	private WorkingTime workingTime;

	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "company") @JsonIgnore
	private Set<Agent> agents;



	public Company() {
		super();
	}


	public Company(String email, String username, String password, String phoneNumber, String propertyNo, 
			String webAddress, Location location, WorkingTime workingTime) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.webAddress = webAddress;
		this.location = location;
		this.workingTime = workingTime;
		this.propertyNo = propertyNo;
		
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
	
	public Set<Agent> getAgents() {
		return agents;
	}

	public void setAgents(Set<Agent> agents) {
		this.agents = agents;
	}


	public Image getCompanyImage() {
		return companyImage;
	}


	public void setCompanyImage(Image companyImage) {
		this.companyImage = companyImage;
	}


	


}
