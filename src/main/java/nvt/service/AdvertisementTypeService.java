package nvt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nvt.beans.AdvertisementType;
import nvt.repository.AdvertisementTypeRepository;

@Service
public class AdvertisementTypeService {

	@Autowired
	AdvertisementTypeRepository advertisementTypeRepository;

	public AdvertisementType findById(int id) {
		return advertisementTypeRepository.findById(id);
	}
	
	public List<AdvertisementType> findAll() {
		return advertisementTypeRepository.findAll();
	}
	
	public Page<AdvertisementType> findAll(Pageable page) {
		return advertisementTypeRepository.findAll(page);
	}
	
	public AdvertisementType save(AdvertisementType advertisementType) {
		return advertisementTypeRepository.save(advertisementType);
	}
	
	public AdvertisementType saveAndFlush(AdvertisementType advertisementType) {
		return advertisementTypeRepository.saveAndFlush(advertisementType);
	}
	
	public void removeById(int id) {
		advertisementTypeRepository.delete(id);
	}
	
	public void remove(AdvertisementType advertisementType) {
		advertisementTypeRepository.delete(advertisementType);
	}
	
}
