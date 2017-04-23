package nvt.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nvt.beans.Agent;
import nvt.beans.AgentRating;
import nvt.beans.User;
import nvt.service.AgentRatingService;
import nvt.service.AgentService;
import nvt.service.UserService;
import nvt.web.dto.AgentRatingDTO;

@RestController
@RequestMapping(value = "api/agentRatings")
public class AgentRatingController {

	@Autowired
	protected AgentRatingService agentRatingService;
	
	@Autowired
	protected AgentService agentService;
	
	@Autowired
	protected UserService userService;
	
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<AgentRatingDTO> createAgentRating(@RequestBody AgentRatingDTO agentRatingDTO) {
		
		AgentRating agentRating = new AgentRating();
		agentRating.setRate(agentRatingDTO.getRate());
		agentRating.setPosted(agentRatingDTO.getPosted());
		
		Agent agent = agentService.findById(agentRatingDTO.getAgent().getId());
		if(agent == null) {
			
		}
		agentRating.setAgent(agent);
		
		User user = userService.findById(agentRatingDTO.getUser().getId());
		if(user == null) {
			return new ResponseEntity<AgentRatingDTO>(HttpStatus.BAD_REQUEST);
		}
		agentRating.setUser(user);
		
		agentRatingService.save(agentRating);
		
		AgentRatingDTO newAgentRatingDTO = new AgentRatingDTO(agentRating);
		
		return new ResponseEntity<AgentRatingDTO>(newAgentRatingDTO, HttpStatus.CREATED);
	}


	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AgentRatingDTO>> getAgentRatings() {
		
		List<AgentRating> agentRatings = agentRatingService.findAll();
		
		List<AgentRatingDTO> agentRatingDTOs = new ArrayList<AgentRatingDTO>();
		for (AgentRating agentRating : agentRatings) {
			AgentRatingDTO agentRatingDTO = new AgentRatingDTO(agentRating);
			agentRatingDTOs.add(agentRatingDTO);
		}
		
		return new ResponseEntity<List<AgentRatingDTO>>(agentRatingDTOs, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<AgentRatingDTO> getAgentRating(@PathVariable Integer id) {
		
		AgentRating agentRating  = agentRatingService.findById(id);
		
		if(agentRating == null) {
			return new ResponseEntity<AgentRatingDTO>(HttpStatus.NOT_FOUND);
		}
		AgentRatingDTO agentRatingDTO = new AgentRatingDTO(agentRating);
		
		return new ResponseEntity<AgentRatingDTO>(agentRatingDTO, HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<AgentRatingDTO> updateAgentRating(@RequestBody AgentRatingDTO agentRatingDTO) {
		
		AgentRating agentRating = agentRatingService.findById(agentRatingDTO.getId());
		
		if(agentRating == null) {
			return new ResponseEntity<AgentRatingDTO>(HttpStatus.BAD_REQUEST);
		}
		
		agentRating.setRate(agentRatingDTO.getRate());
		agentRating.setPosted(agentRatingDTO.getPosted());
		
		Agent agent = agentService.findById(agentRatingDTO.getAgent().getId());
		if(agent == null) {
			return new ResponseEntity<AgentRatingDTO>(HttpStatus.BAD_REQUEST);
		}
		agentRating.setAgent(agent);
		
		User user = userService.findById(agentRatingDTO.getUser().getId());
		if(user == null) {
			return new ResponseEntity<AgentRatingDTO>(HttpStatus.BAD_REQUEST);
		}
		agentRating.setUser(user);
		
		agentRatingService.save(agentRating);
		
		AgentRatingDTO newAgentRatingDTO = new AgentRatingDTO(agentRating);
		
		return new ResponseEntity<AgentRatingDTO>(newAgentRatingDTO, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteAgentRating(@PathVariable Integer id) {
		
		AgentRating agentRating = agentRatingService.findById(id);
		
		if(agentRating == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		agentRatingService.removeById(id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
