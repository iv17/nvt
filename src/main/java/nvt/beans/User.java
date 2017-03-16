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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {

	private static final long serialVersionUID = 3746231252100930513L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false , unique = true)
	protected int id;
	
	@Column(name = "email", unique = false, nullable = false)
	protected String email;
	
	@Column(name = "username", unique = false, nullable = false)
	protected String username;
	
	@Column(name = "password", unique = false, nullable = false)
	protected String password;
	
	@Column(name = "name", unique = false, nullable = false)
	protected String name;
	
	@Column(name = "last_name", unique = false, nullable = false)
	protected String lastName;
	
	@Column(name = "phone_number", unique = false, nullable = false)
	protected String phoneNumber;
	
	@Column(name = "loged", unique = false, nullable = false)
	protected boolean loged;
	
	@Column(name = "authenticated", unique = false, nullable = false)
	protected boolean authenticated;
	
	@OneToOne
	@JoinColumn(name = "image", referencedColumnName = "id", nullable = true)
	protected Image image; 
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "user")
	protected Set<AgentRating> agentRatings;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "user")
	protected Set<RealEstateComment> comments;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "user")
	protected Set<RealEstateRating> ratings;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "user")
	protected Set<RealEstateReport> reports;

	
	
	public User() {
		
	}

	
	public User(String email, String username, String password, String name, String lastName,
			String phoneNumber, Image image) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.image = image;
		
	}

	
	public User(int id, String email, String username, String password, String name, String lastName,
			String phoneNumber, Image image, Set<AgentRating> agentRatings,
			Set<RealEstateComment> comments, Set<RealEstateRating> ratings, Set<RealEstateReport> reports) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.loged = false;
		this.authenticated = false;
		this.image = image;
		this.agentRatings = agentRatings;
		this.comments = comments;
		this.ratings = ratings;
		this.reports = reports;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isLoged() {
		return loged;
	}

	public void setLoged(boolean loged) {
		this.loged = loged;
	}

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Set<AgentRating> getAgentRatings() {
		return agentRatings;
	}

	public void setAgentRatings(Set<AgentRating> agentRatings) {
		this.agentRatings = agentRatings;
	}

	public Set<RealEstateComment> getComments() {
		return comments;
	}

	public void setComments(Set<RealEstateComment> comments) {
		this.comments = comments;
	}

	public Set<RealEstateRating> getRatings() {
		return ratings;
	}

	public void setRatings(Set<RealEstateRating> ratings) {
		this.ratings = ratings;
	}

	public Set<RealEstateReport> getReports() {
		return reports;
	}

	public void setReports(Set<RealEstateReport> reports) {
		this.reports = reports;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", image=" + image + "]";
	}

	
	
	
}
