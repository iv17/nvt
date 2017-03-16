package nvt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nvt.beans.Location;
import nvt.repository.LocationRepository;

@Service
public class LocationService {
	
	@Autowired
	protected LocationRepository locationRepository;
	
	public Location findById(int id) {
		return locationRepository.findById(id);
	}
	
	public List<Location> findByCity(String city) {
		return locationRepository.findByCity(city);
	}
	
	public List<Location> findByBlock(String block) {
		return locationRepository.findByBlock(block);
	}
	
	public List<Location> findByStreet(String street) {
		return locationRepository.findByStreet(street);
	}
	
	public List<Location> findByZipCode(String zipCode) {
		return locationRepository.findByZipCode(zipCode);
	}
	
	public List<Location> findByCoordinates(double coord1, double coord2) {
		return locationRepository.findByCoord1AndCoord2(coord1, coord2);
	}
	
	public List<Location> findAll() {
		return locationRepository.findAll();
	}
	
	public Page<Location> findAll(Pageable page) {
		return locationRepository.findAll(page);	
	}
	
	public Location save(Location location) {
		return locationRepository.save(location);
	}
	
	public Location saveAndFlush(Location location) {
		return locationRepository.saveAndFlush(location);
	}
	
	public void removeById(int id) {
		locationRepository.delete(id);
	}
	
	public void remove(Location location) {
		locationRepository.delete(location);
	}
	
}
