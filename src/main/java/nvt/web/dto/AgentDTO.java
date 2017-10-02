package nvt.web.dto;

import java.util.Date;

import nvt.beans.Agent;

public class AgentDTO extends UserDTO {

	protected int id;
	protected String email;
	protected String username;
	protected String password;
	private String repeated_password; // samo za registraciju
	protected String name;
	protected String lastName;
	protected String phoneNumber;
	protected boolean loged;
	protected boolean authenticated;
	protected ImageDTO image; 
	protected Date date;
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
		if(agent.getImage() != null) {
			image = new ImageDTO(agent.getImage());
		}
		company = new CompanyDTO(agent.getCompany());
	}


	public CompanyDTO getCompany() {
		return company;
	}


	public void setCompany(CompanyDTO company) {
		this.company = company;
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


	public String getRepeated_password() {
		return repeated_password;
	}


	public void setRepeated_password(String repeated_password) {
		this.repeated_password = repeated_password;
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


	public boolean isLoged() {
		return loged;
	}


	public void setLoged(boolean loged) {
		this.loged = loged;
	}


	public boolean isAuthenticated() {
		return authenticated;
	}


	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
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
	
	
	
	
}
