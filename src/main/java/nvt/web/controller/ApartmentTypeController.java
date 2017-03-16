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

import nvt.beans.ApartmentType;
import nvt.service.ApartmentTypeService;
import nvt.web.dto.ApartmentTypeDTO;

@RestController
@RequestMapping(value = "api/apartmentType")
public class ApartmentTypeController {

	@Autowired
	protected ApartmentTypeService apartmentTypeService;
	
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<ApartmentTypeDTO> createApartmentType(@RequestBody ApartmentTypeDTO apartmentTypeDTO) {
		
		ApartmentType apartmentType = new ApartmentType();
		apartmentType.setName(apartmentTypeDTO.getName());
		
		apartmentTypeService.save(apartmentType);
		ApartmentTypeDTO newApartmentTypeDTO = new ApartmentTypeDTO(apartmentType);
		
		return new ResponseEntity<ApartmentTypeDTO>(newApartmentTypeDTO, HttpStatus.CREATED);
	}


	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ApartmentTypeDTO>> getApartmentTypes() {
		
		List<ApartmentType> apartmentTypes = apartmentTypeService.findAll();
		
		List<ApartmentTypeDTO> apartmentTypeDTOs = new ArrayList<ApartmentTypeDTO>();
		for (ApartmentType apartmentType : apartmentTypes) {
			ApartmentTypeDTO apartmentTypeDTO = new ApartmentTypeDTO(apartmentType);
			apartmentTypeDTOs.add(apartmentTypeDTO);
		}
		
		return new ResponseEntity<List<ApartmentTypeDTO>>(apartmentTypeDTOs, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ApartmentTypeDTO> getApartmentType(@PathVariable Integer id) {
		
		ApartmentType apartmentType = apartmentTypeService.findById(id);
		
		if(apartmentType == null) {
			return new ResponseEntity<ApartmentTypeDTO>(HttpStatus.NOT_FOUND);
		}
		ApartmentTypeDTO apartmentTypeDTO = new ApartmentTypeDTO(apartmentType);
		
		return new ResponseEntity<ApartmentTypeDTO>(apartmentTypeDTO, HttpStatus.OK);
	}
	
}
