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
@Table(name = "agent_rating")
public class AgentRating implements Serializable {

	private static final long serialVersionUID = 6155636421036959591L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false , unique = true)
	private int id;
	
	@Column(name = "rate", unique = false, nullable = false)
	private int rate;
	
	@Column(name = "posted", unique = false, nullable = false)
	private Date posted;
	
	@ManyToOne @JsonIgnore
	@JoinColumn(name = "agent_id", referencedColumnName = "id", nullable = false)
	private Agent agent;
	
	@ManyToOne @JsonIgnore
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
	private User user;
	
	public AgentRating() {
		
	}
	
	public AgentRating(int rate, Date posted, Agent agent, User user) {
		this.rate = rate;
		this.posted = posted;
		this.agent = agent;
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

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
