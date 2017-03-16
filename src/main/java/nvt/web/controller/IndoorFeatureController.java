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

import nvt.beans.IndoorFeature;
import nvt.service.IndoorFeatureService;
import nvt.web.dto.IndoorFeatureDTO;

@RestController
@RequestMapping(value = "api/indoorFeatures")
public class IndoorFeatureController {

	@Autowired
	protected IndoorFeatureService indoorFeatureService;
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<IndoorFeatureDTO>> getIndoorFeatures() {
		
		List<IndoorFeature> indoorFeatures = indoorFeatureService.findAll();
		
		List<IndoorFeatureDTO> indoorFeatureDTOs = new ArrayList<IndoorFeatureDTO>();
		for (IndoorFeature indoorFeature : indoorFeatures) {
			IndoorFeatureDTO indoorFeatureDTO = new IndoorFeatureDTO(indoorFeature);
			indoorFeatureDTOs.add(indoorFeatureDTO);
		}
		
		return new ResponseEntity<List<IndoorFeatureDTO>>(indoorFeatureDTOs, HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<IndoorFeatureDTO> getIndoorFeature(@PathVariable Integer id) {
		
		IndoorFeature indoorFeature = indoorFeatureService.findById(id);
		
		if(indoorFeature == null) {
			return new ResponseEntity<IndoorFeatureDTO>(HttpStatus.NOT_FOUND);
		}
		IndoorFeatureDTO indoorFeatureDTO = new IndoorFeatureDTO(indoorFeature);
		
		return new ResponseEntity<IndoorFeatureDTO>(indoorFeatureDTO, HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<IndoorFeatureDTO> saveIndoorFeature(@RequestBody IndoorFeatureDTO indoorFeatureDTO) {
		
		IndoorFeature indoorFeature = new IndoorFeature();
		indoorFeature.setName(indoorFeatureDTO.getName());
		
		indoorFeatureService.save(indoorFeature);
		
		IndoorFeatureDTO newIndoorFeatureDTO = new IndoorFeatureDTO(indoorFeature);
		
		return new ResponseEntity<IndoorFeatureDTO>(newIndoorFeatureDTO, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteIndoorFeature(@PathVariable Integer id) {
		
		IndoorFeature indoorFeature = indoorFeatureService.findById(id);
		if(indoorFeature == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		indoorFeatureService.removeById(id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
