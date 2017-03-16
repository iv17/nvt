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

import nvt.beans.RealEstateType;
import nvt.service.RealEstateTypeService;
import nvt.web.dto.RealEstateTypeDTO;

@RestController
@RequestMapping(value = "api/realEstateTypes")
public class RealEstateTypeController {

	@Autowired
	protected RealEstateTypeService realEstateTypeService;
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<RealEstateTypeDTO>> getRealEstateTypes() {
		
		List<RealEstateType> realEstateTypes = realEstateTypeService.findAll();
	
		List<RealEstateTypeDTO> realEstateTypeDTOs = new ArrayList<RealEstateTypeDTO>();
		for (RealEstateType realEstateType : realEstateTypes) {
			RealEstateTypeDTO realEstateTypeDTO = new RealEstateTypeDTO(realEstateType);
			realEstateTypeDTOs.add(realEstateTypeDTO);
		}
		
		return new ResponseEntity<List<RealEstateTypeDTO>>(realEstateTypeDTOs, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<RealEstateTypeDTO> getRealEstateType(@PathVariable Integer id){
		
		RealEstateType realEstateType = realEstateTypeService.findById(id);
		
		if(realEstateType == null){
			return new ResponseEntity<RealEstateTypeDTO>(HttpStatus.NOT_FOUND);
		}	
		RealEstateTypeDTO realEstateTypeDTO = new RealEstateTypeDTO(realEstateType);
		
		return new ResponseEntity<RealEstateTypeDTO>(realEstateTypeDTO, HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<RealEstateTypeDTO> saveRealEstateType(@RequestBody RealEstateTypeDTO realEstateTypeDTO) {
		
		RealEstateType realEstateType = new RealEstateType();
		realEstateType.setName(realEstateTypeDTO.getName());
		
		realEstateTypeService.save(realEstateType);
		RealEstateTypeDTO newRealEstateTypeDTO = new RealEstateTypeDTO(realEstateType);
			
		return new ResponseEntity<RealEstateTypeDTO>(newRealEstateTypeDTO, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<RealEstateTypeDTO> updateRealEstateType(@RequestBody RealEstateTypeDTO realEstateTypeDTO) {
		
		RealEstateType realEstateType = realEstateTypeService.findById(realEstateTypeDTO.getId());
		
		if(realEstateType == null) {
			return new ResponseEntity<RealEstateTypeDTO>(HttpStatus.BAD_REQUEST);
		}
		
		realEstateTypeService.save(realEstateType);
		RealEstateTypeDTO newRealEstateTypeDTO = new RealEstateTypeDTO(realEstateType);
		
		return new ResponseEntity<RealEstateTypeDTO>(newRealEstateTypeDTO, HttpStatus.OK);
	}
}
