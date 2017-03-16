package nvt.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "agent")
public class Agent extends User {

	private static final long serialVersionUID = -4819479829618308513L;
	
	@ManyToOne
	@JoinColumn(name = "company_id", referencedColumnName = "id", nullable = true)
	protected Company company;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "agent")
	protected Set<Advertisement> advertisements;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "agent")
	protected Set<AgentRating> agentRatings;

	
	
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


	public Agent(Company company, Set<Advertisement> advertisements, Set<AgentRating> agentRatings) {
		super();
		this.company = company;
		this.advertisements = advertisements;
		this.agentRatings = agentRatings;
	}

	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Set<Advertisement> getAdvertisements() {
		return advertisements;
	}

	public void setAdvertisements(Set<Advertisement> advertisements) {
		this.advertisements = advertisements;
	}

	public Set<AgentRating> getAgentRatings() {
		return agentRatings;
	}

	public void setAgentRatings(Set<AgentRating> agentRatings) {
		this.agentRatings = agentRatings;
	}


	
}
