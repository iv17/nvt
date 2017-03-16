package nvt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nvt.beans.RealEstateType;
import nvt.repository.RealEstateTypeRepository;

@Service
public class RealEstateTypeService {

	@Autowired
	RealEstateTypeRepository realEstateTypeRepository;
	
	
	public RealEstateType findById(int id) {
		return realEstateTypeRepository.findById(id);
	}
	
	public List<RealEstateType> findAll() {
		return realEstateTypeRepository.findAll();
	}
	
	public Page<RealEstateType> findAll(Pageable page) {
		return realEstateTypeRepository.findAll(page);
	}
	
	public RealEstateType save(RealEstateType realEstateType) {
		return realEstateTypeRepository.save(realEstateType);
	}
	
	public RealEstateType saveAndFlush(RealEstateType realEstateType) {
		return realEstateTypeRepository.saveAndFlush(realEstateType);
	}
	
	public void removeById(int id) {
		realEstateTypeRepository.delete(id);
	}
	
	public void remove(RealEstateType realEstateType) {
		realEstateTypeRepository.delete(realEstateType);
	}
}
