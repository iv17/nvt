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
import nvt.beans.RealEstateIndoors;
import nvt.beans.RealEstateOutdoors;
import nvt.beans.RealEstateRating;
import nvt.beans.RealEstateReport;
import nvt.service.RealEstateRatingService;
import nvt.service.RealEstateService;
import nvt.service.UserService;
import nvt.util.Util;
import nvt.web.dto.RealEstateCommentDTO;
import nvt.web.dto.RealEstateDTO;
import nvt.web.dto.RealEstateIndoorsDTO;
import nvt.web.dto.RealEstateOutdoorsDTO;
import nvt.web.dto.RealEstateRatingDTO;
import nvt.web.dto.RealEstateReportDTO;
import nvt.web.dto.helper.CreateRateRequestDTO;
import nvt.web.dto.helper.RatingsResponseDTO;
import nvt.web.dto.helper.RealEstateResponseDTO;

@RestController
@RequestMapping(value = "api/realEstateRatings")
public class RealEstateRatingController {

	@Autowired
	protected RealEstateRatingService realEstateRatingService;
	
	@Autowired
	protected RealEstateService realEstateService;
	
	@Autowired
	protected UserService userService;
	
	
	
	@RequestMapping(
			value = "/create", 
			method = RequestMethod.POST, 
			consumes = "application/json"
			)
	public ResponseEntity<RealEstateResponseDTO> createRatings(@RequestBody CreateRateRequestDTO createRateRequest) {
	
		int id = createRateRequest.getRealEstateId();
		int rate = createRateRequest.getRate();
		
	
		if(realEstateService.findById(id) != null) {
	
			RealEstate realEstate = realEstateService.findById(id);
			List<RealEstateRatingDTO> rDTO = new ArrayList<RealEstateRatingDTO>();
	
			for (RealEstateRating r : realEstate.getRatings()) {
				rDTO.add(new RealEstateRatingDTO(r));
			}
	
			
			RealEstateRating rating = new RealEstateRating();
			rating.setRate(rate);
			rating.setPosted(new Date());
			rating.setRealEstate(realEstate);
			//rating.setUser(user);
			realEstateRatingService.save(rating);
	
			Set<RealEstateRating> realEstateRatings = realEstate.getRatings();
			realEstateRatings.add(rating);
			realEstate.setRatings(realEstateRatings);
	
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
	
	
	}


	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<RealEstateRatingDTO>> getRealEstateRatings() {
		
		List<RealEstateRating> realEstateRatings = realEstateRatingService.findAll();
		
		List<RealEstateRatingDTO> realEstateRatingDTOs = new ArrayList<RealEstateRatingDTO>();		
		for (RealEstateRating realEstateRating : realEstateRatings) {
			RealEstateRatingDTO realEstateRatingDTO =  new RealEstateRatingDTO(realEstateRating);
			realEstateRatingDTOs.add(realEstateRatingDTO);
		}
		
		return new ResponseEntity<List<RealEstateRatingDTO>>(realEstateRatingDTOs, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<RealEstateRatingDTO> getRealEstateRating(@PathVariable Integer id){
		
		RealEstateRating realEstateRating = realEstateRatingService.findById(id);
		
		if(realEstateRating == null){
			return new ResponseEntity<RealEstateRatingDTO>(HttpStatus.NOT_FOUND);
		}
		RealEstateRatingDTO realEstateRatingDTO = new RealEstateRatingDTO(realEstateRating);
		
		return new ResponseEntity<RealEstateRatingDTO>(realEstateRatingDTO, HttpStatus.OK);
	}
	
}
