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
import nvt.beans.RealEstateComment;
import nvt.beans.User;
import nvt.service.RealEstateCommentService;
import nvt.service.RealEstateService;
import nvt.service.UserService;
import nvt.web.dto.RealEstateCommentDTO;

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
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<RealEstateCommentDTO> saveRealEstateComment(@RequestBody RealEstateCommentDTO realEstateCommentDTO) {
		
		RealEstateComment realEstateComment = realEstateCommentService.findById(realEstateCommentDTO.getId());
		
		realEstateComment.setComment(realEstateCommentDTO.getComment());
		realEstateComment.setPosted(realEstateCommentDTO.getPosted());
		
		RealEstate realEstate = realEstateService.findById(realEstateCommentDTO.getRealEstateDTO().getId());
		if(realEstate == null) {
			return new ResponseEntity<RealEstateCommentDTO>(HttpStatus.BAD_REQUEST);
		}
		realEstateComment.setRealEstate(realEstate);
	
		User user = userService.findById(realEstateCommentDTO.getUserDTO().getId());
		if(user == null) {
			return new ResponseEntity<RealEstateCommentDTO>(HttpStatus.BAD_REQUEST);
		}
		realEstateComment.setUser(user);
		
		realEstateCommentService.save(realEstateComment);
		RealEstateCommentDTO newRealEstateCommentDTO = new RealEstateCommentDTO(realEstateComment);
		
		return new ResponseEntity<RealEstateCommentDTO>(newRealEstateCommentDTO, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<RealEstateCommentDTO> updateRealEstateComment(@RequestBody RealEstateCommentDTO realEstateCommentDTO) {
		
		RealEstateComment realEstateComment = realEstateCommentService.findById(realEstateCommentDTO.getId());
		
		if(realEstateComment == null) {
			return new ResponseEntity<RealEstateCommentDTO>(HttpStatus.BAD_REQUEST);
		}
		realEstateComment.setComment(realEstateCommentDTO.getComment());
		realEstateComment.setPosted(realEstateCommentDTO.getPosted());
		
		RealEstate realEstate = realEstateService.findById(realEstateCommentDTO.getRealEstateDTO().getId());
		if(realEstate == null) {
			return new ResponseEntity<RealEstateCommentDTO>(HttpStatus.BAD_REQUEST);
		}
		realEstateComment.setRealEstate(realEstate);
	
		User user = userService.findById(realEstateCommentDTO.getUserDTO().getId());
		if(user == null) {
			return new ResponseEntity<RealEstateCommentDTO>(HttpStatus.BAD_REQUEST);
		}
		realEstateComment.setUser(user);
		
		realEstateCommentService.save(realEstateComment);
		
		RealEstateCommentDTO newRealEstateCommentDTO = new RealEstateCommentDTO(realEstateComment);
		
		return new ResponseEntity<RealEstateCommentDTO>(newRealEstateCommentDTO, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteRealEstateComment(@PathVariable Integer id) {
		
		RealEstateComment realEstateComment = realEstateCommentService.findById(id);
		if(realEstateComment == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		realEstateCommentService.removeById(id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
