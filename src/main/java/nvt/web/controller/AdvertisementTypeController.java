package nvt.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nvt.beans.AdvertisementType;
import nvt.service.AdvertisementTypeService;
import nvt.web.dto.AdvertisementTypeDTO;

@RestController
@RequestMapping(value = "api/advertisementTypes")
public class AdvertisementTypeController {
	
	@Autowired
	protected AdvertisementTypeService advertisementTypeService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AdvertisementTypeDTO>> getAdvertisementTypes() {
		
		List<AdvertisementType> advertisementTypes = advertisementTypeService.findAll();
		
		List<AdvertisementTypeDTO>  advertisementTypeDTOs = new ArrayList<AdvertisementTypeDTO>();
		for (AdvertisementType advertisementType : advertisementTypes) {
			AdvertisementTypeDTO advertisementTypeDTO = new AdvertisementTypeDTO(advertisementType);
			advertisementTypeDTOs.add(advertisementTypeDTO);
			
		}
		
		return new ResponseEntity<List<AdvertisementTypeDTO>>(advertisementTypeDTOs, HttpStatus.OK);
	}
}
