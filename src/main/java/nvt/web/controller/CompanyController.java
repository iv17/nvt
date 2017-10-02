package nvt.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nvt.beans.Company;
import nvt.beans.RealEstate;
import nvt.beans.RealEstateComment;
import nvt.beans.RealEstateRating;
import nvt.beans.RealEstateReport;
import nvt.service.AgentService;
import nvt.service.CompanyService;
import nvt.service.ImageService;
import nvt.service.LocationService;
import nvt.service.WorkingTimeService;
import nvt.web.dto.CompanyDTO;
import nvt.web.dto.RealEstateCommentDTO;
import nvt.web.dto.RealEstateDTO;
import nvt.web.dto.RealEstateRatingDTO;
import nvt.web.dto.RealEstateReportDTO;

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
	
	
	@RequestMapping(
			value = "/registration",
			method = RequestMethod.POST,
			consumes = "application/json")
	public ResponseEntity<CompanyDTO> registration(@RequestBody CompanyDTO companyDTO) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		Company company = new Company();
		if (companyService.findByUsername(companyDTO.getUsername()) == null) {

			
			if (companyDTO.getPassword().equals(companyDTO.getRepeated_password())) {

				company.setPropertyNo(companyDTO.getPropertyNo());
				company.setEmail(companyDTO.getEmail());
				company.setUsername(companyDTO.getUsername());
				company.setWebAddress(companyDTO.getWebAddress());
				company.setPhoneNumber(companyDTO.getPhoneNumber());
				company.setPassword(encoder.encode(companyDTO.getPassword()));
				
				CompanyDTO newcompanyDTO = new CompanyDTO(company);

				companyService.save(company);

				return new ResponseEntity<CompanyDTO>(newcompanyDTO, HttpStatus.CREATED);
			}
			return new ResponseEntity<CompanyDTO>(HttpStatus.BAD_REQUEST);

		} else {

			return new ResponseEntity<CompanyDTO>(HttpStatus.BAD_REQUEST);
		}

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

	
	@RequestMapping(
			value = "/{id}/realEstates", 
			method = RequestMethod.GET
			)
	public ResponseEntity<List<RealEstateDTO>> getCompanyRealEstates(@PathVariable Integer id) {

		if(companyService.findById(id) != null) {

			Company company = companyService.findById(id);

			if(company.getRealEstates() == null) {
				return new ResponseEntity<List<RealEstateDTO>>(HttpStatus.NOT_FOUND);
			}
			Set<RealEstate> realEstateSet = company.getRealEstates();
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

		if(companyService.findById(id) != null) {

			Company company = companyService.findById(id);

			if(company.getComments() == null) {
				return new ResponseEntity<List<RealEstateCommentDTO>>(HttpStatus.NOT_FOUND);
			}
			Set<RealEstateComment> commentsSet = company.getComments();
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

		if(companyService.findById(id) != null) {

			Company company = companyService.findById(id);

			if(company.getReports() == null) {
				return new ResponseEntity<List<RealEstateReportDTO>>(HttpStatus.NOT_FOUND);
			}
			Set<RealEstateReport> reportSet = company.getReports();
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

		if(companyService.findById(id) != null) {

			Company company = companyService.findById(id);

			if(company.getRatings() == null) {
				return new ResponseEntity<List<RealEstateRatingDTO>>(HttpStatus.NOT_FOUND);
			}
			Set<RealEstateRating> ratingSet = company.getRatings();
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
