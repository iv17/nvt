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

import nvt.beans.Company;
import nvt.beans.Location;
import nvt.beans.WorkingTime;
import nvt.service.AgentService;
import nvt.service.CompanyService;
import nvt.service.ImageService;
import nvt.service.LocationService;
import nvt.service.WorkingTimeService;
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
	public ResponseEntity<CompanyDTO> registerCompany(@RequestBody CompanyDTO companyDTO) {

		Company company = new Company();
		company.setName(companyDTO.getName());
		company.setPassword(companyDTO.getPassword());
		company.setPropertyNo(companyDTO.getPropertyNo());
		company.setPhoneNumber(companyDTO.getPhoneNumber());
		company.setWebAddress(companyDTO.getWebAddress());

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

}
