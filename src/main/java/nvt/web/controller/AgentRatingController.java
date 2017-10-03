package nvt.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nvt.beans.Agent;
import nvt.beans.AgentRating;
import nvt.beans.User;
import nvt.service.AgentRatingService;
import nvt.service.AgentService;
import nvt.service.UserService;
import nvt.util.Util;
import nvt.web.dto.AgentDTO;
import nvt.web.dto.AgentRatingDTO;
import nvt.web.dto.helper.AgentRatingsResponseDTO;
import nvt.web.dto.helper.CreateAgentRateRequestDTO;
import nvt.web.dto.helper.RatingsResponseDTO;

@RestController
@RequestMapping(value = "api/agentRatings")
public class AgentRatingController {

	@Autowired
	protected AgentRatingService agentRatingService;
	
	@Autowired
	protected AgentService agentService;
	
	@Autowired
	protected UserService userService;
	
	
	
	@RequestMapping(
			value = "/create", 
			method = RequestMethod.POST, 
			consumes = "application/json"
			)
	public ResponseEntity<AgentRatingsResponseDTO> createRatings(@RequestBody CreateAgentRateRequestDTO createRateRequest,  @RequestHeader("X-Auth-Token") String token) {
	
		int id = createRateRequest.getAgentId();
		int rate = createRateRequest.getRate();
		
	
		if(agentService.findById(id) != null && userService.findByToken(token) != null) {
	
			Agent agent = agentService.findById(id);
			List<AgentRatingDTO> aDTO = new ArrayList<AgentRatingDTO>();
			
			for (AgentRating a : agent.getAgentRatings()) {
				aDTO.add(new AgentRatingDTO(a));
			}
	
			User user = userService.findByToken(token);
			AgentRating rating = new AgentRating();
			
			rating.setRate(rate);
			rating.setPosted(new Date());
			rating.setAgent(agent);
			rating.setUser(user);
			agentRatingService.save(rating);
	
			Set<AgentRating> agentRatings = agent.getAgentRatings();
			agentRatings.add(rating);
			agent.setAgentRatings(agentRatings);
	
			agentService.save(agent);
		
			RatingsResponseDTO ratings = Util.agentRatings(agent);
	
			AgentRatingsResponseDTO agentRatingsResponseDTO = new AgentRatingsResponseDTO();
			agentRatingsResponseDTO.setAgent(new AgentDTO(agent));
			agentRatingsResponseDTO.setRatings(ratings);
			return new ResponseEntity<AgentRatingsResponseDTO>(agentRatingsResponseDTO, HttpStatus.CREATED);
	
		} else {
			return new ResponseEntity<AgentRatingsResponseDTO>(HttpStatus.NOT_FOUND);
		}
	
	
	}


	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AgentRatingDTO>> getAgentRatings() {
		
		List<AgentRating> agentRatings = agentRatingService.findAll();
		
		List<AgentRatingDTO> agentRatingDTOs = new ArrayList<AgentRatingDTO>();		
		for (AgentRating agentRating : agentRatings) {
			AgentRatingDTO agentRatingDTO =  new AgentRatingDTO(agentRating);
			agentRatingDTOs.add(agentRatingDTO);
		}
		
		return new ResponseEntity<List<AgentRatingDTO>>(agentRatingDTOs, HttpStatus.OK);
	}
	
	
}
