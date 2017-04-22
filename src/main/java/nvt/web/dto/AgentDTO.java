package nvt.web.dto;

import nvt.beans.Agent;

public class AgentDTO extends UserDTO{

	private CompanyDTO companyDTO;
	
	
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
		loged = agent.isLoged();
		authenticated = agent.isAuthenticated();
		//imageDTO = new ImageDTO(agent.getImage());
		companyDTO = new CompanyDTO(agent.getCompany());
	}

	
	public CompanyDTO getCompanyDTO() {
		return companyDTO;
	}

	public void setCompanyDTO(CompanyDTO companyDTO) {
		this.companyDTO = companyDTO;
	}
	
	
	
}
