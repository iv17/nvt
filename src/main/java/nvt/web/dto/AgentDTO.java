package nvt.web.dto;

import nvt.beans.Agent;

public class AgentDTO extends UserDTO {

	private CompanyDTO company;
	
	
	public AgentDTO() {
		
	}
	
	
	public AgentDTO(Agent agent) {
		id = agent.getId();
		email = agent.getEmail();
		username = agent.getUsername();
		password = agent.getPassword();
		name = agent.getName();
		lastName = agent.getLastName();
		phoneNumber = agent.getPhoneNumber();
	
		authenticated = agent.isAuthenticated();
		//imageDTO = new ImageDTO(agent.getImage());
		company = new CompanyDTO(agent.getCompany());
	}


	public CompanyDTO getCompany() {
		return company;
	}


	public void setCompany(CompanyDTO company) {
		this.company = company;
	}
	
	
}
