package nvt.beans;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "agent")
public class Agent extends User {

	private static final long serialVersionUID = -4819479829618308513L;
	
	@ManyToOne
	@JoinColumn(name = "company_id", referencedColumnName = "id", nullable = true) @JsonIgnore
	private Company company;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, mappedBy = "agent") @JsonIgnore
	private Set<RealEstate> realEstates;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "agent") @JsonIgnore
	private Set<AgentRating> agentRatings;

	
	
	public Agent() {
		super();
	}

	
	public Agent(User user, Company company) {
		super();
		this.email = user.getEmail();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.name = user.getName();
		this.lastName = user.getLastName();
		this.phoneNumber = user.getPhoneNumber();
		this.company = company;
	}


	public Agent(Company company, Set<RealEstate> realEstates, Set<AgentRating> agentRatings) {
		super();
		this.company = company;
		this.realEstates = realEstates;
		this.agentRatings = agentRatings;
	}

	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Set<RealEstate> getRealEstates() {
		return realEstates;
	}

	public void setRealEstates(Set<RealEstate> realEstates) {
		this.realEstates = realEstates;
	}

	public Set<AgentRating> getAgentRatings() {
		return agentRatings;
	}

	public void setAgentRatings(Set<AgentRating> agentRatings) {
		this.agentRatings = agentRatings;
	}


	
}
