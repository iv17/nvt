package nvt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nvt.beans.RealEstateIndoors;
import nvt.repository.RealEstateIndoorsRepository;

@Service
public class RealEstateIndoorsService {

	@Autowired
	RealEstateIndoorsRepository realEstateIndoorsRepository;
	
	
	public RealEstateIndoors findById(int id) {
		return realEstateIndoorsRepository.findById(id);
	}
	
	public List<RealEstateIndoors> findAll() {
		return realEstateIndoorsRepository.findAll();
	}
	
	public Page<RealEstateIndoors> findAll(Pageable page) {
		return realEstateIndoorsRepository.findAll(page);
	}
	
	public RealEstateIndoors save(RealEstateIndoors realEstateIndoor) {
		return realEstateIndoorsRepository.save(realEstateIndoor);
	}
	
	public RealEstateIndoors saveAndFlush(RealEstateIndoors realEstateIndoor) {
		return realEstateIndoorsRepository.saveAndFlush(realEstateIndoor);
	}
	
	public void removeById(int id) {
		realEstateIndoorsRepository.delete(id);
	}
	
	public void remove(RealEstateIndoors realEstateIndoor) {
		realEstateIndoorsRepository.delete(realEstateIndoor);
	}
}
