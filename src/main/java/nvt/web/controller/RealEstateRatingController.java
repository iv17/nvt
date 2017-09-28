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
import nvt.beans.RealEstateRating;
import nvt.service.RealEstateRatingService;
import nvt.service.RealEstateService;
import nvt.service.UserService;
import nvt.web.dto.CreateCommentResponseDTO;
import nvt.web.dto.RealEstateCommentDTO;
import nvt.web.dto.RealEstateDTO;
import nvt.web.dto.RealEstateRatingDTO;

@RestController
@RequestMapping(value = "api/realEstateRatings")
public class RealEstateRatingController {

	@Autowired
	protected RealEstateRatingService realEstateRatingService;
	
	@Autowired
	protected RealEstateService realEstateService;
	
	@Autowired
	protected UserService userService;
	
	
	
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
	
	@RequestMapping(
			value = "/create", 
			method = RequestMethod.POST, 
			consumes = "application/json"
			)
	public ResponseEntity<CreateCommentResponseDTO> createComment(@RequestBody nvt.web.dto.CreateRateRequestDTO createRateRequest) {

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
			for (RealEstateComment comm : comments) {
				RealEstateCommentDTO commentDTO = new RealEstateCommentDTO(comm);
				commentsDTO.add(commentDTO);
			}
	
			Set<RealEstateRating> ratings = realEstate.getRatings();
			List<RealEstateRatingDTO> ratingDTOs = new ArrayList<RealEstateRatingDTO>();
			for (RealEstateRating realEstateRating : ratings) {
				RealEstateRatingDTO realEstateRatingDTO = new RealEstateRatingDTO(realEstateRating);
				ratingDTOs.add(realEstateRatingDTO);
			}
			

			CreateCommentResponseDTO createCommentResponseDTO = new CreateCommentResponseDTO(realEstateDTO, commentsDTO, ratingDTOs);
			return new ResponseEntity<CreateCommentResponseDTO>(createCommentResponseDTO, HttpStatus.CREATED);

		} else {
			return new ResponseEntity<CreateCommentResponseDTO>(HttpStatus.NOT_FOUND);
		}


	}
	
}
