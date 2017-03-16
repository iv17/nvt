package nvt.web.dto;

import java.util.Date;

import nvt.beans.AgentRating;

public class AgentRatingDTO {

	protected int id;
	protected int rate;
	protected Date posted;
	protected AgentDTO agentDTO;
	protected UserDTO userDTO;

	
	
	public AgentRatingDTO() {
		
	}
	
	
	public AgentRatingDTO(AgentRating agentRating) {
		this(agentRating.getId(),
				agentRating.getRate(),
				agentRating.getPosted(),
				new AgentDTO(agentRating.getAgent()),
				new UserDTO(agentRating.getUser()));
	}

	
	public AgentRatingDTO(int id, int rate, Date posted, AgentDTO agentDTO, UserDTO userDTO) {
		this.id = id;
		this.rate = rate;
		this.posted = posted;
		this.agentDTO = agentDTO;
		this.userDTO = userDTO;
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
