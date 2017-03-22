package nvt.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nvt.beans.Advertisement;
import nvt.beans.AdvertisementType;
import nvt.beans.Agent;
import nvt.beans.RealEstate;
import nvt.service.AdvertisementService;
import nvt.service.AdvertisementTypeService;
import nvt.service.AgentService;
import nvt.service.RealEstateService;
import nvt.web.dto.AdvertisementDTO;

@RestController
@RequestMapping(value = "api/advertisement")
public class AdvertisementController {

	@Autowired
	protected AdvertisementService advertisementService;

	@Autowired
	protected RealEstateService realEstateService;

	@Autowired
	protected AgentService agentService;

	@Autowired
	protected AdvertisementTypeService advertisementTypeService;


	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<AdvertisementDTO> createAdvertisement(@RequestBody AdvertisementDTO advertisementDTO) {

		Advertisement advertisement = new Advertisement();
		advertisement.setName(advertisementDTO.getName());
		advertisement.setPosted(advertisementDTO.getPosted());
		advertisement.setUpdated(advertisementDTO.getPosted());
		advertisement.setDuration(advertisementDTO.getDuration());
		advertisement.setInappropriate(false);
		advertisement.setVerified(false);

		RealEstate realEstate = realEstateService.findById(advertisementDTO.getRealEstateDTO().getId());
		if (realEstate == null) {
			return new ResponseEntity<AdvertisementDTO>(HttpStatus.BAD_REQUEST);
		}
		advertisement.setRealEstate(realEstate);

		Agent agent = agentService.findById(advertisementDTO.getAgentDTO().getId());
		if(agent == null) {
			return new ResponseEntity<AdvertisementDTO>(HttpStatus.BAD_REQUEST);
		}
		advertisement.setAgent(agent);
		
		AdvertisementType advertisementType = advertisementTypeService.findById(advertisementDTO.getAdvertisementTypeDTO().getId());
		if (advertisementType == null) {
			return new ResponseEntity<AdvertisementDTO>(HttpStatus.BAD_REQUEST);
		}
		advertisement.setAdvertisementType(advertisementType);
		
		advertisementService.save(advertisement);

		AdvertisementDTO newAdvertisementDTO = new AdvertisementDTO(advertisement);
		
		return new ResponseEntity<AdvertisementDTO>(newAdvertisementDTO, HttpStatus.CREATED);

	}


	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AdvertisementDTO>> getAdvertisements() {

		List<Advertisement> advertisements = advertisementService.findAll();

		List<AdvertisementDTO> advertisementDTOs = new ArrayList<AdvertisementDTO>();
		for (Advertisement advertisement : advertisements) {
			AdvertisementDTO advertisementDTO = new AdvertisementDTO(advertisement);
			advertisementDTOs.add(advertisementDTO);
		}

		return new ResponseEntity<List<AdvertisementDTO>>(advertisementDTOs, HttpStatus.OK);
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<AdvertisementDTO> getAdvertisement(@PathVariable Integer id) {

		Advertisement advertisement = advertisementService.findById(id);

		if(advertisement == null) {
			return new ResponseEntity<AdvertisementDTO>(HttpStatus.NOT_FOUND);
		}
		AdvertisementDTO advertisementDTO = new AdvertisementDTO(advertisement);

		return new ResponseEntity<AdvertisementDTO>(advertisementDTO, HttpStatus.OK);
	}


	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<AdvertisementDTO> updateAdvertisement(@RequestBody AdvertisementDTO advertisementDTO) {

		Advertisement advertisement = advertisementService.findById(advertisementDTO.getId());

		if(advertisement == null) {
			return new ResponseEntity<AdvertisementDTO>(HttpStatus.BAD_REQUEST);
		}
		advertisement.setName(advertisementDTO.getName());
		advertisement.setPosted(advertisementDTO.getPosted());
		advertisement.setUpdated(advertisementDTO.getUpdated());
		advertisement.setDuration(advertisementDTO.getDuration());
		advertisement.setInappropriate(advertisementDTO.isInappropriate());
		advertisement.setVerified(advertisementDTO.isVerified());

		RealEstate realEstate = realEstateService.findById(advertisementDTO.getRealEstateDTO().getId());
		if (realEstate == null) {
			return new ResponseEntity<AdvertisementDTO>(HttpStatus.BAD_REQUEST);
		}
		advertisement.setRealEstate(realEstate);

		Agent agent = agentService.findById(advertisementDTO.getAgentDTO().getId());
		if(agent == null) {
			return new ResponseEntity<AdvertisementDTO>(HttpStatus.BAD_REQUEST);
		}
		advertisement.setAgent(agent);
		
		AdvertisementType advertisementType = advertisementTypeService.findById(advertisementDTO.getAdvertisementTypeDTO().getId());
		if (advertisementType == null) {
			return new ResponseEntity<AdvertisementDTO>(HttpStatus.BAD_REQUEST);
		}
		advertisement.setAdvertisementType(advertisementType);
		
		advertisement = advertisementService.save(advertisement);
		
		AdvertisementDTO newAdvertisementDTO = new AdvertisementDTO(advertisement);

		return new ResponseEntity<AdvertisementDTO>(newAdvertisementDTO, HttpStatus.OK);
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteAdvertisement(@PathVariable Integer id) {

		Advertisement advertisement = advertisementService.findById(id);

		if(advertisement == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		advertisementService.removeById(id);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	//PROVERI
	//@RequestMapping(value = "/{id}/{updatedDate}",method = RequestMethod.PUT)
	public ResponseEntity<AdvertisementDTO> prolong(@PathVariable Integer id, @PathVariable Date updatedDate) {

		Advertisement advertisement = advertisementService.findById(id);

		if(advertisement == null) {
			return new ResponseEntity<AdvertisementDTO>(HttpStatus.BAD_REQUEST);
		}
		
		advertisement.setUpdated(updatedDate);

		AdvertisementDTO newAvertisementDTO = new AdvertisementDTO(advertisement);
		
		advertisement = advertisementService.save(advertisement);
		
		return new ResponseEntity<AdvertisementDTO>(newAvertisementDTO, HttpStatus.CREATED);
		
	}
}
