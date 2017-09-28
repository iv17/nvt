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
import nvt.service.RealEstateCommentService;
import nvt.service.RealEstateService;
import nvt.service.UserService;
import nvt.web.dto.CreateCommentResponseDTO;
import nvt.web.dto.RealEstateCommentDTO;
import nvt.web.dto.RealEstateDTO;

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
	public ResponseEntity<CreateCommentResponseDTO> createComment(@RequestBody nvt.web.dto.CreateCommentRequestDTO createCommentRequest) {

		int id = createCommentRequest.getRealEstateId();
		String text = createCommentRequest.getText();

		if(realEstateService.findById(id) != null) {

			RealEstate realEstate = realEstateService.findById(id);
			List<RealEstateCommentDTO> cDTO = new ArrayList<RealEstateCommentDTO>();

			for (RealEstateComment c : realEstate.getComments()) {
				cDTO.add(new RealEstateCommentDTO(c));
			}

			RealEstateComment comment = new RealEstateComment();
			comment.setComment(text);
			comment.setRealEstate(realEstate);
			//comment.setUser(user);
			comment.setPosted(new Date());

			realEstateCommentService.save(comment); 	//sacuvam komentar

			Set<RealEstateComment> realEstateComments = realEstate.getComments();
			realEstateComments.add(comment);	

			realEstate.setComments(realEstateComments);
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

}
