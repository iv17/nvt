package nvt.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nvt.beans.RealEstateRating;
import nvt.service.RealEstateRatingService;
import nvt.service.RealEstateService;
import nvt.service.UserService;
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
	
	
}
