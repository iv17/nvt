package nvt.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
}
