package nvt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nvt.beans.RealEstateOutdoors;
import nvt.repository.RealEstateOutdoorsRepository;

@Service
public class RealEstateOutdoorsService {

	@Autowired
	RealEstateOutdoorsRepository realEstateOutdoorsRepository;
	
	
	public RealEstateOutdoors findById(int id) {
		return realEstateOutdoorsRepository.findById(id);
	}
	
	public List<RealEstateOutdoors> findAll() {
		return realEstateOutdoorsRepository.findAll();
	}
	
	public Page<RealEstateOutdoors> findAll(Pageable page) {
		return realEstateOutdoorsRepository.findAll(page);
	}
	
	public RealEstateOutdoors save(RealEstateOutdoors realEstateOutdoor) {
		return realEstateOutdoorsRepository.save(realEstateOutdoor);
	}
	
	public RealEstateOutdoors saveAndFlush(RealEstateOutdoors realEstateOutdoor) {
		return realEstateOutdoorsRepository.saveAndFlush(realEstateOutdoor);
	}
	
	public void removeById(int id) {
		realEstateOutdoorsRepository.delete(id);
	}
	
	public void remove(RealEstateOutdoors realEstateOutdoor) {
		realEstateOutdoorsRepository.delete(realEstateOutdoor);
	}
}
