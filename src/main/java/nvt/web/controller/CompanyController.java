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

import nvt.beans.Agent;
import nvt.beans.Company;
import nvt.beans.Image;
import nvt.beans.Location;
import nvt.beans.WorkingTime;
import nvt.service.AgentService;
import nvt.service.CompanyService;
import nvt.service.ImageService;
import nvt.service.LocationService;
import nvt.service.WorkingTimeService;
import nvt.web.dto.AgentDTO;
import nvt.web.dto.CompanyDTO;

@RestController
@RequestMapping(value = "api/companies")
public class CompanyController {

	@Autowired 
	protected CompanyService companyService;

	@Autowired
	protected AgentService agentService;

	@Autowired
	protected LocationService locationService;

	@Autowired
	protected WorkingTimeService workingTimeService;

	@Autowired
	protected ImageService imageService;
	
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<CompanyDTO> createCompany(@RequestBody CompanyDTO companyDTO) {

		Company company = new Company();
		company.setName(companyDTO.getName());
		company.setPassword(companyDTO.getPassword());
		company.setPropertyNo(companyDTO.getPropertyNo());
		company.setPhoneNumber(companyDTO.getPhoneNumber());
		company.setWebAddress(companyDTO.getWebAddress());

		Image image = imageService.findById(companyDTO.getImage().getId());
		if(image == null) {
			return new ResponseEntity<CompanyDTO>(HttpStatus.NOT_FOUND);
		}
		company.setImage(image);
		
		Location location = locationService.findById(companyDTO.getLocation().getId());
		if(location == null) {
			return new ResponseEntity<CompanyDTO>(HttpStatus.NOT_FOUND);
		}
		company.setLocation(location);

		WorkingTime workingTime = workingTimeService.findById(companyDTO.getWorkingTime().getId());
		if(workingTime == null) {
			return new ResponseEntity<CompanyDTO>(HttpStatus.NOT_FOUND);
		}
		company.setWorkingTime(workingTime);

		CompanyDTO newCompanyDTO = new CompanyDTO(company);

		company = companyService.save(company);

		return new ResponseEntity<CompanyDTO>(newCompanyDTO, HttpStatus.CREATED);

	}


	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CompanyDTO>> getCompanies() {

		List<Company> companies = companyService.findAll();

		List<CompanyDTO> companyDTOs = new ArrayList<CompanyDTO>();
		for (Company company : companies) {
			CompanyDTO companyDTO = new CompanyDTO(company);
			companyDTOs.add(companyDTO);
		}

		return new ResponseEntity<List<CompanyDTO>>(companyDTOs, HttpStatus.OK);
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<CompanyDTO> getCompany(@PathVariable Integer id) {

		Company company = companyService.findById(id);

		if(company == null) {
			return new ResponseEntity<CompanyDTO>(HttpStatus.NOT_FOUND);
		}
		CompanyDTO companyDTO = new CompanyDTO(company);

		return new ResponseEntity<CompanyDTO>(companyDTO, HttpStatus.OK);
	}


	//@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<CompanyDTO> saveCompany(@RequestBody CompanyDTO companyDTO) {

		Company company = new Company();
		company.setName(companyDTO.getName());
		company.setPassword(companyDTO.getPassword());
		company.setPropertyNo(companyDTO.getPropertyNo());
		company.setPhoneNumber(companyDTO.getPhoneNumber());
		company.setWebAddress(companyDTO.getWebAddress());

		Image image = imageService.findById(companyDTO.getImage().getId());
		if(image == null) {
			return new ResponseEntity<CompanyDTO>(HttpStatus.NOT_FOUND);
		}
		company.setImage(image);
		
		Location location = locationService.findById(companyDTO.getLocation().getId());
		if(location == null) {
			return new ResponseEntity<CompanyDTO>(HttpStatus.NOT_FOUND);
		}
		company.setLocation(location);

		WorkingTime workingTime = workingTimeService.findById(companyDTO.getWorkingTime().getId());
		if(workingTime == null) {
			return new ResponseEntity<CompanyDTO>(HttpStatus.NOT_FOUND);
		}
		company.setWorkingTime(workingTime);

		CompanyDTO newCompanyDTO = new CompanyDTO(company);

		companyService.save(company);

		return new ResponseEntity<CompanyDTO>(newCompanyDTO, HttpStatus.CREATED);
	}


	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<CompanyDTO> updateCompany(@RequestBody CompanyDTO companyDTO) {

		Company company = companyService.findById(companyDTO.getId());

		if(company == null) {
			return new ResponseEntity<CompanyDTO>(HttpStatus.BAD_REQUEST);
		}

		company.setName(companyDTO.getName());
		company.setPassword(companyDTO.getPassword());
		company.setPropertyNo(companyDTO.getPropertyNo());
		company.setPhoneNumber(companyDTO.getPhoneNumber());
		company.setWebAddress(companyDTO.getWebAddress());

		Image image = imageService.findById(companyDTO.getImage().getId());
		if(image == null) {
			return new ResponseEntity<CompanyDTO>(HttpStatus.NOT_FOUND);
		}
		company.setImage(image);
		
		Location location = locationService.findById(companyDTO.getLocation().getId());
		if(location == null) {
			return new ResponseEntity<CompanyDTO>(HttpStatus.NOT_FOUND);
		}
		company.setLocation(location);

		WorkingTime workingTime = workingTimeService.findById(companyDTO.getWorkingTime().getId());
		if(workingTime == null) {
			return new ResponseEntity<CompanyDTO>(HttpStatus.NOT_FOUND);
		}
		company.setWorkingTime(workingTime);

		CompanyDTO newCompanyDTO = new CompanyDTO(company);

		company = companyService.save(company);

		return new ResponseEntity<CompanyDTO>(newCompanyDTO, HttpStatus.CREATED);

	}


	@RequestMapping(value = "/{id}/agents", method = RequestMethod.GET)
	public ResponseEntity<List<AgentDTO>> getAgents(@PathVariable Integer id) {

		Company company = companyService.findById(id);
		Set<Agent> agents = company.getAgents();

		List<AgentDTO> agentDTOs = new ArrayList<AgentDTO>();
		for (Agent agent : agents) {
			AgentDTO agentDTO = new AgentDTO(agent);
			agentDTOs.add(agentDTO);
		}

		return new ResponseEntity<List<AgentDTO>>(agentDTOs, HttpStatus.OK);

	}

	@RequestMapping(value = "/{id}/{agentId}", method = RequestMethod.PUT)
	public ResponseEntity<List<AgentDTO>> addAgent(@PathVariable Integer id, @PathVariable Integer agentId) {

		Company company = companyService.findById(id);
		
		Set<Agent> agents = company.getAgents();
		if(agents.contains(agentService.findById(agentId))) {
			return new ResponseEntity<List<AgentDTO>>(HttpStatus.BAD_REQUEST);
		}
		Agent agent = agentService.findById(agentId);
		agents.add(agent);
		
		company.setAgents(agents);
		
		List<AgentDTO> agentDTOs = new ArrayList<AgentDTO>();
		for (Agent a : agents) {
			AgentDTO newAgentDTO = new AgentDTO(a);
			agentDTOs.add(newAgentDTO);
		}
		
		companyService.save(company);
		
		return new ResponseEntity<List<AgentDTO>>(agentDTOs, HttpStatus.OK);

	}
}
