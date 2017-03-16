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

import nvt.beans.HeatingType;
import nvt.service.HeatingTypeService;
import nvt.web.dto.HeatingTypeDTO;

@RestController
@RequestMapping(value = "api/heatingTypes")
public class HeatingTypeController {

	@Autowired
	protected HeatingTypeService heatingTypeService;
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<HeatingTypeDTO>> getHeatingTypes() {
		
		List<HeatingType> heatingTypes = heatingTypeService.findAll();
		
		List<HeatingTypeDTO> heatingTypeDTOs = new ArrayList<HeatingTypeDTO>();
		for (HeatingType heatingType : heatingTypes) {
			HeatingTypeDTO heatingTypeDTO = new HeatingTypeDTO(heatingType);
			heatingTypeDTOs.add(heatingTypeDTO);
		}
		
		return new ResponseEntity<List<HeatingTypeDTO>>(heatingTypeDTOs, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<HeatingTypeDTO> getHeatingType(@PathVariable Integer id) {
		
		HeatingType heatingType = heatingTypeService.findById(id);
		
		if(heatingType == null) {
			return new ResponseEntity<HeatingTypeDTO>(HttpStatus.NOT_FOUND);
		}
		HeatingTypeDTO heatingTypeDTO = new HeatingTypeDTO(heatingType);
		
		return new ResponseEntity<HeatingTypeDTO>(heatingTypeDTO, HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<HeatingTypeDTO> saveHeatingType(@RequestBody HeatingTypeDTO heatingTypeDTO) {
		
		HeatingType heatingType = new HeatingType();
		heatingType.setName(heatingTypeDTO.getName());
		
		heatingTypeService.save(heatingType);
		
		HeatingTypeDTO newHeatingTypeDTO = new HeatingTypeDTO(heatingType);
		
		return new ResponseEntity<HeatingTypeDTO>(newHeatingTypeDTO, HttpStatus.CREATED);
	}
}
