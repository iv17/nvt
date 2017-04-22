package nvt.web.dto;

import java.util.Date;

import nvt.beans.AgentRating;

public class AgentRatingDTO {

	private int id;
	private int rate;
	private Date posted;
	private AgentDTO agentDTO;
	private UserDTO userDTO;

	
	
	public AgentRatingDTO() {
		
	}
	
	
	public AgentRatingDTO(AgentRating agentRating) {
		id = agentRating.getId();
		rate = agentRating.getRate();
		posted = agentRating.getPosted();
		agentDTO = new AgentDTO(agentRating.getAgent());
		userDTO = new UserDTO(agentRating.getUser());
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

	public AgentDTO getAgentDTO() {
		return agentDTO;
	}

	public void setAgentDTO(AgentDTO agentDTO) {
		this.agentDTO = agentDTO;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	
	
}
