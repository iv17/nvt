package nvt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nvt.beans.ApartmentType;
import nvt.repository.ApartmentTypeRepository;

@Service
public class ApartmentTypeService {

	@Autowired
	ApartmentTypeRepository apartmentTypeRepository;
	
	
	public ApartmentType findById(int id) {
		return apartmentTypeRepository.findById(id);
	}
	
	public List<ApartmentType> findAll() {
		return apartmentTypeRepository.findAll();
	}
	
	public Page<ApartmentType> findAll(Pageable page) {
		return apartmentTypeRepository.findAll(page);
	}
	
	public ApartmentType save(ApartmentType apartmentType) {
		return apartmentTypeRepository.save(apartmentType);
	}
	
	public ApartmentType saveAndFlush(ApartmentType apartmentType) {
		return apartmentTypeRepository.saveAndFlush(apartmentType);
	}
	
	public void removeById(int id) {
		apartmentTypeRepository.delete(id);
	}
	
	public void remove(ApartmentType apartmentType) {
		apartmentTypeRepository.delete(apartmentType);
	}
	
	
}

