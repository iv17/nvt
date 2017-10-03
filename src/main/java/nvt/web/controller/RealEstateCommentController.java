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
import nvt.service.RealEstateCommentService;
import nvt.service.RealEstateService;
import nvt.service.UserService;
import nvt.util.Util;
import nvt.web.dto.RealEstateCommentDTO;
import nvt.web.dto.RealEstateDTO;
import nvt.web.dto.RealEstateIndoorsDTO;
import nvt.web.dto.RealEstateOutdoorsDTO;
import nvt.web.dto.RealEstateReportDTO;
import nvt.web.dto.helper.CreateCommentRequestDTO;
import nvt.web.dto.helper.RatingsResponseDTO;
import nvt.web.dto.helper.RealEstateResponseDTO;

@RestController
@RequestMapping(value = "api/realEstateComments")
public class RealEstateCommentController {

	@Autowired
	protected RealEstateCommentService realEstateCommentService;

	@Autowired
	protected RealEstateService realEstateService;

	@Autowired
	protected UserService userService;
	
	

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<RealEstateCommentDTO>> getRealEstateComments() {

		List<RealEstateComment> realEstateComments = realEstateCommentService.findAll();

		List<RealEstateCommentDTO> realEstateCommentDTOs = new ArrayList<RealEstateCommentDTO>();
		for (RealEstateComment realEstateComment : realEstateComments) {
			RealEstateCommentDTO realEstateCommentDTO = new RealEstateCommentDTO(realEstateComment);
			realEstateCommentDTOs.add(realEstateCommentDTO);
		}

		return new ResponseEntity<List<RealEstateCommentDTO>>(realEstateCommentDTOs, HttpStatus.OK);
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<RealEstateCommentDTO> getRealEstateComment(@PathVariable Integer id){

		RealEstateComment realEstateComment = realEstateCommentService.findById(id);

		if(realEstateComment == null){
			return new ResponseEntity<RealEstateCommentDTO>(HttpStatus.NOT_FOUND);
		}
		RealEstateCommentDTO realEstateCommentDTO = new RealEstateCommentDTO(realEstateComment);

		return new ResponseEntity<RealEstateCommentDTO>(realEstateCommentDTO, HttpStatus.OK);
	}

	@RequestMapping(
			value = "/create", 
			method = RequestMethod.POST, 
			consumes = "application/json"
			)
	public ResponseEntity<RealEstateResponseDTO> createComment(@RequestBody CreateCommentRequestDTO createCommentRequest, @RequestHeader("X-Auth-Token") String token) {

		int id = createCommentRequest.getRealEstateId();
		String text = createCommentRequest.getText();

		if(userService.findByToken(token) != null ) {
			
			User user = userService.findByToken(token);
			
			if(realEstateService.findById(id) != null ) {

				RealEstate realEstate = realEstateService.findById(id);
				List<RealEstateCommentDTO> cDTO = new ArrayList<RealEstateCommentDTO>();

				for (RealEstateComment c : realEstate.getComments()) {
					cDTO.add(new RealEstateCommentDTO(c));
				}

				RealEstateComment comment = new RealEstateComment();
				comment.setComment(text);
				comment.setRealEstate(realEstate);
				comment.setUser(user);
				comment.setPosted(new Date());

				realEstateCommentService.save(comment); 	
				Set<RealEstateComment> realEstateComments = realEstate.getComments();
				realEstateComments.add(comment);	

				realEstate.setComments(realEstateComments);
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

}
