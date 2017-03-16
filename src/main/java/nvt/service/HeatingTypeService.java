package nvt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nvt.beans.HeatingType;
import nvt.repository.HeatingTypeRepository;

@Service
public class HeatingTypeService {

	@Autowired
	protected HeatingTypeRepository heatingTypeRepository;
	
	
	public HeatingType findById(int id) {
		return heatingTypeRepository.findById(id);
	}
	
	public List<HeatingType> findAll() {
		return heatingTypeRepository.findAll();
	}
	
	public Page<HeatingType> findAll(Pageable page) {
		return heatingTypeRepository.findAll(page);
	}
	
	public HeatingType save(HeatingType heatingType) {
		return heatingTypeRepository.save(heatingType);
	}
	
	public HeatingType saveAndFlush(HeatingType heatingType) {
		return heatingTypeRepository.saveAndFlush(heatingType);
	}
	
	public void removeById(int id) {
		heatingTypeRepository.delete(id);
	}
	
	public void remove(HeatingType heatingType) {
		heatingTypeRepository.delete(heatingType);
	}
	
}
