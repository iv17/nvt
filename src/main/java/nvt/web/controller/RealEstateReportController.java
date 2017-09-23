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

import nvt.beans.RealEstate;
import nvt.beans.RealEstateReport;
import nvt.beans.User;
import nvt.service.RealEstateReportService;
import nvt.service.RealEstateService;
import nvt.service.UserService;
import nvt.web.dto.RealEstateReportDTO;

@RestController
@RequestMapping(value = "api/realEstateReports")
public class RealEstateReportController {

	@Autowired
	protected RealEstateReportService realEstateReportService;

	@Autowired
	protected RealEstateService realEstateService;

	@Autowired 
	UserService userService;



	//prijava oglasa kao neprikladnog

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<RealEstateReportDTO> createReport(@RequestBody RealEstateReportDTO realEstateReportDTO) {

		RealEstateReport realEstateReport = realEstateReportService.findById(realEstateReportDTO.getId());

		realEstateReport.setReport(realEstateReportDTO.getReport());
		realEstateReport.setPosted(realEstateReportDTO.getPosted());

		RealEstate realEstate = realEstateService.findById(realEstateReportDTO.getRealEstate().getId());
		if(realEstate == null) {

		}
		realEstateReport.setRealEstate(realEstate);

		User user = userService.findById(realEstateReportDTO.getUser().getId());
		if(user == null) {

		}
		realEstateReport.setUser(user);

		realEstateService.save(realEstate);

		RealEstateReportDTO newRealEstateReportDTO = new RealEstateReportDTO(realEstateReport);

		return new ResponseEntity<RealEstateReportDTO>(newRealEstateReportDTO, HttpStatus.OK);
	}


	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<RealEstateReportDTO>> getRealEstateReports() {

		List<RealEstateReport> realEstateReports = realEstateReportService.findAll();

		List<RealEstateReportDTO> realEstateReportDTOs = new ArrayList<>();
		for (RealEstateReport realEstateReport : realEstateReports) {
			RealEstateReportDTO realEstateReportDTO = new RealEstateReportDTO(realEstateReport);
			realEstateReportDTOs.add(realEstateReportDTO);
		}

		return new ResponseEntity<List<RealEstateReportDTO>>(realEstateReportDTOs, HttpStatus.OK);
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<RealEstateReportDTO> getRealEstateReport(@PathVariable Integer id){

		RealEstateReport realEstateReport = realEstateReportService.findById(id);

		if(realEstateReport == null){
			return new ResponseEntity<RealEstateReportDTO>(HttpStatus.NOT_FOUND);
		}
		RealEstateReportDTO realEstateReportDTO = new RealEstateReportDTO(realEstateReport);

		return new ResponseEntity<RealEstateReportDTO>(realEstateReportDTO, HttpStatus.OK);
	}

}
