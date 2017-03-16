package nvt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nvt.beans.Location;
import nvt.beans.RealEstate;
import nvt.beans.RealEstateType;
import nvt.repository.RealEstateRepository;

@Service
public class RealEstateService {

	@Autowired
	RealEstateRepository realEstateRepository;
	
	
	public RealEstate findById(int id) {
		return realEstateRepository.findById(id);
	}

	public List<RealEstate> findByLocation(Location location) {
		return realEstateRepository.findByLocation(location);
	}
	
	public List<RealEstate> findByType(RealEstateType realEstateType) {
		return realEstateRepository.findByRealEstateType(realEstateType);
	}
	
	public List<RealEstate> findAll() {
		return realEstateRepository.findAll();
	}
	
	public Page<RealEstate> findAll(Pageable page) {
		return realEstateRepository.findAll(page);
	}
	
	public RealEstate save(RealEstate realEstate) {
		return realEstateRepository.save(realEstate);
	}
	
	public RealEstate saveAndFlush(RealEstate realEstate) {
		return realEstateRepository.saveAndFlush(realEstate);
	}
	
	public void removeById(int id) {
		realEstateRepository.delete(id);
	}
	
	public void remove(RealEstate realEstate) {
		realEstateRepository.delete(realEstate);
	}
	
}
