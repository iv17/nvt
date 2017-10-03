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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nvt.beans.RealEstate;
import nvt.beans.RealEstateComment;
import nvt.beans.RealEstateIndoors;
import nvt.beans.RealEstateOutdoors;
import nvt.beans.RealEstateReport;
import nvt.beans.User;
import nvt.service.RealEstateReportService;
import nvt.service.RealEstateService;
import nvt.service.UserService;
import nvt.util.Util;
import nvt.web.dto.RealEstateCommentDTO;
import nvt.web.dto.RealEstateDTO;
import nvt.web.dto.RealEstateIndoorsDTO;
import nvt.web.dto.RealEstateOutdoorsDTO;
import nvt.web.dto.RealEstateReportDTO;
import nvt.web.dto.helper.RatingsResponseDTO;
import nvt.web.dto.helper.RealEstateResponseDTO;

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
	public ResponseEntity<RealEstateResponseDTO> createReport(@RequestBody RealEstateDTO re, @RequestHeader("X-Auth-Token") String token) {

		if(userService.findByToken(token) != null) {

			User user = userService.findByToken(token);

			int id = re.getId();

			if(realEstateService.findById(id) != null) {

				RealEstate realEstate = realEstateService.findById(id);

				RealEstateReport report = new RealEstateReport();
				report.setPosted(new Date());
				report.setRealEstate(realEstate);
				report.setUser(user);

				realEstateReportService.save(report);

				Set<RealEstateReport> allReports = realEstate.getReports();
				allReports.add(report);

				realEstate.setReports(allReports);
				realEstateService.save(realEstate);

				RealEstateDTO realEstateDTO = new RealEstateDTO(realEstate);

				Set<RealEstateComment> comments = realEstate.getComments();
				List<RealEstateCommentDTO> commentsDTO = new ArrayList<RealEstateCommentDTO>();
				for (RealEstateComment c : comments) {
					RealEstateCommentDTO commentDTO = new RealEstateCommentDTO(c);
					commentsDTO.add(commentDTO);
				}

				Set<RealEstateReport> reports = realEstate.getReports();
				List<RealEstateReportDTO> reportsDTO = new ArrayList<RealEstateReportDTO>();
				for (RealEstateReport r : reports) {
					RealEstateReportDTO reportDTO = new RealEstateReportDTO(r);
					reportsDTO.add(reportDTO);
				}
				Set<RealEstateIndoors> indoors = realEstate.getIndoors();
				List<RealEstateIndoorsDTO> indoorsDTO = new ArrayList<RealEstateIndoorsDTO>();
				for (RealEstateIndoors i : indoors) {
					RealEstateIndoorsDTO indoorDTO = new RealEstateIndoorsDTO(i);
					indoorsDTO.add(indoorDTO);
				}
				Set<RealEstateOutdoors> outdoors = realEstate.getOutdoors();
				List<RealEstateOutdoorsDTO> outdoorsDTO = new ArrayList<RealEstateOutdoorsDTO>();
				for (RealEstateOutdoors o : outdoors) {
					RealEstateOutdoorsDTO outdoorDTO = new RealEstateOutdoorsDTO(o);
					outdoorsDTO.add(outdoorDTO);
				}
				RatingsResponseDTO ratings = Util.ratings(realEstate);

				RealEstateResponseDTO realEstateResponseDTO = new RealEstateResponseDTO();
				realEstateResponseDTO.setRealEstate(realEstateDTO);
				realEstateResponseDTO.setComments(commentsDTO);
				realEstateResponseDTO.setReports(reportsDTO);
				realEstateResponseDTO.setIndoors(indoorsDTO);
				realEstateResponseDTO.setOutdoors(outdoorsDTO);
				realEstateResponseDTO.setRatings(ratings);
				return new ResponseEntity<RealEstateResponseDTO>(realEstateResponseDTO, HttpStatus.CREATED);

			} else {
				return new ResponseEntity<RealEstateResponseDTO>(HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<RealEstateResponseDTO>(HttpStatus.BAD_REQUEST);
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
