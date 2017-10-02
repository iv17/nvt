package nvt.web.controller;

import java.util.ArrayList;
import java.util.Date;
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

import nvt.beans.RealEstate;
import nvt.beans.RealEstateComment;
import nvt.beans.RealEstateReport;
import nvt.beans.User;
import nvt.service.RealEstateReportService;
import nvt.service.RealEstateService;
import nvt.service.UserService;
import nvt.web.dto.CreateCommentResponseDTO;
import nvt.web.dto.RealEstateCommentDTO;
import nvt.web.dto.RealEstateDTO;
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
	@RequestMapping(
			value = "/create", 
			method = RequestMethod.POST, 
			consumes = "application/json"
			)
	public ResponseEntity<CreateCommentResponseDTO> createReport(@RequestBody RealEstateDTO r) {

		int id = r.getId();

		if(realEstateService.findById(id) != null) {

			RealEstate realEstate = realEstateService.findById(id);
			List<RealEstateCommentDTO> cDTO = new ArrayList<RealEstateCommentDTO>();

			RealEstateReport report = new RealEstateReport();
			report.setPosted(new Date());
			report.setRealEstate(realEstate);
			//report.setUser(user);

			realEstateReportService.save(report);
			
			Set<RealEstateReport> reports = realEstate.getReports();
			reports.add(report);
			
			realEstate.setReports(reports);
			realEstateService.save(realEstate);
			
			
			RealEstateDTO realEstateDTO = new RealEstateDTO(realEstate);

			Set<RealEstateComment> comments = realEstate.getComments();
			List<RealEstateCommentDTO> commentsDTO = new ArrayList<RealEstateCommentDTO>();
			for (RealEstateComment comm : comments) {
				RealEstateCommentDTO commentDTO = new RealEstateCommentDTO(comm);
				commentsDTO.add(commentDTO);
			}

			CreateCommentResponseDTO createCommentResponseDTO = new CreateCommentResponseDTO(realEstateDTO, commentsDTO);
			return new ResponseEntity<CreateCommentResponseDTO>(createCommentResponseDTO, HttpStatus.CREATED);

		} else {
			return new ResponseEntity<CreateCommentResponseDTO>(HttpStatus.NOT_FOUND);
		}


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
