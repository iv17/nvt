package nvt.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nvt.beans.AgentRating;
import nvt.beans.Image;
import nvt.beans.RealEstateComment;
import nvt.beans.RealEstateRating;
import nvt.beans.RealEstateReport;
import nvt.beans.User;
import nvt.repository.ImageRepository;
import nvt.service.AgentRatingService;
import nvt.service.UserService;
import nvt.web.dto.AgentRatingDTO;
import nvt.web.dto.RealEstateCommentDTO;
import nvt.web.dto.RealEstateRatingDTO;
import nvt.web.dto.RealEstateReportDTO;
import nvt.web.dto.UserDTO;

@RestController
@RequestMapping(value = "api/users")
public class UserController {

	@Autowired
	protected UserService userService;

	@Autowired
	protected AgentRatingService agentRatingService;

	@Autowired
	protected ImageRepository imageRepository;
	
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {

		User user = new User();
		user.setEmail(userDTO.getEmail());
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		user.setName(userDTO.getName());
		user.setLastName(userDTO.getLastName());
		user.setPhoneNumber(userDTO.getPhoneNumber());
		user.setLoged(false);
		user.setAuthenticated(false);

		Image image = imageRepository.findById(userDTO.getImageDTO().getId());
		if(image == null) {
			return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
		}
		user.setImage(image);
		
		UserDTO newUserDTO = new UserDTO(user);

		userService.save(user);

		return new ResponseEntity<UserDTO>(newUserDTO, HttpStatus.CREATED);

	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> getUsers() {

		List<User> users = userService.findAll();

		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		for (User user : users) {
			UserDTO userDTO = new UserDTO(user);
			userDTOs.add(userDTO);
		}

		return new ResponseEntity<List<UserDTO>>(userDTOs, HttpStatus.OK);
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> getUser(@PathVariable Integer id) {

		User user = userService.findById(id);
		if(user == null) {
			return new ResponseEntity<UserDTO>(HttpStatus.NOT_FOUND);
		}

		UserDTO userDTO = new UserDTO(user);

		return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
	}


	//@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {

		User user = new User();
		user.setEmail(userDTO.getEmail());
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		user.setName(userDTO.getName());
		user.setLastName(userDTO.getLastName());
		user.setPhoneNumber(userDTO.getPhoneNumber());
		user.setLoged(userDTO.isLoged());
		user.setAuthenticated(userDTO.isAuthenticated());

		Image image = imageRepository.findById(userDTO.getImageDTO().getId());
		if(image == null) {
			return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
		}
		user.setImage(image);
		
		UserDTO newUserDTO = new UserDTO(user);

		userService.save(user);

		return new ResponseEntity<UserDTO>(newUserDTO, HttpStatus.CREATED);
	}


	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO) {

		User user = userService.findById(userDTO.getId());

		if(user == null) {
			return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
		}
		user.setEmail(userDTO.getEmail());
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		user.setName(userDTO.getName());
		user.setLastName(userDTO.getLastName());
		user.setPhoneNumber(userDTO.getPhoneNumber());
		user.setLoged(userDTO.isLoged());
		user.setAuthenticated(userDTO.isAuthenticated());

		Image image = imageRepository.findById(userDTO.getImageDTO().getId());
		if(image == null) {
			return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
		}
		user.setImage(image);
		
		UserDTO newUserDTO = new UserDTO(user);

		userService.save(user);

		return new ResponseEntity<UserDTO>(newUserDTO, HttpStatus.OK);
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {

		User user = userService.findById(id);

		if(user == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		userService.removeById(id);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{userID}/ratingsForAgents",method = RequestMethod.GET)
	public ResponseEntity<List<AgentRatingDTO>> getUserRatingsForAgents(@PathVariable Integer userID) {

		User user = userService.findById(userID);

		Set<AgentRating> agentRatings = user.getAgentRatings();

		List<AgentRatingDTO> agentRatingDTOs = new ArrayList<AgentRatingDTO>();

		for (AgentRating agentRating : agentRatings) {
			AgentRatingDTO agentRatingDTO = new AgentRatingDTO(agentRating);
			agentRatingDTOs.add(agentRatingDTO);
		}

		return new ResponseEntity<List<AgentRatingDTO>>(agentRatingDTOs, HttpStatus.OK);
	}


	@RequestMapping(value = "/{userID}/comments", method = RequestMethod.GET)
	public ResponseEntity<List<RealEstateCommentDTO>> getUserComments(@PathVariable Integer userID) {

		User user = userService.findById(userID);

		Set<RealEstateComment> comments = user.getComments();

		List<RealEstateCommentDTO> commentDTOs = new ArrayList<RealEstateCommentDTO>();

		for (RealEstateComment realEstateComment : comments) {
			RealEstateCommentDTO realEstateCommentDTO = new RealEstateCommentDTO(realEstateComment);
			commentDTOs.add(realEstateCommentDTO);
		}

		return new ResponseEntity<List<RealEstateCommentDTO>>(commentDTOs, HttpStatus.OK);
	}


	@RequestMapping(value = "/{userID}/ratingsForEstates", method = RequestMethod.GET)
	public ResponseEntity<List<RealEstateRatingDTO>> getUserRatingsForRealEstate(@PathVariable Integer userID) {

		User user = userService.findById(userID);

		Set<RealEstateRating> ratings = user.getRatings();

		List<RealEstateRatingDTO> ratingDTOs = new ArrayList<RealEstateRatingDTO>();

		for (RealEstateRating realEstateRating : ratings) {
			RealEstateRatingDTO realEstateRatingDTO = new RealEstateRatingDTO(realEstateRating);
			ratingDTOs.add(realEstateRatingDTO);
		}

		return new ResponseEntity<List<RealEstateRatingDTO>>(ratingDTOs, HttpStatus.OK);
	}


	@RequestMapping(value = "/{userID}/reports", method = RequestMethod.GET)
	public ResponseEntity<List<RealEstateReportDTO>> getUserReports(@PathVariable Integer userID) {

		User user = userService.findById(userID);

		Set<RealEstateReport> reports = user.getReports();

		List<RealEstateReportDTO> reportDTOs = new ArrayList<RealEstateReportDTO>();

		for (RealEstateReport realEstateReport : reports) {
			RealEstateReportDTO realEstateReportDTO = new RealEstateReportDTO(realEstateReport);
			reportDTOs.add(realEstateReportDTO);
		}
		return new ResponseEntity<List<RealEstateReportDTO>>(reportDTOs, HttpStatus.OK);
	}



	//@RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<UserDTO> registration(@RequestBody UserDTO userDTO) {

		User user = new User();

		user.setEmail(userDTO.getEmail());
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		
		UserDTO newUserDTO = new UserDTO(user);

		userService.save(user);
		
		return new ResponseEntity<UserDTO>(newUserDTO, HttpStatus.CREATED);

	}

	@RequestMapping(value = "/{username}/{password}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> login(@PathVariable String username, @PathVariable String password) {

		User user = userService.findByUsernameAndPassword(username, password);

		UserDTO userDTO = new UserDTO(user);

		return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);

	}


	public UserDTO getCurrentUser() {
		List<User> users = userService.findAll();
		UserDTO userDTO = new UserDTO();
		for (User user : users) {
			if(user.isLoged()) {
				new UserDTO(user);
			}
		}

		return userDTO;
	}

}
