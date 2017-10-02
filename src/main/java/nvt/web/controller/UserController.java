package nvt.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nvt.beans.Agent;
import nvt.beans.RealEstate;
import nvt.beans.RealEstateComment;
import nvt.beans.RealEstateRating;
import nvt.beans.RealEstateReport;
import nvt.beans.User;
import nvt.conf.TokenUtils;
import nvt.repository.ImageRepository;
import nvt.service.AgentService;
import nvt.service.CompanyService;
import nvt.service.RealEstateService;
import nvt.service.UserService;
import nvt.web.dto.AgentDTO;
import nvt.web.dto.RealEstateCommentDTO;
import nvt.web.dto.RealEstateDTO;
import nvt.web.dto.RealEstateRatingDTO;
import nvt.web.dto.RealEstateReportDTO;
import nvt.web.dto.UserDTO;
import nvt.web.dto.helper.LoginResponseDTO;
import nvt.web.dto.helper.RegistrationDTO;

@RestController
@RequestMapping(value = "api/users")
public class UserController {

	@Autowired
	protected UserService userService;
	
	@Autowired
	protected AgentService agentService;
	
	@Autowired
	protected CompanyService companyService;

	@Autowired
	protected RealEstateService realEstateService;

	@Autowired
	protected ImageRepository imageRepository;

	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	TokenUtils tokenUtils;


	@RequestMapping(
			value = "/registration",
			method = RequestMethod.POST,
			consumes = "application/json")
	public ResponseEntity<AgentDTO> registration(@RequestBody RegistrationDTO userDTO) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		Agent agent = new Agent();

		if (userService.findByUsername(userDTO.getUsername()) == null
				|| userService.findByEmail(userDTO.getEmail()) == null) {

			
			if (userDTO.getPassword().equals(userDTO.getRepeated_password())) {

				agent.setName(userDTO.getName());
				agent.setLastName(userDTO.getLastName());
				agent.setEmail(userDTO.getEmail());
				agent.setUsername(userDTO.getUsername());
				agent.setPassword(encoder.encode(userDTO.getPassword()));

				if(userDTO.getCompanyId() != -1) {
					agent.setCompany(companyService.findById(userDTO.getCompanyId()));
				} 
				AgentDTO agentDTO = new AgentDTO(agent);
				return new ResponseEntity<AgentDTO>(agentDTO, HttpStatus.OK);
				
			}
			return new ResponseEntity<AgentDTO>(HttpStatus.BAD_REQUEST);

		} else {

			return new ResponseEntity<AgentDTO>(HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(
			value = "/login", 
			method = RequestMethod.POST,
			consumes = "application/json")
	public ResponseEntity<LoginResponseDTO> login(@RequestBody UserDTO userDTO) {

		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
				userDTO.getUsername(), userDTO.getPassword());

		Authentication authentication = authenticationManager.authenticate(token);

		SecurityContextHolder.getContext().setAuthentication(authentication);
		UserDetails details = userDetailsService.loadUserByUsername(userDTO.getUsername());

		String userToken = tokenUtils.generateToken(details);

		User user = userService.findByToken(userToken);

		LoginResponseDTO loginResponseDTO = new LoginResponseDTO(new UserDTO(user), userToken);

		return new ResponseEntity<LoginResponseDTO>(loginResponseDTO, HttpStatus.OK);

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




	@RequestMapping(
			value = "/realEstates", 
			method = RequestMethod.POST, 
			consumes = "application/json"
			)
	public ResponseEntity<List<RealEstateDTO>> getRealEstates(@RequestHeader("X-Auth-Token") String token) {

		if(userService.findByToken(token) != null) {

			User user = userService.findByToken(token);

			Set<RealEstate> realEstateSet = user.getRealEstates();
			List<RealEstateDTO> realEstatesDTO = new ArrayList<RealEstateDTO>();
			
			for (RealEstate realEstate : realEstateSet) {
				RealEstateDTO realEstateDTO = new RealEstateDTO(realEstate);
				realEstatesDTO.add(realEstateDTO);
			}
			return new ResponseEntity<List<RealEstateDTO>>(realEstatesDTO, HttpStatus.OK);

		}
		return new ResponseEntity<List<RealEstateDTO>>(HttpStatus.NOT_FOUND);

	}

	@RequestMapping(
			value = "/{id}/realEstates", 
			method = RequestMethod.GET
			)
	public ResponseEntity<List<RealEstateDTO>> getUserRealEstates(@PathVariable Integer id) {

		if(userService.findById(id) != null) {

			User user = userService.findById(id);

			if(user.getRealEstates() == null) {
				return new ResponseEntity<List<RealEstateDTO>>(HttpStatus.NOT_FOUND);
			}
			Set<RealEstate> realEstateSet = user.getRealEstates();
			List<RealEstateDTO> realEstatesDTO = new ArrayList<RealEstateDTO>();
			
			for (RealEstate realEstate : realEstateSet) {
				RealEstateDTO realEstateDTO = new RealEstateDTO(realEstate);
				realEstatesDTO.add(realEstateDTO);
			}
			return new ResponseEntity<List<RealEstateDTO>>(realEstatesDTO, HttpStatus.OK);

		}
		return new ResponseEntity<List<RealEstateDTO>>(HttpStatus.NOT_FOUND);

	}
	
	@RequestMapping(
			value = "/{id}/comments", 
			method = RequestMethod.GET
			)
	public ResponseEntity<List<RealEstateCommentDTO>> getUserComments(@PathVariable Integer id) {

		if(userService.findById(id) != null) {

			User user = userService.findById(id);

			if(user.getComments() == null) {
				return new ResponseEntity<List<RealEstateCommentDTO>>(HttpStatus.NOT_FOUND);
			}
			Set<RealEstateComment> commentsSet = user.getComments();
			List<RealEstateCommentDTO> realEstateCommentsDTO = new ArrayList<RealEstateCommentDTO>();
			
			for (RealEstateComment comment : commentsSet) {
				RealEstateCommentDTO commentDTO = new RealEstateCommentDTO(comment);
				realEstateCommentsDTO.add(commentDTO);
			}
			return new ResponseEntity<List<RealEstateCommentDTO>>(realEstateCommentsDTO, HttpStatus.OK);

		}
		return new ResponseEntity<List<RealEstateCommentDTO>>(HttpStatus.NOT_FOUND);

	}

	@RequestMapping(
			value = "/{id}/reports", 
			method = RequestMethod.GET
			)
	public ResponseEntity<List<RealEstateReportDTO>> getUserReports(@PathVariable Integer id) {

		if(userService.findById(id) != null) {

			User user = userService.findById(id);

			if(user.getReports() == null) {
				return new ResponseEntity<List<RealEstateReportDTO>>(HttpStatus.NOT_FOUND);
			}
			Set<RealEstateReport> reportSet = user.getReports();
			List<RealEstateReportDTO> reportsDTO = new ArrayList<RealEstateReportDTO>();
			
			for (RealEstateReport report : reportSet) {
				RealEstateReportDTO reportDTO = new RealEstateReportDTO(report);
				reportsDTO.add(reportDTO);
			}
			return new ResponseEntity<List<RealEstateReportDTO>>(reportsDTO, HttpStatus.OK);

		}
		return new ResponseEntity<List<RealEstateReportDTO>>(HttpStatus.NOT_FOUND);

	}
	
	@RequestMapping(
			value = "/{id}/ratings", 
			method = RequestMethod.GET
			)
	public ResponseEntity<List<RealEstateRatingDTO>> getUserRatings(@PathVariable Integer id) {

		if(userService.findById(id) != null) {

			User user = userService.findById(id);

			if(user.getRatings() == null) {
				return new ResponseEntity<List<RealEstateRatingDTO>>(HttpStatus.NOT_FOUND);
			}
			Set<RealEstateRating> ratingSet = user.getRatings();
			List<RealEstateRatingDTO> ratingsDTO = new ArrayList<RealEstateRatingDTO>();
			
			for (RealEstateRating rating : ratingSet) {
				RealEstateRatingDTO ratingDTO = new RealEstateRatingDTO(rating);
				ratingsDTO.add(ratingDTO);
			}
			return new ResponseEntity<List<RealEstateRatingDTO>>(ratingsDTO, HttpStatus.OK);

		}
		return new ResponseEntity<List<RealEstateRatingDTO>>(HttpStatus.NOT_FOUND);

	}

	
}
