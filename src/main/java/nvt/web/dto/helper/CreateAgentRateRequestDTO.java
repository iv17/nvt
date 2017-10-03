package nvt.web.dto.helper;

public class CreateAgentRateRequestDTO {

	protected int agentId;
	protected int rate;
	
	
	public CreateAgentRateRequestDTO() {
	
	}

	public CreateAgentRateRequestDTO(int agentId, int rate) {

		this.agentId = agentId;
		this.rate = rate;
	}
	public int getAgentId() {
		return agentId;
	}
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	
	
	
	
}
