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

import nvt.beans.Location;
import nvt.service.LocationService;
import nvt.web.dto.LocationDTO;

@RestController
@RequestMapping(value = "api/locations")
public class LocationController {

	@Autowired
	protected LocationService locationService;
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<LocationDTO>> getLocations() {
		
		List<Location> locations = locationService.findAll();
		
		List<LocationDTO> locationDTOs = new ArrayList<LocationDTO>();
		for (Location location : locations) {
			LocationDTO locationDTO = new LocationDTO(location);
			locationDTOs.add(locationDTO);
		}
		
		return new ResponseEntity<List<LocationDTO>>(locationDTOs, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<LocationDTO> getLocation(@PathVariable Integer id) {
		
		Location location = locationService.findById(id);
		
		if(location == null) {
			return new ResponseEntity<LocationDTO>(HttpStatus.NOT_FOUND);
		}
		LocationDTO locationDTO = new LocationDTO(location);
		
		return new ResponseEntity<LocationDTO>(locationDTO, HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<LocationDTO> saveLocation(@RequestBody LocationDTO locationDTO) {
		
		Location location = new Location();
		location.setCity(locationDTO.getCity());
		location.setBlock(locationDTO.getBlock());
		location.setStreet(locationDTO.getStreet());
		location.setZipCode(locationDTO.getZipCode());
		
		locationService.save(location);
		
		LocationDTO newLocationDTO = new LocationDTO(location);
		
		return new ResponseEntity<LocationDTO>(newLocationDTO, HttpStatus.CREATED);
	}
}
