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

import nvt.beans.OutdoorFeature;
import nvt.service.OutdoorFeatureService;
import nvt.web.dto.OutdoorFeatureDTO;

@RestController
@RequestMapping(value = "api/outdoorFeatures")
public class OutdoorFeatureController {

	@Autowired
	protected OutdoorFeatureService outdoorFeatureService;
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<OutdoorFeatureDTO>> getOutdoorFeatures() {
		
		List<OutdoorFeature> outdoorFeatures = outdoorFeatureService.findAll();
		
		List<OutdoorFeatureDTO> outdoorFeaturesDTOs = new ArrayList<OutdoorFeatureDTO>();
		for (OutdoorFeature outdoorFeature : outdoorFeatures) {
			OutdoorFeatureDTO outdoorFeatureDTO = new OutdoorFeatureDTO(outdoorFeature);
			outdoorFeaturesDTOs.add(outdoorFeatureDTO);
		}
		
		return new ResponseEntity<List<OutdoorFeatureDTO>>(outdoorFeaturesDTOs, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<OutdoorFeatureDTO> getOutdoorFeature(@PathVariable Integer id) {
		
		OutdoorFeature outdoorFeature = outdoorFeatureService.findById(id);
		
		if(outdoorFeature == null) {
			return new ResponseEntity<OutdoorFeatureDTO>(HttpStatus.NOT_FOUND);
		}
		OutdoorFeatureDTO outdoorFeatureDTO = new OutdoorFeatureDTO(outdoorFeature);
		
		return new ResponseEntity<OutdoorFeatureDTO>(outdoorFeatureDTO, HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<OutdoorFeatureDTO> saveOutdoorFeature(@RequestBody OutdoorFeatureDTO outdoorDTO) {
		
		OutdoorFeature outdoorFeature = new OutdoorFeature();
		outdoorFeature.setName(outdoorFeature.getName());
		
		outdoorFeatureService.save(outdoorFeature);
		
		OutdoorFeatureDTO newOutdoorFeatureDTO = new OutdoorFeatureDTO(outdoorFeature);
		
		return new ResponseEntity<OutdoorFeatureDTO>(newOutdoorFeatureDTO, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteOutdoorFeature(@PathVariable Integer id) {
		
		OutdoorFeature outdoorFeature = outdoorFeatureService.findById(id);
		if(outdoorFeature == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		outdoorFeatureService.removeById(id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
