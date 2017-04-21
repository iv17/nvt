package nvt.web.dto;

import nvt.beans.User;

public class UserDTO {

	protected int id;
	protected String email;
	protected String username;
	protected String password;
	protected String name;
	protected String lastName;
	protected String phoneNumber;
	protected boolean loged;
	protected boolean authenticated;
	protected ImageDTO imageDTO;
	
	
	
	public UserDTO() {
		
	}
	
	
	public UserDTO(User user) {
		id = user.getId();
		email = user.getEmail();
		username = user.getUsername();
		password = user.getPassword();
		name = user.getName();
		lastName = user.getLastName();
		phoneNumber = user.getPhoneNumber();
		loged = user.isLoged();
		authenticated = user.isAuthenticated();
		//imageDTO = new ImageDTO(user.getImage());
	}

	/*
	public UserDTO(int id, String email, String username, String password, String name,
			String lastName, String phoneNumber, boolean loged, boolean authenticated,
			ImageDTO imageDTO) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.loged = loged;
		this.authenticated = authenticated;
		this.imageDTO = imageDTO;
	}
	*/

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

	public ImageDTO getImageDTO() {
		return imageDTO;
	}

	public void setImageDTO(ImageDTO imageDTO) {
		this.imageDTO = imageDTO;
	}
	
	
}
