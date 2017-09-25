package nvt.web.dto;

import nvt.beans.User;

public class UserDTO {

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
	private ImageDTO image; 

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
		if(user.getImage() != null) {
			image = new ImageDTO(user.getImage());
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


	public String getRepeated_password() {
		return repeated_password;
	}

	public void setRepeated_password(String repeated_password) {
		this.repeated_password = repeated_password;
	}

	
}
