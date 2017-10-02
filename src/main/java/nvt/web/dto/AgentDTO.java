package nvt.web.dto;

import java.util.Date;

import nvt.beans.Agent;

public class AgentDTO {

	protected int id;
	protected String email;
	protected String username;
	protected String password;
	protected String name;
	protected String lastName;
	protected String phoneNumber;
	protected ImageDTO image; 
	protected Date date;
	protected CompanyDTO company;
	
	
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
		if(agent.getImage() != null) {
			image = new ImageDTO(agent.getImage());
		}
		if(agent.getCompany() != null) {
			company = new CompanyDTO(agent.getCompany());
		}
		
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

	public ImageDTO getImage() {
		return image;
	}

	public void setImage(ImageDTO image) {
		this.image = image;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public CompanyDTO getCompany() {
		return company;
	}

	public void setCompany(CompanyDTO company) {
		this.company = company;
	}
	
}
