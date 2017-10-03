package nvt.web.dto.helper;

import nvt.web.dto.AgentDTO;

public class AgentRatingsResponseDTO {

	AgentDTO agent;
	RatingsResponseDTO ratings;
	
	public AgentRatingsResponseDTO() {
	
	}
	
	public AgentRatingsResponseDTO(AgentDTO agent, RatingsResponseDTO ratings) {
		super();
		this.agent = agent;
		this.ratings = ratings;
	}
	public AgentDTO getAgent() {
		return agent;
	}
	public void setAgent(AgentDTO agent) {
		this.agent = agent;
	}
	public RatingsResponseDTO getRatings() {
		return ratings;
	}
	public void setRatings(RatingsResponseDTO ratings) {
		this.ratings = ratings;
	}
	
	
	
}
