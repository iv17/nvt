package nvt.web.controller;

import java.util.ArrayList;
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

import nvt.beans.AdvertisementType;
import nvt.beans.Agent;
import nvt.beans.HeatingType;
import nvt.beans.Location;
import nvt.beans.RealEstate;
import nvt.beans.RealEstateComment;
import nvt.beans.RealEstateRating;
import nvt.beans.RealEstateReport;
import nvt.beans.RealEstateType;
import nvt.service.AdvertisementTypeService;
import nvt.service.AgentService;
import nvt.service.HeatingTypeService;
import nvt.service.IndoorFeatureService;
import nvt.service.LocationService;
import nvt.service.OutdoorFeatureService;
import nvt.service.RealEstateCommentService;
import nvt.service.RealEstateRatingService;
import nvt.service.RealEstateReportService;
import nvt.service.RealEstateService;
import nvt.service.RealEstateTypeService;
import nvt.web.dto.RealEstateCommentDTO;
import nvt.web.dto.RealEstateDTO;
import nvt.web.dto.RealEstateRatingDTO;
import nvt.web.dto.RealEstateReportDTO;

@RestController
@RequestMapping(value = "api/realEstates")
public class RealEstateController {

	@Autowired
	protected RealEstateService realEstateService;

	@Autowired
	protected RealEstateTypeService realEstateTypeService;

	@Autowired
	protected RealEstateCommentService realEstateCommentService;

	@Autowired
	protected RealEstateRatingService realEstateRatingService;

	@Autowired
	protected RealEstateReportService realEstateReportService;

	@Autowired 
	protected LocationService locationService;

	@Autowired
	protected HeatingTypeService heatingTypeService;
	
	@Autowired
	protected AgentService agentService;
	
	@Autowired
	protected AdvertisementTypeService advertisementTypeService;
	
	@Autowired
	protected IndoorFeatureService indoorFeatureService;

	@Autowired
	protected OutdoorFeatureService outdoorFeatureService;
	
	
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<RealEstateDTO> createRealEstate(@RequestBody RealEstateDTO realEstateDTO) {

		
		RealEstate realEstate = new RealEstate();
		realEstate.setName(realEstateDTO.getName());
		realEstate.setDescription(realEstateDTO.getDescription());
		realEstate.setPrice(realEstateDTO.getPrice());
		realEstate.setSurface(realEstateDTO.getSurface());
		realEstate.setFloor(realEstateDTO.getFloor());
		realEstate.setRooms(realEstateDTO.getRooms());
		realEstate.setBathrooms(realEstateDTO.getBathrooms());
		realEstate.setFiled(realEstateDTO.isFiled());
		realEstate.setFurnished(realEstateDTO.isFurnished());
		realEstate.setConstructedYear(realEstateDTO.getConstructedYear());
		
		Location location = locationService.findById(realEstateDTO.getLocation().getId());
		if(location == null) {
			return new ResponseEntity<RealEstateDTO>(HttpStatus.NOT_FOUND);
		}
		realEstate.setLocation(location);
		
		RealEstateType realEstateType = realEstateTypeService.findById(realEstateDTO.getRealEstateType().getId());
		if(realEstateType == null) {
			return new ResponseEntity<RealEstateDTO>(HttpStatus.NOT_FOUND);
		}
		realEstate.setRealEstateType(realEstateType);
		
		HeatingType heatingType = heatingTypeService.findById(realEstateDTO.getHeatingType().getId());
		if(heatingType == null) {
			return new ResponseEntity<RealEstateDTO>(HttpStatus.NOT_FOUND);
		}
		realEstate.setHeatingType(heatingType);
		
		realEstate.setPosted(realEstateDTO.getPosted());
		realEstate.setUpdated(realEstateDTO.getUpdated());
		realEstate.setDuration(realEstateDTO.getDuration());
		realEstate.setInappropriate(realEstateDTO.isInappropriate());
		realEstate.setVerified(realEstateDTO.isVerified());
		
		RealEstateDTO newRealEstateDTO = new RealEstateDTO(realEstate);

		Agent agent = agentService.findById(realEstateDTO.getAgent().getId());
		if(agent == null) {
			return new ResponseEntity<RealEstateDTO>(HttpStatus.NOT_FOUND);
		}
		realEstate.setAgent(agent);
		
		AdvertisementType  advertisementType = advertisementTypeService.findById(realEstateDTO.getAdvertisementType().getId());
		if(advertisementType == null) {
			return new ResponseEntity<RealEstateDTO>(HttpStatus.NOT_FOUND);
		}
		realEstate.setAdvertisementType(advertisementType);
		
		realEstateService.save(realEstate);
		
		return new ResponseEntity<RealEstateDTO>(newRealEstateDTO, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<RealEstateDTO>> getRealEstates() {

		List<RealEstate> realEstates = realEstateService.findAll();

		List<RealEstateDTO> realEstateDTOs = realEstates2realEsateDTOs(realEstates);

		return new ResponseEntity<List<RealEstateDTO>>(realEstateDTOs, HttpStatus.OK);
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<RealEstateDTO> getRealEstate(@PathVariable Integer id){

		RealEstate realEstate = realEstateService.findById(id);

		if(realEstate == null){
			return new ResponseEntity<RealEstateDTO>(HttpStatus.NOT_FOUND);
		}
		RealEstateDTO realEstateDTO = new RealEstateDTO(realEstate);

		return new ResponseEntity<RealEstateDTO>(realEstateDTO, HttpStatus.OK);
	}


	//@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<RealEstateDTO> saveRealEstate(@RequestBody RealEstateDTO realEstateDTO) {

		RealEstate realEstate = new RealEstate();
		realEstate.setName(realEstateDTO.getName());
		realEstate.setDescription(realEstateDTO.getDescription());
		realEstate.setPrice(realEstateDTO.getPrice());
		realEstate.setSurface(realEstateDTO.getSurface());
		realEstate.setFloor(realEstateDTO.getFloor());
		realEstate.setRooms(realEstateDTO.getRooms());
		realEstate.setBathrooms(realEstateDTO.getBathrooms());
		realEstate.setFiled(realEstateDTO.isFiled());
		realEstate.setFurnished(realEstateDTO.isFurnished());
		realEstate.setConstructedYear(realEstateDTO.getConstructedYear());
		
		Location location = locationService.findById(realEstateDTO.getLocation().getId());
		if(location == null) {
			return new ResponseEntity<RealEstateDTO>(HttpStatus.NOT_FOUND);
		}
		realEstate.setLocation(location);
		
		RealEstateType realEstateType = realEstateTypeService.findById(realEstateDTO.getRealEstateType().getId());
		if(realEstateType == null) {
			return new ResponseEntity<RealEstateDTO>(HttpStatus.NOT_FOUND);
		}
		realEstate.setRealEstateType(realEstateType);
		
		HeatingType heatingType = heatingTypeService.findById(realEstateDTO.getHeatingType().getId());
		if(heatingType == null) {
			return new ResponseEntity<RealEstateDTO>(HttpStatus.NOT_FOUND);
		}
		realEstate.setHeatingType(heatingType);

		
		realEstateService.save(realEstate);
		RealEstateDTO newRealEstateDTO = new RealEstateDTO(realEstate);

		return new ResponseEntity<RealEstateDTO>(newRealEstateDTO, HttpStatus.CREATED);
	}


	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<RealEstateDTO> updateRealEstate(@RequestBody RealEstateDTO realEstateDTO) {

		
		if(realEstateService.findById(realEstateDTO.getId()) == null) {
			return new ResponseEntity<RealEstateDTO>(HttpStatus.BAD_REQUEST);
		}
		
		RealEstate realEstate = new RealEstate();
		realEstate.setName(realEstateDTO.getName());
		realEstate.setDescription(realEstateDTO.getDescription());
		realEstate.setPrice(realEstateDTO.getPrice());
		realEstate.setSurface(realEstateDTO.getSurface());
		realEstate.setFloor(realEstateDTO.getFloor());
		realEstate.setRooms(realEstateDTO.getRooms());
		realEstate.setBathrooms(realEstateDTO.getBathrooms());
		realEstate.setFiled(realEstateDTO.isFiled());
		realEstate.setFurnished(realEstateDTO.isFurnished());
		realEstate.setConstructedYear(realEstateDTO.getConstructedYear());
		
		Location location = locationService.findById(realEstateDTO.getLocation().getId());
		if(location == null) {
			return new ResponseEntity<RealEstateDTO>(HttpStatus.NOT_FOUND);
		}
		realEstate.setLocation(location);
		
		RealEstateType realEstateType = realEstateTypeService.findById(realEstateDTO.getRealEstateType().getId());
		if(realEstateType == null) {
			return new ResponseEntity<RealEstateDTO>(HttpStatus.NOT_FOUND);
		}
		realEstate.setRealEstateType(realEstateType);
		
		HeatingType heatingType = heatingTypeService.findById(realEstateDTO.getHeatingType().getId());
		if(heatingType == null) {
			return new ResponseEntity<RealEstateDTO>(HttpStatus.NOT_FOUND);
		}
		realEstate.setHeatingType(heatingType);
		
		
		RealEstateDTO newRealEstateDTO = new RealEstateDTO(realEstate);

		realEstateService.save(realEstate);
		
		return new ResponseEntity<RealEstateDTO>(newRealEstateDTO, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteRealEstate(@PathVariable Integer id) {

		RealEstate realEstate = realEstateService.findById(id);
		if(realEstate == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		realEstateService.removeById(id);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/*
	 * PRETRAGE
	 */

	@RequestMapping(value = "/{id}/comments", method = RequestMethod.GET)
	public ResponseEntity<List<RealEstateCommentDTO>> getRealEstateComments(@PathVariable Integer id) {

		RealEstate realEstate = realEstateService.findById(id);

		Set<RealEstateComment> realEstateComments = realEstate.getComments();

		List<RealEstateCommentDTO> realEstateCommentDTOs = new ArrayList<RealEstateCommentDTO>();
		for (RealEstateComment comment : realEstateComments) {
			RealEstateCommentDTO realEstateCommentDTO = new RealEstateCommentDTO(comment);
			System.out.println(realEstateCommentDTO.toString());
			realEstateCommentDTOs.add(realEstateCommentDTO);
		}

		return new ResponseEntity<List<RealEstateCommentDTO>>(realEstateCommentDTOs, HttpStatus.OK);

	}


	@RequestMapping(value = "/{id}/ratings", method = RequestMethod.GET)
	public ResponseEntity<List<RealEstateRatingDTO>> getRealEstateRatings(@PathVariable Integer id) {

		RealEstate realEstate = realEstateService.findById(id);

		Set<RealEstateRating> realEstateRatings = realEstate.getRatings();

		List<RealEstateRatingDTO> realEstateRatingDTOs = new ArrayList<RealEstateRatingDTO>();
		for (RealEstateRating realEstateRating : realEstateRatings) {
			RealEstateRatingDTO realEstateRatingDTO = new RealEstateRatingDTO(realEstateRating);
			realEstateRatingDTOs.add(realEstateRatingDTO);
		}

		return new ResponseEntity<List<RealEstateRatingDTO>>(realEstateRatingDTOs, HttpStatus.OK);

	}

	@RequestMapping(value = "/{id}/reports", method = RequestMethod.GET)
	public ResponseEntity<List<RealEstateReportDTO>> getRealEstateReports(@PathVariable Integer id) {

		RealEstate realEstate = realEstateService.findById(id);

		Set<RealEstateReport> realEstateReports = realEstate.getReports();
		
		List<RealEstateReportDTO> realEstateReportDTOs = new ArrayList<RealEstateReportDTO>();
		for (RealEstateReport realEstateReport : realEstateReports) {
			RealEstateReportDTO realEstateReportDTO =  new RealEstateReportDTO(realEstateReport);
			realEstateReportDTOs.add(realEstateReportDTO);
		}

		return new ResponseEntity<List<RealEstateReportDTO>>(realEstateReportDTOs, HttpStatus.OK);

	}

	
	//UTILS

	public List<RealEstateDTO> realEstates2realEsateDTOs(List<RealEstate> realEstates) {

		List<RealEstateDTO> realEstateDTOs = new ArrayList<RealEstateDTO>();
		for (RealEstate realEstate : realEstates) {
			RealEstateDTO realEstateDTO = new RealEstateDTO(realEstate);
			realEstateDTOs.add(realEstateDTO);
		}

		return realEstateDTOs;
	}


	@RequestMapping(value = "/{city}", method = RequestMethod.GET)
	public ResponseEntity<List<RealEstateDTO>> findByCity(@PathVariable String city) {
	
		List<Location> locations = locationService.findByCity(city);
	
		List<RealEstate> realEstates = findByLocations(locations);
	
		List<RealEstateDTO> realEstateDTOs = realEstates2realEsateDTOs(realEstates);
	
		return new ResponseEntity<List<RealEstateDTO>>(realEstateDTOs, HttpStatus.OK);
	}


	@RequestMapping(value = "/{block}", method = RequestMethod.GET)
	public ResponseEntity<List<RealEstateDTO>> findByBlock(@PathVariable String block) {
	
		List<Location> locations = locationService.findByBlock(block);
	
		List<RealEstate> realEstates = findByLocations(locations);
	
		List<RealEstateDTO> realEstateDTOs = realEstates2realEsateDTOs(realEstates);
	
		return new ResponseEntity<List<RealEstateDTO>>(realEstateDTOs, HttpStatus.OK);
	}


	@RequestMapping(value = "/{street}", method = RequestMethod.GET)
	public ResponseEntity<List<RealEstateDTO>> findByStreet(@PathVariable String street) {
	
		List<Location> locations = locationService.findByStreet(street);
	
		List<RealEstate> realEstates = findByLocations(locations);
	
		List<RealEstateDTO> realEstateDTOs = realEstates2realEsateDTOs(realEstates);
	
		return new ResponseEntity<List<RealEstateDTO>>(realEstateDTOs, HttpStatus.OK);
	}


	/*
	 * PRETRAGE
	 */
	
	@RequestMapping(value = "/{typeId}", method = RequestMethod.GET)
	public ResponseEntity<List<RealEstateDTO>> findByType(@PathVariable Integer typeId) {
	
		RealEstateType realEstateType = realEstateTypeService.findById(typeId);
		if(realEstateType == null) {
			return new ResponseEntity<List<RealEstateDTO>>(HttpStatus.NOT_FOUND);
		}
	
		List<RealEstate> realEstates = realEstateService.findByType(realEstateType);
	
		List<RealEstateDTO> realEstateDTOs = realEstates2realEsateDTOs(realEstates);
	
		return new ResponseEntity<List<RealEstateDTO>>(realEstateDTOs, HttpStatus.OK);
	}


	/*
	 * PRETRAGE
	 */
	
	@RequestMapping(value = "/{zipCode}", method = RequestMethod.GET)
	public ResponseEntity<List<RealEstateDTO>> findByZipCode(@PathVariable String zipCode) {
	
		List<Location> locations = locationService.findByZipCode(zipCode);
	
		List<RealEstate> realEstates = findByLocations(locations);
	
		List<RealEstateDTO> realEstateDTOs = realEstates2realEsateDTOs(realEstates);
	
		return new ResponseEntity<List<RealEstateDTO>>(realEstateDTOs, HttpStatus.OK);
	}


	public List<RealEstate> findByLocations(List<Location> locations) {

		List<RealEstate> realEstates = new ArrayList<RealEstate>();
		for (Location location : locations) {
			List<RealEstate> tempRealEstates = realEstateService.findByLocation(location);
			realEstates.addAll(tempRealEstates);
		}

		return realEstates;
	}
}
