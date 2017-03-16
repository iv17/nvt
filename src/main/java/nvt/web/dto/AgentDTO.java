package nvt.web.dto;

import nvt.beans.Agent;

public class AgentDTO extends UserDTO{

	protected CompanyDTO companyDTO;
	
	
	public AgentDTO() {
		
	}
	
	
	public AgentDTO(Agent agent) {
		super(agent.getId(),
				agent.getEmail(),
				agent.getUsername(),
				agent.getPassword(),
				agent.getName(),
				agent.getLastName(), 
				agent.getPhoneNumber(),
				agent.isLoged(), 
				agent.isAuthenticated(),
				new ImageDTO(agent.getImage())); 
		companyDTO = new CompanyDTO(agent.getCompany());
	}

	
	public CompanyDTO getCompanyDTO() {
		return companyDTO;
	}

	public void setCompanyDTO(CompanyDTO companyDTO) {
		this.companyDTO = companyDTO;
	}
	
	
	
}
