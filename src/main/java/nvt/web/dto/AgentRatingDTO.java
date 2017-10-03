package nvt.web.dto;

import java.util.Date;

import nvt.beans.AgentRating;

public class AgentRatingDTO {

	protected int id;
	protected int rate;
	protected Date posted;
	protected AgentDTO agent;
	protected UserDTO user;


	public AgentRatingDTO() {

	}


	public AgentRatingDTO(AgentRating agentRating) {
		id = agentRating.getId();
		rate = agentRating.getRate();
		posted = agentRating.getPosted();
		if(agentRating.getAgent() != null) {
			agent = new AgentDTO(agentRating.getAgent());
		}
		if(agentRating.getUser() != null) {
			user = new UserDTO(agentRating.getUser());
		}


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

	public AgentDTO getAgent() {
		return agent;
	}

	public void setAgent(AgentDTO agent) {
		this.agent = agent;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

}
