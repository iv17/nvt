package nvt.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
}
