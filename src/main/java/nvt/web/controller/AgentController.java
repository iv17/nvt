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

import nvt.beans.Advertisement;
import nvt.beans.Agent;
import nvt.beans.AgentRating;
import nvt.beans.Company;
import nvt.beans.Image;
import nvt.service.AgentService;
import nvt.service.CompanyService;
import nvt.service.ImageService;
import nvt.web.dto.AdvertisementDTO;
import nvt.web.dto.AgentDTO;
import nvt.web.dto.AgentRatingDTO;

@RestController
@RequestMapping(value = "api/agents")
public class AgentController {

	@Autowired
	protected AgentService agentService;
	
	@Autowired
	protected CompanyService companyService;
	
	@Autowired 
	protected ImageService imageService;
	
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<AgentDTO> createAgent(@RequestBody AgentDTO agentDTO){
		
		Agent agent = new Agent();
		agent.setEmail(agent.getEmail());
		agent.setUsername(agentDTO.getUsername());
		agent.setPassword(agentDTO.getPassword());
		agent.setName(agentDTO.getName());
		agent.setLastName(agentDTO.getLastName());
		agent.setPhoneNumber(agentDTO.getPhoneNumber());
	
		Image image = imageService.findById(agentDTO.getImageDTO().getId());
		if(image == null) {
			return new ResponseEntity<AgentDTO>(HttpStatus.BAD_REQUEST);
		}
		agent.setImage(image);
		
		Company company = companyService.findById(agentDTO.getCompanyDTO().getId());
		if(company != null) {
			return new ResponseEntity<AgentDTO>(HttpStatus.BAD_REQUEST);
		}
		agent.setCompany(company);
		
		AgentDTO newAgentDTO = new AgentDTO(agent);
		
		agentService.save(agent);
		
		return new ResponseEntity<>(newAgentDTO, HttpStatus.CREATED);	
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AgentDTO>> getAgents() {
		
		List<Agent> agents = agentService.findAll();
		
		List<AgentDTO> agentDTOs = new ArrayList<AgentDTO>();
		for (Agent agent : agents) {
			AgentDTO agentDTO = new AgentDTO(agent);
			agentDTOs.add(agentDTO);
		}
		
		return new ResponseEntity<List<AgentDTO>>(agentDTOs, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<AgentDTO> getAgent(@PathVariable Integer id) {
		
		Agent agent  = agentService.findById(id);
		
		if(agent == null) {
			return new ResponseEntity<AgentDTO>(HttpStatus.NOT_FOUND);
		}
		AgentDTO agentDTO = new AgentDTO(agent);
		
		return new ResponseEntity<AgentDTO>(agentDTO, HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<AgentDTO> updateAgent(@RequestBody AgentDTO agentDTO) {
		
		Agent agent = agentService.findById(agentDTO.getId());		
		
		if(agent == null) {
			return new ResponseEntity<AgentDTO>(HttpStatus.BAD_REQUEST);
		}	
		agent.setEmail(agentDTO.getEmail());
		agent.setUsername(agentDTO.getUsername());
		agent.setPassword(agentDTO.getPassword());
		agent.setName(agentDTO.getName());
		agent.setLastName(agentDTO.getLastName());
		agent.setPhoneNumber(agentDTO.getPhoneNumber());
	
		Image image = imageService.findById(agentDTO.getImageDTO().getId());
		if(image == null) {
			return new ResponseEntity<AgentDTO>(HttpStatus.BAD_REQUEST);
		}
		agent.setImage(image);
	
		Company company = companyService.findById(agentDTO.getCompanyDTO().getId());
		if(company != null) {
			return new ResponseEntity<AgentDTO>(HttpStatus.BAD_REQUEST);
		}
		agent.setCompany(company);
		
		agentService.save(agent);
		
		AgentDTO newAgentDTO = new AgentDTO(agent);
		
		return new ResponseEntity<AgentDTO>(newAgentDTO, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteAgent(@PathVariable Integer id) {
		
		Agent agent = agentService.findById(id);
		
		if(agent == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		agentService.removeById(id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/{id}/advertisements", method = RequestMethod.GET)
	public ResponseEntity<List<AdvertisementDTO>> getAgentAdvertisements(@PathVariable Integer id) {
		
		Agent agent = agentService.findById(id);
		
		Set<Advertisement> advertisements = agent.getAdvertisements();
		
		List<AdvertisementDTO> advertisementDTOs = new ArrayList<AdvertisementDTO>();
		for (Advertisement advertisement : advertisements) {
			AdvertisementDTO advertisementDTO = new AdvertisementDTO(advertisement);
			advertisementDTOs.add(advertisementDTO);
		}
		
		return new ResponseEntity<List<AdvertisementDTO>>(advertisementDTOs, HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value = "/{id}/agentRatings", method = RequestMethod.GET)
	public ResponseEntity<List<AgentRatingDTO>> getAgentRatings(@PathVariable Integer id) {
		
		Agent agent = agentService.findById(id);
		
		Set<AgentRating> agentRatings = agent.getAgentRatings();
		
		List<AgentRatingDTO> agentRatingDTOs = new ArrayList<AgentRatingDTO>();
		for (AgentRating agentRating : agentRatings) {
			AgentRatingDTO agentRatingDTO = new AgentRatingDTO(agentRating);
			agentRatingDTOs.add(agentRatingDTO);
		}
		
		return new ResponseEntity<List<AgentRatingDTO>>(agentRatingDTOs, HttpStatus.OK);
		
	}
	
	
}
