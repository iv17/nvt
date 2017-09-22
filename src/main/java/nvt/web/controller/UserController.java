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

import nvt.beans.RealEstate;
import nvt.beans.User;
import nvt.conf.TokenUtils;
import nvt.repository.ImageRepository;
import nvt.service.AgentRatingService;
import nvt.service.UserService;
import nvt.web.dto.LoginResponseDTO;
import nvt.web.dto.RealEstateDTO;
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

	//====================Security====================
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	TokenUtils tokenUtils;
	//====================Security====================




	@RequestMapping(
			value = "/registration",
			method = RequestMethod.POST,
			consumes = "application/json")
	public ResponseEntity<UserDTO> registration(@RequestBody UserDTO userDTO) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		User user = new User();

		if (userService.findByUsername(userDTO.getUsername()) == null
				|| userService.findByEmail(userDTO.getEmail()) == null) {

			
			if (userDTO.getPassword().equals(userDTO.getRepeated_password())) {

				user.setName(userDTO.getName());
				user.setLastName(userDTO.getLastName());
				user.setEmail(userDTO.getEmail());
				user.setUsername(userDTO.getUsername());
				user.setPassword(encoder.encode(userDTO.getPassword()));

				UserDTO newUserDTO = new UserDTO(user);

				userService.save(user);

				return new ResponseEntity<UserDTO>(newUserDTO, HttpStatus.CREATED);
			}
			return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);

		} else {

			return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
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
			value = "/realEstates", // id - id user-a ciji su snippeti
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





}
