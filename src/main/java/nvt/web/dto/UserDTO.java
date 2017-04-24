package nvt.web.dto;

import java.util.HashSet;
import java.util.Set;

import nvt.beans.AgentRating;
import nvt.beans.RealEstateComment;
import nvt.beans.RealEstateRating;
import nvt.beans.RealEstateReport;
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
	protected ImageDTO image;
	private Set<RealEstateCommentDTO> comments;
	private Set<RealEstateRatingDTO> ratings;
	private Set<RealEstateReportDTO> reports;
	private Set<AgentRatingDTO> agentRatings;
	
	/*
	public RealEstateCommentDTO toDTOu(RealEstateComment realEstateComment) {
		RealEstateCommentDTO realEstateCommentDTO = new RealEstateCommentDTO();
		
		realEstateCommentDTO.setId(realEstateComment.getId());
		realEstateCommentDTO.setComment(realEstateComment.getComment());
		realEstateCommentDTO.setPosted(realEstateComment.getPosted());
		realEstateCommentDTO.setRealEstate(new RealEstateDTO(realEstateComment.getRealEstate()));
		realEstateCommentDTO.setUser(new UserDTO(realEstateComment.getUser()));
		
		return realEstateCommentDTO;
	}
	
	public RealEstateRatingDTO toDTOu(RealEstateRating realEstateRating) {
		RealEstateRatingDTO realEstateRatingDTO = new RealEstateRatingDTO();
		
		realEstateRatingDTO.setId(realEstateRating.getId());
		realEstateRatingDTO.setRate(realEstateRating.getRate());
		realEstateRatingDTO.setPosted(realEstateRating.getPosted());
		realEstateRatingDTO.setRealEstate(new RealEstateDTO(realEstateRating.getRealEstate()));
		realEstateRatingDTO.setUser(this);
		
		return realEstateRatingDTO;
	}
	
	public RealEstateReportDTO toDTOu(RealEstateReport realEstateReport) {
		RealEstateReportDTO realEstateReportDTO = new RealEstateReportDTO();
		
		realEstateReportDTO.setId(realEstateReport.getId());
		realEstateReportDTO.setReport(realEstateReport.getReport());
		realEstateReportDTO.setPosted(realEstateReport.getPosted());
		realEstateReportDTO.setRealEstate(new RealEstateDTO(realEstateReport.getRealEstate()));
		realEstateReportDTO.setUser(this);
		
		return realEstateReportDTO;
	}
	
	public AgentRatingDTO toDTO(AgentRating agentRating) {
		AgentRatingDTO agentRatingDTO = new AgentRatingDTO();
		
		agentRatingDTO.setId(agentRating.getId());
		agentRatingDTO.setRate(agentRating.getRate());
		agentRatingDTO.setPosted(agentRating.getPosted());
		agentRatingDTO.setAgent(new AgentDTO(agentRating.getAgent()));
		
		return agentRatingDTO;

	}
	
	*/
	
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
		//image = new ImageDTO(user.getImage());
		
		/*
		comments = new HashSet<RealEstateCommentDTO>();
		for (RealEstateComment realEstateComment : user.getComments()) {
			RealEstateCommentDTO realEstateCommentDTO = toDTOu(realEstateComment);
			comments.add(realEstateCommentDTO);
		}
		
		ratings = new HashSet<RealEstateRatingDTO>();
		for (RealEstateRating realEstateRating : user.getRatings()) {
			RealEstateRatingDTO realEstateRatingDTO = toDTOu(realEstateRating);
			ratings.add(realEstateRatingDTO);
		}
		
		reports = new HashSet<RealEstateReportDTO>();
		for (RealEstateReport realEstateReport : user.getReports()) {
			RealEstateReportDTO realEstateReportDTO = toDTOu(realEstateReport);
			reports.add(realEstateReportDTO);
		}
		
		agentRatings = new HashSet<AgentRatingDTO>();
		for (AgentRating agentRating : user.getAgentRatings()) {
			AgentRatingDTO agentRatingDTO = toDTO(agentRating);
			agentRatings.add(agentRatingDTO);
		}
		*/
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
}
