package nvt.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nvt.beans.Location;
import nvt.service.LocationService;
import nvt.web.dto.BlockDTO;
import nvt.web.dto.CityDTO;
import nvt.web.dto.LocationDTO;
import nvt.web.dto.StreetDTO;
import nvt.web.dto.ZipCodeDTO;

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
	
	@RequestMapping(
			value = "/zipCodes",
			method = RequestMethod.GET
			)
	public ResponseEntity<List<ZipCodeDTO>> getUniqueZipCodes() {
		
		List<Location> locations = locationService.findAll();
		List<String> duplicates = new ArrayList<>();
		
		
		for (Location location : locations) {
			duplicates.add(location.getZipCode());
		}
		List<String> zipCodes = givenListContainsDuplicates_whenRemovingDuplicatesWithJava8_thenCorrect(duplicates);
		
		List<ZipCodeDTO> dtos = new ArrayList<>();
		for (String string : zipCodes) {
			ZipCodeDTO dto = new ZipCodeDTO();
			dto.setId(locationService.findByZipCode(string).get(0).getId());
			dto.setLabel(string);
			dtos.add(dto);
		}
		
		return new ResponseEntity<List<ZipCodeDTO>>(dtos, HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/cities",
			method = RequestMethod.GET
			)
	public ResponseEntity<List<CityDTO>> getUniqueCities() {
		
		List<Location> locations = locationService.findAll();
		List<String> duplicates = new ArrayList<>();
		
		
		for (Location location : locations) {
			duplicates.add(location.getCity());
		}
		List<String> cities = givenListContainsDuplicates_whenRemovingDuplicatesWithJava8_thenCorrect(duplicates);
		
		List<CityDTO> dtos = new ArrayList<>();
		for (String string : cities) {
			CityDTO dto = new CityDTO();
			dto.setId(locationService.findByCity(string).get(0).getId());
			dto.setLabel(string);
			dtos.add(dto);
		}
		
		return new ResponseEntity<List<CityDTO>>(dtos, HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/blocks",
			method = RequestMethod.GET
			)
	public ResponseEntity<List<BlockDTO>> getUniqueBlocks() {
		
		List<Location> locations = locationService.findAll();
		List<String> duplicates = new ArrayList<>();
		
		
		for (Location location : locations) {
			duplicates.add(location.getBlock());
		}
		List<String> blocks = givenListContainsDuplicates_whenRemovingDuplicatesWithJava8_thenCorrect(duplicates);
		
		List<BlockDTO> dtos = new ArrayList<>();
		for (String string : blocks) {
			BlockDTO dto = new BlockDTO();
			dto.setId(locationService.findByBlock(string).get(0).getId());
			dto.setLabel(string);
			dtos.add(dto);
		}
		
		return new ResponseEntity<List<BlockDTO>>(dtos, HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/streets",
			method = RequestMethod.GET
			)
	public ResponseEntity<List<StreetDTO>> getUniqueStreets() {
		
		List<Location> locations = locationService.findAll();
		List<String> duplicates = new ArrayList<>();
		
		
		for (Location location : locations) {
			duplicates.add(location.getStreet());
		}
		List<String> streets = givenListContainsDuplicates_whenRemovingDuplicatesWithJava8_thenCorrect(duplicates);
		
		List<StreetDTO> dtos = new ArrayList<>();
		for (String string : streets) {
			StreetDTO dto = new StreetDTO();
			dto.setLabel(string);
			dtos.add(dto);
		}
		
		return new ResponseEntity<List<StreetDTO>>(dtos, HttpStatus.OK);
	}
	
	public List<String>  givenListContainsDuplicates_whenRemovingDuplicatesWithJava8_thenCorrect(List<String> labels) {
	    List<String> listWithDuplicates = labels;
	    List<String> listWithoutDuplicates = listWithDuplicates.stream()
	     .distinct()
	     .collect(Collectors.toList());
	    
	    return listWithoutDuplicates;
	}
	
}
