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

import nvt.beans.RealEstateComment;
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
	
}
